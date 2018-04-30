package game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character extends GameObject {

	public Character() {
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(TextureLoader.defaultLoader.getCharacterSprite(0, 1), position.x, position.y);
	}
}
