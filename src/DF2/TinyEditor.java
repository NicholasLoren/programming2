package DF2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEditor {
    public static void main(String[] args) throws IOException {
        String [] text = new String [100];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter some text");
        System.out.println("Enter `stop` to quit");

        for(int i = 0; i < text.length; i++){
            text[i] = reader.readLine();
            if(text[i].equals("stop")) break;
        }

        for (String s : text) {
            if (s.equals("stop")) break;
            System.out.println(s);
        }
    }
}
