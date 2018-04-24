package game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Character {
	public Vector2 position = new Vector2();

	public void draw(SpriteBatch batch) {
		batch.draw(TextureLoader.defaultLoader.getCharacterSprite(0, 1), position.x, position.y);
	}

	public void update(int delta) {
	}
}
