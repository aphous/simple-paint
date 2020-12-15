package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RectangleList {

    private List<Rectangle> rectangleList = new ArrayList();
    private String filename = "ola";

    public void add(int index, Rectangle rectangle){
        rectangleList.add(index, rectangle);
    }

    public Rectangle get(int index){
        return rectangleList.get(index);
    }

    public void save(){
        try {
            FileWriter file = new FileWriter(this.filename);
            BufferedWriter write = new BufferedWriter(file);

            for(int i = 0; i<rectangleList.size(); i++){
                if(rectangleList.get(i).isFilled()){
                    write.write(rectangleList.indexOf(rectangleList.get(i)));
                }
            }
            write.flush();
            write.close();
            System.out.println("Save sucessful");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){

        try {
            FileReader file = new FileReader(this.filename);
            BufferedReader reader = new BufferedReader(file);

            int index;

            for(int i = 0; i<rectangleList.size(); i++){
                if(rectangleList.get(i).isFilled()) {
                    rectangleList.get(i).draw();
                }
            }
            while((index = reader.read()) != -1){
                rectangleList.get(index).fill();
            }

            reader.close();
            System.out.println("Load sucessfull");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void saveString(){
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
            System.out.println("Save2 sucessful");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadString(){
        try {
            FileReader file = new FileReader(this.filename);
            BufferedReader reader = new BufferedReader(file);

            String line = "";
            String[] words;

            for(int i = 0; i<rectangleList.size(); i++){
                if(rectangleList.get(i).isFilled()) {
                    rectangleList.get(i).draw();
                }
            }

            while((line = reader.readLine()) != null){
                words = line.split(" ");

                for(int w = 0; w<words.length; w++) {
                    for (int i = 0; i < rectangleList.size(); i++) {
                        if (rectangleList.get(i).toString().equals(words[w])) {
                            rectangleList.get(i).fill();
                        }
                    }
                }
            }

            reader.close();
            System.out.println("Load2 sucessful");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void saveObject(){
        try {
            FileOutputStream file = new FileOutputStream(this.filename);
            ObjectOutputStream stream = new ObjectOutputStream(file);

            for(int i = 0; i<rectangleList.size(); i++){
                if(rectangleList.get(i).isFilled()) {
                    Object alo = rectangleList.get(i);
                    stream.writeObject(alo);
                }
            }
            stream.close();
            file.close();
            System.out.println("Save2 sucessful");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void clear(){
        for(int i = 0; i<rectangleList.size(); i++){
            if(rectangleList.get(i).isFilled()) {
                rectangleList.get(i).draw();
            }
        }
    }

}
