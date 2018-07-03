package com.pokemon.rest;


import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/addPokemon")
    public ResponseEntity<String> addPokemon(@RequestBody PokemonDto pokemonDto) {


        //TODO
        // /addPokemon -> post tworzacy
        // pokemona i dodajacy go do listy PokemonCache


        return null;
    }


    //get ktory to wyswietli //getAllPokemons


}
