import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TextTranscriber {


    private HtmlPage htmlPage;
    private HtmlForm inputForm;
    private HtmlTextArea inputTextArea;
    private HtmlInput transcribeButton;
    private HtmlTableDataCell outputCell;
    private HtmlInput shavianButton;



    public TextTranscriber() {
        try {
            WebClient webClient = new WebClient();
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
            Logger.getLogger("org.apache.http").setLevel(Level.OFF);

            htmlPage = webClient.getPage("http://upodn.com/phon.php");
            inputForm = htmlPage.getForms().get(0);
            inputTextArea = inputForm.getTextAreaByName("intext");
            shavianButton = inputForm.getInputByValue("3");
            shavianButton.click();
            transcribeButton = htmlPage.getFirstByXPath("//input[@value='Transcribe it']");
        }
        catch (IOException e) {
            System.out.println("IOException when instantiating TextTranscriber object");
        }


    }

    public String getShavianFromEnglish(String englishText) {
        try {
            inputTextArea.setText(englishText);
            htmlPage = transcribeButton.click();
            inputForm = htmlPage.getForms().get(0);
            inputTextArea = inputForm.getTextAreaByName("intext");
            transcribeButton = htmlPage.getFirstByXPath("//input[@value='Transcribe it']");
            outputCell = htmlPage.getFirstByXPath("//td[@width='50%' and @valign='top' and @align='left']");
            return outputCell.asText();
        }
        catch (IOException e) {
            System.out.println("IOException at getShavianFromEnglish");
            return "";
        }
    }

    public String getPhoneticFromShavian(String shavianText) {
        String phoneticString = "";
        for (int position = 0; position < shavianText.length(); position += 2) {
            if (shavianText.length() < position + 2) { phoneticString += shavianText.substring(position, position + 1); }
            else if (shavianText.length() > position + 3 && shavianText.substring(position, position + 4).equals("\uD801\uDC5B\uD801\uDC60")) {
                phoneticString += "j";
                position += 2;
            }
            else if (shavianText.length() > position + 3 && shavianText.substring(position, position + 4).equals("\uD801\uDC51\uD801\uDC56")) {
                phoneticString += "C";
                position += 2;
            }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC6D")) { phoneticString += "A"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC68")) { phoneticString += "A"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC5A")) { phoneticString += "b"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC57")) { phoneticString += "C"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC5B")) { phoneticString += "d"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC67")) { phoneticString += "E"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC53")) { phoneticString += "f"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC5C")) { phoneticString += "g"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC63")) { phoneticString += "h"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC66")) { phoneticString += "I"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC70")) { phoneticString += "I"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC58")) { phoneticString += "I"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC61")) { phoneticString += "j"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC60")) { phoneticString += "j"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC52")) { phoneticString += "k"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC64")) { phoneticString += "l"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC65")) { phoneticString += "m"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC6F")) { phoneticString += "n"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC6A")) { phoneticString += "O"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC77")) { phoneticString += "O"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC50")) { phoneticString += "p"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC6E")) { phoneticString += "r"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC55")) { phoneticString += "s"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC56")) { phoneticString += "S"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC51")) { phoneticString += "t"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC54")) { phoneticString += "T"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC5E")) { phoneticString += "T"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC62")) { phoneticString += "U"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC75")) { phoneticString += "U"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC6B")) { phoneticString += "U"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC69")) { phoneticString += "u"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC5D")) { phoneticString += "v"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC5F")) { phoneticString += "z"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC71")) { phoneticString += "EI"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC59")) { phoneticString += "ng"; }
            else if (shavianText.substring(position, position + 2).equals("\uD801\uDC74")) { phoneticString += "OU"; }
            else if (shavianText.substring(position, position + 2).equals("")) { phoneticString += ""; }

            else {
                phoneticString += shavianText.substring(position, position + 1);
                position--;
            }
        }
        return phoneticString;
    }

    public String getPhoneticFromEnglish(String englishText) {
        return this.getPhoneticFromShavian(getShavianFromEnglish(englishText));
    }

    public void writeFilePhoneticFromEnglish(String inputFile, String outputFile) {
        String line = null;
        BufferedWriter bufferedWriter = null;
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFile);
            bufferedWriter = new BufferedWriter(fileWriter);

            while((line = bufferedReader.readLine()) != null) {
                String[] sentences = line.split("\\.");
                for (int sentenceNumber = 0; sentenceNumber < sentences.length; sentenceNumber++) {
                    String[] clauses = sentences[sentenceNumber].split("[,;]");
                    for (int clauseNumber = 0; clauseNumber < clauses.length; clauseNumber++) {
                        System.out.println(clauses[clauseNumber]);
                        bufferedWriter.write(this.getPhoneticFromEnglish(clauses[clauseNumber]));
                        if (clauseNumber < clauses.length - 1) {
                            bufferedWriter.write(", ");
                        }
                    }
                    if (sentenceNumber < sentences.length - 1) {
                        bufferedWriter.write(". ");
                    }
                }
                bufferedWriter.newLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to open file '" + inputFile + "'");
        }
        catch (IOException e) {
            System.out.println("Unable to read file '" + inputFile + "'");
        }
        finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
