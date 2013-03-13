package com.degesoft.snowflake;
import java.util.*;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class flakesField {

	private List<SnowFlake> flakes = new LinkedList<SnowFlake>();
	private final int width;
    private final int height;
    
    public flakesField(int width, int height) throws SlickException {
    	this.width = width;
    	this.height = height;
    	for (int i = 0; i < 200; i++) {
    		flakes.add(new SnowFlake((float) (Math.random() * width)));
        }
    }
    
    public void render(GameContainer container, Graphics g) {

        for (SnowFlake f : flakes) {
            f.render(container, g);
        }
    }
    
    public void update(GameContainer container, int deltaMS) {
        for (SnowFlake f : flakes) {
            f.update(deltaMS);
            if(f.getY() > height)
            	f.reset((float) (Math.random() * width));
        }
    }
}
