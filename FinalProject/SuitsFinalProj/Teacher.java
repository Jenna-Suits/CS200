//Jenna Suits
//12/8/23
//Final project
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class Teacher extends Student
{
    //teacher extends student
    //able to getInfo and printInfo
    //getAll prints entire list
    public static void getAll(ArrayList<Account> allList){
        Scanner scnr = new Scanner (System.in);
        //create name variable
        String name="";
        //print entire list
        System.out.println("Printing all: ");
        printInfo(allList);
    }//cheange info changes one students grade
    public static void changeInfo(ArrayList<Account> allList,String path){
        Scanner scnr = new Scanner (System.in);
        //create variables
        String name="";
        String theName="";
        String user="";
        String pass="";
        String grade="";
        String newGrade="";
        //ask for user input
        System.out.println("Name of grade you wish to change: ");
        theName=scnr.next();
        System.out.println("");
        
        boolean flag=true;
        //try and catch for if user inputs something other than a,b,c,d,f
        while(flag){
            try{
                System.out.println("What grade do you want to change it to (a,b,c,d,f)");
                String c=scnr.next();
                System.out.println("");
                
                while(!("a".equals(c)||"b".equals(c)||"c".equals(c)||"d".equals(c)||"f".equals(c))){
                    System.out.println("Invalid input. Enter a,b,c,d,or f only.");
                    System.out.println("What grade do you want to change it to (a,b,c,d,f)");
                    c=scnr.next();
                    System.out.println("");
                }
                newGrade=c;
                flag=false;
            }catch(NumberFormatException e){
                System.out.println("Invalid input. Enter a,b,c,d,or f only.");
                System.out.println("What grade do you want to change it to (a,b,c,d,f)");
            }
        }
        //display what new grade will be
        System.out.println("New grade will be changed to: "+newGrade);
        //create new variables
        String n="";
        String u="";
        String p="";
        String g="";
        String end ="";
        //print array with new changed grade
        if(!("".equals(theName))){
            for(int i=allList.size()-1;i>=0;i--){
                if((allList.get(i).getName().compareTo(theName)==0)){
                    n=allList.get(i).getName();
                    u=allList.get(i).getUser();
                    p=allList.get(i).getPass();
                    
                    Account act=new Account(n,u,p,newGrade);
                    allList.remove(i);
                    printInfo(allList);
                    System.out.println(act);
                }
                
            }
            
        }
    }
}