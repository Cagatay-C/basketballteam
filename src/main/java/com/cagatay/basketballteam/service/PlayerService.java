package com.cagatay.basketballteam.service;

import java.util.List;

import com.cagatay.basketballteam.model.Player;

public interface PlayerService {
	Player addPlayer(Player player);
	Boolean deletePlayer(int id);
	List<Player> players();
}
