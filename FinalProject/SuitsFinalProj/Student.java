//Jenna Suits
//12/8/23
//Final project
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
public class Student
{
    //get info gets one persons info
    public static void getInfo(ArrayList<Account> allList){
        Scanner scnr = new Scanner (System.in);
        String name="";
        //ask for name to see
        System.out.print("Enter your name: ");
        name=scnr.nextLine();
        System.out.println("");
        //display name
        System.out.println("");        
        System.out.println("Name chosen: "+name);
        
        //remove all names except for the name desired
        if(!("".equals(name))){
            for(int i=allList.size()-1;i>=0;i--){
                if(!(allList.get(i).getName().compareTo(name)==0)){
                    allList.remove(i);
                }
            }
        }
        //print the final array
        printInfo(allList);
        }
        //printInfo displays array 
    public static void printInfo(ArrayList<Account> allList){
        //print headers
        System.out.println("");
        System.out.printf("Name");
        System.out.printf("%20s","Username");
        System.out.printf("%15s","Password");
        System.out.printf("%10s","Grade");
        System.out.println("");
        //print arrrays
        for(int k=0;k<allList.size();k++){
            System.out.print(allList.get(k));
            System.out.println("");
        }
    }
}
