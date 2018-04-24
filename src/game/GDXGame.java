package game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GDXGame implements ApplicationListener {
	private SpriteBatch batch;
	private TextureRegion img;
	private Character mc = new Character();

	@Override
	public void create() {
		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(135f / 255, 206f / 255, 250f / 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		mc.draw(batch);
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
