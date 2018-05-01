package game;

import game.components.CharacterController;
import game.components.GameObject;
import game.components.SpriteComponent;

public class CharacterFactory {
	public static GameObject createCharacter(GameObject emptyObject) {
		emptyObject.addComponent(new SpriteComponent(TextureLoader.defaultLoader.getCharacterSprite(0, 0)));
		emptyObject.addComponent(new CharacterController());
		return emptyObject;
	}
}
