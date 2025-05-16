//Jenna Suits
//CS200 Homework 2
import java.util.Scanner;
public class Tester
{
    //main method 
    public static void Main(String[] args)
    {
        Scanner scnr = new Scanner (System.in);
        //create object
        Box newBox= new Box();
        //ask for values
        System.out.println("Enter the length in feet: ");
        newBox.setLength(scnr.nextDouble());
        System.out.println("Enter the width in feet: ");
        newBox.setWidth(scnr.nextDouble());
        System.out.println("Enter the height in feet: ");
        newBox.setHeight(scnr.nextDouble());
        System.out.println("Enter the weight in pounds: ");
        newBox.setWeight(scnr.nextDouble());
        
        try{
            //calculate volume and density
            double volume=newBox.calculateVolume();
            double density=newBox.calculateDensity();
            //display values 
            System.out.printf("The volume of the box is %.2f",volume);
            System.out.println(" cubic ft.");
            System.out.printf("The density of the box is %.2f",density);
            System.out.println(" lbs./cubic ft.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("The volume of the box is 0.00 cubic feet.");
            System.out.println("The density of the box is 0.00 lbs./cubic ft.");
        }
        boolean cube=newBox.isACube();
        boolean square=newBox.hasASquare();
        if(square==true){
            System.out.println("At least one side of the box is square.");
        }else{
            System.out.println("No sides of the box are square.");
        }
        if(cube==true){
            System.out.println("The box is a cube.");
        }else{
            System.out.println("The box is not a cube.");
        }
        boolean heavy=newBox.isHeavy();
        boolean lightweight=newBox.isLightweight();
        if(heavy==true){
            System.out.println("The box is heavy.");
        }else{
            System.out.println("The box is not heavy.");
        }
        if(lightweight==true){
            System.out.println("The box is lightweight.");
        }else{
            System.out.println("The box is not lightweight.");
        }
        
        
    }
}
