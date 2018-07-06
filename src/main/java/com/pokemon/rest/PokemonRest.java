package com.pokemon.rest;


import com.pokemon.dto.PokemonDto;
import com.pokemon.exception.EmptyPokemonException;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
    public ResponseEntity<PokemonDto> getPokemon(@RequestParam(value = "id") int id) throws IOException {

        PokemonDto pokemonDto = pokemonService.getPokemonById(id);
        if (pokemonDto != null) {
            return getPokemonDtoResponseEntity(id, pokemonDto);
        }

        pokemonDto = pokemonService.getPokemonDto(id);
        pokemonService.addToDb(pokemonDto, id);
        return getPokemonDtoResponseEntity(id, pokemonDto);

    }

    private ResponseEntity<PokemonDto> getPokemonDtoResponseEntity(@RequestParam(value = "id") int id, PokemonDto pokemonDto) throws IOException {
        pokemonDto.add(linkTo(methodOn(PokemonRest.class).getPokemon(id)).withSelfRel());
        return new ResponseEntity<>(pokemonDto, HttpStatus.OK);
    }

    @GetMapping("/api/getAll")
    public List<PokemonDto> getPokemon() throws IOException, EmptyPokemonException {
       throw new EmptyPokemonException();
    }
    //get ktory to wyswietli //getAllPokemons


}
