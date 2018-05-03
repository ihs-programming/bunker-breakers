package game;

import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

import game.components.CharacterController;
import game.components.GameObject;
import game.components.PhysicsBodyComponent;
import game.components.SpriteComponent;

public class CharacterFactory {
	public static final float DEFAULT_CHARACTER_HEIGHT = 1.5f;

	public static GameObject createCharacter(GameObject emptyObject) {
		emptyObject.addComponent(createResizedSprite());
		emptyObject.addComponent(new CharacterController());
		emptyObject.addComponent(new PhysicsBodyComponent(getCharacterHitboxShape()));
		return emptyObject;
	}

	private static Shape getCharacterHitboxShape() {
		PolygonShape pshape = new PolygonShape();
		pshape.setAsBox(2f, 2f);
		return pshape;
	}

	private static SpriteComponent createResizedSprite() {
		SpriteComponent sc = new SpriteComponent(TextureLoader.defaultLoader.getCharacterSprite(0, 0));
		Shape hitbox = getCharacterHitboxShape();
		float maxdiameter = Math.max(sc.sprite.getHeight(), sc.sprite.getWidth());
		sc.sprite.setScale(Geometry.getRadius(hitbox) / maxdiameter / 2f);
		sc.sprite.setScale(.1f);
		return sc;
	}
}
