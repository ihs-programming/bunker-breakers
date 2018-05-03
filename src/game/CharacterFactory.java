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
		emptyObject.addComponent(new SpriteComponent(TextureLoader.defaultLoader.getCharacterSprite(0, 0)));
		emptyObject.addComponent(new CharacterController());
		emptyObject.addComponent(new PhysicsBodyComponent(createCharacterHitboxShape()));
		return emptyObject;
	}

	private static Shape createCharacterHitboxShape() {
		PolygonShape pshape = new PolygonShape();
		pshape.setAsBox(1f, 1f);
		return pshape;
	}
}
