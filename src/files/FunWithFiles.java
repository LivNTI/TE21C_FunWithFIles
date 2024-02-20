package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;


// Class that manages files
public class FunWithFiles {
    String fileName= "myFile.txt";
    File myFileObj;
    public FunWithFiles(){
        createFiles();
        //write2File();
        readFromFile();
    }


//reads from a file
    private void readFromFile() {
        try {
            Scanner myFileScanner = new Scanner(myFileObj);
            while(myFileScanner.hasNextLine()) {
                System.out.println(myFileScanner.nextLine());
            }



        }catch(FileNotFoundException e){
            System.out.println("File could not be found!");
        }

    }

    // Writes to a file
    private void write2File() {
        try {
            FileWriter myWriter = new FileWriter(fileName,true);

            Scanner myKeyScanner= new Scanner(System.in);

            System.out.println("What do you want to write to the file?");
            String input= myKeyScanner.nextLine();
            myWriter.write(input);

            myWriter.close();

        }catch (IOException e){
            System.out.println("could not write to file");
            e.printStackTrace();
        }
    }

    //Creates a file
    private void createFiles() {
        myFileObj= new File(fileName);
        try {
            if(myFileObj.createNewFile()){
                System.out.println("File ahs been created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException ioErr){
            System.out.println("file could not be created");

        }catch(Exception error){
            System.out.println("something went wrong");
        }

    }
}
