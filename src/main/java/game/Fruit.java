package game;

import java.util.Random;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;



/**
 * Fruit class representing the pellets on the map,
 * that can be eaten by the snake.
 */
public class Fruit extends Tile {

    @Getter
    @Setter
    private int value;

    /**
     * Default constructor for the Fruit items on the map.
     * @param x the x coordinate on the map.
     * @param y the y coordinate on the map.
     * @param color the color of the fruit.
     * @param sprite the sprite of the fruit (optional).
     * @param value the value of this fruit tile.
     */
    public Fruit(int x, int y, Color color, String sprite, int value) {
        super(x, y, color, sprite);
        this.value = value;
        int random = new Random().nextInt((4)) + 1;
        String pelletSprite = "image/Pellet" + random + ".png";
        System.out.println(pelletSprite);
        this.setSprite(pelletSprite);
    }
}
