package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerMapper implements RowMapper<Integer> {

    private String columnLabel;

    public IntegerMapper(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt(columnLabel);
    }
}
