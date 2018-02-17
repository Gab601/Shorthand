import java.awt.*;
import java.util.Scanner;

public class SimpleTranscriber {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);

        ShorthandImage shorthandImage = new ShorthandImage(1910, 100, new Point(10, 50), new Color(255, 255, 255));
        String inputString = scanner.nextLine();
        char letter;
        for (int i = 0; i < inputString.length(); i++) {
            letter = inputString.charAt(i);
            shorthandImage.draw(letter);
        }
        shorthandImage.displayImage();
        System.out.print("Process finished successfully");
    }
}
