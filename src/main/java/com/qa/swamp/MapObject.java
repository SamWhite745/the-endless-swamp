package com.qa.swamp;

public abstract class MapObject {
	private int xLoc;
	private int yLoc;

	public MapObject(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
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
}
