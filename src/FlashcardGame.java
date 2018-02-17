import java.awt.*;
import java.util.Scanner;

public class FlashcardGame {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        ShorthandImage shorthandImage;
        String inputString = "";
        String generatedString;
        String consonants = "bCdfgjklmnprsStTvzh";
        String vowels = "aeiouU";

        while (!inputString.equals("stop")) {

            //Generate random "word" -- either CVC or CVCV
            int c1 = (int)(Math.random() * 19);
            int v1 = (int)(Math.random() * 6);
            int c2 = (int)(Math.random() * 18);
            int v2 = (int)(Math.random() * 12);
            generatedString = "";
            generatedString += consonants.charAt(c1);
            generatedString += vowels.charAt(v1);
            generatedString += consonants.charAt(c2);
            if (v2 < 6) { generatedString += vowels.charAt(v2); }

            shorthandImage = new ShorthandImage(400, 300, new Point(10, 150), new Color(255, 255, 255), 80, 30, 10);
            for (int i = 0; i < generatedString.length(); i++) {
                shorthandImage.draw(generatedString.charAt(i));
            }

            System.out.println("Your answer: ");
            shorthandImage.displayImage();
            long startTime = System.currentTimeMillis();
            inputString = scanner.nextLine();
            long stopTime = System.currentTimeMillis();

            if (inputString.equals(generatedString)) {
                System.out.println("Congrats, you got it right in " + (stopTime-startTime)/1000 + " seconds!");
            }
            else {
                System.out.println("Sorry, that is not correct. The correct answer was " + generatedString);
            }
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                System.out.print(e.getLocalizedMessage());
            }
            shorthandImage.hideImage();
        }

    }
}
