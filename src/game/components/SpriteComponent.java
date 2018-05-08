package game.components;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class SpriteComponent extends Component {

	public Sprite sprite;

	public SpriteComponent(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {
		Vector2 p = gameObject.getAbsolutePos();
		sprite.setCenter(p.x, p.y);
		sprite.draw(sb);
	}
}
