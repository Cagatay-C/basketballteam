package com.cagatay.basketballteam.service;

import java.util.List;

import com.cagatay.basketballteam.input.CreatePlayerInput;
import com.cagatay.basketballteam.model.Player;

public interface PlayerService {
	Player createPlayer(CreatePlayerInput player);
	int deletePlayer(Long id);
	List<Player> getAllPlayers();
}
