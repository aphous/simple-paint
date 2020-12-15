package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.List;

public class Cursor {

    private Grid grid;
    private Rectangle cursor;
    private int cellSize;

    public Cursor(Grid grid){
        this.grid=grid;
        this.cellSize=grid.getCellSize();
    }

    public void init(){
        this.cursor= new Rectangle(grid.getX(), grid.getY(), grid.getCellSize(), grid.getCellSize());
        cursor.setColor(Color.GREEN);
        cursor.fill();
    }

    public int getWidth(){
        return cursor.getX()+cursor.getWidth();
    }

    public int getHeight(){
        return cursor.getY()+cursor.getHeight();
    }

    public int getRow(){
        return (cursor.getX()-grid.getX())/cellSize;
    }

    public int getCol(){
        return (cursor.getY()-grid.getY())/cellSize;
    }

    public void moveRight(){
        if(getWidth()<grid.getWidth()) {
            cursor.translate(cellSize, 0);
        }
    }

    public void moveLeft(){
        if(cursor.getX()>grid.getX()) {
            cursor.translate(-cellSize, 0);
        }
    }

    public void moveUp(){
        if(cursor.getY()>grid.getY()) {
            cursor.translate(0, -cellSize);
        }
    }

    public void moveDown(){
        if(getHeight()<grid.getHeight()) {
            cursor.translate(0, cellSize);
        }
    }

    public void paint(){
        List<Rectangle> rectangleList = grid.getRectangleList();
        int index=(getRow()*(grid.getRows()-1))+getRow()+getCol();

        Rectangle rectangle = rectangleList.get(index);
        if(!rectangle.isFilled()) {
            rectangle.fill();
        } else {
            rectangle.draw();
        }
    }
}
