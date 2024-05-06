package DF2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ShowFileExample {
    public static void main(String[] args) {
        FileInputStream fin;
        String filename;
        var input = new Scanner(System.in);

        System.out.print("Enter file path:");
        filename = input.nextLine();

        try{
            fin = new FileInputStream(filename);
        }catch(FileNotFoundException e){
            System.out.println("Failed to open file");
            return;
        }

        int i;
        try{
            do{
              i = fin.read();
              if(i != -1) System.out.println((char) i);
            }while(i!= -1);
        }catch(IOException e){
            System.out.println("Error reading contents");
            return;
        }

        try{
            fin.close();
        }catch(IOException e){
            System.out.println("Failed to close file");
        }
    }
}
