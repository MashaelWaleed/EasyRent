/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 1 
 */
package assignment1;
import java.io.*;
import java.util.*;
public class Program1_EasyRent {

    public static void main(String[] args) throws FileNotFoundException {
       int numberOfReservaion=0;
    // Creat Scanners and printWriter to read and write data................................................................
     File file1 =new File ("inputCar.txt"); 
     if (!file1.exists())
         System.exit(0);
     Scanner read = new Scanner(file1);
     
     File file2 = new File ("ReservationInput.txt");
      if (!file1.exists())
         System.exit(0);
     Scanner read2 = new Scanner(file2); 
     
     PrintWriter write1= new PrintWriter("CarsInfo.txt");
     PrintWriter write2= new PrintWriter("ReservationStatus.txt");
     PrintWriter write3= new PrintWriter("AnalysisReport.txt");
     
     
     //1D array for type of car ............................................................................................
      int numOfcarType=read.nextInt();
        String[] carTypeArray = new String [numOfcarType];
        for (int i =0;i<carTypeArray.length;i++){
        carTypeArray[i]=read.next();}
        
      //array of cars  ......................................................................................................
      int numOfCar=read.nextInt();
      Car [] carArray=new Car[numOfCar];
      
      //array of service....................................................................................................
      int numOfService=read.nextInt();
      Service [] serviceArray=new Service[numOfService];
      
      //2D Array for Analysis................................................................................................
      int [][] analysis=new int[numOfService][numOfcarType];
        
      //input cars and services deails........................................................................................
       while(read.hasNext()){  
       String Command =read.next();
       if(Command.equalsIgnoreCase("AddCar")){
       creatCar(carArray,read);}
      
       if(Command.equalsIgnoreCase("AddService")){       
        creatService (serviceArray,read);} 

       if(Command.equalsIgnoreCase("Quit")){       
        break;}}
       read.close();
       //print cars details ..................................................................................................
        printCars(carArray,write1);
       
       
       //creat array of reservation and customer...............................................................................
        int numOfReservation=read2.nextInt();
        Reservation [] reservationArray=new Reservation[numOfReservation];
        Customer [] customerArray=new Customer[numOfReservation];
        
        while(read2.hasNext()){
        String Command2=read2.next();
        if(Command2.equalsIgnoreCase("Reserve")){
        creatReservation(reservationArray ,read2,carArray,customerArray,serviceArray,numberOfReservaion);
        numberOfReservaion++;
         }
        else if(Command2.equalsIgnoreCase("Quit")){
        break; } }
        read2.close();
       
       //print Reservation confirmation and invoice..............................................................................
       
       printReservation(write2,reservationArray);
       
       //fill and print the 2D array for Analysis Report..............................................................................
       fillAnalysisReport(carTypeArray,serviceArray,analysis,reservationArray);
       printAnalysisReport(analysis,write3,carTypeArray,serviceArray);
     
}
    
 ///////////////////////////////////////////////////////////method for fill carArray/////////////////////////////////////////////////
    public static void creatCar(Car []carArray ,Scanner read){
      
    carArray[Car.getNumberOfCars()]=new Car(read.next(),read.nextInt(),read.nextInt(),read.nextBoolean(),read.next(),read.nextBoolean());
      }
       
 ///////////////////////////////////////////////////////method for fill serviceArray/////////////////////////////////////////////////
    public static void creatService(Service []serviceArray ,Scanner read){
        
    serviceArray[Service.getNumberOfService()]=new Service(read.next(),read.nextInt());
      } 
//////////////////////////////////////////////////////method for fill reservationArray/////////////////////////////////////////////////   
    public static void creatReservation(Reservation []reservationArray ,Scanner read2,Car[]carArray,Customer[]customerArray,
          Service [] serviceArray,int index){
       
          String type_=read2.next();
          String trans=read2.next();
          String conv=read2.next();
         int result= searchCar(carArray,type_,trans,conv);
         
          if (result==-1){
          read2.next();
          read2.next();
          
          read2.nextInt();read2.nextInt();read2.nextInt();
          read2.nextInt();read2.nextInt();read2.nextInt();
          
          read2.next();
          read2.next();
          read2.next();
          
          read2.nextLong();
          read2.nextInt();
          
           String s1 =read2.next();
            if(!s1.equals("submit")){read2.next();}
            else{}
          }
          else{
              
           reservationArray[index] =new Reservation(); 
           
           reservationArray[index].setCar(carArray[result]);
          
          
           reservationArray[index].setPickUpLocation(read2.next());
           reservationArray[index].setDropOfLocation(read2.next());
            
           reservationArray[index].setPickUp(new Date(read2.nextInt(),read2.nextInt(),read2.nextInt()));
           reservationArray[index].setDropOf(new Date(read2.nextInt(),read2.nextInt(),read2.nextInt()));
            
            customerArray[index]=new Customer();
            customerArray[index].setFirstName(read2.next());
            customerArray[index].setLastName(read2.next());
            customerArray[index].setEmail(read2.next());
          
            customerArray[index].setCreditCard(read2.nextLong());
            customerArray[index].setDiscountCode(read2.nextInt());
            
            reservationArray[index].setCustomer(customerArray[index]);
            createCode(reservationArray,customerArray,carArray,index);
            
             String s =read2.next();
            if(!s.equals("submit")){
            int result2 =searchService(serviceArray,s);
             if (result2==-1){}
              else{reservationArray[index].setAdditionalServices(serviceArray[result2]);}
            }
              else{reservationArray[index].setAdditionalServices(new Service());}}
    
    }
    
 ////////////////////////////////////////////////////method for print carArray/////////////////////////////////////////////
   public static void printCars(Car[]carArray,PrintWriter write1){
      write1.println("--------------- Welcome to Car Renting  Data Base ---------------");
      write1.println(" ");
      write1.println(" ");
      for(int i=0 ;i<carArray.length;i++){
      write1.println( carArray[i].toString());
      write1.println("------------------------------------------------------");
      write1.println(" ");
      }
      write1.flush();
      write1.close();
  }
 /////////////////////////////////////////////////method for looking for the required car///////////////////////////////////////

    public static int searchCar(Car[]carArray,String type, String trans, String conv){
        boolean convertible;
          if(conv.equalsIgnoreCase("Convertible"))  
          convertible=true;
          else convertible=false;
          
          boolean transmission;
          if(trans.equalsIgnoreCase("Manual"))  
          transmission=true;
          else transmission=false;
          
          
    for(int i =0;i< carArray.length;i++){
    if(carArray[i].getCarType().equals(type)){
    if(carArray[i].getTransmission()==transmission){
        if(carArray[i].isConvertible()==convertible)
            return i;}}
    }

return -1;
}

////////////////////////////////////////////method for looking for the required service////////////////////////////////////////////
public static int searchService(Service[]serviceArray,String service){

for(int i =0;i< serviceArray.length;i++){
    
if(serviceArray[i].getServicetype().equals(service)){
   return i;
   }}
return -1;}

/////////////////////////////////////////////method for creating Code for customer//////////////////////////////////////////////////////
public static void createCode(Reservation[]reservationArray,Customer[]customerArray,Car [] carArray,int index){
    
    
String s=""+ customerArray[index].getFirstName().charAt(0)
        +customerArray[index].getLastName().charAt(0);

int random = new Random().nextInt(1000);

int year = reservationArray[index].getCar().getYearOfConstruction();
String result =s+"_"+random+"_"+year;
        reservationArray[index].setReservationCode(result);

}
///////////////////////////////////////////////method for printing all reservations//////////////////////////////////////////////////////////
    public static void printReservation(PrintWriter write2,Reservation[]reservationArray){
    write2.println("--------------- Welcome to Car Renting  Management System ---------------");
    write2.println();
    write2.println();
    write2.println("--------------- Display All System Procedures ---------------");
    write2.println();
    write2.println();
     for(int i =0;i<reservationArray.length;i++) {
     if (reservationArray[i]==null){
        write2.println("SORRY: The reservation is NOT completed \n" +
        "There is no available Car  \n\n");
        }
        else{
        write2.println("DONE: The reservation is completed");
     
        write2.println("******Reservation Refrence number : "+ reservationArray[i].getReservationCode());
        write2.println("******Customer information : "+reservationArray[i].getCustomer().toString());
        write2.printf("******Pick up location : %-7s",reservationArray[i].getPickUpLocation());
        write2.printf("******Drop of location : %-7s",reservationArray[i].getDropOfLocation());
        write2.printf("\n******Pick up date : %-11s",reservationArray[i].getPickUpFormat());
        write2.printf("******Drop of date : %-11s",reservationArray[i].getDropOfFormat());
        write2.println("\n******Car information : The car Type: "+reservationArray[i].getCar().getBrand()+" "
                +reservationArray[i].getCar().getCarType() +", Year: "+
                reservationArray[i].getCar().getYearOfConstruction()+",\nTransmission: "+
                reservationArray[i].getCar().getTransmissionWord()+(reservationArray[i].getCar().isConvertible()?" and Convertible":" "));
        write2.println("******Additional services : Service "+reservationArray[i].getAdditionalServices().getServicetype());
        
        write2.println("--------------- Invoice Details ---------------");
        write2.println(" Number of reserved days: "+reservationArray[i].getNumOfResDay());
        write2.println(" Intial Total: "+reservationArray[i].calculateIntialTotal());
        write2.println("--------------- Additional Services Price ---------------");
        write2.println(" Total After additional Services  : "+reservationArray[i].calculatePriceAfterAddService());
        write2.println("--------------- Final Payment after Discount ---------------");
        write2.println(" Final Total  : "+reservationArray[i].calculateTotal());
        write2.println();
        write2.println();
       }}
    
      write2.flush();
      write2.close(); }
    ///////////////////////////////////////////method for filling the 2D analysisArray//////////////////////////////////////////////////////
public static void fillAnalysisReport(String[] carTypeArray , Service [] serviceArray,int [][] analysis,Reservation[]reservationArray ){

    for(int i=0;i<reservationArray.length;i++){
        if(reservationArray[i]==null){}
        else{
    String service=reservationArray[i].getAdditionalServices().getServicetype();
    String type =reservationArray[i].getCar().getCarType();
    for (int j=0;j<serviceArray.length;j++){
        for(int k=0;k<carTypeArray.length;k++){
    if(type.equalsIgnoreCase(carTypeArray[j]) && service.equalsIgnoreCase(serviceArray[k].getServicetype())){
        analysis[k][j]++;break;
    }}}
     }}
}

/////////////////////////////////////////////method for printing the 2D analysisArray//////////////////////////////////////////////////////
public static void printAnalysisReport(int [][] analysis,PrintWriter write3,String[] carTypeArray , Service [] serviceArray){
write3.println("-------------- Analysis Report ---------------");
write3.println();
write3.print("             CarType           ");
for(int i =0;i<carTypeArray.length;i++){
write3.printf("%-16s",carTypeArray[i]);
};
    
write3.println("\n        Services");

write3.println("        -----------------------------------------------------");
for(int i =0;i<analysis.length;i++){
    
write3.printf("        %-25s%-16d%-16d%-16d",serviceArray[i].getServicetype(),analysis[i][0],analysis[i][1],analysis[i][2]);
write3.println( );  }

write3.flush();
write3.close();}


}
    
    












