/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 1 
 */
package assignment1;

import java.util.Date;

public class Reservation {
  private String reservation_code ;
  private String pick_up_location;
  private String drop_of_location;
  private Date pick_up;
  private Date drop_of;
  private Date date_of_reservation;
  private Customer customer;
  private Car car;
  private Service additional_services;
 
///////////////////////////////////////////////////////////////////////////////////////////////  

    public String toString() {
       return  
"Reservation Refrence number : "+reservation_code+
" Customer information : "+customer.toString()+
" Pick up location : "+pick_up_location+" Drop of location : "+drop_of_location+
" Pick up date : "+getPickUpFormat()+" Drop of date : "+getDropOfFormat()+
"\nCar information : The car Type: "+car.getBrand()+" "+car.getCarType() +", Year: "+
                car.getYearOfConstruction()+",Transmission:"+car.getTransmissionWord()+(car.isConvertible()?" and Convertible":" ")+
" Additional services : Service "+additional_services.getServicetype() ;
                
    }
/////////////////////////////////////////////////////////////////////////////////////////////////  
    public Reservation(){
   
       date_of_reservation=new Date(); 
        
    }

    public Reservation( Car car,String pick_up_location, String drop_of_location, Date pick_up, Date drop_of, Customer customer, Service additional_services) {
        this.car = car;
        this.pick_up_location = pick_up_location;
        this.drop_of_location = drop_of_location;
        this.pick_up = pick_up;
        this.drop_of = drop_of;
        this.date_of_reservation = date_of_reservation;
        this.customer = customer;
        this.reservation_code = reservation_code;
        this.additional_services = additional_services;
       
    }
//////////////////////////////////////////////////////////////////////////////////////////////////   

    public String getReservationCode() {
        return reservation_code;
    }

    public String getPickUpLocation() {
        return pick_up_location;
    }

    public String getDropOfLocation() {
        return drop_of_location;
    }

    public Date getPickUp() {
        return pick_up;
    }
    
    public String getPickUpFormat() {
        return pick_up.getDate()+"-"+pick_up.getMonth()+"-"+pick_up.getYear();
        }
    

    public Date getDropOf() {
        return drop_of;
    }
    
    public String getDropOfFormat() {
        return drop_of.getDate()+"-"+drop_of.getMonth()+"-"+drop_of.getYear();
    }
    

    public Date getDateOfReservation() {
        return date_of_reservation;
    }
    
 
     public int getNumOfResDay() {
      int i= pick_up.getDate();
       int j=  drop_of.getDate();
        return (j-i);
     }
     
    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public Service getAdditionalServices() {
        return additional_services;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////

    public void setReservationCode(String reservation_code) {
        this.reservation_code = reservation_code;
    }

    public void setPickUpLocation(String pick_up_location) {
        this.pick_up_location = pick_up_location;
    }

    public void setDropOfLocation(String drop_of_location) {
        this.drop_of_location = drop_of_location;
    }

    public void setPickUp(Date pick_up) {
        this.pick_up = pick_up;
    }

    public void setDropOf(Date drop_of) {
        this.drop_of = drop_of;
    }

    public void setCar(Car car) {
        this.car = car;
    }

      public void setCustomer(Customer customer) {
        this.customer = customer;}
    
    
    public void setAdditionalServices(Service additional_services) {
        this.additional_services = additional_services;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public double calculateIntialTotal(){
      double intialPrice=car.calculateFinalPrice()*getNumOfResDay();
      return intialPrice;}
    
    
    public double calculatePriceAfterAddService(){
      return calculateIntialTotal()+additional_services.getServiceprice();}
     
    public double calculateTotal(){
        if((customer.getDiscountCode()/100)<10 && (customer.getDiscountCode()/100)>=7)
         return calculatePriceAfterAddService()*0.80;
         
        else if((customer.getDiscountCode()/100)<7&&(customer.getDiscountCode()/100)>=4)
         return calculatePriceAfterAddService()*0.85;
         
        else 
         return calculatePriceAfterAddService()*0.90;
        
      }
    
    
}
