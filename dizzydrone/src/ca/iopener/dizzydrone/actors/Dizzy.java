package ca.iopener.dizzydrone.actors;

import ca.iopener.dizzydrone.Assets;
import ca.iopener.dizzydrone.Assets.AssetName;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Dizzy extends Image {

	public static final int PAUSED = 1, MOVING = 2, SPINNING = 4;
	public int status;
	private int rotationSpeed = 5;
	private static final float DIZZYSIZE = 32f;
	public Vector2 vector;

	public Dizzy() {
		this.setSize(DIZZYSIZE, DIZZYSIZE);
		this.setName("Dizzy");
		this.status = PAUSED | SPINNING;
		this.vector = new Vector2(1, 0);
		//this.setPosition(100, 100);
		this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
		this.setRotation(0);
		this.setDrawable(new TextureRegionDrawable(Assets
				.getSprite(AssetName.DIZZY)));
	}

	public void move() {
		this.setPosition(this.getX() + this.vector.x, this.getY() + this.vector.y);
	}

	public void spin() {
		this.setRotation((this.getRotation() + rotationSpeed) % 360);
	}

	public boolean intersectsWith(Image actor) {
		if (actor.isVisible()) {
			Rectangle r = new Rectangle(this.getX(), this.getY(),
					this.getWidth(), this.getHeight());
			Rectangle s = new Rectangle(actor.getX(), actor.getY(),
					actor.getWidth(), actor.getHeight());
			return r.overlaps(s);
		} else {
			return false;
		}
	}

	public String toString() {
		return "Heading: " + this.vector + ", Speed: " + this.vector.len()
				+ ", Position: " + this.getX() + "/" + this.getY()
				+ ", Rotation: " + this.getRotation() + ", Status: " + status;
	}

}
