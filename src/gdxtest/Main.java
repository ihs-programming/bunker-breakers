package gdxtest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Cool Game";
		config.width = 800;
		config.height = 800;
		new LwjglApplication(new GDXGame(), config);
	}
}
