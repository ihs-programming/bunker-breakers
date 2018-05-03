package game;

import java.util.Optional;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Shape;

import game.components.GameObject;
import game.components.PhysicsBodyComponent;

public class WorldGenerator {
	public static GameObject generateWorldMap(GameObject gobj) {
		createFloor(gobj);
		return gobj;
	}

	private static GameObject createFloor(GameObject parent) {
		EdgeShape s = new EdgeShape();
		s.set(new Vector2(0f, 0f), new Vector2(10f, 0f));
		createWall(parent, s);
		return parent;
	}

	protected static GameObject createWall(GameObject parent, Shape wallType) {
		GameObject gobj = parent.createChild();
		BodyDef bd = new BodyDef();
		bd.fixedRotation = true;
		gobj.addComponent(new PhysicsBodyComponent(wallType, Optional.of(bd), Optional.empty()));
		wallType.dispose();
		return gobj;
	}
}
