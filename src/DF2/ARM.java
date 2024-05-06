package DF2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ARM {
    public static void main(String[] args) {
        String filepath = "C:/Users/KBM  COMPUTERS/Downloads/Comment.eml";

        try(FileInputStream fin = new FileInputStream(filepath)){
            int i;

            do{
                i = fin.read();
                System.out.print((char) i);
            }while(i != -1);
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            System.out.println("Something went wrong: "+ e.getMessage());
        }
    }
}
