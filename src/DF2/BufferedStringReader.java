package DF2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedStringReader {
    public static void main(String[] args) throws IOException {
        String words;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter some words... Enter 'stop' to quit");
        do{
            words = reader.readLine();
            System.out.println(words);
        }while(!words.equals("stop"));


    }
}
