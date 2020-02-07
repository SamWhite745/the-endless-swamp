package com.qa.swamp;

public abstract class MapObject {
	private int xLoc;
	private int yLoc;
	private MapObjectType type;

	public MapObject(int xLoc, int yLoc, MapObjectType type) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.type = type;
	}
	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	
	@Override
	public String toString() {
		return "X: " + this.xLoc + " Y: " + this.yLoc;
	}
	public MapObjectType getType() {
		return type;
	}
	public void setType(MapObjectType type) {
		this.type = type;
	}
}
