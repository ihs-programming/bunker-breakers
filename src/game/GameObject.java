package game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class GameObject implements Drawable {
	protected Vector2 position = new Vector2();

	@Override
	public void draw(SpriteBatch batch, ShapeRenderer sr) {
	}

	public void update(int ms) {
	}
}
