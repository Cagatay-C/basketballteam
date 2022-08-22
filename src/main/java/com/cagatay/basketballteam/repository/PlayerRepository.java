package com.cagatay.basketballteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cagatay.basketballteam.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	int deleteById(Long id);
}
