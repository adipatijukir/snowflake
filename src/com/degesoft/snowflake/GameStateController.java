package com.degesoft.snowflake;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameStateController extends StateBasedGame {
    public GameStateController() {
        super("SnowFlakes");
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        addState(new FlakesState());
    }

}