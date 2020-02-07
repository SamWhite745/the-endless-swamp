package com.qa.swamp;

public class Map {
	private MapSize mapSize;
//	private List<MapObject> mapObjects = new ArrayList<MapObject>();
	private MapObject player;
	private MapObject treasure;

	public Map(MapSize mapSize) {
		this.mapSize = mapSize;
	}

	public void initialise() {
		MapObjectFactory factory = new MapObjectFactory();

		MapObject player = factory.buildMapObject(MapObjectType.PLAYER, mapSize);
		MapObject treasure = factory.buildMapObject(MapObjectType.TREASURE, mapSize);

		this.player = player;
		this.treasure = treasure;
	}
	
	public void play() {
		boolean won = false;
		System.out.println("Grey foggy clouds float oppressively close to you, reflected in the murky grey water which reaches up your shins.");
		System.out.println("Some black plants barely poke out of the shallow water.");
		System.out.println("You notice a small watch-like device in your left hand.");
		System.out.println("It has hands like a watch, but the hands don't seem to tell time.");
		System.out.println("Which way do you want to go?");
		System.out.println("(HINT!) Try North, South, East or West.");

		while (!won) {
			Direction direction = Direction.getDirection();
			switch (direction) {
			case NORTH:
				moveObjectNorth(getPlayer());
				break;
			case EAST:
				moveObjectEast(getPlayer());
				break;
			case SOUTH:
				moveObjectSouth(getPlayer());
				break;
			case WEST:
				moveObjectWest(getPlayer());
				break;
			}
//			printLocation(getPlayer());
//			printLocation(getTreasure());
			System.out.println("The dial reads: " + getDistance(getPlayer(), getTreasure()));
			if(getDistance(getPlayer(), getTreasure()) == 0.0) won = true;
		}
		
		System.out.println("Congratulaions! You found some dank swamp memes!");
	}

	public void moveObjectNorth(MapObject mapObject) {
		int yLoc = mapObject.getyLoc();

		if (yLoc + 1 >= mapSize.getSize())
			mapObject.setyLoc(0);
		else
			mapObject.setyLoc(yLoc + 1);
	}

	public void moveObjectSouth(MapObject mapObject) {
		int yLoc = mapObject.getyLoc();

		if (yLoc - 1 < 0)
			mapObject.setyLoc(mapSize.getSize() - 1);
		else
			mapObject.setyLoc(yLoc - 1);
	}

	public void moveObjectEast(MapObject mapObject) {
		int xLoc = mapObject.getxLoc();

		if (xLoc + 1 >= mapSize.getSize())
			mapObject.setxLoc(0);
		else
			mapObject.setxLoc(xLoc + 1);
	}

	public void moveObjectWest(MapObject mapObject) {
		int xLoc = mapObject.getxLoc();

		if (xLoc - 1 < 0)
			mapObject.setxLoc(mapSize.getSize() - 1);
		else
			mapObject.setxLoc(xLoc - 1);
	}

	public MapObject getPlayer() {
//		return mapObjects.stream().filter(mapObject -> mapObject.getClass().isInstance(Player.class)).findFirst()
//				.orElse(null);
		return this.player;
	}

	public MapObject getTreasure() {
//		return mapObjects.stream().filter(mapObject -> mapObject.getClass().isInstance(Treasure.class)).findFirst()
//				.orElse(null);
		return this.treasure;
	}

	public void printLocation(MapObject mapObject) {
		if (mapObject.getClass().equals(Player.class)) System.out.println("Player");
		else if (mapObject.getClass().equals(Treasure.class)) System.out.println("Treasure");
		System.out.println("X : " + mapObject.getxLoc());
		System.out.println("Y : " + mapObject.getyLoc());
	}

	public double getDistance(MapObject first, MapObject second) {
		int xDist = Math.min(
				Math.abs(first.getxLoc() - second.getxLoc()),
				(mapSize.getSize()- Math.max(first.getxLoc(), second.getxLoc()))
						+ Math.min(first.getxLoc(), second.getxLoc()));
		
		int yDist = Math.min(
				Math.abs(first.getyLoc() - second.getyLoc()),
				(mapSize.getSize()- Math.max(first.getyLoc(), second.getyLoc()))
						+ Math.min(first.getyLoc(), second.getyLoc()));
		
		xDist = xDist * xDist;
		yDist = yDist * yDist;
		double zDist = Math.sqrt(xDist + yDist);
		return zDist;
	}

}
