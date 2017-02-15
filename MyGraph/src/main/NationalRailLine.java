package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NationalRailLine {
	
	public static void main(String[] args){
		
		MyGraph<String> railwayMap = new MyGraph<>();
		//load nodes
		try {
			FileInputStream input = new FileInputStream("national rail line.txt");
			Scanner scr = new Scanner(input);
			while(scr.hasNextLine()) {
				String newline = scr.nextLine();
				String[] items = newline.split(",");
				String city = items[0];
				
				if(items.length > 1) {
					for (int i = 1; i < items.length; i++) {
						if(!isInt(items[i])) {
							
						}
					}
				}
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	private static boolean isInt(String str) {
		boolean isInt;
		for (int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
