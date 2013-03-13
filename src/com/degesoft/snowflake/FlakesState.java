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
        /*camera = new Camera();
        pizzaWorld = new PizzaWorld(camera);
        pizzaWorld.init(container);*/
    	field = new flakesField(800, 600);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        /*if (pizzaWorld != null) {
            pizzaWorld.render(container, g);
        }*/
    	if (field != null)
    		field.render(container, g);
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);
        startGame(container);
        /*music = new Music(soundPaths[random.nextInt(soundPaths.length)]);
        music.play(1.0f, musicVolume);
        music.addListener(this);*/
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
        /*music.fade(500, 0.0f, true);*/
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        container.setMinimumLogicUpdateInterval(msPerUpdate);
        container.setMaximumLogicUpdateInterval(msPerUpdate);
    }

    // We are using a fixed update rate
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        /*if (pizzaWorld != null) {
            camera.update(delta);
            pizzaWorld.update(container, delta);

            if (pizzaWorld.isGameOver()) {
                GameOverState state = (GameOverState) game.getState(GameOverState.ID);
                state.setVictory(pizzaWorld.isVictory());
                game.enterState(GameOverState.ID, new FadeOutTransition(Color.black, 1600), new FadeInTransition());
            }
        }*/
    	if (field!= null)
    		field.update(container, delta);
    }

    @Override
    public int getID() {
        return ID;
    }

}
