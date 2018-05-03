package game;

import java.util.Optional;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import game.components.GameObject;

public class GDXGame extends Game {
	public static boolean DEBUG_MODE = true;

	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private GameWorld world;

	private long prevTime = 0;

	@Override
	public void create() {
		world = new GameWorld();
		GameObject character = new GameObject(Optional.empty(), world);
		world.addGameObject(CharacterFactory.createCharacter(character));
		world.addGameObject(WorldGenerator.generateWorldMap(new GameObject(Optional.empty(), world)));

		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();

		prevTime = System.currentTimeMillis();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(135f / 255, 206f / 255, 250f / 255, 1);
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.draw(batch, shapeRenderer);

		int delta = (int) (System.currentTimeMillis() - prevTime);
		world.update(delta);
		prevTime = System.currentTimeMillis();
	}

	@Override
	public void dispose() {
		batch.dispose();
		TextureLoader.defaultLoader.dispose();
	}
}
