package game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Character extends GameObject {

	public Character() {
	}

	@Override
	public void draw(SpriteBatch batch, ShapeRenderer sr) {
		batch.draw(TextureLoader.defaultLoader.getCharacterSprite(0, 1), position.x, position.y);
	}

	public void move(Vector2 direction) {

	}
}
