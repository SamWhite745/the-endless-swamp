package com.qa.swamp;

public enum Direction {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	public static Direction getDirection() {
		Direction direction;
		while (true) {
			try {
				direction = Direction.valueOf(Utils.getStringInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid input! Try again.");
			}
		}
		return direction;
	}
}
