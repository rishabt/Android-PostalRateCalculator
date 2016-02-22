package ca.mcgill.amp;

/**
 * Created by dsharm10 on 21/02/2016.
 */
public class CanadaMail extends Mail {

    double rateFor30;
    double rateFor50;

    double rateFor100;
    double rateFor200;
    double rateFor300;
    double rateFor400;
    double rateFor500;

    public CanadaMail(double length, double height, double width, double weight, Item itemType){
        super(length, height, width, weight, itemType);
    }

    @Override
    double calculateStandard() {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    double calculateNonStandard() {
        // TODO Auto-generated method stub
        return -1;
    }
}
