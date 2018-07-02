package com.pokemon.rest;


import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.IOException;

@RestController
public class PokemonRest {

    private PokemonService pokemonService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public PokemonRest(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemon")
    public PokemonDto getPokemon(@RequestParam(value="id") String id) throws IOException {

        return pokemonService.getPokemonDto(id);
    }



    //TODO
    // /addPokemon -> post tworzacy
    // pokemona i dodajacy go do listy PokemonCache


}
