package com.pokemon.service;

import com.pokemon.dto.PokemonDto;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    public PokemonServiceImpl(ParseService parseService, PokemonJdbcService pokemonJdbcService) {
        this.parseService = parseService;
        this.pokemonJdbcService = pokemonJdbcService;
    }

    ParseService parseService;
    PokemonJdbcService pokemonJdbcService;

    public PokemonDto getPokemonDto(int id) throws IOException {
        CloseableHttpClient httpClient
                = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        ResponseEntity<String> response
                = new RestTemplate(requestFactory).exchange(
                "http://pokeapi.co/api/v2/pokemon/" + id, HttpMethod.GET, null, String.class);


        return parseService.returnParsedPokemon(response.getBody());
    }

    @Override
    public void addToDb(PokemonDto pokemonDto, int id) {
        pokemonJdbcService.addToPokemonTable(pokemonDto, id);

    }

    @Override
    public PokemonDto getPokemonById(int id) {

        return pokemonJdbcService.getById(id);
    }
}
