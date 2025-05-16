//Jenna Suits
//CS200 homework 3
//11/7/23
import java.util.Scanner;
import java.util.InputMismatchException;
public interface Shape
{
    //interface methods
    double calculateVolume();
    double calculateDensity()throws Exception;
    double calculateBestFit();
    double calculateWaste();
    void printoutput();
}