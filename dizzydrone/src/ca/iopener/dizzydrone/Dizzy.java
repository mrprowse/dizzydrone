package ca.iopener.dizzydrone;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

public class Dizzy {

	public static final int ACTIVE = 0, PAUSED = 1, INVISIBLE = 2, DESTRUCTIVE = 4;
	private int score;
	private int status;
	public BodyDef bodyDef;
	public FixtureDef fixture;
	private Body body;

	public Dizzy() {
		bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.gravityScale = 0;
		bodyDef.angle = 0;
		bodyDef.angularVelocity = 1;
		bodyDef.position.set(200, 200);
		fixture = new FixtureDef();
		fixture.friction = 0;
		fixture.restitution = 1;
		fixture.shape = new CircleShape();
		fixture.shape.setRadius(16);
		fixture.density = 1;
		setScore(0);
		status = ACTIVE;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score > 0) {
			this.score = score;
		}
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}


}
