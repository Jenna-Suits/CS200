//Jenna Suits
//CS200 Homework Assignment 3
//11/7/23


import java.util.Scanner;
import java.util.InputMismatchException;

public class Box implements Shape
{
    Scanner scnr = new Scanner (System.in);
    ////declare private variables
    private double length;
    private double width;
    private double height;
    private double weight;
    
    private double volume;
    private double density;
    private double bestFit;
    private double waste;
    //have box call in the parameters
        //setters for length width and height
    public Box(double l, double w, double h){
        this.length=l;
        this.width=w;
        this.height=h;
    }
    //weight getter and setter
    public void setWeight(double amount){
        this.weight=amount;
    }
    public double getBoxWeight(){
        return weight;
    }
    //volume calculation
    public double calculateVolume(){
        double length=getBoxLength();
        double width=getBoxWidth();
        double height=getBoxHeight();
        double volume=length*width*height;
        return volume;
    }
    //density calculation
        //has exception for if the dinominator is 0
    public double calculateDensity()throws Exception{
        double volume=calculateVolume();
        if(volume==0.0){
            throw new Exception("Division by zero attempted.");
        }
        return getBoxWeight()/volume;
    }
    //calculates bestfit
        //calls methods to declare variables in scope
    public double calculateBestFit(){
        double length=getBoxLength();
        double width=getBoxWidth();
        double height=getBoxHeight();
        bestFit=length*width*height;
        return bestFit;
    }
    //calulate waste
    public double calculateWaste(){
        double bestFit=calculateBestFit();
        double volume=calculateVolume();
        waste=(bestFit-volume)/bestFit;
        return waste*100;
    }
     //getters
    public double getBoxLength(){
        return length;
    }
    public double getBoxWidth(){
        return width;
    }
    public double getBoxHeight(){
        return height;
    }
    //ouput method
    public void printoutput(){
        System.out.println("A Box of length "+length+", width "+width+", height "+height+", and weight "+weight+" lb. was created.");
    }

}
