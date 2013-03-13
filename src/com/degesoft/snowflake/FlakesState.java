package com.degesoft.snowflake;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class FlakesState extends BasicGameState {
    Random random = new Random();
    public static final int ID = 3;
    private final int updatesPerSecond = 40;
    private final int msPerUpdate = 1000 / updatesPerSecond;
    private flakesField field;

    public FlakesState() {
    }

    void startGame(GameContainer container) throws SlickException {
    	field = new flakesField(800, 600);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	if (field != null)
    		field.render(container, g);
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);
        startGame(container);
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        container.setMinimumLogicUpdateInterval(msPerUpdate);
        container.setMaximumLogicUpdateInterval(msPerUpdate);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	if (field!= null)
    		field.update(container, delta);
    }

    @Override
    public int getID() {
        return ID;
    }

}
