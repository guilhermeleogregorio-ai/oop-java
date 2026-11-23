package org.guilherme.ifsp.exercises.Prova3.costs;

import java.sql.SQLException;
import java.util.List;

public interface PeriodCostDao {
    List<PeriodCostDto> findall(int hours, double fee) throws SQLException;
}
