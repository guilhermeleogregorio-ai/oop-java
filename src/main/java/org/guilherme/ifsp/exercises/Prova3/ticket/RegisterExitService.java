package org.guilherme.ifsp.exercises.Prova3.ticket;

import org.guilherme.ifsp.exercises.Prova3.costs.PeriodCostDao;
import org.guilherme.ifsp.exercises.Prova3.costs.PeriodCostDto;
import org.guilherme.ifsp.exercises.Prova3.customer.Customer;
import org.guilherme.ifsp.exercises.Prova3.customer.CustomerDao;
import org.guilherme.ifsp.exercises.Prova3.customer.CustomerDto;
import org.guilherme.ifsp.exercises.Prova3.customer.Type;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RegisterExitService {
    private final CustomerDao customerDao;
    private final TicketDao ticketDao;
    private final PeriodCostDao periodCostDao;

    public RegisterExitService(CustomerDao customerDao, TicketDao ticketDao, PeriodCostDao periodCostDao) {
        this.customerDao = customerDao;
        this.ticketDao = ticketDao;
        this.periodCostDao = periodCostDao;
    }

    public double register(String plate) throws SQLException {
        if (plate == null || plate.isBlank()) {
            throw new IllegalArgumentException("A placa não pode ser nula");
        }

        CustomerDto customerDto = customerDao.findOne(plate, null, null);
        if (customerDto == null) {
            throw new NoSuchElementException("Cliente não encontrado");
        }

        EntryTicketDto openTicketDto = ticketDao.findOpenTicket(null, plate, null)
                .orElseThrow(() -> new IllegalStateException("Não há ticket aberto para a placa: " + plate));

        Customer customer = toCustomer(customerDto);
        Ticket ticket = toTicket(openTicketDto, customer);

        ticket.exit();
        Duration duration = ticket.parkingDuration();
        long hours = getRoundedHours(duration);

        double fee = calculateFee(hours);

        ExitTicketDto exitDto = toExitTicketDto(ticket, fee);
        ticketDao.updateExit(exitDto.getPlate(), exitDto.getExit(), exitDto.getFee());

        return fee;
    }

    private double calculateFee(long hours) throws SQLException {
        if (hours <= 0) {
            return 0.0;
        }

        List<PeriodCostDto> costDtos = periodCostDao.findall(0, 0);
        Map<Integer, Double> periodCosts = toPeriodCostsMap(costDtos);

        int target = (int) hours;
        int maxPlanHours = periodCosts.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        int limit = target + maxPlanHours;
        double[] dp = new double[limit + 1];
        Arrays.fill(dp, Double.POSITIVE_INFINITY);
        dp[0] = 0.0;

        IntStream.rangeClosed(1, limit).forEach(h ->
                dp[h] = periodCosts.entrySet().stream()
                        .filter(entry -> h >= entry.getKey() && dp[h - entry.getKey()] != Double.POSITIVE_INFINITY)
                        .mapToDouble(entry -> dp[h - entry.getKey()] + entry.getValue())
                        .min()
                        .orElse(Double.POSITIVE_INFINITY)
        );

        return IntStream.rangeClosed(target, limit)
                .mapToDouble(h -> dp[h])
                .min()
                .orElse(0.0);
    }

    private long getRoundedHours(Duration duration) {
        if (duration.isZero() || duration.isNegative()) {
            return 1L;
        }
        long hours = duration.toHours();
        if (duration.minusHours(hours).toMillis() > 0 || duration.minusHours(hours).toNanos() > 0) {
            hours++;
        }
        return hours;
    }

    private Customer toCustomer(CustomerDto dto) {
        return new Customer(
                dto.getPlate(),
                dto.getPhone(),
                Type.valueOf(dto.getType().toUpperCase())
        );
    }

    private Ticket toTicket(EntryTicketDto dto, Customer customer) {
        return new Ticket(
                UUID.fromString(dto.getId()),
                customer,
                LocalDateTime.parse(dto.getEntry())
        );
    }

    private ExitTicketDto toExitTicketDto(Ticket ticket, double fee) {
        return new ExitTicketDto(
                String.valueOf(ticket.getCliente().getPlate()),
                ticket.getExit().toString(),
                fee
        );
    }

    private Map<Integer, Double> toPeriodCostsMap(List<PeriodCostDto> dtos) {
        return dtos.stream()
                .collect(Collectors.toMap(PeriodCostDto::getHours, PeriodCostDto::getFee));
    }
}
