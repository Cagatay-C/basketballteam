package com.cagatay.basketballteam.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.cagatay.basketballteam.input.CreatePlayerInput;
import com.cagatay.basketballteam.model.Player;
import com.cagatay.basketballteam.repository.PlayerRepository;
import com.cagatay.basketballteam.service.PlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Transactional
@Controller
@Slf4j
public class PlayerServiceImpl implements PlayerService{
	private final PlayerRepository playerRepository;
	
	@MutationMapping
	public Player createPlayer (@Argument("input") CreatePlayerInput createPlayerInput) {
		log.info("Adding new player: {}" + createPlayerInput.getName());
		return playerRepository.save(new Player(null,createPlayerInput.getName(),
				createPlayerInput.getSurname(),createPlayerInput.getPosition()
				));
	}

	@MutationMapping
	public int deletePlayer(@Argument Long id) {
		log.info("Deleting player by ID: {}", id);
		return playerRepository.deleteById(id);
	}
	
	@QueryMapping
	public List<Player> players() {
		log.info("Fetching all players");
		return playerRepository.findAll();
	}
}
