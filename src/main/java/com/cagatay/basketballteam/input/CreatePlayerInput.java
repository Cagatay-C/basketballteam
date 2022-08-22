package com.cagatay.basketballteam.input;

import com.cagatay.basketballteam.enumeration.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlayerInput {
	private Long id;
	private String name;
	private String surname;
	private Position position;
}
