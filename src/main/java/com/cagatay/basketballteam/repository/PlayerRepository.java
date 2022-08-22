package com.cagatay.basketballteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cagatay.basketballteam.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	int deleteById(Long id);
}
