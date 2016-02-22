package ca.mcgill.amp;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class InternationalMail extends Mail {

    double rateFor30;
    double rateFor50;

    double rateFor100;
    double rateFor200;
    double rateFor500;

    public InternationalMail(double length, double height, double width, double weight, Item itemType) {
        super(length, height, width, weight, itemType);

        switch(itemType) {
            case REGULAR_METERPOSTALINDICA:  this.rateFor30 = 2.36;
                                             this.rateFor50 = 3.42;
                                             break;
            case REGULAR_SINGLESTAMP : 		 this.rateFor30 = 2.50;
                                             this.rateFor50 = 3.60;
                                             break;
            case OTHER_STAMP :  			 this.rateFor100 = 5.90;
                                             this.rateFor200 = 10.30;
                                             this.rateFor500 = 20.60;
                                             break;
            case OTHER_METERPOSTALINDICA :   this.rateFor100 = 5.56;
                                             this.rateFor200 = 9.69;
                                             this.rateFor500 = 19.39;
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
        return -1;
    }

    @Override
    double calculateNonStandard() {
        // TODO Auto-generated method stub

        return -1;
    }
}
