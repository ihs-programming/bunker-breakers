package game.components;

import java.util.Optional;

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

	private Optional<BodyDef> customBodyDef = Optional.empty();
	private Optional<FixtureDef> customFixtureDef = Optional.empty();

	public PhysicsBodyComponent(Shape s, Optional<BodyDef> bd, Optional<FixtureDef> fd) {
		shape = s;
		customBodyDef = bd;
		customFixtureDef = fd;
	}

	public PhysicsBodyComponent(Shape s) {
		this(s, Optional.empty(), Optional.empty());
	}

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
		if (rb != null && world.physicsWorld == rb.getWorld()) {
			return;
		}
		rb = world.physicsWorld.createBody(createBodyDef());
		rb.createFixture(createFixtureDef());
		rb.setTransform(gameObject.position, 0f);
	}

	private BodyDef createBodyDef() {
		if (customBodyDef.isPresent()) {
			return customBodyDef.get();
		}
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DynamicBody;
		bd.position.set(gameObject.position);
		return bd;
	}

	private FixtureDef createFixtureDef() {
		if (customFixtureDef.isPresent()) {
			return customFixtureDef.get();
		}
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		return fd;
	}

	public void setVelocity(Vector2 vel) {
		rb.setLinearVelocity(vel);
	}
}
