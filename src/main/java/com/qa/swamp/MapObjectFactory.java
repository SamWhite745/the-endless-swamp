package com.qa.swamp;

import java.util.ArrayList;
import java.util.List;

public class MapObjectFactory {
	private static List<MapObject> mapObjects = new ArrayList<>();
	
    public static MapObject buildMapObject(MapObjectType type, MapSize mapSize) {
    	boolean uniqueLoc = false;
        MapObject mapObj = null;

    	while (!uniqueLoc) {
            int xLoc = Utils.getRandomLocation(mapSize.getSize());
            int yLoc = Utils.getRandomLocation(mapSize.getSize());
            switch (type) {
            case PLAYER:
            	mapObj = new Player(xLoc, yLoc, MapObjectType.PLAYER);
                break;
     
            case TREASURE:
            	mapObj = new Treasure(xLoc, yLoc, MapObjectType.TREASURE);
                break;
            } 
            
            uniqueLoc = true;
            for (MapObject mapObject : mapObjects) {
            	if (mapObject.toString().equals(mapObj.toString())) uniqueLoc = false;
            }
    	}
        mapObjects.add(mapObj);
        return mapObj;

    }
    
    public static void addObject(MapObject mapObject) {
    	mapObjects.add(mapObject);
    }
    
    public static List<MapObject> getMapObjects(){
    	return mapObjects;
    }
}
