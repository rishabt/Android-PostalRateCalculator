package ca.mcgill.amp;

/**
 * Created by rtando1 on 21/02/2016.
 */

public enum Item {

    REGULAR_STAMPS,
    REGULAR_METERPOSTALINDICA,
    REGULAR_SINGLESTAMP,
    OTHER_STAMP,
    OTHER_METERPOSTALINDICA;

    public static String getType(Item item){
        if(item == REGULAR_METERPOSTALINDICA || item == REGULAR_STAMPS || item == REGULAR_SINGLESTAMP){
            return "Regular";
        }

        return "Other";
    }
}

