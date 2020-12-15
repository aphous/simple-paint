package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler{

    private Keyboard keyboard;
    private Cursor cursor;
    private Grid grid;

    public void init(Cursor cursor, Grid grid){
        this.keyboard = new Keyboard(this);
        this.cursor=cursor;
        this.grid=grid;

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);//Indicar qual a tecla
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);//Indicar qual a tecla
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);//Indicar qual a tecla
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);//Indicar qual a tecla
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);//Indicar qual a tecla
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);//Indicar qual a tecla
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);//Indicar qual a tecla
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);//Indicar qual a tecla
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);//Indicar qual po evento


        keyboard.addEventListener(rightPressed);//Dizer esta atento a este evento
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(space);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);
        keyboard.addEventListener(clear);

    }

    private void setCursor(Cursor cursor){
        this.cursor=cursor;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            cursor.moveDown();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            cursor.moveLeft();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            cursor.moveUp();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            cursor.moveRight();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            cursor.paint();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            grid.save();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_L){
            grid.load();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_C){
            grid.clear();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
