package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Grid {

    public static final int PADDING = 10;
    private List<Rectangle> rectangleList;
    private int rows;
    private int cols;
    private int cellSize;
    private String filename;

    public Grid(int rows, int cols){
        this.cellSize=50;
        this.rows=rows;
        this.cols=cols;
        this.filename="ola";
        this.rectangleList = new ArrayList<>();
    }

    public Grid(){
        this.cellSize=50;
        this.rows=10;
        this.cols=10;
        this.filename="ola";
        this.rectangleList = new ArrayList<>();
    }

    public void init(){
        Rectangle rectangle;
        int k = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                rectangle = new Rectangle((cellSize*i)+PADDING,(cellSize*j)+PADDING, cellSize, cellSize);
                rectangleList.add(k, rectangle);
                k++;
                rectangle.draw();
            }
        }
    }

    public int getX(){
        return PADDING;
    }

    public int getY(){
        return PADDING;
    }

    public int getWidth(){
        return PADDING+(rows*cellSize);
    }

    public int getHeight(){
        return PADDING+(cols*cellSize);
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public int getCellSize(){
        return cellSize;
    }

    public List<Rectangle> getRectangleList(){
        return rectangleList;
    }

   public void save() {
       try {
           FileWriter file = new FileWriter(this.filename);
           BufferedWriter write = new BufferedWriter(file);

           for(int i = 0; i<rectangleList.size(); i++){
               if(rectangleList.get(i).isFilled()) {
                   write.write(rectangleList.get(i).toString() + "\n");
               }
           }
           write.flush();
           write.close();
           System.out.println("Save sucessful");
       } catch(IOException e) {
           System.out.println(e.getMessage());
       }
   }


    public void load() {
        try {
            FileReader file = new FileReader(this.filename);
            BufferedReader reader = new BufferedReader(file);

            String line = "";
            String[] words;

            clear();

            while((line = reader.readLine()) != null){
                words = line.split(" ");

                for(int w = 0; w<words.length; w++) {
                    for (int i = 0; i < rectangleList.size(); i++) {
                        if (rectangleList.get(i).toString().equals(words[w])) {
                            rectangleList.get(i).fill();
                            break;
                        }
                    }
                }
            }

            reader.close();
            System.out.println("Load sucessful");

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clear() {
        for(int i = 0; i<rectangleList.size(); i++){
            if(rectangleList.get(i).isFilled()) {
                rectangleList.get(i).draw();
            }
        }
    }
}
