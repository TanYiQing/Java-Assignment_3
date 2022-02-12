/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class TelNum {
    
    private String fName;
    private String lName;
    private String subscriber;
    private final File FILE=new File("Tel Num.txt");
    private String name;
    private String prefix;
    
    public void checkSelection(int option){
        if(option<1||option>3)
            throw new IndexOutOfBoundsException();
    }
    
    public void checkName(String name) throws IOException{
        Scanner scan =new Scanner(name);
        if(name.contains(" ")){
            fName=scan.next();
            lName=scan.nextLine();
        }
        
        if(lName==null){
            throw new IOException();
        }
            
    }
     
    public void checkNumber(String allNumber) throws IOException{
        if(allNumber.length()<10)
            throw new IOException();
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setNumber(String number){
        if(number.length()==10){
            this.subscriber=number.substring(number.length()-7);
            this.prefix=number.substring(0, 3);
        }
      
      
    }
    
    public void saveToFile(){
        try{
        FileWriter fileWriter=new FileWriter(FILE,true);
        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.println(toString());
        printWriter.close();
        }catch(IOException ex){
            System.out.println("Error");
        }
        
    }
    
    public void displayFile(){
        try{
        Scanner scan=new Scanner(FILE);
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            System.out.println(line);
        }
        }catch(Exception e){
            System.out.println("Error");
        }
        
        
    }
    
    
    @Override
    public String toString(){
        return fName+"\t\t"+lName+"\t\t"+prefix+"\t\t"+subscriber;
    }
    
    
}
