package gui.controller;

import game.Settings;
import gui.Gui;
import java.io.IOException;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * This class is a controller class for settings.
 */
public class SettingController {
    public Gui gui = new Gui();

    public RadioButton jungleRadio;
    public RadioButton nightRadio;
    public RadioButton basicRadio;
    public ToggleGroup themes;

    public RadioButton easyRadio;
    public RadioButton difficultRadio;
    public RadioButton insaneRadio;
    public ToggleGroup difficulty;

    /**
     * This method goes back to the Entry page from Settings page.
     * @throws IOException exception for file. (exists or not).
     */
    public void goBackEntry() throws IOException {
        gui.switchScene("src/main/resources/fxml/Entry.fxml");
    }


    /**
     * Changes the theme of the game based on which one is selected.
     */
    public void changeThemes() {
        RadioButton selected = (RadioButton)themes.getSelectedToggle();
        if (selected.equals(jungleRadio)) {
            Settings.setBackground("/image/jungle_bg.png");
        } else if (selected.equals(nightRadio)) {
            Settings.setBackground("/image/night.png");
        } else if (selected.equals(basicRadio)) {
            Settings.setBackground("");
        }
    }

    /**
     * Changes the difficulty of the game.
     */
    public void changeDifficulty() {
        RadioButton selected = (RadioButton)difficulty.getSelectedToggle();
        if (selected.equals(easyRadio)) {
            Settings.setGameMode(0);
        } else if (selected.equals(difficultRadio)) {
            Settings.setGameMode(1);
        } else if (selected.equals(insaneRadio)) {
            Settings.setGameMode(2);
        }
    }
}
