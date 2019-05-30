package basicfileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//Print to file and retrieving from file in text form 
/**
 *
 * @author krati
 */
public class BasicFileIO {
    public static void main(String[] args){
        File file = new File("test.txt");
        
        try{
            //write name and age to file 
            PrintWriter output = new PrintWriter(file);
            output.println("Mr. Darcy");
            output.println(32);
            //remember to close to release file so other programs in OS can use file
            output.close();
        }catch(IOException ex){
            System.out.printf("Error: %s\n", ex);
        };
        
        try {
            //Read name and age from file
            Scanner input = new Scanner(file);
            String name = input.nextLine();
            int age = input.nextInt();
            System.out.printf("My name is %s and my age is %d\n", name, age);
        } catch (FileNotFoundException ex) {
            System.out.printf("Error: %s\n", ex);
        }
    }
}
