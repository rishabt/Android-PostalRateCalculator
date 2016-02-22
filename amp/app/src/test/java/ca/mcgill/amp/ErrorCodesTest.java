package ca.mcgill.amp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rtando1 on 21/02/2016.
 */
public class ErrorCodesTest {

    static ErrorCodes error;
    @Before
    public void setUp() throws Exception {
    }

    /*
        Set code value of enum
     */
    @Test
    public void testErrorCodesInstantiation(){

        error = ErrorCodes.NEGATIVE_VALUE;
        assert(error.code == -2);

        error = ErrorCodes.OVERWEIGHT_FOR_CATEGORY;
        assert(error.code == -3);
    }

}