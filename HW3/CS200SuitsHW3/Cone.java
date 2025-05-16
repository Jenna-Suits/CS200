//Jenna Suits
//CS200 Homework Assignment 3
//11/7/23

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;

public class Cone implements Shape
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
    private double coneVolume;
    private double coneDensity;
    //call cone to pass in variables
        //is setter for height and dinominator
    public Cone(double h, double d){
        this.diameter=d;
        this.height=h;
    }
    //getter and setter for weight
    public void setWeight(double amount){
        this.weight=amount;
    }
    public double getConeWeight(){
        return weight;
    }
    //calculate volume settering variables to called methods
    public double calculateVolume(){
        double diameter=getConeDiameter();
        double height=getConeHeight();
        double radius=diameter/2;
        double pi=Math.PI;
        double volume=pi*(radius*radius)*(height/3);
        return volume;
    }
    //calculate density
        //has exception
    public double calculateDensity()throws Exception{
        double volume=calculateVolume();
        if(volume==0.0){
            throw new Exception("Division by zero attempted.");
        }
        return getConeWeight()/volume;
    }
    //calculate best fit
    public double calculateBestFit(){
        double diameter=getConeDiameter();
        double height=getConeHeight();
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
    public double getConeDiameter(){
        return diameter;
    }
    public double getConeHeight(){
        return height;
    }
    //print method
    public void printoutput(){
        System.out.println("A Cone of height "+height+", diameter "+diameter+", and weight "+weight+" lb. was created.");
    }
}
