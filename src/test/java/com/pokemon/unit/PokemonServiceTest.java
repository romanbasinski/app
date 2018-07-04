package com.pokemon.unit;

import com.pokemon.service.PokemonService;
import com.pokemon.PokemonServiceImplTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PokemonServiceTest {


    PokemonService pokemonService = new PokemonServiceImplTest();

    @Test
    public void shouldReturnBulbasaur() throws IOException {
        Assert.assertEquals(pokemonService
                .getPokemonDto(1).getName(),"bublbasaur");
    }

    @Test
    public void shoudlNotReturnBulbasaur() throws IOException {
        Assert.assertNotEquals(pokemonService
                .getPokemonDto(2).getName(),"bu");

    }
}
