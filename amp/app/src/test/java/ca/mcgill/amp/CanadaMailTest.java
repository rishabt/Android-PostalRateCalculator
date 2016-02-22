package ca.mcgill.amp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dsharm10 on 21/02/2016.
 */
public class CanadaMailTest {

    CanadaMail canada;
    double weight = 0.0;
    double height =  0.0;
    double length = 0.0;
    double width = 0.0;

    Item itemType = Item.OTHER_STAMP;
    String location = "Canada";

    @Before
    public void setUp() throws Exception {
        canada = new CanadaMail(length, height, width, weight, itemType);
    }

    /*
    Instantiate a International mail object
    */
    @Test
    public void testCanadaMailConstructor(){
        assertEquals(Item.OTHER_STAMP,canada.itemType);
        assert(0.0 == canada.weight);
        assert(0.0 == canada.height);
        assert(0.0 == canada.length);
        assert(0.0 == canada.width);

        switch(itemType){
            case REGULAR_STAMPS : 			 
                assert(canada.rateFor30 == 0.85);
                assert(canada.rateFor50 == 1.20);
                break;
            case REGULAR_METERPOSTALINDICA : 
                assert(canada.rateFor30 == 0.80);
                assert(canada.rateFor50 == 1.19);
                break;
            case REGULAR_SINGLESTAMP : 		 
                assert(canada.rateFor30 == 1.00);
                assert(canada.rateFor50 == 1.20);
                break;
            case OTHER_STAMP :  			 
                assert(canada.rateFor100 == 1.80);
                assert(canada.rateFor200 == 2.95);
                assert(canada.rateFor300 == 4.10);
                assert(canada.rateFor400 == 4.70);
                assert(canada.rateFor500 == 5.05);
                break;
            case OTHER_METERPOSTALINDICA :   
                assert(canada.rateFor100 == 1.71);
                assert(canada.rateFor200 == 2.77);
                assert(canada.rateFor300 == 3.89);
                assert(canada.rateFor400 == 4.42);
                assert(canada.rateFor500 == 4.74);
                break;
        }
    }

    /*
    Calculate the Standard rate for posts under 30 grams
    */
    @Test
    public void testCalculateStandardRateFor30(){

        weight = 25;
        canada = new CanadaMail(length, height, width, weight, Item.REGULAR_METERPOSTALINDICA);

        assert(canada.calculateStandard() == canada.rateFor30);
    }


}