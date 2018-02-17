import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ShorthandImage {
    private BufferedImage bufferedImage;
    private Point position;
    private int color;
    private int defaultY;
    private int longLength;
    private int shortLength;
    private int vowelRadius;
    private double curviness;
    private char lastLetter;

    public ShorthandImage(int rows, int iters, Point position, Color color) {
        this.bufferedImage = new BufferedImage(rows, iters, 1);
        this.position = position;
        this.color = color.getRGB();
        defaultY = position.y;
        longLength = 30;
        shortLength = 15;
        vowelRadius = 5;
        lastLetter = ' ';
        curviness = 0.2;
    }

    public ShorthandImage(int rows, int iters, Point position, Color color, int longLength, int shortLength, int vowelSize) {
        this.bufferedImage = new BufferedImage(rows, iters, 1);
        this.position = position;
        this.color = color.getRGB();
        defaultY = position.y;
        this.longLength = longLength;
        this.shortLength = shortLength;
        this.vowelRadius = vowelSize;
        lastLetter = ' ';
    }

    public void draw(char chr) {
        switch (chr) {
            case 'a':
                if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'i' || lastLetter == 'o' || lastLetter == 'u' || lastLetter == 'U') {vowelSpacing();}
                this.drawA();
                break;

            case 'b':
                this.drawB();
                break;

            case 'C':
                this.drawCH();
                break;

            case 'd':
                this.drawD();
                break;

            case 'e':
                if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'i' || lastLetter == 'o' || lastLetter == 'u' || lastLetter == 'U') {vowelSpacing();}
                this.drawE();
                break;

            case 'f':
                this.drawF();
                break;

            case 'g':
                this.drawG();
                break;

            case 'h':
                this.drawH();
                break;

            case 'i':
                if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'i' || lastLetter == 'u' || lastLetter == 'o') {vowelSpacing();}
                this.drawI();
                break;

            case 'j':
                this.drawJ();
                break;

            case 'k':
                this.drawK();
                break;

            case 'l':
                this.drawL();
                break;

            case 'm':
                this.drawM();
                break;

            case 'n':
                this.drawN();
                break;

            case 'o':
                if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'o' || lastLetter == 'i') {vowelSpacing();}
                this.drawO();
                break;

            case 'p':
                this.drawP();
                break;

            case 'r':
                this.drawR();
                break;

            case 's':
                this.drawS();
                break;

            case 'S':
                this.drawSH();
                break;

            case 't':
                this.drawT();
                break;

            case 'T':
                this.drawTH();
                break;

            case 'u':
                if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'i' || lastLetter == 'u' || lastLetter == 'U') {vowelSpacing();}
                this.drawU();
                break;

            case 'U':
                if (lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'U' || lastLetter == 'u') {vowelSpacing();}
                this.drawOO();
                break;

            case 'v':
                this.drawV();
                break;

            case 'z':
                this.drawZ();
                break;

            default:
                this.drawSpace();
                break;
        }
        lastLetter = chr;
    }

    public void drawA() {
        for (int degrees = 0; degrees < 360; degrees += 5) {
            bufferedImage.setRGB((int)Math.round(position.x + vowelRadius * Math.cos(degrees)), (int)Math.round(position.y + vowelRadius + vowelRadius * Math.sin(degrees)), color);
        }
    }

    public void drawB() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
            if (iter % 2 == 1) { position.y--; }
        }
    }

    public void drawCH() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y + Math.pow(2 * iter - shortLength, 2) * curviness / shortLength - shortLength * curviness), color);
            position.x++;
            if (iter%2 == 0) { position.y--; }
        }
    }

    public void drawD() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
        }
    }

    public void drawE() {
        for (int degrees = 0; degrees < 360; degrees += 5) {
            bufferedImage.setRGB((int)Math.round(position.x + vowelRadius * Math.cos(degrees)), (int)Math.round(position.y - vowelRadius + vowelRadius * Math.sin(degrees)), color);
        }
    }

    public void drawF() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.y++;
            if (iter % 2 == 1) { position.x++; }
        }
    }

    public void drawG() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
            if (iter % 2 == 1) { position.y++; }
        }
    }

    public void drawH() {
        for (int iter = 0; iter < longLength*1.5; iter++) {
            bufferedImage.setRGB(position.x + iter / 2, position.y - iter, color);
        }
        for (int iter = 0; iter < vowelRadius*1.5; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
        }
    }

    public void drawI() {
        for (int iter = 0; iter < vowelRadius * 2; iter++) {
            bufferedImage.setRGB(position.x, position.y - iter, color);
        }
    }

    public void drawJ() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y + Math.pow(2 * iter - longLength, 2) * curviness / longLength - longLength * curviness), color);
            position.x++;
            if (iter%2 == 0) { position.y--; }
        }
    }

    public void drawK() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
            if (iter % 2 == 1) { position.y++; }
        }
    }

    public void drawL() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y - Math.pow(2 * iter - shortLength, 2) * curviness / shortLength + shortLength * curviness), color);
            position.x++;
        }
    }

    public void drawM() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y + Math.pow(2 * iter - longLength, 2) * curviness / longLength - longLength * curviness), color);
            position.x++;
        }
    }

    public void drawN() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y + Math.pow(2 * iter - shortLength, 2) * curviness / shortLength - shortLength * curviness), color);
            position.x++;
        }
    }

    public void drawO() {
        position.x += vowelRadius / 2;
        for (int degrees = 0; degrees < 360; degrees += 5) {
            if (-Math.sqrt(3) * vowelRadius / 2 + vowelRadius * Math.sin(degrees) <= 0) {
                bufferedImage.setRGB((int)Math.round(position.x + vowelRadius * Math.cos(degrees)), (int)Math.round(position.y - Math.sqrt(3) * vowelRadius / 2 + vowelRadius * Math.sin(degrees)), color);
            }

        }
        position.x += vowelRadius / 2;
    }

    public void drawP() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
            if (iter % 2 == 1) { position.y--; }
        }
    }

    public void drawR() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y - Math.pow(2 * iter - longLength, 2) * curviness / longLength + longLength * curviness), color);
            position.x++;
        }
    }

    public void drawS() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.y--;
            if (iter % 2 == 1) { position.x++; }
        }
    }

    public void drawSH() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y - Math.pow(2 * iter - longLength, 2) * curviness / longLength + longLength * curviness), color);
            position.x++;
            if (iter%2 == 0) { position.y++; }
        }
    }

    public void drawT() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
        }
    }

    public void drawTH() {
        for (int iter = 0; iter < shortLength; iter++) {
            bufferedImage.setRGB(position.x, (int)Math.round(position.y - Math.pow(2 * iter - shortLength, 2) * curviness / shortLength + shortLength * curviness), color);
            position.x++;
            if (iter%2 == 0) { position.y++; }
        }
    }

    public void drawU() {
        for (int iter = 0; iter < vowelRadius * 2; iter++) {
            bufferedImage.setRGB(position.x, position.y + iter, color);
        }
    }

    public void drawOO() {
        position.x += vowelRadius / 2;
        for (int degrees = 0; degrees < 360; degrees += 5) {
            if (Math.sqrt(3) * vowelRadius / 2 + vowelRadius * Math.sin(degrees) >= 0) {
                bufferedImage.setRGB((int)Math.round(position.x + vowelRadius * Math.cos(degrees)), (int)Math.round(position.y + Math.sqrt(3) * vowelRadius / 2 + vowelRadius * Math.sin(degrees)), color);
            }

        }
        position.x += vowelRadius / 2;
    }

    public void drawV() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.y++;
            if (iter % 2 == 1) { position.x++; }
        }
    }

    public void drawZ() {
        for (int iter = 0; iter < longLength; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.y--;
            if (iter % 2 == 1) { position.x++; }
        }
    }

    public void drawSpace() {
        position.x += 10;
        position.y = defaultY;
    }

    private void vowelSpacing() {
        for (int iter = 0; iter < vowelRadius*1.5; iter++) {
            bufferedImage.setRGB(position.x, position.y, color);
            position.x++;
        }
    }

    public void displayImage() {
        JFrame jFrame = new JFrame("Shorthand Image");
        jFrame.setLayout(new FlowLayout());
        JLabel lbl = new JLabel();
        jFrame.setSize(bufferedImage.getWidth() + 10, bufferedImage.getHeight() + 50);
        ImageIcon icon = new ImageIcon(bufferedImage);
        lbl.setIcon(icon);
        jFrame.add(lbl);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
