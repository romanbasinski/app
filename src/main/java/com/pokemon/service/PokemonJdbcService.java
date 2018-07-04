package com.pokemon.service;


import com.pokemon.config.JdbcConfig;
import com.pokemon.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public PokemonDto getById(String id) {
        try {
            jdbcTemplate.queryForObject("SELECT * FROM POKEMONS WHERE ID = " + id,
                    (resultSet, i) -> {
                        PokemonDto pokemonDto = new PokemonDto();
                        pokemonDto.setId(resultSet.getInt("id"));
                        pokemonDto.setName(resultSet.getString("name"));
                        pokemonDto.setWeight(resultSet.getString("weight"));
                        pokemonDto.setSpeciesUrl(resultSet.getString("speciesUrl"));
                        pokemonDto.setSpeciesName(resultSet.getString("speciesName"));
                        return pokemonDto;
                    });
        } catch (Exception e) {

        }
        return null;
        //https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/data-access.html#jdbc
    }
}
