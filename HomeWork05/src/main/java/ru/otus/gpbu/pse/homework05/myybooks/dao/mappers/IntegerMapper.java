package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.jdbc.core.RowMapper;

public interface IntegerMapper extends RowMapper<Integer> {
    IntegerMapper setColumnLabel(String columnLabel);
}
