package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureLoader {
	public static final Path RESOURCE_DIR = Paths.get("data");

	private AssetManager assetManager;
	private Texture characterTexture;

	public static final TextureLoader defaultLoader = new TextureLoader();

	public TextureLoader() {
		characterTexture = new Texture("data/characters.png");
		assetManager = new AssetManager();
		addAllAssets(assetManager);
	}

	private void addAllAssets(AssetManager dest) {
		try {
			Files.walk(RESOURCE_DIR).forEach(p -> loadAsset(p));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadAsset(Path assetLocation) {
		if (Files.isDirectory(assetLocation)) {
			return;
		}
	}

	public TextureRegion getCharacterSprite(int spriteX, int spriteY) {
		TextureRegion[][] charSpriteRegions = TextureRegion.split(characterTexture, characterTexture.getWidth() / 12,
				characterTexture.getHeight() / 8);
		return charSpriteRegions[spriteX][spriteY];
	}

	public void dispose() {
		characterTexture.dispose();
	}
}
