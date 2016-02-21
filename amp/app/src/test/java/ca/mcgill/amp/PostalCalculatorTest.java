package ca.mcgill.amp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class PostalCalculatorTest {

    PostalCalculator calculator;

    @Before
    public void setUp() throws Exception {
        double weight = 0.0;
        double height =  0.0;
        double length = 0.0;
        double width = 0.0;

        Item itemType = Item.OTHER_STAMP;
        String location = "US";
        calculator = new PostalCalculator(height, width, length, weight, itemType, location);
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


}