/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 1 
 */
package assignment1;

public class Car {
    private String brand;
    private String carType;
    private int year_of_construction;
    private double car_rate;
    private boolean transmission_Manual;
    private boolean convertible;
    private static int numOfCars=0;
/////////////////////////////////////////////////////////////////////////////////////////////
    public Car(){
this("None",0,0,false,"None",false);
        
    }

    public Car(String brand, int year_of_construction, double car_rate, boolean transmission_Manual,String carType, boolean convertible) {
        this.brand = brand;
        this.carType = carType;
        this.year_of_construction = year_of_construction;
        this.car_rate = car_rate;
        this.transmission_Manual = transmission_Manual;
        this.convertible = convertible;
        numOfCars++;
        
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String toString() {
        return "The car Type: " + brand + " " + carType + ", year: " + year_of_construction + ", Transmission: "+ getTransmissionWord() +(convertible?" and Convertible":" ");
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
public static int getNumberOfCars() {
        return numOfCars;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getCarType() {
        return carType;
    }

    public int getYearOfConstruction() {
        return year_of_construction;
    }

    public double getCarRate() {
        return car_rate;
    }
    
    public boolean getTransmission() {
        return transmission_Manual;
    }  
    
    public boolean isConvertible() {
        return convertible;
    }
    public String getTransmissionWord() {
       if  (transmission_Manual)  
       return "Manual";
       else return"Automatic";
    } 
    
    public String isConvertibleWord() {
        if  (convertible)  
        return "Convertible";
        else return"Non_Convertible";}
 
 ////////////////////////////////////////////////////////////////////////////////////////  

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setYearOfConstruction(int yearOfConstruction) {
        this.year_of_construction = yearOfConstruction;
    }

    public void setCarRate(double carRate) {
        this.car_rate = carRate;
    }

    public void setTransmission(boolean transmission_Manual) {
        this.transmission_Manual = transmission_Manual;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }
   ////////////////////////////////////////////////////////////////////////////////////////////////
       public double calculateFinalPrice(){
      double intialPrice=getCarRate();
      if(getCarType().equalsIgnoreCase("Luxury"))
      return intialPrice*1.1;
      else
      return intialPrice;}
    
}
