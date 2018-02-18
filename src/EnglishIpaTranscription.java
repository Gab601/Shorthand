import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.Scanner;

public class EnglishIpaTranscription {
    public static void main (String args[]) {
        try (WebClient webClient = new WebClient()) {
            java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
            java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

            HtmlPage page = webClient.getPage("http://texttophonetic.appspot.com/");
            HtmlForm form = page.getForms().get(0);
            HtmlTextArea inputTextArea = form.getTextAreaByName("c");
            HtmlButton button = page.getFirstByXPath("//button[@id='btnTranslate']");
            HtmlTextArea outputTextArea = form.getTextAreaByName("txtPhonetic");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your English phrase here: ");
            String inputText = scanner.nextLine();

            inputTextArea.setText(inputText);
            button.click();
            try { Thread.sleep(1000); }
            catch (InterruptedException e) { }
            System.out.println("The IPA pronunciation of that phrase is: " + outputTextArea.getTextContent());

        }
        catch (IOException e) {

        }
    }

}
