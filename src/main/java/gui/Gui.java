package gui;

import static game.Directions.DOWN;
import static game.GameSettings.BACKGROUND_COLOR;
import static game.GameSettings.HEIGHT;
import static game.GameSettings.TEXT_COLOR;
import static game.GameSettings.WIDTH;

import game.BoardFactory;
import game.BodyPart;
import game.Game;
import game.GameSettings;
import game.Painter;
import game.Snake;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Contains all the methods needed for controller logic.
 */
public class Gui {


    /**
     * This method pops up an alert box that gives notifications.
     *
     * @param message - message of the alert box
     * @param title   - title of the alert
     */
    public void showAlert(String message, String title) {
        AlertBox.display(message, title);
    }

    /**
     * This method changes the url for the respective scenes.
     *
     * @param path - the url for the scene
     * @throws IOException When path not available.
     */
    public void switchScene(String path) throws IOException {
        final URL url = new File(path).toURI().toURL();
        final Parent entryParent = FXMLLoader.load(url);
        MainRunner.stage.setScene(new Scene(entryParent, 1000, 600));
    }

    /**
     * Getting text from textfield.
     * @param any Textfield
     * @return content of textfield
     */
    public String getText(TextField any) {
        return any.getText();
    }

    /**
     * Make GUI Scene for the snake game.
     */
    public void startSnakeGame() {
        final Canvas canvas = new Canvas(WIDTH, HEIGHT);
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // Creates a score node that is added to the scene.
        final Text score = new Text();
        score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        score.setFill(TEXT_COLOR);
        score.setX(50);
        score.setY(130);
        score.setText("Score: 0");

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, BACKGROUND_COLOR);

        root.getChildren().add(canvas);
        root.getChildren().add(score);

        Painter painter = new Painter(gc);

        Snake snake = new Snake(new BodyPart(10, 10,
            GameSettings.SNAKE_COLOR, GameSettings.SNAKE_HEAD), DOWN);
        BoardFactory factory = new BoardFactory("/image/background.png");
        Game game = new Game(scene, painter, canvas, snake, score, factory);

        snake.setGame(game);
        game.start();
        MainRunner.stage.setScene(scene);
    }
}

