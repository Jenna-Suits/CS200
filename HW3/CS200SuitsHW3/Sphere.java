//Jenna Suits
//CS200 Homework Assignment 3
//11/7/23

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;

public class Sphere implements Shape
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
    private double Volume;
    private double Density;
    //call sphere to pass in diameter
    public Sphere(double d){
        this.diameter=d;
    }
    //getters and setters for weight
    public void setWeight(double amount){
        this.weight=amount;
    }
    public double getSphereWeight(){
        return weight;
    }   
    public double getSphereDiameter(){
        return diameter;
    }
    //calculate volume setting methods called to variables
    public double calculateVolume(){
        double diameter=getSphereDiameter();
        double radius=diameter/2;
        double pi=Math.PI;
        double volume=((4*pi)/3)*(radius*radius*radius);
        return volume;
    }
    //calculate density
    public double calculateDensity()throws Exception{
        double volume=calculateVolume();
        if(volume==0.0){
            throw new Exception("Division by zero attempted.");
        }
        return getSphereWeight()/volume;
    }
    //calulate bestFit
    public double calculateBestFit(){
        double diameter=getSphereDiameter();
        bestFit=diameter*diameter*diameter;
        return bestFit;
    }
    //calculate waste
    public double calculateWaste(){
        double bestFit=calculateBestFit();
        double volume=calculateVolume();
        waste=(bestFit-volume)/bestFit;
        return waste*100;
    }
    //print method
    public void printoutput(){
        System.out.println("A Sphere of diameter "+diameter+" and weight "+weight+" lb. was created.");
    }
}
