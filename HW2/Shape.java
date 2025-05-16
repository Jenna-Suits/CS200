//Jenna Suits
//CS200 homework 2
//10/15/23
public class Shape
{
    //declare private variable
    protected double weight;
        //weight==lbs
    //default constructor initializes weight to 0.0
    public Shape(){
        weight=0.0;
    }
    //constructor that initializes weight 
    public Shape(double amount){
        weight=amount;
    }
    //method accepts double and returns nothing
    public void setWeight(double amount){
        this.weight=amount;
    }
    //method accepts nothing and returns weight
    public double getWeight(){
        return weight;
    }
}