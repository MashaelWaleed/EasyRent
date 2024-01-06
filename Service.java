/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 1 
 */
package assignment1;


public class Service {
  private String servicetype;
  private double serviceprice;
  private static int numOfService=0;
  
///////////////////////////////////////////////////////////
   public Service() {
   this("None",0);}

    public Service(String servicetype, double serviceprice) {
        this.servicetype = servicetype;
        this.serviceprice = serviceprice;
        numOfService++;
        
    }
///////////////////////////////////////////////////////////

    public String toString() {
        return "servicetype: " + servicetype + ", serviceprice: " + serviceprice ;
    }
    
//////////////////////////////////////////////////////////
    public static int getNumberOfService() {
        return numOfService;
    }
    
    public String getServicetype() {
        return servicetype;
    }

    public double getServiceprice() {
        return serviceprice;
    }
    
/////////////////////////////////////////////////////////////

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public void setServiceprice(double serviceprice) {
        this.serviceprice = serviceprice;
    }
}
