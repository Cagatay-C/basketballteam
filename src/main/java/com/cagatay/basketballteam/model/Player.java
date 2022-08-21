package com.cagatay.basketballteam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "Player's name cannot be empty or null")
	private String name;
	@NotEmpty(message = "Player's surname cannot be empty or null")
	private String surname;
	@NotEmpty(message = "Player's position cannot be empty or null")
	private int position;
}
