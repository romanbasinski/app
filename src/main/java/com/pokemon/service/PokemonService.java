package com.pokemon.service;

import com.pokemon.dto.PokemonDto;

import java.io.IOException;

public interface PokemonService {

    PokemonDto getPokemonDto(String id) throws IOException;
    void addToDb(PokemonDto pokemonDto);
}
