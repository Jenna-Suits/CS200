//Jenna Suits
//CS200 Homework Assignment 1
//9/24/2023

//Homework description: 
//Within this homework assignment, the code is used to display a 2 dimentional array (matrix), filled with randomly generted numbers between 0 and 15.
//It then uses a sliding window (2x2) moving with a stride of 1 to compute different calculations and display the resulting arrays.
//These calculations include finding the sum, the average, the minimum, and the maximum of each window. 
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void Main(String[] args)
    {
        System.out.print("Enter the array size (an integer between 2 and 8): ");
        Scanner scnr = new Scanner (System.in);
        //declare variables
        int integer;
        int seed;
        //read in integer
        integer=scnr.nextInt();
        //Make sure that the integer that is entered is between 2 and 8
        while(integer <2 || integer >8){
            System.out.println("That number is outside the range of possible values. Try again.");
            System.out.print("Enter the array size (an integer between 2 and 8): ");
            integer=scnr.nextInt();
        }
        //read in the seed
        System.out.print("Enter an integer seed: ");
        seed=scnr.nextInt();
        
        System.out.println("");
        //display the header
        System.out.println("Main array:");
        //create array
        int [][]array=createArray(integer, seed);
        //print array
        //using for loops iterate through each x and y of the 2d array and print the elements, making sure to add a 0 if element is less than 10
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if (array[i][j]<10){
                    System.out.print("0"+array[i][j]+" ");
                }
                if (array[i][j]>=10){
                    System.out.print(array[i][j]+" ");
                }
                
            }
            System.out.println("");
        }
        
        System.out.println("");
        
        //initialize sumArray
        //call createSumArray passing in the integer and original array
        int [][]sumArray=createSumArray(integer,array);
        //print sum array
        System.out.println("Sum array:");
        for(int i=0;i<sumArray.length;i++){
            for(int j=0;j<sumArray.length;j++){
                if (sumArray[i][j]<10){
                    System.out.print("0"+sumArray[i][j]+" ");
                }
                if (sumArray[i][j]>=10){
                    System.out.print(sumArray[i][j]+" ");
                }
                
            }
            System.out.println("");
        }
        System.out.println("");
        //initialize avg array
        //call createAvgArray passing in the integer and original array
        int [][]avgArray=createAvgArray(integer,array);
        //print avg array
        System.out.println("Avg array:");
        for(int i=0;i<avgArray.length;i++){
            for(int j=0;j<avgArray.length;j++){
                if (avgArray[i][j]<10){
                    System.out.print("0"+avgArray[i][j]+" ");
                }
                if (avgArray[i][j]>=10){
                    System.out.print(avgArray[i][j]+" ");
                }
                
            }
            System.out.println("");
        }
        System.out.println("");
        //initialize min array
        //call createMinArray passing in the integer and original array
        int [][]minArray=createMinArray(integer,array);
        //print min array
        System.out.println("Min array:");
        for(int i=0;i<minArray.length;i++){
            for(int j=0;j<minArray.length;j++){
                if (minArray[i][j]<10){
                    System.out.print("0"+minArray[i][j]+" ");
                }
                if (minArray[i][j]>=10){
                    System.out.print(minArray[i][j]+" ");
                }
                
            }
            System.out.println("");
        }
        System.out.println("");
        //initialize max array
        //call createMaxArray passing in the integer and original array
        int [][]maxArray=createMaxArray(integer,array);
        //print max array
        System.out.println("Max array:");
        for(int i=0;i<maxArray.length;i++){
            for(int j=0;j<maxArray.length;j++){
                if (maxArray[i][j]<10){
                    System.out.print("0"+maxArray[i][j]+" ");
                }
                if (maxArray[i][j]>=10){
                    System.out.print(maxArray[i][j]+" ");
                }
                
            }
            System.out.println("");
        }
    }
    //method to create the original array
    public static int[][] createArray(int integer, int seed){
        int [][] array= new int [integer][integer];
        Random random= new Random(seed);
        //for each (x,y) of array generate a new random number using seed input
        for(int i=0; i<array.length;i++){
            for(int j=0;j<array.length;j++){
                array[i][j]=random.nextInt(15);
        }
        }
        return array;
    }
    public static int[][] createSumArray(int integer,int [][]a){
        //create new array that is 1 less than original because of sliding window
        int [][] array= new int [integer-1][integer-1];
        //iterate through each x in each y adding all elements in window to new array
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                array[i][j]=a[i][j]+a[i+1][j]+a[i][j+1]+a[i+1][j+1];
            }
          
        }
        return array;
    }
    public static int[][] createAvgArray(int integer,int [][]a){
        int [][] array= new int [integer-1][integer-1];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                //iterate through each x in each y to add window elements and divide by amount of elements
                array[i][j]=(a[i][j]+a[i+1][j]+a[i][j+1]+a[i+1][j+1])/4;
            }
          
        }
        return array;
    }
    public static int[][] createMinArray(int integer,int [][]a){
        int [][] array= new int [integer-1][integer-1];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                //create a temporary 1 dimentinal array to store the four elements in the window
                int []tempArray= new int [4];
                //store the four elements
                tempArray[0]=a[i][j];
                tempArray[1]=a[i+1][j];
                tempArray[2]=a[i][j+1];
                tempArray[3]=a[i+1][j+1];
                //asign the first element as min
                int min=tempArray[0];
                //fo through each elemtn in the temperary array to determin if any are less that the first 
                //and if so assign as new min
                for(int k=0;k<4;k++){
                    if(tempArray[k]<min){
                        min=tempArray[k];
                    }
                }
                //assign the min to the new 2d array
                array[i][j]=min;
            }
        } 
        return array;
    }
    public static int[][] createMaxArray(int integer,int [][]a){
        int [][] array= new int [integer-1][integer-1];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                //temp 1d array
                int []tempArray= new int [4];
                //assign window elements to temperary array
                tempArray[0]=a[i][j];
                tempArray[1]=a[i+1][j];
                tempArray[2]=a[i][j+1];
                tempArray[3]=a[i+1][j+1];
                //assign first element to the max
                int max=tempArray[0];
                for(int k=0;k<4;k++){
                    if(tempArray[k]>max){
                        //if next element is > max then make it the new max
                        max=tempArray[k];
                    }
                }
                //assign the max to the element in the 2d array
                array[i][j]=max;
            }
        } 
        return array;
    }
    
}

