package com.degesoft.snowflake;

import org.newdawn.slick.AppGameContainer;

public class MainClass {

    public static void main(String[] args) throws Exception {

        AppGameContainer app = new AppGameContainer(new GameStateController());

        app.setDisplayMode(800, 600, false);
        app.setIcons(new String[] { "res/snowflake16.png", "res/snowflake32.png" });
        app.start();
    }
}