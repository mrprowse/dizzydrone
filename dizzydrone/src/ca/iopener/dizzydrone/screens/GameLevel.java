package ca.iopener.dizzydrone.screens;

import ca.iopener.dizzydrone.DizzyDroneGame;
import ca.iopener.dizzydrone.actors.Dizzy;
import ca.iopener.dizzydrone.actors.PowerPack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public class GameLevel extends InputAdapter implements Screen {

	Stage stage = new Stage();
	DizzyDroneGame game;
	Array<Image> actors = new Array<Image>();
	SpriteBatch batch = new SpriteBatch();
	int levelScore;
	String levelName;
	boolean isTouched;
	BitmapFont font = new BitmapFont();
	Dizzy dizzy;
	FPSLogger fps = new FPSLogger();

	public GameLevel(DizzyDroneGame game) {
		this.game = game;
		this.dizzy = this.game.player;
		create();
	}

	/**
	 * @TODO: build a tool to import a level from XML or JSON
	 * @param id
	 */
	public void importLevel(int id) {

	}

	public void create() {
		Gdx.app.log("INFO", "GameLevel.create");
		Gdx.input.setInputProcessor(stage);
		actors.add(this.game.player);
		for (int i = 0; i < 5; i++) {
			actors.add(new PowerPack());
		}
		for (Image actor : actors) {
			stage.addActor(actor);
		}
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		if ((dizzy.status & Dizzy.PAUSED) > 0) {
			if (Gdx.input.justTouched()) {
				// Move Dizzy if paused an user clicks
				dizzy.status = dizzy.status & Dizzy.MOVING & ~Dizzy.PAUSED;
			}
		} else {
			if (Gdx.input.isTouched()) {
				Gdx.app.log("INFO", "touched");
				isTouched = true;
				// Don't move Dizzy while player is touching screen
				dizzy.status = dizzy.status & ~Dizzy.MOVING;
			} else if (isTouched) {
				// This is the case where the touch has just ended
				Gdx.app.log("INFO", "touch over");
				isTouched = false;
				Gdx.app.log("INFO", "Before: " + Float.toString(dizzy.vector.angle()));
				dizzy.vector.setAngle(dizzy.getRotation());
				Gdx.app.log("INFO", "After: " + Float.toString(dizzy.vector.angle()));
				dizzy.status = dizzy.status | Dizzy.MOVING;
			} else {
				// Default is Dizzy spins and moves
				dizzy.status = Dizzy.MOVING | Dizzy.SPINNING;
			}
		}
		// Move Dizzy
		if ((dizzy.status & Dizzy.MOVING) > 0) {
			dizzy.move();
		}
		if ((dizzy.status & Dizzy.SPINNING) > 0) {
			dizzy.spin();
		}
		bounceDizzy();

		fps.log();
		//Gdx.app.log("INFO", dizzy.toString());

		stage.act(delta);
		stage.draw();
		batch.enableBlending();
		batch.begin();
		// font.draw(batch, Float.toString(dizzy.getRotation()) + " @ "
		// + dizzy.position.len(), dizzy.getX(), dizzy.getY() - 20);
		font.draw(batch, dizzy.vector + " @ " + dizzy.vector.angle() +  "/" + dizzy.getRotation(),
				dizzy.getX(), dizzy.getY() + (2 * dizzy.getHeight()));
		batch.end();
	}

	public void bounceDizzy() {
		// Check collisions
		for (int i = 1; i < actors.size; i++) {
			Image a = actors.get(i);
			if (dizzy.intersectsWith(a)) {
				Gdx.app.log("INFO",
						"intersect at " + a.getName() + " @ " + a.getX() + "/"
								+ a.getY());
				dizzy.vector.set(-dizzy.vector.x, -dizzy.vector.y);
				a.setVisible(false);
				a.remove();
			}

		}
		// Check wall contact
		if (dizzy.getX() < 0
				|| (dizzy.getX() + dizzy.getWidth()) > stage.getWidth()) {
			dizzy.vector.x *= -1;
			// dizzy.vector.scl(1.1f).limit(5);
			if (dizzy.getX() < 0) {
				dizzy.setX(0);
			} else {
				dizzy.setX(stage.getWidth() - dizzy.getWidth());
			}
		}
		if (dizzy.getY() < 0
				|| (dizzy.getY() + dizzy.getHeight()) > stage.getHeight()) {
			dizzy.vector.y *= -1;
			// dizzy.vector.scl(1.1f).limit(5);
			if (dizzy.getY() < 0) {
				dizzy.setY(0);
			} else {
				dizzy.setY(stage.getHeight() - dizzy.getHeight());
			}
		}
		int result = dizzy.status & Dizzy.MOVING;
		if (result > 0) {
			dizzy.move();
		}
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("INFO", "GameLevel.resize");
		stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		Gdx.app.log("INFO", "GameLevel.show");
		// TODO Auto-generated method stub
		// Build game board
		// Create collectibles
		// Place player in centre of screen
		for (Image actor : actors) {
			if (actor.getName().equalsIgnoreCase("dizzy")) {
				actor.setPosition(stage.getWidth() / 2 - dizzy.getWidth() / 2,
						stage.getHeight() / 2 - dizzy.getHeight() / 2);
			} else {
				actor.setPosition((float) Math.random() * stage.getWidth(),
						(float) Math.random() * stage.getHeight());
			}
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
	}

}
