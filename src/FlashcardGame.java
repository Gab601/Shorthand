import java.awt.*;
import java.util.Scanner;

public class FlashcardGame {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        ShorthandImage shorthandImage = new ShorthandImage(1910, 100, new Point(10, 50), new Color(255, 255, 255));
        String inputString = "";
        String consonants = "bCdfgjklmnprsStTvz";
        String vowels = "aeiouU";

        while (!inputString.equals("stop")) {
            for (int i = 0; i < generatedString.length(); i++) {
                shorthandImage.draw(generatedString.charAt(i);
            }
            shorthandImage.displayImage();
            inputString = scanner.nextLine();
        }

    }
}
