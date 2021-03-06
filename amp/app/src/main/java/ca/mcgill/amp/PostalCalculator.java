package ca.mcgill.amp;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class PostalCalculator {

    double weight;
    double height;
    double length;
    double width;

    Item itemType;
    String location;

    public PostalCalculator(double height, double length, double width, double weight,
                            Item itemType, String location){

        this.length = length;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.itemType = itemType;
        this.location = location;
    }

    public static boolean isValid(double length, double width, double height, boolean regular)
    {
        if(length<=0 || width <=0 || height <=0 )
            return false;
        if(regular)
        {
            if(length<=24.5 && width <=15.6 && height <= .5 )
                return true;
            else
                return false;
        }
        else
        {
            if(length<=38 && width <=27 && height <= 2 )
                return true;
            else
                return false;
        }
    }

    public double calculate(){

        double rate;

        if(location.equals("US")){
            Mail us = new USMail(this.length, this.height, this.width, this.weight, this.itemType);
            if(Item.getType(itemType).equals("Regular")){
                return us.calculateStandard();
            }
            else{
                return us.calculateNonStandard();
            }
        }
        else if(location.equals("Canada")){
            Mail ca = new CanadaMail(this.length, this.height, this.width, this.weight, this.itemType);
            if(Item.getType(itemType).equals("Regular")){
                return ca.calculateStandard();
            }
            else{
                return ca.calculateNonStandard();
            }
        }
        else if(location.equals("International")){
            Mail in = new InternationalMail(this.length, this.height, this.width, this.weight, this.itemType);
            if(Item.getType(itemType).equals("Regular")){
                return in.calculateStandard();
            }
            else{
                return in.calculateNonStandard();
            }
        }

        return -1;
    }

}
