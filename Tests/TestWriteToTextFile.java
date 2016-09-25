import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by stevenburris on 9/24/16.
 */
public class TestWriteToTextFile {

    @Test
    public void testTxtWriter() throws IOException {

        //Given
        ArrayList<Country> countryList = Main.countryMap.get(Main.firstLetter1);


        // When

        Main.txtWriter(Main.firstLetter1,countryList);

        // Then

        assertTrue(true);


    }
}
