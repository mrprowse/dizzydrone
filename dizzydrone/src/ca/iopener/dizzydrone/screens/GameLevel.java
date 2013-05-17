package ca.iopener.dizzydrone.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameLevel extends InputAdapter implements Screen {

	Stage stage;
	
/*	World world;
	Body player;
	OrthographicCamera cam;
	Box2DDebugRenderer renderer;
	BitmapFont font;
	Vector3 point;
	SpriteBatch batch;*/
	private Game game;
	
	public GameLevel(Game game) {
		this.game = game;
	}

	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
/*		Gdx.app.log("INFO", "create");
		world = new World(new Vector2(0, 0), true);
		renderer = new Box2DDebugRenderer();
		cam = new OrthographicCamera(28, 20);
		point = new Vector3();
		font = new BitmapFont();
		batch = new SpriteBatch();
		createWorld();
		Gdx.input.setInputProcessor(this);*/
	}

	/*private void createWorld() {
		// TODO Auto-generated method stub
		Gdx.app.log("INFO", "createWorld");
		player = createPlayer();
	}*/

	/*private Body createPlayer() {
		Gdx.app.log("INFO", "createPlayer");
		BodyDef def = new BodyDef();
		def.type = BodyType.DynamicBody;
		Body box = world.createBody(def);
		Gdx.app.log("INFO", box.toString());

		CircleShape circle = new CircleShape();
		circle.setRadius(0.45f);
		circle.setPosition(new Vector2(5f, 5f));
		box.createFixture(circle, 0);
		circle.dispose();

		box.setBullet(true);

		return box;
	}*/

	@Override
	public void render(float delta) {
		Gdx.app.log("INFO", "render");
		/*if (world == null) {
			create();
		}*/
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//cam.position.set(0, 0, 0);
		//cam.update();
		//cam.apply(Gdx.gl10);
		//renderer.render(world, new Matrix4());

		//Vector2 vel = player.getLinearVelocity();
		//Vector2 pos = player.getPosition();

		// le step...
		/*world.step(Gdx.graphics.getDeltaTime(), 4, 4);
		player.setAwake(true);

		cam.project(point.set(pos.x, pos.y, 0));
		batch.begin();
		font.drawMultiLine(batch, pos.x + "/" + pos.y, 100f, 100f);
		font.drawMultiLine(batch, player.getPosition().x + ", " + player.getPosition().y, point.x, point.y);
		batch.end();
		
		if (player.getPosition().x > 1 || player.getPosition().x < -1) {
			player.setTransform(0, 0, 0);
			player.setLinearVelocity(0, 0);
		}*/

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

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
		//world.dispose();
	}

}
