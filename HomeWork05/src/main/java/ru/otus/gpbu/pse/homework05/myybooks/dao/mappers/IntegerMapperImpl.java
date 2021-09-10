package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class IntegerMapperImpl implements IntegerMapper {

    private String columnLabel;

    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt(columnLabel);
    }

    @Override
    public IntegerMapper setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
        return this;
    }
}
