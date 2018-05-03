package game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class Geometry {
	public static float getRadius(Shape s) {
		switch (s.getType()) {
		case Polygon:
			PolygonShape ps = (PolygonShape) s;
			float maxRadius = 0f;
			for (int i = 0; i < ps.getVertexCount(); i++) {
				for (int j = 0; j < ps.getVertexCount(); j++) {
					Vector2 a = new Vector2();
					Vector2 b = new Vector2();
					ps.getVertex(i, a);
					ps.getVertex(j, b);
					maxRadius = Math.max(maxRadius, new Vector2(a).sub(b).len());
				}
			}
			break;
		default:
			return -1f;
		}
		return -1f;
	}
}
