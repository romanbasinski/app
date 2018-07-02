package com.pokemon.integration;

import com.pokemon.dto.PokemonDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;


	@Test
	public void shouldGetResponseBody() {
		PokemonDto body = this.testRestTemplate.getForObject("/pokemon?id=1",PokemonDto.class);
		assertThat(body.getName()).isEqualTo("bulbasaur");
	}

}
