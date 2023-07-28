package com.dimitri.colorfx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import com.dimitri.colorfx.models.*;


public class ColorController implements Initializable {

    private Color color;
    private Palette palette;

    private enum COLOR {
        RED, GREEN, BLUE;
    }

    @FXML
    private Slider sliderRed;

    @FXML
    private Slider sliderGreen;

    @FXML
    private Slider sliderBlue;

    @FXML
    private TextField textFieldRed;

    @FXML
    private TextField textFieldBlue;

    @FXML
    private TextField textFieldGreen;

    @FXML
    private TextField hexColor;

    @FXML
    private Pane paneColor;

    @FXML
    private Pane paneInvertColor;

    @FXML
    private Pane paneColorPalette1, paneColorPalette2, paneColorPalette3;

    @FXML
    private Pane paneColorPalette4;

    @FXML
    private Pane paneColorPalette5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        color = new Color(100, 100, 50);
        palette = new Palette(color);

        updateUI();

        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> setColor(COLOR.RED, newValue.intValue()));
        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> setColor(COLOR.GREEN, newValue.intValue()));
        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> setColor(COLOR.BLUE, newValue.intValue()));

        textFieldRed.setOnAction(actionEvent -> setColor(COLOR.RED, textFieldRed.getText()));
        textFieldGreen.setOnAction(actionEvent -> setColor(COLOR.GREEN, textFieldGreen.getText()));
        textFieldBlue.setOnAction(actionEvent -> setColor(COLOR.BLUE, textFieldBlue.getText()));

        hexColor.setOnAction(actionEvent -> setColor(hexColor.getText()));
    }

    private void setColor(COLOR rgb, String value) {
        try {
            setColor(rgb, Integer.parseInt(value));
        } catch (IllegalArgumentException e) {
            updateUI();
        }
    }

    private void setColor(COLOR rgb, int value) {
        try {
            switch (rgb) {
                case RED:
                    color.setRed(value);
                    break;
                case GREEN:
                    color.setGreen(value);
                    break;
                case BLUE:
                    color.setBlue(value);
                    break;
            }
        } catch (IllegalArgumentException e) {
            // Nothing to do
        }
        updateUI();
    }

    private void setColor(String hex) {
        try {
            color.setHexValue(hex);
        } catch (IllegalArgumentException e) {
            // Nothing to do
        }

        updateUI();
    }

    private void updateUI() {

        palette.updatePalette();

        sliderRed.setValue(color.getRed());
        sliderGreen.setValue(color.getGreen());
        sliderBlue.setValue(color.getBlue());

        textFieldRed.setText(String.valueOf(color.getRed()));
        textFieldGreen.setText(String.valueOf(color.getGreen()));
        textFieldBlue.setText(String.valueOf(color.getBlue()));

        hexColor.setText(color.getHexValue());

        paneColor.setStyle("-fx-background-color: " + color.getHexValue() + ";");
        paneInvertColor.setStyle("-fx-background-color: " + color.getInvertedHexValue() + ";");
        paneColorPalette1.setStyle("-fx-background-color: " + palette.getPalette().get(0).getHexValue() + ";");
        paneColorPalette2.setStyle("-fx-background-color: " + palette.getPalette().get(1).getHexValue() + ";");
        paneColorPalette3.setStyle("-fx-background-color: " + palette.getPalette().get(2).getHexValue() + ";");
        paneColorPalette4.setStyle("-fx-background-color: " + palette.getPalette().get(3).getHexValue() + ";");
        paneColorPalette5.setStyle("-fx-background-color: " + palette.getPalette().get(4).getHexValue() + ";");
    }

}
