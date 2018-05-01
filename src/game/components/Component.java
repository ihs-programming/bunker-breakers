package game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Component {
	protected GameObject gameObject = null;

	public void setGameObject(GameObject obj) {
		gameObject = obj;
	}

	public void update(int ms) {
	}

	public void draw(SpriteBatch sbatch, ShapeRenderer sr) {

	}
}
