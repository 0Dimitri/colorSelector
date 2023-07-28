package com.dimitri.colorfx.models;

public class Color {
    private int red;
    private int green;
    private int blue;
    private String hex;

    public Color(int red, int green, int blue) {
        String redHex;
        String greenHex;
        String blueHex;

        redHex = red < 16 ?  "0" + Integer.toHexString(red):Integer.toHexString(red);
        greenHex = green < 16 ?  "0" + Integer.toHexString(green):Integer.toHexString(green);
        blueHex = blue < 16 ?  "0" + Integer.toHexString(blue):Integer.toHexString(blue);

        this.hex = (redHex + greenHex + blueHex).toUpperCase();
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public Color(String hexValue) {
        this.hex = hexValue.substring(1,7);
        this.red = Integer.parseInt(hexValue.substring(1,3),16);
        this.green = Integer.parseInt(hexValue.substring(3,5),16);
        this.blue = Integer.parseInt(hexValue.substring(5,7),16);
    }

    @Override
    public String toString() {
        return "[value=" + this.getHexValue().toUpperCase() + ", r=" + this.getRed() + ", g=" +this.getGreen() + ", b=" + this.getBlue() + "]";
    }

    public String getHexValue() {
        return "#" + this.hex;
    }

    public String getInvertedHexValue() {
        Color color = new Color(this.blue,this.green,this.red);
        return color.getHexValue();
    }

    public void setHexValue(String hexValue) {
        this.hex = hexValue.substring(1,7);
        this.red = Integer.parseInt(hexValue.substring(1,3),16);
        this.green = Integer.parseInt(hexValue.substring(3,5),16);
        this.blue = Integer.parseInt(hexValue.substring(5,7),16);
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        String redHex;
        redHex = red < 16 ?  "0" + Integer.toHexString(red):Integer.toHexString(red);
        if (red >= 0 && red <= 255){
            this.red = red;

            if (this.hex.length() != 0){
                this.hex = (redHex + this.getHexValue().substring(3,7)).toUpperCase();
            }
        }else{
            throw new IllegalArgumentException("Value must be >= 0 and <= 255");
        }
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        String greenHex;
        greenHex = green < 16 ?  "0" + Integer.toHexString(green):Integer.toHexString(green);
        if (green >= 0 && green <= 255){
            this.green = green;
            if (this.hex.length() !=0) {
                this.hex = (this.getHexValue().substring(1, 3) + greenHex + this.getHexValue().substring(5, 7)).toUpperCase();
            }
        }else{
            throw new IllegalArgumentException("Value must be >= 0 and <= 255");
        }
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        String blueHex;
        blueHex = blue < 16 ?  "0" + Integer.toHexString(blue):Integer.toHexString(blue);
        if (blue >= 0 && blue <= 255){
            this.blue = blue;
            if (this.hex.length() != 0) {
                this.hex = (this.getHexValue().substring(1, 5) + blueHex).toUpperCase();
            }
        }else{
            throw new IllegalArgumentException("Value must be >= 0 and <= 255");
        }
    }
}