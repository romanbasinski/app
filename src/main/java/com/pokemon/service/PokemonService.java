package com.pokemon.service;

import com.pokemon.dto.PokemonDto;

import java.io.IOException;

public interface PokemonService {

    PokemonDto getPokemonDto(String id) throws IOException;
    public void addToDb(PokemonDto pokemonDto, int id);

    PokemonDto getPokemonById(String id);
}
