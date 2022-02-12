/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class TelNumTest {
    static Scanner input=new Scanner(System.in);
    static TelNum t=new TelNum();
    static int a,option;
    static String fullname,pNumber; 
    
    public static void main(String[]args){
        do{
        System.out.println(t.toString());
        System.out.println(" *** XYZ TELEPHONE NUMBER LIST *** \n");

        System.out.println("1. Add new number\n2. Display phone number list\n3. Exit\n");
          do{
           a=0;
        try{
        System.out.print("Enter your selection:");
        option=input.nextInt();
        t.checkSelection(option);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid input. Please enter 1, 2 or 3\n");
            a++;
        }
       
        
        if(option==1){
            inputName();
            inputNumber();
            t.saveToFile();
            System.out.println("Thank you. The number list has been updated\n");
        }
        
        else if(option==2){
            System.out.println("First\t\t Last\t\tPrefix\t\tNumber");
            System.out.println("---------------------------------------------------");
            t.displayFile();
            System.out.println();
        }
        }while(a==1);
        
        }while(option!=3);
       
    }
    
    public static void inputName(){
        do{
            a=0;
        try{
        System.out.print("Enter your fullname:");
        fullname=input.next()+input.nextLine();
        t.checkName(fullname);
        t.setName(fullname);
        }catch(IOException e){
            System.out.println("Please enter your first and last name\n");
            a++;
        }
        }while(a==1);
    }
    
    public static void inputNumber(){
        do{
            a=0;
        
        try{
        System.out.print("Enter your phone number:");
        pNumber=input.next()+input.nextLine();
        t.checkNumber(pNumber);
        t.setNumber(pNumber);
        }catch(IOException e){
            System.out.println("Please enter your number in this format: 0123456789\n");
            a++;
        }
        }while(a==1);
        
    }
    
}


