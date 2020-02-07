package com.qa.swamp;

public enum MapSize {
	SMALL(11),
	MEDIUM(21),
	LARGE(31),
	HUGE(51);
	
	private int size;
	private MapSize(int size) {
		this.setSize(size);
	}
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public static void printSizes() {
		for (MapSize mapSize : MapSize.values()) {
			System.out.println(mapSize.name());
		}
	}
	
	public static MapSize getMapSize() {
		MapSize mapSize;
		while (true) {
			try {
				mapSize = MapSize.valueOf(Utils.getStringInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid input!");
			}
		}
		return mapSize;
	}
}
