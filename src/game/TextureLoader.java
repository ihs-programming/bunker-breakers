package game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureLoader {
	private Texture characterTexture;

	public static final TextureLoader defaultLoader = new TextureLoader();
	
	public TextureLoader() {
		characterTexture = new Texture("data/characters.png");
	}
	
	public TextureRegion getCharacterSprite(int spriteX, int spriteY) {
		TextureRegion[][] charSpriteRegions = TextureRegion.split(characterTexture, characterTexture.getWidth() / 12, characterTexture.getHeight() / 8);
		return charSpriteRegions[spriteX][spriteY];
	}
	
	public void dispose() {
		characterTexture.dispose();
	}
}
