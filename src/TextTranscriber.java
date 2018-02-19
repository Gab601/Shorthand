import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TextTranscriber {


    private HtmlPage htmlPage;
    private HtmlForm inputForm;
    private HtmlTextArea inputTextArea;
    private HtmlInput transcribeButton;
    private HtmlTableDataCell outputCell;
    private HtmlInput shavianButton;


    public TextTranscriber() throws IOException {
        WebClient webClient = new WebClient();
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
        Logger.getLogger("org.apache.http").setLevel(Level.OFF);

        htmlPage = webClient.getPage("http://upodn.com/phon.php");
        inputForm = htmlPage.getForms().get(0);
        inputTextArea = inputForm.getTextAreaByName("intext");
        shavianButton = inputForm.getInputByValue("3");
        transcribeButton = htmlPage.getFirstByXPath("//input[@value='Transcribe it']");


    }

    public String getShavianFromEnglish(String englishText) throws IOException {
        inputTextArea.setText(englishText);
        shavianButton.click();
        htmlPage = transcribeButton.click();
        HtmlTableDataCell outputCell = htmlPage.getFirstByXPath("//td[@width='50%' and @valign='top' and @align='left']");
        return outputCell.asText();
    }

    public String getPhoneticFromShavian(String shavianText) {
        String phoneticString = "";
        for (int position = 0; position < shavianText.length(); position += 2) {
            if (shavianText.substring(position, position + 1).equals(" ")) {
                phoneticString += " ";
                position--;
            }
            else if (shavianText.substring(position, position + 2).equals("𐑭")) { phoneticString += "a"; }
            else { phoneticString += shavianText.substring(position, position + 2); }
        }
        return phoneticString;
    }

    public String getPhoneticFromEnglish(String englishText) throws IOException {
        return "";
    }

}
