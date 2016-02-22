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

    String location_op1 = "US";
    String location_op2 = "Canada";
    String location_op3 = "International";

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
    test US rate
     */
    @Test
    public void testUSMailStandardCalculate(){
        PostalCalculator pc = new PostalCalculator(height, length, width, 29.0, Item.REGULAR_SINGLESTAMP, location_op1);
        assert(pc.calculate() == 1.20);
    }

    /*
    test US rate
     */
    @Test
    public void testUSMailNonStandardCalculate(){
        PostalCalculator pc = new PostalCalculator(height, length, width, 99.0, Item.OTHER_STAMP, location_op1);
        assert(pc.calculate() == 2.95);
    }

    /*
    test Canada rate
     */
    @Test
    public void testCanadaMailStandardCalculate(){
        PostalCalculator pc = new PostalCalculator(height, length, width, 29.0, Item.REGULAR_SINGLESTAMP, location_op2);
        assert(pc.calculate() == 1.00);
    }

    /*
    test Canada rate
     */
    @Test
    public void testCanadaMailNonStandardCalculate(){
        PostalCalculator pc = new PostalCalculator(height, length, width, 99.0, Item.OTHER_STAMP, location_op2);
        assert(pc.calculate() == 1.80);
    }

    /*
    test International rate
     */
    @Test
    public void testInternationalMailStandardCalculate(){
        PostalCalculator pc = new PostalCalculator(height, length, width, 29.0, Item.REGULAR_SINGLESTAMP, location_op2);
        assert(pc.calculate() == 2.50);
    }
}