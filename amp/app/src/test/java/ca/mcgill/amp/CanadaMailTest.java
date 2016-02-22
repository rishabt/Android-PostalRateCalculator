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

        assert(canada.rateFor30 == 0.85);
    }
}