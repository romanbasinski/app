package com.pokemon.service;


import com.pokemon.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

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

    public PokemonDto getById(int id) {
        try {

            return jdbcTemplate.queryForObject("SELECT idPokemon, name, weight, speciesUrl, speciesName FROM POKEMONS WHERE ID = " + id,
                    (resultSet, i) -> {
                        PokemonDto pokemonDto = new PokemonDto();
                        pokemonDto.setIdPokemon(resultSet.getInt("idPokemon"));
                        pokemonDto.setName(resultSet.getString("name"));
                        pokemonDto.setWeight(resultSet.getString("weight"));
                        pokemonDto.setSpeciesUrl(resultSet.getString("speciesUrl"));
                        pokemonDto.setSpeciesName(resultSet.getString("speciesName"));
                        return pokemonDto;
                    });
        } catch (Exception e) {

            //https://doc}s.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/data-access.html#jdbc
        }
        return null
                ;
    }
}