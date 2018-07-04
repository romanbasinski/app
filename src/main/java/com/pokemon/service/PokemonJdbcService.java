package com.pokemon.service;


import com.pokemon.config.JdbcConfig;
import com.pokemon.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonJdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void methodInit() {

    }

    public void addToPokemonTable(PokemonDto pokemonDto, int id) {
        jdbcTemplate.update("INSERT INTO pokemons VALUES(?,?,?,?,?)",
               id, pokemonDto.getName(), pokemonDto.getWeight(),
                pokemonDto.getSpeciesUrl(), pokemonDto.getSpeciesName());

    }


    // ROWMAPPER
//    public class EmployeeRowMapper implements RowMapper<Employee> {
////        @Override
////        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
////            Employee employee = new Employee();
////
////            employee.setId(rs.getInt("ID"));
////            employee.setFirstName(rs.getString("FIRST_NAME"));
////            employee.setLastName(rs.getString("LAST_NAME"));
////            employee.setAddress(rs.getString("ADDRESS"));
////
////            return employee;
////        }
////    }
//String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
//    List<Employee> employees = jdbcTemplate.query(
//            query, new Object[] { id }, new EmployeeRowMapper());


    //https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/data-access.html#jdbc
}
