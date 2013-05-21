package ca.iopener.dizzydrone.actors;

import ca.iopener.dizzydrone.Assets;
import ca.iopener.dizzydrone.Assets.AssetName;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PowerPack extends Image {
	
	public float radius = 12;

	public PowerPack() {
		this.setName("PowerUp");
		this.setSize(32, 32);
		this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
		this.setDrawable(new TextureRegionDrawable(Assets.getSprite(AssetName.POWERUP)));
	}
}
