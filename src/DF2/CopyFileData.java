package DF2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileData {
    public static void main(String[] args) {
        try(FileInputStream inputFile = new FileInputStream("C:\\Users\\KBM  COMPUTERS\\Downloads\\Comment.eml");
        FileOutputStream outputFile = new FileOutputStream("C:\\Users\\KBM  COMPUTERS\\Downloads\\out.eml")){
            //Try reading the file data from the input to its output destination
            int i;
            do{
                i = inputFile.read();
                if(i != -1) outputFile.write(i);
            }while(i != -1);
        }catch (FileNotFoundException e){
            System.out.println("File Not Found: "+ e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Data transfer complete");
        }
    }
}
