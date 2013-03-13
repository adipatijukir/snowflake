package com.degesoft.snowflake;
import java.lang.Math; 

import org.newdawn.slick.*;

public class SnowFlake {
	protected float x, y;
	protected float angle;
	protected float angleStep;
	protected float lateralPower;
	protected float fallSpeed;
	protected Image flakeImage;
	protected float rotationSpeed;
	protected float scale;
	protected int rotationSense;
	
	public SnowFlake(float x) throws SlickException {
		angle = (float) (Math.random() * 2 * Math.PI);
		angleStep = (float) ((Math.random() * Math.PI / 16) + Math.PI / 32);
		this.x = x;
		fallSpeed = (float) (Math.random() * 10 + 1);
		y = 56 * fallSpeed;
		lateralPower = (float) (Math.random() * 10 + 0.1);
		flakeImage = new Image("res/snowflake.png");
		rotationSpeed = (float) (Math.PI * Math.random() / 16);
		flakeImage.rotate((float) (Math.PI * 2 * Math.random()));
		scale = (float) (Math.random() / 1.5 + 0.66);
		if(Math.random() >= 0.5)
			rotationSense = 1;
		else
			rotationSense = -1;
	}
	
	public float getX() {
        return (float) (x + Math.sin(angle) * lateralPower);
    }

    public float getY() {
        return y;
    }
    
    public boolean update(int deltaMS) {
    	y += fallSpeed * deltaMS / 1000 * (0.9 + Math.random() / 5);
    	angle += angleStep * deltaMS / 100 * (0.9 + Math.random() / 5);
    	flakeImage.rotate((float) (rotationSpeed * rotationSense * deltaMS / 10 * (0.9 + Math.random() / 5)));
    	return true;
    }
    
    public void render(GameContainer slickContainer, Graphics g) {
    	g.drawImage(flakeImage, this.getX(), this.getY(), this.getX() + flakeImage.getWidth() * scale, this.getY() + flakeImage.getHeight() * scale, 0, 0, flakeImage.getWidth(), flakeImage.getHeight());
    }
    
    public void reset(float x) {
		angle = (float) (Math.random() * 2 * Math.PI);
		angleStep = (float) ((Math.random() * Math.PI / 16) + Math.PI / 32);
		y = -15;
		this.x = x;
		fallSpeed = (float) (Math.random() * 10 + 1);
		rotationSpeed = (float) (Math.PI * Math.random() / 16);
		lateralPower = (float) (Math.random() * 10 + 0.1);
		scale = (float) (Math.random() / 2 + 0.75);
		if(Math.random() >= 0.5)
			rotationSense = 1;
		else
			rotationSense = -1;
	}
}
