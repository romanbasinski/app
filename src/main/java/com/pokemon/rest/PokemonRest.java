package com.pokemon.rest;


import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PokemonRest {

    private PokemonService pokemonService;

    @Autowired
    public PokemonRest(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemon")
    public String getPokemon(@RequestParam(value="id") String id) throws IOException {
        return pokemonService.getPokemonDto(id).getName();
    }




}
