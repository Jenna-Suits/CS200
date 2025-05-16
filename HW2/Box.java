//Jenna Suits
//CS200 Homework Assignment 2
//10/15/23

//Homework description: create a shape and determine the different dimentions


public class Box extends Shape
{
    ////declare private variables
    private double length;
    private double width;
    private double height;
    
    private boolean aCube=false;
    private boolean aSquare=false;
    private double volume;
    private double density;
    private boolean heavy;
    private boolean lightWeight;
    //setters and getter methods
        //setters
    public void setLength(double l){
        this.length=l;
    }
    public void setWidth(double w){
        this.width=w;
    }
    public void setHeight(double h){
        this.height=h;
    }
        //getters
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    
    //calculated values
    public boolean isACube(){
        if (length==width && width==height){
            return aCube=true;
        }
        return aCube;
    }
    public boolean hasASquare(){
        if(length==width || length==height || width==height){
            return aSquare=true;
        }
        return aSquare;
    }
    public double calculateVolume(){
        double length=getLength();
        double width=getWidth();
        double height=getHeight();
        double volume=length*width*height;
        return volume;
    }
    public double calculateDensity() throws Exception{
        double volume=calculateVolume();
        if(volume==0.0){
            throw new Exception("Division by zero attempted.");
        }
        return getWeight()/volume;
    }
    public boolean isHeavy(){
        try{
            double density=calculateDensity();
            return density>=10.00;
        } catch (Exception e){
            return false;
        }
        
    }
    public boolean isLightweight(){
        try{
            double density=calculateDensity();
            return density<=0.10;
        }catch(Exception e){
            return true;
        }
    }
}
