package com.cagatay.basketballteam.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.util.List;

import com.cagatay.basketballteam.enumeration.Position;
import com.cagatay.basketballteam.input.CreatePlayerInput;
import com.cagatay.basketballteam.model.Player;
import com.cagatay.basketballteam.repository.PlayerRepository;
import com.cagatay.basketballteam.service.implementation.PlayerServiceImpl;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
	@Mock
	private PlayerRepository playerRepository;
	@InjectMocks
	private PlayerServiceImpl underTest;
	private Player player;
	
	@BeforeEach
	void Setup() {
		player = new Player(null,
				"cagatay",
				"cinkir",
				Position.CENTER
				);
		underTest = new PlayerServiceImpl(playerRepository);
	}

	@Test
	void itShouldCreatePlayer() {
		//given
		CreatePlayerInput createPlayerInput = new CreatePlayerInput(null,
				player.getName(),
				player.getSurname(),
				player.getPosition()
				);
		given(playerRepository.save(player)).willReturn(player);
		
		//when
		Player createdPlayer = underTest.createPlayer(createPlayerInput);
		
		//then
		assertThat(createdPlayer).isNotNull();
	}

	@Test
	void itShouldGetAllPlayers() {
		//given
		Player secondPlayer = new Player(null,
				"caglar",
				"cinkir",
				Position.SHOOTING_GUARD
				);
		
		given(playerRepository.findAll()).willReturn(List.of(player, secondPlayer));
		
		//when
		List<Player> playerList = underTest.getAllPlayers();
		
		//then
		assertThat(playerList).isNotNull();
		assertThat(playerList.size()).isEqualTo(2);
	}

}
