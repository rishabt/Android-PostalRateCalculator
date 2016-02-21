package ca.mcgill.amp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class PostalCalculatorTest {

    PostalCalculator calculator;
    USMail us;
    double weight = 0.0;
    double height =  0.0;
    double length = 0.0;
    double width = 0.0;

    Item itemType = Item.OTHER_STAMP;
    String location = "US";

    @Before
    public void setUp() throws Exception {

        calculator = new PostalCalculator(height, width, length, weight, itemType, location);
        us = new USMail(length, height, width, weight, itemType);
    }


    /*
    Instantiate calculator with length, height, width, weight, location and itemType data
    */
    @Test
    public void testInstantiateCalculator(){
        assertEquals(Item.OTHER_STAMP,calculator.itemType);
        assert(0.0 == calculator.weight);
        assert(0.0 == calculator.height);
        assert(0.0 == calculator.length);
        assert(0.0 == calculator.width);
        assertEquals("US", calculator.location);
    }

    /*
    getType method should return the correct type of a stamp
     */
    @Test
    public void testGetItemType(){
        assertEquals(Item.getType(Item.REGULAR_STAMPS),"Regular");
        assertEquals(Item.getType(Item.REGULAR_METERPOSTALINDICA),"Regular");
        assertEquals(Item.getType(Item.REGULAR_SINGLESTAMP),"Regular");
        assertEquals(Item.getType(Item.OTHER_STAMP),"Other");
        assertEquals(Item.getType(Item.OTHER_METERPOSTALINDICA),"Other");
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
}