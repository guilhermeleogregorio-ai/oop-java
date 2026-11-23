package org.guilherme.ifsp.exercises.Prova3.persistence;

import org.guilherme.ifsp.exercises.Prova3.costs.PeriodCostDao;
import org.guilherme.ifsp.exercises.Prova3.costs.PeriodCostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodCostDaoImpl implements PeriodCostDao {
    @Override
    public List<PeriodCostDto> findall(int hours, double fee) throws SQLException {
        List<PeriodCostDto> list = new ArrayList<>();
        String sql = "SELECT * FROM costs";

        try(PreparedStatement ps = ConnectionFactory.getPreparedStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new PeriodCostDto(rs.getInt("hours"), rs.getDouble("fee")));
            }
        }catch (SQLException e){ e.printStackTrace();}
        return list;
    }
}
