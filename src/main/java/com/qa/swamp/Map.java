package com.qa.swamp;

public class Map {
	private MapSize mapSize;

	public Map(MapSize mapSize) {
		this.mapSize = mapSize;
	}

	public void initialise() {

		MapObjectFactory.buildMapObject(MapObjectType.PLAYER, mapSize);
		MapObjectFactory.buildMapObject(MapObjectType.TREASURE, mapSize);
	}
	
	public void play() {
		boolean won = false;
		System.out.println("Grey foggy clouds float oppressively close to you, reflected in the murky grey water which reaches up your shins.");
		System.out.println("Some black plants barely poke out of the shallow water.");
		System.out.println("You notice a small watch-like device in your left hand.");
		System.out.println("It has hands like a watch, but the hands don't seem to tell time.");
		System.out.println("Which way do you want to go?");
		System.out.println("(HINT!) Try North, South, East or West.");
		System.out.println("The dial reads: " + getDistance(getMapObject(MapObjectType.PLAYER), getMapObject(MapObjectType.TREASURE)));

		while (!won) {
			Direction direction = Direction.getDirection();
			switch (direction) {
			case NORTH:
				moveObjectNorth(getMapObject(MapObjectType.PLAYER));
				break;
			case EAST:
				moveObjectEast(getMapObject(MapObjectType.PLAYER));
				break;
			case SOUTH:
				moveObjectSouth(getMapObject(MapObjectType.PLAYER));
				break;
			case WEST:
				moveObjectWest(getMapObject(MapObjectType.PLAYER));
				break;
			}
			System.out.println("The dial reads: " + getDistance(getMapObject(MapObjectType.PLAYER), getMapObject(MapObjectType.TREASURE)));
			if(getDistance(getMapObject(MapObjectType.PLAYER), getMapObject(MapObjectType.TREASURE)) == 0.0) won = true;
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
	
	public MapObject getMapObject(MapObjectType mapObjectType) {
		return MapObjectFactory.getMapObjects().stream()
				.filter(mapObject -> mapObject.getType().equals(mapObjectType))
				.findFirst()
				.orElse(null);
	}

	public void printLocation(MapObject mapObject) {
		System.out.println(mapObject.getType().name());
		System.out.println(getLocation(mapObject));
	}
	
	public String getLocation(MapObject mapObject) {
		return mapObject.toString();
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
