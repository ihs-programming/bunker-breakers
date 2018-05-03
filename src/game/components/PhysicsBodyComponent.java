package game.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

import game.GameWorld;

public class PhysicsBodyComponent extends Component {
	private Body rb;
	private Shape shape;

	public PhysicsBodyComponent(Shape s) {
		shape = s;
	}

	/**
	 * Method depends on order of world update calls
	 */
	@Override
	public void update(int delta) {
		rb.setTransform(gameObject.position, rb.getAngle());
	}

	@Override
	public void postPhysicsUpdate() {
		gameObject.position = rb.getPosition();
	}

	@Override
	public void updateWorld(GameWorld world) {
		rb = world.physicsWorld.createBody(createBodyDef());
		rb.createFixture(createFixtureDef());
		shape.dispose();
	}

	private BodyDef createBodyDef() {
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		bd.position.set(gameObject.position);
		return bd;
	}

	private FixtureDef createFixtureDef() {
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		return fd;
	}

	public void setVelocity(Vector2 vel) {
		rb.setLinearVelocity(vel);
	}
}
