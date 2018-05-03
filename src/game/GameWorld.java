package game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import game.components.GameObject;

public class GameWorld {
	/*
	 * Values taken from
	 * https://github.com/libgdx/libgdx/wiki/box2d#creating-a-world
	 */
	public static final int VELOCITY_ITERATIONS = 6;
	public static final int POSITION_ITERATIONS = 2;
	public static final int PHYSICS_TIME_STEP = 16;

	public World physicsWorld = new World(new Vector2(), true);
	private int physicsUpdateAccumulator = 0;
	private Camera camera;

	public List<GameObject> gameObjects = new ArrayList<>();

	private Box2DDebugRenderer debugRenderer;

	public GameWorld() {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (GDXGame.DEBUG_MODE) {
			debugRenderer = new Box2DDebugRenderer();
		}
	}

	public void addGameObject(GameObject obj) {
		obj.setWorld(this);
		gameObjects.add(obj);
	}

	public void draw(SpriteBatch batch, ShapeRenderer sr) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if (GDXGame.DEBUG_MODE) {
			debugRenderer.render(physicsWorld, new Matrix4(camera.combined));
		}
		for (GameObject g : gameObjects) {
			g.draw(batch, sr);
		}
		batch.end();
	}

	public void update(int ms) {
		for (GameObject gobj : gameObjects) {
			gobj.update(ms);
		}
		updatePhysicWorld(ms);
		for (GameObject gobj : gameObjects) {
			gobj.postPhysicsUpdate();
		}
	}

	private void updatePhysicWorld(int ms) {
		physicsUpdateAccumulator += ms;
		while (physicsUpdateAccumulator >= PHYSICS_TIME_STEP) {
			physicsWorld.step(PHYSICS_TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
			physicsUpdateAccumulator -= PHYSICS_TIME_STEP;
		}
	}
}
