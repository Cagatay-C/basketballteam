package com.cagatay.basketballteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cagatay.basketballteam.enumeration.Position;
import com.cagatay.basketballteam.model.Player;
import com.cagatay.basketballteam.repository.PlayerRepository;

@SpringBootApplication
public class BasketballteamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketballteamApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(PlayerRepository playerRepository) {
		return args -> {
			playerRepository.save(new Player(null,"cagatay","cinkir",Position.CENTER));
			playerRepository.save(new Player(null,"caglar","cinkir",Position.POINT_GUARD));
			
		};
	}
}
