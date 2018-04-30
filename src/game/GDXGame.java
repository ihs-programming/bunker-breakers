package game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GDXGame extends Game {
	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private GameWorld world;
	private Character mc = new Character();

	@Override
	public void create() {
		world = new GameWorld();
		world.addGameObject(mc);

		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(135f / 255, 206f / 255, 250f / 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		world.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		TextureLoader.defaultLoader.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
}
