package com.cagatay.basketballteam.controller;

import java.util.List;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.cagatay.basketballteam.input.CreatePlayerInput;
import com.cagatay.basketballteam.model.Player;
import com.cagatay.basketballteam.service.PlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class PlayerController{
	private final PlayerService playerService;
	
	@MutationMapping
	public Player createPlayer (@Argument("input") CreatePlayerInput createPlayerInput) throws RuntimeException {
		log.info("Adding new player: {}" + createPlayerInput.getName());	
		return playerService.savePlayer(new Player(null,createPlayerInput.getName(),
				createPlayerInput.getSurname(),createPlayerInput.getPosition()
				));
	}

	@MutationMapping
	public int deletePlayer(@Argument Long id) {
		log.info("Deleting player by ID: {}", id);
		return playerService.deleteByPlayerID(id);
	}
	
	@QueryMapping
	public List<Player> getAllPlayers() {
		log.info("Fetching all players");
		return playerService.findAllPlayers();
	}
}

