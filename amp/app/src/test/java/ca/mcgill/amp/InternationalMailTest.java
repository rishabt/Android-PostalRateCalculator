package ca.mcgill.amp;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class InternationalMailTest {

    InternationalMail international;
    double weight = 0.0;
    double height =  0.0;
    double length = 0.0;
    double width = 0.0;

    Item itemType = Item.OTHER_STAMP;
    String location = "US";

    @Before
    public void setUp() throws Exception {
        international = new InternationalMail(length, height, width, weight, itemType);
    }

    /*
    Instantiate a International mail object
    */
    @Test
    public void testInternationalMailConstructor(){
        assertEquals(Item.OTHER_STAMP,international.itemType);
        assert(0.0 == international.weight);
        assert(0.0 == international.height);
        assert(0.0 == international.length);
        assert(0.0 == international.width);
    }

    /*
    Set the postal rates for different types of stamps
     */
    @Test
    public void testSampleRatesREGULAR_METERPOSTALINDICA(){

        international = new InternationalMail(length, height, width, weight, Item.REGULAR_METERPOSTALINDICA);
        switch(international.itemType){
            case REGULAR_METERPOSTALINDICA :
                assert(international.rateFor30 == 2.36);
                assert(international.rateFor50 == 3.42);
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

        international = new InternationalMail(length, height, width, weight, Item.REGULAR_SINGLESTAMP);
        switch(international.itemType){
            case REGULAR_SINGLESTAMP:
                assert(international.rateFor30 == 2.50);
                assert(international.rateFor50 == 3.60);
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

        international = new InternationalMail(length, height, width, weight, Item.OTHER_STAMP);
        switch(international.itemType){
            case OTHER_STAMP:
                assert(international.rateFor100 == 5.90);
                assert(international.rateFor200 == 10.30);
                assert(international.rateFor500 == 20.60);
                break;
            default:
                break;
        }
    }

}