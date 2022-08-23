package com.cagatay.basketballteam.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cagatay.basketballteam.enumeration.Position;
import com.cagatay.basketballteam.model.Player;
import com.cagatay.basketballteam.repository.PlayerRepository;
import com.cagatay.basketballteam.service.PlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService{
	private final PlayerRepository playerRepository;
	private final int PLAYERS_LIMIT = 5;

	public Player savePlayer(Player player) throws RuntimeException {
		List<Player> playerList = findAllPlayers();
		if(playerList.size() >= PLAYERS_LIMIT)
			throw new RuntimeException("Team has already maximum capacity.");
		if(isContainPosition(playerList, player.getPosition()))
			throw new RuntimeException("Position already exist in the team.");
		return playerRepository.save(player);
	}

	public int deleteByPlayerID(Long id) {
		log.info("Deleting player by ID: {}", id);
		return playerRepository.deleteById(id);
	}
	
	public List<Player> findAllPlayers() {
		log.info("Fetching all players");
		return playerRepository.findAll();
	}
	
	private Boolean isContainPosition(List<Player> players, Position position) {
		Boolean isContain = false;
		for (int i=0; i<players.size(); i++) {
			if(players.get(i).getPosition() == position)
				isContain = true;
		}
		return isContain;
	}
}
