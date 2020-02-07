package com.qa.swamp;

import java.util.Random;
import java.util.Scanner;

public abstract class Utils {
	public static int getRandomLocation(int mapSize) {
		Random r = new Random();
		int rand = r.nextInt(mapSize);
		return rand;
	}
	
	public static String getStringInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
