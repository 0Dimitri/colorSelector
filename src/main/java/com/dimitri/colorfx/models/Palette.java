package com.dimitri.colorfx.models;

import java.util.ArrayList;

public class Palette {

	private final Color color;
	private final ArrayList<Color> palette;

	public Palette(Color color) {

		this.color = color;

		this.palette = new ArrayList<>(5);

		for (int i = 0; i < 5; i++){
			palette.add(new Color(0, 0, 0));
		}
		generatePalette();
	}

	private void generatePalette() {

		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();

		//Random random = new Random();
		int inc = 0;
		for (int i = 0; i < palette.size(); i++) {
			Color color = palette.get(i);
			color.setRed((red + inc) % 256);
			color.setGreen((green + inc) % 256);
			color.setBlue((blue + inc) % 256);
			inc += 10;
		}
	}

	public ArrayList<Color> getPalette() {
		return this.palette;
	}

	public void updatePalette() {
		generatePalette();
	}

}
