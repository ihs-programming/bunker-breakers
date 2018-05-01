package game.components;

import java.util.Optional;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class CharacterController extends Component {
	@Override
	public void update(int ms) {
		Vector2 movement = new Vector2();
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			movement.y += 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			movement.x -= 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			movement.y -= 1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			movement.x += 1;
		}
		movement.scl(1000f);
		Optional<PhysicsBodyComponent> bodyComp = gameObject.getComponent(PhysicsBodyComponent.class);
		if (bodyComp.isPresent()) {
			PhysicsBodyComponent pbc = bodyComp.get();
			pbc.setVelocity(movement);
		} else {
			gameObject.position.add(movement);
		}
	}
}
