import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by stevenburris on 9/24/16.
 */
public class TestReadCountriesFile {
    @Test
    public void testRead() {

        // Given
        final String COUNTRIES = "countries.txt";

        // IF / When

        ArrayList<Country> countries = Main.read(COUNTRIES);


        // Then

        assertTrue(countries.get(0).getClass().equals(Country.class));
        assertTrue(countries.get(0).name.equals("afghanistan"));
        assertTrue(countries.get(0).abbreviation.equals("AF"));
        assertTrue(countries.get(1).name.equals("albania"));
        assertTrue(countries.get(1).abbreviation.equals("AL"));

    }



}
