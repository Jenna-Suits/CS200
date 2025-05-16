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

public class CSVtoArrayList {
    //main method
    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);
        BufferedReader readBuffer = null;
        //create array from account class
        ArrayList<Account> allList=new ArrayList<>();
        //try and catch for file reaing
        try {
            String inputLine;
            System.out.println("----Student-Teacher-DataSet----");
            System.out.println("Enter a full pathname and filename for the input file: ");
            String path=scnr.next();
            readBuffer = new BufferedReader(new FileReader(path));
            int k=0;
            while ((inputLine = readBuffer.readLine()) != null) {
                //skip the header line
                if(k==0){
                    k++;
                    continue;
                }
                //add each array created from CSVtoArrayList to allList
                allList.add(CSVtoArrayList(inputLine));         
            }
            //Show reading is done
            System.out.println("Reading file... Done");
            int finalc=0;
            boolean flag=true;
            //try and catch for if user inputs 1 or 2
            while(flag){
                try{
                    System.out.print("Are you a (1) teacher or a (2) student(Enter 1 or 2)");
                    String c=scnr.next();
                    System.out.println("");
                    //make choice an int 
                    int choice=Integer.parseInt(c);
                    while(choice!= 1 && choice!=2){
                        System.out.println("Invalid input. Enter 1 or 2 only.");
                        System.out.print("Are you a (1) teacher or a (2) student(Enter 1 or 2)");
                        c=scnr.next();
                        System.out.println("");
                        choice=Integer.parseInt(c);
                    }
                    finalc=choice;
                    flag=false;
                }catch(NumberFormatException e){
                    System.out.println("Invalid input. Enter 1 or 2 only.");
                    System.out.print("Are you a (1) teacher or a (2) student(Enter 1 or 2)");
                }
            }
            //if it is 1 or 2 what method to call
            if(finalc == 1){
                Teacher teach= new Teacher();
                int ch=0;
                //ask what they would like to choose with try and catch for if it is not 1,2,3
                try{
                    System.out.println("Would you like to (1) print all list, (2) print your information, or (3) change a students grade? ");
                    String c=scnr.next();
                    System.out.println("");
                    //make choice an int 
                    int choice=Integer.parseInt(c);
                    while(choice!= 1 && choice!=2 && choice!=3){
                        System.out.println("Invalid input. Enter 1 or 2 only.");
                        System.out.println("Would you like to (1) print all list, (2) print your information, or (3) change a students grade? ");
                        c=scnr.next();
                        System.out.println("");
                        choice=Integer.parseInt(c);
                    }
                    ch=choice;
                    flag=false;
                }catch(NumberFormatException e){
                    System.out.println("Invalid input. Enter 1, 2 or 3 only.");
                    System.out.println("Would you like to (1) print all list, (2) print your information, or (3) change a students grade? ");
                }
                if(ch==1){
                    teach.getAll(allList);
                }else if(ch==2){
                    teach.getInfo(allList);
                }else if(ch==3){
                    teach.changeInfo(allList,path);
                }
            }
            if(finalc == 2){
                Student stud= new Student();
                stud.getInfo(allList);
                
            }
        }//catch for if the file name is not found
        catch (IOException e) {
            System.out.println("This filename cannot be found. Exiting.");
            e.printStackTrace();
        } finally {
            try {
                if (readBuffer != null)
                {
                    readBuffer.close();
                }
            } catch (IOException readException) {
                System.out.println("Ran into an error reading the file");
                readException.printStackTrace();
            }
        }
       
    }
    // Utility which converts CSV to ArrayList using Split operation
    public static Account CSVtoArrayList(String CSVFileName) {
        Account account=null;
       
       
        if (CSVFileName != null) {
            String[] splitData = CSVFileName.split("\\,", -1); //the -1 helps handle the null values
           
            for (int i = 0; i < splitData.length; i++) {
                //if it is null, replace it with a 0
                if (splitData[i].length() == 0) {
                    splitData[i] = "0";
                }
                //as long as it is not null and the length is not 0, trim the value and add it to the arraylist
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    //dedicates each part of the array to a different variable
                    String name=splitData[i].trim();
                    i++;
                    String user=splitData[i].trim();
                    i++;
                    String pass=splitData[i].trim();
                    i++;
                    String grade=splitData[i].trim();
                    i++;
                    //sends the variables to the different arrays in account class
                    account=new Account(name,user,pass,grade);
                }
               
            }
         }//returns account array
     return account;
    }
 }