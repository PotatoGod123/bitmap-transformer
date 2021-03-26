package bitmap.transformer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.lang.Object;
import javax.imageio.ImageIO;

public class BitMap {
    String inputFilePath;
    String outputFilePath;
    String transformName;

    public BitMap(String inputFilePath, String outputFilePath, String transformName) {

        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.transformName = transformName;
    }

    public String printInfo(){
        String result = "This is your File location app/src/main/resources/img.bmp, this is your destination of new file app/src/main/img.bmp, this is that transformation you want white";
        System.out.println("This is your File location "+this.inputFilePath+", this is your destination of new file "+this.outputFilePath+", this is that transformation you want "+this.transformName);
        return result;
    }

    public void testFile() throws IOException {
        File selectedFile = new File(inputFilePath);

        BufferedImage fileScanned;

        try{
            fileScanned = ImageIO.read(selectedFile);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("File does not exist");
            return;
        }

        ImageIO.write(fileScanned, "bmp", new File(outputFilePath));

        System.out.println(fileScanned);
    }

    public int paintWhite() throws IOException {

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(this.inputFilePath));
        } catch (IOException e) {
        }
        int width = image.getWidth();
        int height = image.getHeight();
        Color white = new Color(255, 255, 255);
        int rgb = white.getRGB();
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++){
                image.setRGB(i, j, rgb);
            }
        }
        ImageIO.write(image, "bmp", new File(this.outputFilePath));
        return width;
    }

    public void paintBlack() throws IOException {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(this.inputFilePath));
        } catch (IOException e) {
        }
        Color black = new Color(0, 0, 0);
        int width = image.getWidth();
        int height = image.getHeight();
        int rgb = black.getRGB();
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++){
                image.setRGB(i, j, rgb);
            }
        }
        ImageIO.write(image, "bmp", new File(this.outputFilePath));
    }
    public void paintBlackWhite() throws IOException {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(this.inputFilePath));
        } catch (IOException e) {
        }
        Color white = new Color(255, 255, 255);
        Color black = new Color(0, 0, 0);
        int width = image.getWidth();
        int height = image.getHeight();
        int rgb = black.getRGB();
        int rgb2 = white.getRGB();
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++){
                if (i>=width/2 && i>=height/2){
                    image.setRGB(i, j, rgb2);
                    continue;
                }
                image.setRGB(i, j, rgb);
            }
        }
        ImageIO.write(image, "bmp", new File(this.outputFilePath));
    }
}
