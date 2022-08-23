package com.cagatay.basketballteam.service;

import java.util.List;

import com.cagatay.basketballteam.model.Player;

public interface PlayerService {
	Player savePlayer(Player player) throws RuntimeException;
	int deleteByPlayerID(Long id);
	List<Player> findAllPlayers();
}
