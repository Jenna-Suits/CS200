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
        //create array from world class
        ArrayList<World> allList=new ArrayList<>();
        //try and catch for file reaing
        try {
            String inputLine;
            System.out.println("Welcome to the World Happiness - Corruption Dataset (2015-2020).");
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
                    System.out.print("Do you wish to (1) Search or (2) sort by column? (Enter 1 or 2): ");
                    String c=scnr.next();
                    System.out.println("");
                    //make choice an int 
                    int choice=Integer.parseInt(c);
                    while(choice!= 1 && choice!=2){
                        System.out.println("Invalid input. Enter 1 or 2 only.");
                        System.out.print("Do you wish to (1) Search or (2) sort by column? (Enter 1 or 2): ");
                        c=scnr.next();
                        System.out.println("");
                        choice=Integer.parseInt(c);
                    }
                    finalc=choice;
                    flag=false;
                }catch(NumberFormatException e){
                    System.out.println("Invalid input. Enter 1 or 2 only.");
                    System.out.print("Do you wish to (1) Search or (2) sort by column? (Enter 1 or 2): ");
                }
            }
            //if it is 1 or 2 what method to call
            if(finalc == 1){
                search(allList);            
                System.out.println("");
            }
            if(finalc == 2){
                sort(allList);
           
        }//catch for if the file name is not found
        } catch (IOException e) {
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
    public static World CSVtoArrayList(String CSVFileName) {
        World world=null;
       
       
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
                    String country=splitData[i].trim();
                    i++;
                    Integer year=Integer.parseInt(splitData[i].trim());
                    i++;
                    String continent=splitData[i].trim();
                    i++;
                    Double happy=Double.parseDouble(splitData[i].trim());
                    i++;
                    Double GDP=Double.parseDouble(splitData[i].trim());
                    i++;
                    Double family=Double.parseDouble(splitData[i].trim());
                    i++;
                    Double health=Double.parseDouble(splitData[i].trim());
                    i++;
                    Double free=Double.parseDouble(splitData[i].trim());
                    i++;
                    Double gene=Double.parseDouble(splitData[i].trim());
                    i++;
                    Double trust=Double.parseDouble(splitData[i].trim());
                    i++;
                    Double CPI=Double.parseDouble(splitData[i].trim());
                    i++;
                    //sends the variables to the different arrays in world class
                    world=new World(country, continent, year, happy, GDP, family, health, free, gene, trust, CPI);
                }
               
            }
           
         }//returns world array
     return world;
    }
    //search method
    public static void search(ArrayList<World> allList){
        Scanner scnr = new Scanner (System.in);
        ArrayList<Object> arrlist = new ArrayList<Object>();
        int searchCountry;
        int searchContinent;
        int searchYear;
        String country="";
        String continent="";
        String year="";
        //set country continent and year to variables
        System.out.println("Search Selected.");
        System.out.print("Enter the country name: ");
        String coun=scnr.nextLine();
        if(!("".equals(coun))){
            country=coun;
        }else{
            country="all";
        }
        System.out.println("");
        System.out.print("Enter the continent: ");
        String cont=scnr.nextLine();
        if(!("".equals(cont))){
            continent=cont;
        }else{
            continent="all";
        }
        System.out.println("");
        boolean f=true;
        System.out.print("Enter the year to search by (15-20 inclusive): ");
        String y=scnr.nextLine();
        //makes sure year is between 2015-2020
        if(!("".equals(y))){
            while(f){
                try{
                    if("".equals(y)){
                        year="all";
                        f=false;
                    }
                    System.out.println("");
                    int ye=Integer.parseInt(y);
                    while(ye!=15 && ye!=16 && ye!=17 && ye!=18 && ye!=19 && ye!=20){
                        System.out.println("Error not 15-20 inclusive");
                        System.out.print("Enter the year to search by (15-20 inclusive): ");
                        y=scnr.next();
                        System.out.println("");
                    }
                    year=y;
                    f=false;
                }catch(NumberFormatException e){
                    System.out.println("Error not 15-20 inclusive");
                    System.out.print("Enter the year to search by (15-20 inclusive): ");
                }
            }
        }else{
            year="all";
        }
        System.out.println("");
        System.out.println("Country: "+country);
        System.out.println("Continent: "+continent);
        //set year to nyear to make into int
        int nyear=0;
        if("15".equals(year)){
            nyear=2015;
            
        }
        if("16".equals(year)){
            nyear=2016;
        }
        if("17".equals(year)){
            nyear=2017;
        }
        if("18".equals(year)){
            nyear=2018;
        }
        if("19".equals(year)){
            nyear=2019;
        }
        if("20".equals(year)){
            nyear=2020;
        }
        //remove each that is not wanted
        if(year!="all"){
            System.out.println("Year: "+nyear);
        }else{
            System.out.println("Year: all");
        }
        if(!("all".equals(country))){
            for(int i=allList.size()-1;i>=0;i--){
                if(!(allList.get(i).getCountry().compareTo(country)==0)){
                    allList.remove(i);
                }
            }
        }
        System.out.println("");
        if("all"!=year){
            for(int i=allList.size()-1;i>=0;i--){
                if(!(allList.get(i).getYear().compareTo(nyear)==0)){
                    allList.remove(i);
                }
            }
        }
        if(!("all".equals(continent))){
            for(int i=allList.size()-1;i>=0;i--){
                if(!(allList.get(i).getContinent().compareTo(continent)==0)){
                    allList.remove(i);
                }
            }
        }
        //call sort method
        sort(allList);
    }
    public static void sort(ArrayList<World> allList){
        Scanner scnr = new Scanner (System.in);
        //ask what to sort by
        System.out.println("Sort by: ");
        System.out.println("");
        System.out.println("a. country");
        System.out.println("b. year");
        System.out.println("c. continent");
        System.out.println("d. happiness score");
        System.out.println("e. GDP per capita");
        System.out.println("f. family");
        System.out.println("g. health");
        System.out.println("h. freedom");
        System.out.println("i. generosity");
        System.out.println("j. government trust");
        System.out.println("k. CPI score");
        System.out.println("");
        System.out.print("Column to sort by (a-k): ");
        String c=scnr.next();
        System.out.println("");
        //make sure value is correct
        while(!(c.equals("a")||c.equals("b")||c.equals("c")||c.equals("d")||c.equals("e")||c.equals("f")||c.equals("g")||c.equals("h")||c.equals("i")||c.equals("j")||c.equals("k"))){
            System.out.println("Invalid value.");
            System.out.println("Sort by: ");
            System.out.println("");
            System.out.println("a. country");
            System.out.println("b. year");
            System.out.println("c. continent");
            System.out.println("d. happiness score");
            System.out.println("e. GDP per capita");
            System.out.println("f. family");
            System.out.println("g. health");
            System.out.println("h. freedom");
            System.out.println("i. generosity");
            System.out.println("j. government trust");
            System.out.println("k. CPI score");
            System.out.println("");
            System.out.print("Column to sort by (a-k): ");
            c=scnr.next();
            System.out.println("");
        }
        
        
        //coice of sort
        int choice;
        if(c.equals("a")){
            System.out.println("Sort by country");  
            choice=0;
        }
        if(c.equals("b")){
            System.out.println("Sort by year");
            choice=1;
        }
        if(c.equals("c")){
            System.out.println("Sort by continent");  
            choice=2;
        }
        if(c.equals("d")){
            System.out.println("Sort by happiness score");      
            choice=3;
        }
        if(c.equals("e")){
            System.out.println("Sort by GDP per capita");    
            choice=4;
        }
        if(c.equals("f")){
            System.out.println("Sort by family"); 
            choice=5;
        }
        if(c.equals("g")){
            System.out.println("Sort by health"); 
            choice=6;
        }
        if(c.equals("h")){
            System.out.println("Sort by freedom"); 
            choice=7;
        }
        if(c.equals("i")){
            System.out.println("Sort by generosity"); 
            choice=8;
        }
        if(c.equals("j")){
            System.out.println("Sort by government trust");    
            choice=9;
        }
        if(c.equals("k")){
            System.out.println("Sort by CPI score"); 
            choice=10;
        }
        System.out.println("");
        String finalOrder="";
        boolean f= true;
        //make sure to choose acending or decending
        while(f){
            try{
                System.out.print("Sort by column in (a)scending or (d)ecending order: (a or d)?");
                String order=scnr.next();
                System.out.println("");
                while(!(order.equals("a") || order.equals("d"))){
                    System.out.println("Invalid input.");
                    System.out.print("Sort by column in (a)scending or (d)ecending order: (a or d)?");
                    order=scnr.next();
                    System.out.println("");
                }
                finalOrder=order;
                f=false;
            }catch(NumberFormatException e){
                System.out.println("Invalid input");
                System.out.print("Sort by column in (a)scending or (d)ecending order: (a or d)?");
            }
        }
        System.out.println("");
        if(finalOrder.equals("a")){
            System.out.println("Sort in acending order.");
        }
        if(finalOrder.equals("d")){
            System.out.println("Sort in decending order.");
        }
        //sort the arrays to the selected choice
        if(c.equals("a")){ 
            if(finalOrder.compareTo("a")==0){
                
                allList.sort(Comparator.comparing(World::getCountry));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getCountry).reversed());
            }
            choice=0;
        }
        if(c.equals("b")){
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getYear));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getYear).reversed());
            }
            choice=1;
        }
        if(c.equals("c")){
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getContinent));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getContinent).reversed());
            }
            choice=2;
        }
        if(c.equals("d")){      
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getHappy));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getHappy).reversed());
            }
            choice=3;
        }
        if(c.equals("e")){   
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getGDP));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getGDP).reversed());
            }
            choice=4;
        }
        if(c.equals("f")){ 
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getFamily));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getFamily).reversed());
            }
            choice=5;
        }
        if(c.equals("g")){
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getHealth));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getHealth).reversed());
            }
            choice=6;
        }
        if(c.equals("h")){
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getFree));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getFree).reversed());
            }
            choice=7;
        }
        if(c.equals("i")){
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getGene));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getGene).reversed());
            }
            choice=8;
        }
        if(c.equals("j")){   
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getTrust));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getTrust).reversed());
            }
            choice=9;
        }
        if(c.equals("k")){
            if(finalOrder.compareTo("a")==0){
                allList.sort(Comparator.comparing(World::getCPI));
            }else if(finalOrder.compareTo("d")==0){
                allList.sort(Comparator.comparing(World::getCPI).reversed());
            }
            choice=10;
        }
        //print the result
        printInfo(allList);
    }
    //print method
    public static void printInfo(ArrayList<World> allList){
        //print headers
        System.out.println("");
        System.out.printf("Country");
        System.out.printf("%20s","Year");
        System.out.printf("%10s","Cont");
        System.out.printf("%10s","Happ");
        System.out.printf("%10s","GDP");
        System.out.printf("%10s","Fam");
        System.out.printf("%10s","Hlth");
        System.out.printf("%10s","Free");
        System.out.printf("%10s","Gene");
        System.out.printf("%10s","Govt");
        System.out.printf("%10s","CPI");
        System.out.println("");
        //print arrrays
        int s=allList.size();
        if(s==0){
                System.out.println("No rows returned.");
            }
        for(int k=0;k<allList.size();k++){
            System.out.print(allList.get(k));
            System.out.println("");
        }
    }
 }