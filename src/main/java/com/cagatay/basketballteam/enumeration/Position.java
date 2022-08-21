package com.cagatay.basketballteam.enumeration;

public enum Position {
	POINT_GUARD("POINT_GUARD"),
	SHOOTING_GUARD("SHOOTING_GUARD"),
	SMALL_FORWARD("SMALL_FORWARD"),
	POWER_FORWARD("POWER_FORWARD"),
	CENTER("CENTER");
	
	private final String position;
	
	Position(String position){
		this.position = position;
	}
	
	public String getPosition() {
		return this.position;
	}
}
