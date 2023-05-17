package com.example.profiltrenera.AddToDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AddingColToDBCommponent {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AddingColToDBCommponent(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addColumnToPlayersTable() {
        LocalDate currentDate = LocalDate.now();
        int numberOfDaysInMonth = currentDate.lengthOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        for (int day = 1; day <= numberOfDaysInMonth; day++) {
            LocalDate date = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), day);
            String columnName = "data_" + date.format(formatter);
            String query = "ALTER TABLE players ADD COLUMN " + columnName + " VARCHAR(250) DEFAULT ' ' ";

            try {
                jdbcTemplate.execute(query);
            } catch (DataAccessException e) {
                // Ignorowanie wyjątku, gdy kolumna już istnieje
            }
        }
    }

    public void dropColumnToPlayersTable() {
        LocalDate currentDate = LocalDate.now();
        int numberOfDaysInMonth = currentDate.lengthOfMonth();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        for (int day = 1; day <= numberOfDaysInMonth; day++) {
            LocalDate date = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), day);
            String columnName = "data_" + date.format(formatter);
            String query = "ALTER TABLE players DROP COLUMN " + columnName;

            try {
                jdbcTemplate.execute(query);
            } catch (DataAccessException e) {
                // Ignorowanie wyjątku, gdy kolumna już istnieje
            }
        }
    }
}
