package game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import game.components.GameObject;

public class GameWorld {
	public World physicWorld = new World(new Vector2(0, -9.8f), true);
	public List<GameObject> gameObjects = new ArrayList<>();

	public GameWorld() {
	}

	public void addGameObject(GameObject obj) {
		obj.setWorld(this);
		gameObjects.add(obj);
	}

	public void draw(SpriteBatch batch, ShapeRenderer sr) {
		for (GameObject g : gameObjects) {
			g.draw(batch, sr);
		}
	}

	public void update(int ms) {
		for (GameObject gobj : gameObjects) {
			gobj.update(ms);
		}
	}
}
