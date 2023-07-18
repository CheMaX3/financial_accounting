package org.chemax.financial_accounting.dao;

import org.chemax.financial_accounting.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(Long id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?",
                new BeanPropertyRowMapper<>(Person.class), new Object[]{id}).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person VALUES(1, ?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail());
    }

    public void update(Long id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?",
                updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}
