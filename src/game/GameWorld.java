package game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class GameWorld implements Drawable {
	public World physicWorld = new World(new Vector2(0, -9.8f), true);
	public List<GameObject> gameObjects = new ArrayList<>();

	public GameWorld() {
	}

	public void addGameObject(GameObject obj) {
		gameObjects.add(obj);
	}

	@Override
	public void draw(SpriteBatch batch) {
		for (GameObject g : gameObjects) {
			g.draw(batch);
		}
	}
}
