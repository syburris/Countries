import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by stevenburris on 9/24/16.
 */
public class TestAddToHashMap {

    @Test
    public void testHashMap() {
        //Given

        ArrayList<Country> countries = Main.read(Main.COUNTRIES);

        //If

        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
        for (Country country : countries) {
            String firsLetter2 = String.valueOf(country.abbreviation.charAt(0));
            ArrayList<Country> countryNameBeginsWith = countryMap.get(firsLetter2);
            if ( countryNameBeginsWith == null) {
                countryNameBeginsWith = new ArrayList<>();
            }
            countryNameBeginsWith.add(country);
            countryMap.put(firsLetter2,countryNameBeginsWith);
        }

        //Then

        assertTrue(true);
    }

}
