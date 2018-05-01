package game.components;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class SpriteComponent extends Component {

	private Sprite sprite;

	public SpriteComponent(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {
		Vector2 p = gameObject.getAbsolutePos();
		sb.draw(sprite, p.x, p.y);
	}
}
