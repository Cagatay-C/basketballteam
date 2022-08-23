package com.cagatay.basketballteam.service;

import java.util.List;

import com.cagatay.basketballteam.model.Player;

public interface PlayerService {
	Player savePlayer(Player player) throws Exception;
	int deleteByPlayerID(Long id);
	List<Player> findAllPlayers();
}
