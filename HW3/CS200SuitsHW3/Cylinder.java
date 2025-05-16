//Jenna Suits
//CS200 Homework Assignment 3
//11/7/23

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;

public class Cylinder implements Shape
{
    Scanner scnr = new Scanner (System.in);
    ////declare private variables
    private double length;
    private double width;
    private double height;
    private double weight;
    
    private double bestFit;
    private double waste;
    private double diameter;
    private double cylinderVolume;
    private double cylinderDensity;
    //call cylinder to set height and dinominator
    public Cylinder(double h, double d){
        this.diameter=d;
        this.height=h;
    }
    //getter and setter for weight
    public void setWeight(double amount){
        this.weight=amount;
    }
    public double getCylinderWeight(){
        return weight;
    }
    //calculate volume by setting variable equal to called methods
    public double calculateVolume(){
        double diameter=getCylinderDiameter();
        double height=getCylinderHeight();
        double radius=diameter/2;
        double pi=Math.PI;
        double volume=pi*(radius*radius)*(height);
        return volume;
    }
    //calculate density with exception
    public double calculateDensity()throws Exception{
        double volume=calculateVolume();
        if(volume==0.0){
            throw new Exception("Division by zero attempted.");
        }
        return getCylinderWeight()/volume;
    }
    //calculate bestFit
    public double calculateBestFit(){
        double diameter=getCylinderDiameter();
        double height=getCylinderHeight();
        bestFit=diameter*diameter*height;
        return bestFit;
    }
    //calculate waste
    public double calculateWaste(){
        double bestFit=calculateBestFit();
        double volume=calculateVolume();
        waste=(bestFit-volume)/bestFit;
        return waste*100;
    }
    
    
    //getters
    public double getCylinderHeight(){
        return height;
    }
    public double getCylinderDiameter(){
        return diameter;
    }
    //print method
    public void printoutput(){
        System.out.println("A Cylinder of height "+height+", diameter "+diameter+", and weight "+weight+" lb. was created.");
    }
}
