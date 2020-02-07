package com.qa.swamp;

public class MapObjectFactory {
    public MapObject buildMapObject(MapObjectType type, MapSize mapSize) {
        MapObject mapObj = null;
        int xLoc = Utils.getRandomLocation(mapSize.getSize());
        int yLoc = Utils.getRandomLocation(mapSize.getSize());
        switch (type) {
        case PLAYER:
        	mapObj = new Player(xLoc, yLoc);
            break;
 
        case TREASURE:
        	mapObj = new Treasure(xLoc, yLoc);
            break;
        } 
        return mapObj;
    }
}
