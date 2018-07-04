package com.pokemon;

import com.pokemon.dto.PokemonDto;
import com.pokemon.service.PokemonService;

import java.io.IOException;

public class PokemonServiceImplTest implements PokemonService {

    @Override
    public PokemonDto getPokemonDto(int id) throws IOException {
        return new PokemonDto(id, "bublbasaur","20");
    }

    @Override
    public void addToDb(PokemonDto pokemonDto, int id) {

    }
    @Override
    public PokemonDto getPokemonById(int id) {
        return null;
    }
}
