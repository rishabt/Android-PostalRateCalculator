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

        switch(itemType){
            case REGULAR_STAMPS :
                this.rateFor30 = 0.85;
                this.rateFor50 = 1.20;
                break;
            case REGULAR_METERPOSTALINDICA :
                this.rateFor30 = 0.80;
                this.rateFor50 = 1.19;
                break;
            case REGULAR_SINGLESTAMP :
                this.rateFor30 = 1.00;
                this.rateFor50 = 1.20;
                break;
            case OTHER_STAMP :
                this.rateFor100 = 1.80;
                this.rateFor200 = 2.95;
                this.rateFor300 = 4.10;
                this.rateFor400 = 4.70;
                this.rateFor500 = 5.05;
                break;
            case OTHER_METERPOSTALINDICA :
                this.rateFor100 = 1.71;
                this.rateFor200 = 2.77;
                this.rateFor300 = 3.89;
                this.rateFor400 = 4.42;
                this.rateFor500 = 4.74;
                break;

        }
    }

    @Override
    double calculateStandard() {

        if(this.weight > 0 && this.weight <= 30){
            return this.rateFor30;
        }else if(this.weight > 30 && this.weight <= 50){
            return this.rateFor50;
        }else if(this.weight < 0){
            return ErrorCodes.NEGATIVE_VALUE.code;
        }else if(this.weight > 50){
            return ErrorCodes.OVERWEIGHT_FOR_CATEGORY.code;
        }

        return -1;
    }

    @Override
    double calculateNonStandard() {

        if(this.weight > 0 && this.weight <= 100){
            return this.rateFor100;
        }else if(this.weight > 100 && this.weight <= 200){
            return this.rateFor200;
        }else if(this.weight > 200 && this.weight <= 300){
            return this.rateFor300;
        }else if(this.weight > 300 && this.weight <= 400){
            return this.rateFor400;
        }else if(this.weight > 400 && this.weight <= 500){
            return this.rateFor500;
        }

        return -1;
    }
}
