package ca.mcgill.amp;

/**
 * Created by rtando1 on 21/02/2016.
 */
public abstract class Mail {

    public double length;
    public double height;
    public double width;

    public double weight;

    Item itemType;

    public Mail(double length, double height, double width, double weight, Item itemType){
        this.length = length;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.itemType = itemType;
    }

    abstract double calculateStandard();

    abstract double calculateNonStandard();
}
