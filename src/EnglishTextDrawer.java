import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EnglishTextDrawer {
    public static void main (String args[]) {
        String fileName = "/home/gkammer/Documents/Kammer Shorthand/test";
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch (IOException e) {
            System.out.println("Unable to read file '" + fileName + "'");
        }
    }
}
