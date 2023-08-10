package com.example.todoapp;

import android.content.Context;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FIleHelper {
    public static final String FILENAME = "listinfo.dat";

    public static void writeData (ArrayList <String> item,Context context){


        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            ObjectOutputStream oas = new ObjectOutputStream(fos);
            oas.writeObject(item);
            oas.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

        public static ArrayList<String> readData (Context context){
        ArrayList<String> itemList = null;
            try {
                FileInputStream fis = context.openFileInput(FILENAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                itemList = (ArrayList<String>) ois.readObject();
            } catch (FileNotFoundException e) {
                itemList = new ArrayList<>();
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        return itemList;
        }
}
