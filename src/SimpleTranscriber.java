import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class SimpleTranscriber {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String shavianString = "";
        TextTranscriber textTranscriber = null;

        try {
            textTranscriber = new TextTranscriber();
            shavianString = textTranscriber.getShavianFromEnglish(inputString);
        }
        catch (IOException e) { }


        ShorthandImage shorthandImage = new ShorthandImage(1910, 100, new Point(10, 50), new Color(255, 255, 255));

        char letter;
        for (int i = 0; i < inputString.length(); i++) {
            letter = inputString.charAt(i);
            shorthandImage.draw(letter);
        }
        shorthandImage.displayImage();
        System.out.println(shavianString);
        System.out.println(textTranscriber.getPhoneticFromShavian(shavianString));
        System.out.print("Process finished successfully");
    }
}
