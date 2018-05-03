package game.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import game.GameWorld;

public class GameObject {
	protected Vector2 position = new Vector2();
	protected List<Component> components = new ArrayList<>();
	protected List<GameObject> children = new ArrayList<>();
	protected Optional<GameObject> parent = Optional.empty();

	protected GameWorld world;

	public GameObject(Optional<GameObject> parent, GameWorld w) {
		this.parent = parent;
		world = w;
	}

	public void draw(SpriteBatch batch, ShapeRenderer sr) {
		for (Component comp : components) {
			comp.draw(batch, sr);
		}
		for (GameObject child : children) {
			child.draw(batch, sr);
		}
	}

	public void update(int ms) {
		for (Component comp : components) {
			comp.update(ms);
		}
		for (GameObject gobj : children) {
			gobj.update(ms);
		}
	}

	public void postPhysicsUpdate() {
		for (Component comp : components) {
			comp.postPhysicsUpdate();
		}
		for (GameObject gobj : children) {
			gobj.postPhysicsUpdate();
		}
	}

	public Vector2 getRelativePos() {
		return new Vector2(position);
	}

	public Vector2 getAbsolutePos() {
		if (!parent.isPresent()) {
			return new Vector2(position);
		}
		return new Vector2(position).add(parent.get().getAbsolutePos());
	}

	public void addComponent(Component c) {
		c.setGameObject(this);
		components.add(c);
	}

	public void setWorld(GameWorld world) {
		this.world = world;
		for (Component c : components) {
			c.updateWorld(world);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends Component> Optional<T> getComponent(Class<T> compType) {
		for (Component c : components) {
			if (compType.isInstance(c)) {
				return Optional.of((T) c);
			}
		}
		return Optional.empty();
	}
}