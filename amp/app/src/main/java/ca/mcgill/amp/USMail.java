package ca.mcgill.amp;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class USMail extends Mail {

    public double rateFor30;
    public double rateFor50;

    public double rateFor100;
    public double rateFor200;
    public double rateFor500;

    public USMail(double length, double height, double width, double weight, Item itemType){
        super(length, height, width, weight, itemType);

        switch(itemType){
            case REGULAR_METERPOSTALINDICA :
                this.rateFor30 = 1.19;
                this.rateFor50 = 1.72;
                break;
            default:
                break;

        }
    }























    @Override
    double calculateStandard() {
        // TODO Auto-generated method stub

        if(this.weight > 0 && this.weight <= 30){
            return this.rateFor30;
        }
        else if(this.weight > 30 && this.weight <= 50){
            return this.rateFor50;
        }
        else if(this.weight < 0){
            return ErrorCodes.NEGATIVE_VALUE.code;
        }
        else if(this.weight > 50){
            return ErrorCodes.OVERWEIGHT_FOR_CATEGORY.code;
        }

        return -1;
    }

    @Override
    double calculateNonStandard() {
        // TODO Auto-generated method stub
        if(this.weight > 0 && this.weight <= 100){
            return this.rateFor100;
        }
        else if(this.weight > 100 && this.weight <= 200){
            return this.rateFor200;
        }
        else if(this.weight > 200 && this.weight <= 500){
            return this.rateFor500;
        }
        else if(this.weight < 0){
            return ErrorCodes.NEGATIVE_VALUE.code;
        }
        else if(this.weight > 500){
            return ErrorCodes.OVERWEIGHT_FOR_CATEGORY.code;
        }

        return -1;
    }
}
