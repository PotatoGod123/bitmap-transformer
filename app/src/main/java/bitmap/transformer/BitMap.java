package bitmap.transformer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BitMap {
    String inputFilePath;
    String outputFilePath;
    String transformName;


    public BitMap(String inputFilePath, String outputFilePath, String transformName) {

        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.transformName = transformName;
    }


    public void printInfo(){
        System.out.println("This is your File location "+this.inputFilePath+", this is your destination of new file "+this.outputFilePath+", this is that transformation you want "+this.transformName);
    }

    public void testFile(){
        File selectedFile = new File(inputFilePath);

        Scanner fileScanned;

        try{
            fileScanned= new Scanner(selectedFile);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("File does not exist");
            return;
        }

        System.out.println(fileScanned);

    }
}
