//Jenna Suits
//CS200 Homework 3
//11/7/23

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class Tester
{
    //main method 
    public static void Main(String[] args)
    {
        Scanner scnr = new Scanner (System.in);
        //declare variables
        double length;
        double width;
        double height;
        double weight;
        double max;
        double max2;
        //create array for the length height and width
        double[] list =new double[3];
        //ask for values
        System.out.println("Enter the length: ");
        //use a boolean and try and catch for if the variable is not a negative and not anything other than a double
            //in try i set the input to string then change it to double if exception occurs then the catch will prompt for new number
            //set the length and array index to variable when satisfies all requirements
        boolean flag=true;
        while(flag){
            try{
                String l = scnr.next();
                length=Double.valueOf(l);
                while(length<=0){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the length: ");
                l=scnr.next();
                length=Double.valueOf(l);
                }
                list[0]=length;
                flag=false;
            }catch(NumberFormatException e){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the length: ");
            }
        }
        
        System.out.println("Enter the width: ");
        flag=true;
        while(flag){
            try{
                String w = scnr.next();
                width=Double.valueOf(w);
                while(width<=0){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the width: ");
                w=scnr.next();
                width=Double.valueOf(w);
                }
                list[1]=width;
                flag=false;
                
            }catch(NumberFormatException e){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the width: ");
            }
        }
        
        System.out.println("Enter the height: ");
        flag=true;
        while(flag){
            try{
                String h = scnr.next();
                height=Double.valueOf(h);
                while(height<=0){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the height: ");
                h=scnr.next();
                height=Double.valueOf(h);
                }
                list[2]=height;
                flag=false;
                
            }catch(NumberFormatException e){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the height: ");
            }
        }
        
        //find top 2 of l w h
        length=list[0];
        width=list[1];
        height=list[2];
        //sort the array so last is highest
        Arrays.sort(list);
        //set max and the next highest
        max=list[2];
        max2=list[1];
        //create box with all four parameters        
        Box newBox= new Box(length,width,height);
        //create cone object with max and max 2 
        Cone newCone= new Cone(max,max2);
        //create cylinder object with max and max2
        Cylinder newCylinder= new Cylinder(max,max2);
        //create Sphere object with max parameter
        Sphere newSphere= new Sphere(max);
        
        System.out.println("Enter the weight: ");
        flag=true;
        while(flag){
            try{
                //double length=Double.valueOf(lengthtest);
                String w = scnr.next();
                weight=Double.valueOf(w);
                if(weight<=0){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the weight: ");
                //list[2]=height;
                w=scnr.next();
                weight=Double.valueOf(w);
                }
                newBox.setWeight(weight);
                newCone.setWeight(weight);
                newCylinder.setWeight(weight);
                newSphere.setWeight(weight);
                //list[2]=weight;
                flag=false;
            }catch(NumberFormatException e){
                System.out.println("Invalid entry. Only positive values > 0 are allowed. Please re-enter.");
                System.out.println("Enter the weight: ");
            }
        }
        //set the weights to variables
        double boxWeight=newBox.getBoxWeight();
        double coneWeight=newCone.getConeWeight();
        double cylinderWeight=newCylinder.getCylinderWeight();
        double sphereWeight=newSphere.getSphereWeight();
        
        //display ouputs
        newBox.printoutput();
        newCone.printoutput();
        newCylinder.printoutput();
        newSphere.printoutput();
        //create a space
        System.out.println();
        //display all volume and density
            //useing try and catch incase there is a problem with getting the density it results to o
            //use %.2f to get each variable to display 2 decimal points
            //use %30s on density to create the new column 
        try{
            //calculate volume and density
            double volume=newBox.calculateVolume();
            double density=newBox.calculateDensity();
            //display values 
            System.out.printf("Box volume: %.2f",volume);
            System.out.print(" cu ft.");
            //System.out.print();
            System.out.printf("%30s %.2f","Box density: ",density);
            System.out.println(" lbs./cu ft.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.print("Box volume: 0.00 cu ft.");
            System.out.printf("%30s","Box density: 0.00 lbs./cu ft.");
            System.out.println();
        }
        try{
            //calculate volume and density
            double volume=newCone.calculateVolume();
            double density=newCone.calculateDensity();
            //display values 
            System.out.printf("Cone volume: %.2f",volume);
            System.out.print(" cu ft.");
            System.out.printf("%30s %.2f","Cone density: ",density);
            System.out.println(" lbs./cu ft.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.print("Cone volume: 0.00 cu ft.");
            System.out.printf("%30s","Cone density: 0.00 lbs./cu ft.");
            System.out.println();
        }
        try{
            //calculate volume and density
            double volume=newCylinder.calculateVolume();
            double density=newCylinder.calculateDensity();
            //display values 
            System.out.printf("Cylinder volume: %.2f",volume);
            System.out.print(" cubic ft.");
            System.out.printf("%27s %.2f","Cylinder density: ",density);
            System.out.println(" lbs./cubic ft.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.print("Cylinder volume: 0.00 cu ft.");
            System.out.printf("%30s","Cylinder density: 0.00 lbs./cu ft.");
            System.out.println();
        }
        try{
            //calculate volume and density
            double volume=newSphere.calculateVolume();
            double density=newSphere.calculateDensity();
            //display values 
            System.out.printf("Sphere volume: %.2f",volume);
            System.out.print(" cu ft.");
            System.out.printf("%30s %.2f","Sphere density: ",density);
            System.out.println(" lbs./cu ft.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.print("Sphere volume: 0.00 cu feet.");
            System.out.printf("%30s","Sphere density: 0.00 lbs./cu ft.");
            System.out.println();
        }
        //create a space
        System.out.println();
        
        System.out.println("An object container would need to be:");
        //display the best fit and waste
        System.out.printf("%.2f cu ft for a Box (%.2f%% waste)",newBox.calculateBestFit(),newBox.calculateWaste());
        System.out.println();
        
        System.out.printf("%.2f cu ft for a Cone (%.2f%% waste)",newCone.calculateBestFit(),newCone.calculateWaste());
        System.out.println();
        
        System.out.printf("%.2f cu ft for a Cylinder (%.2f%% waste)",newCylinder.calculateBestFit(),newCylinder.calculateWaste());
        System.out.println();
        
        System.out.printf("%.2f cu ft for a Sphere (%.2f%% waste)",newSphere.calculateBestFit(),newSphere.calculateWaste());
        System.out.println();
        
    }
}
