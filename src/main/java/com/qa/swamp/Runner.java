package com.qa.swamp;

public class Runner {

	public static void main(String[] args) {
		System.out.println("How large is the infinite swamp!?");
		MapSize.printSizes();
		MapSize mapSize = MapSize.getMapSize();
		
		Map map = new Map(mapSize);
		map.initialise();
		map.play();

		// TODO Auto-generated method stub

	}

}
