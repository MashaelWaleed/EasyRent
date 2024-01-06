/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 1 
 */
package assignment1;

public class Customer {
 private String first_name;  
 private String last_name;
 private String email;
 private long credit_Card ;
 private int discount_code;
 
 //////////////////////////////////////////////////////////////////////////////////////////////
 
 public Customer(){this("None","None","None",0,0);}
 
    public Customer(String first_name, String last_name, String email, long credit_Card, int discount_code) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.credit_Card = credit_Card;
        this.discount_code = discount_code;
    }
////////////////////////////////////////////////////////////////////////////////////////////////    

    public String toString() {
        return "Customer Name: " + first_name + " " + last_name + ", Email: \n" + email + ", Code: " +discount_code ;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public long getCreditCard() {
        return credit_Card;
    }

    public int getDiscountCode() {
        return discount_code;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreditCard(long credit_Card) {
        this.credit_Card = credit_Card;
    }

    public void setDiscountCode(int discount_code) {
        this.discount_code = discount_code;
    }
    
    
    
    
}
