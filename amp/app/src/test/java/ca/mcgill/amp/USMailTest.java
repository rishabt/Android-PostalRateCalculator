package ca.mcgill.amp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class USMailTest {

    USMail us;
    double weight = 0.0;
    double height =  0.0;
    double length = 0.0;
    double width = 0.0;

    Item itemType = Item.OTHER_STAMP;
    String location = "US";

    @Before
    public void setUp() throws Exception {
        us = new USMail(length, height, width, weight, itemType);
    }

    /*
    Instantiate a US mail object
    */
    @Test
    public void testUSMailConstructor(){
        assertEquals(Item.OTHER_STAMP,us.itemType);
        assert(0.0 == us.weight);
        assert(0.0 == us.height);
        assert(0.0 == us.length);
        assert(0.0 == us.width);
    }

    /*
    Set the postal rates for different types of stamps
     */
    @Test
    public void testSampleRatesREGULAR_METERPOSTALINDICA(){

        us = new USMail(length, height, width, weight, Item.REGULAR_METERPOSTALINDICA);
        switch(us.itemType){
            case REGULAR_METERPOSTALINDICA :
                assert(us.rateFor30 == 1.19);
                assert(us.rateFor50 == 1.72);
                break;
            default:
                break;
        }
    }

    /*
   Set the postal rates for different types of stamps
    */
    @Test
    public void testSampleRatesREGULAR_SINGLESTAMP(){

        us = new USMail(length, height, width, weight, Item.REGULAR_SINGLESTAMP);
        switch(us.itemType){
            case REGULAR_SINGLESTAMP:
                assert(us.rateFor30 == 1.20);
                assert(us.rateFor50 == 1.80);
                break;
            default:
                break;
        }
    }

    /*
   Set the postal rates for different types of stamps
   */
    @Test
    public void testSampleRatesOTHER_STAMP(){

        us = new USMail(length, height, width, weight, Item.OTHER_STAMP);
        switch(us.itemType){
            case OTHER_STAMP:
                assert(us.rateFor100 == 2.95);
                assert(us.rateFor200 == 5.15);
                assert(us.rateFor500 == 10.30);
                break;
            default:
                break;
        }
    }

    /*
   Set the postal rates for different types of stamps
   */
    @Test
    public void testSampleRatesOTHER_METERPOSTALINDICA(){

        us = new USMail(length, height, width, weight, Item.OTHER_METERPOSTALINDICA);
        switch(us.itemType){
            case OTHER_METERPOSTALINDICA:
                assert(us.rateFor100 == 2.68);
                assert(us.rateFor200 == 4.85);
                assert(us.rateFor500 == 9.69);
                break;
            default:
                break;
        }
    }

    /*
        Calculate the Standard rate for posts under 30 grams
     */
    @Test
    public void testCalculateStanardRateFor30(){

        weight = 25;
        us = new USMail(length, height, width, weight, Item.REGULAR_METERPOSTALINDICA);

        assert(us.calculateStandard() == us.rateFor30);
    }

    /*
       Calculate the Standard rate for posts under 50 grams
    */
    @Test
    public void testCalculateStanardRateFor50(){

        weight = 35;
        us = new USMail(length, height, width, weight, Item.REGULAR_METERPOSTALINDICA);

        assert(us.calculateStandard() == us.rateFor50);
    }

    /*
       Check Error condition for negative weights
    */
    @Test
    public void testErrorConditionCalculateStandardRateWeightLessThanZero(){

        weight = -1;
        us = new USMail(length, height, width, weight, Item.REGULAR_METERPOSTALINDICA);

        assert(us.calculateStandard() == ErrorCodes.NEGATIVE_VALUE.code);
    }

    /*
      Check Error condition for overweight posts
   */
    @Test
    public void testErrorConditionCalculateStandardRateOverWeight(){

        weight = 55.0;
        us = new USMail(length, height, width, weight, Item.REGULAR_METERPOSTALINDICA);

        assert(us.calculateStandard() == ErrorCodes.OVERWEIGHT_FOR_CATEGORY.code);
    }

    /*
     Calculate the Non-Standard rate for rateFor100
  */
    @Test
    public void testCalculateStanardRateFor100(){

        weight = 95;
        us = new USMail(length, height, width, weight, Item.OTHER_METERPOSTALINDICA);

        assert(us.calculateNonStandard() == us.rateFor100);
    }

    /*
    Calculate the Non-Standard rate for rateFor100
    */
    @Test
    public void testCalculateStanardRateFor200(){

        weight = 195;
        us = new USMail(length, height, width, weight, Item.OTHER_METERPOSTALINDICA);

        assert(us.calculateNonStandard() == us.rateFor200);
    }

}