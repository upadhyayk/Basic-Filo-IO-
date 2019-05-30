/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicfileio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author krati
 */
public class test {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        //created file to write to
        File file = new File("student.txt");
        //Arraylist collecion of students
        ArrayList<Student> students = new ArrayList<Student>();
        Student Tom = new Student("Tom", 3.9);
        Student Dave = new Student("Dave", 4.0);
        Student Bill = new Student("Bill", 2.0);
        students.add(Tom);
        students.add(Dave);
        students.add(Bill);
        
        //serialize collection of students and write bytes to file
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for(int i = 0; i<students.size(); i++){
            objectOutputStream.writeObject(students.get(i));
        }
        objectOutputStream.close();
        fileOutputStream.close();
        
        //deserialize file back into a collection of students 
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Student> students2 = new ArrayList();
        
        //will continue reading in an object and adding to collection and at end will throw end of file exception 
        //catch end of file exception and you are done 
        try{
            while(true){
            Student s = (Student) objectInputStream.readObject();
            students2.add(s);
            }
        }catch(EOFException ex){        }
        
        for(int i = 0; i < students2.size(); i++){
            System.out.println(students2.get(i));
        }    
        
        }
}
