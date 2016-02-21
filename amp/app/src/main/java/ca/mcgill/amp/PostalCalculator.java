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
}
