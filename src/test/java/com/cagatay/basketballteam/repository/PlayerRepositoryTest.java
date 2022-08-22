package com.cagatay.basketballteam.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cagatay.basketballteam.enumeration.Position;
import com.cagatay.basketballteam.model.Player;

@DataJpaTest
public class PlayerRepositoryTest {
	@Autowired
	private PlayerRepository underTest;
	
	@Test
	void itShouldDeletePlayerById() {
		//given
		Player player = new Player(null, 
				"cagatay", 
				"cinkir", 
				Position.CENTER
		);
		Long playerID = underTest.save(player).getId();
		//when
		int expected = underTest.deleteById(playerID);
		//then
		assertThat(expected).isEqualTo(1);
	}
}
