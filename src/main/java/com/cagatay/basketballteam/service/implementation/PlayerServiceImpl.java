package com.cagatay.basketballteam.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;

import com.cagatay.basketballteam.model.Player;
import com.cagatay.basketballteam.repository.PlayerRepository;
import com.cagatay.basketballteam.service.PlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PlayerServiceImpl implements PlayerService{
	private final PlayerRepository playerRepository;
	
	@Override
	public Player addPlayer(Player player) {
		log.info("Adding new player: {}" + player.getName());
		return null;
	}

	@Override
	public Boolean deletePlayer(int id) {
		log.info("Deleting player by ID: {}", id);
		return null;
	}

	@QueryMapping
	@Override
	public List<Player> players() {
		log.info("Fetching all players");
		return playerRepository.findAll();
	}

}
