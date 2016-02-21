package ca.mcgill.amp;

/**
 * Created by rtando1 on 21/02/2016.
 */
public abstract class Mail {

    protected double length;
    protected double height;
    protected double width;

    protected double weight;

    Item itemType;

    public Mail(double length, double height, double width, double weight, Item itemType){

    }

    abstract double calculateStandard();

    abstract double calculateNonStandard();
}
