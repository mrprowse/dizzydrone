package ca.iopener.dizzydrone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static enum AssetName {DIZZY, POWERUP, WALL, ENEMY};
	public static Texture background;
	public static TextureRegion backgroundRegion;

	private static TextureRegion dizzy, powerup, wall, enemy;
	private static BitmapFont font;

	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		dizzy = new TextureRegion(new Texture("img/dizzydrone.png"), 0, 0, 32, 32);
		powerup = new TextureRegion(new Texture("img/powerup.png"), 0, 0, 32, 32);
		font = new BitmapFont();
	}
	
	public static TextureRegion getSprite(AssetName asset) {
		if (asset == AssetName.DIZZY) {
			return dizzy;
		} else if (asset == AssetName.POWERUP) {
			return powerup;
		}
		return null;
	}

}
