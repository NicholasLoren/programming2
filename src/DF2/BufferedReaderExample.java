package DF2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter some characters");

        do{
            c = (char) reader.read();
            System.out.println(c);

        }while(c!='q');
    }
}
