package org.academiadecodigo.bootcamp;

public class Paint {

    private Grid grid;
    private Cursor cursor;
    private Controls keyboard;

    public Paint(){
        this.grid = new Grid();
        this.keyboard = new Controls();
        this.cursor = new Cursor(grid);
    }

    public void start() {
        grid.init();
        cursor.init();
        keyboard.init(cursor, grid);
    }
}
