package ca.iopener.dizzydrone;

import ca.iopener.dizzydrone.Assets.AssetName;
import ca.iopener.dizzydrone.actors.Dizzy;
import ca.iopener.dizzydrone.screens.GameLevel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;

public class DizzyDroneGame extends Game {
	
	static final Array<Screen> screens = new Array<Screen>();
	//public Assets assets = new Assets();
	public Dizzy player;
	
	@Override
	public void create() {
		Assets.load();
		if (Assets.getSprite(AssetName.DIZZY) == null) {
			Gdx.app.log("INFO", "dizzy is null");
		}
		player = new Dizzy();
		screens.add(new GameLevel(this));
		setScreen(screens.get(0));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
