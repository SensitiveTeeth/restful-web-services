package com.learningJavaMicroservice.rest.webservices.restfulwebservices.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
    private final JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                    INSERT INTO course (id, name, author)
                    VALUES(?, ?, ?);
                    """;

    private static String DELETE_QUERY =
            """
                    DELETE FROM course WHERE id = ?
                    """;

    private static String SELECT_QUERY =
            """
                    SELECT * FROM course WHERE id = ?
                    """;

    public JdbcRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }


    public void insert(Course course) {
        this.springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        this.springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return this.springJdbcTemplate.queryForObject(
                SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),
                id
        );
    }
}
