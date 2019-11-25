/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class ControlDeFichero {
    
    public static void escribirLog(String s) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("ERRORES/log.txt",true));
        writer.write(s);
        writer.close();
        
    }
    
    static String buscarError(int e) throws FileNotFoundException, IOException {
        String error = null;
        BufferedReader br = new BufferedReader(new FileReader("ERRORES/posiblesErrores.txt")); 
        for (int i=0;i<e;i++) 
            error = br.readLine();
        return error;
    }
    /*
    
    // Java Program to illustrate reading from FileReader 
// using BufferedReader 
import java.io.*; 
public class ReadFromFile2 
{ 
  public static void main(String[] args)throws Exception 
  { 
  // We need to provide file path as the parameter: 
  // double backquote is to avoid compiler interpret words 
  // like \test as \t (ie. as a escape sequence) 
  File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt"); 
  
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  String st; 
  while ((st = br.readLine()) != null) 
    System.out.println(st); 
  } 
}
    
    
    public static void usingBufferedWritter() throws IOException 
{
    String fileContent = "Hello Learner!";
     
    BufferedWriter writer = new BufferedWriter(new FileWriter("c:/temp/samplefile1.txt"));
    writer.write(fileContent);
    writer.close();
}

    
    try (FileOutputStream fos = new FileOutputStream("pathname")) {
   fos.write(myByteArray);
   //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
}
    
    File file;
// ...(file is initialised)...
byte[] fileContent = Files.readAllBytes(file.toPath());
    
    
    */
}
