import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by stevenburris on 9/25/16.
 */
public class TestTxtWriter {

    @Test
    public void testTxtWriter() throws IOException {

        ArrayList<Country> countries= Main.read("countries.txt");
        //When
        File countryFile = new File("A" + "_countries.txt");
        FileWriter fileWriter = new FileWriter(countryFile);
        for (Country country : countries) {
            fileWriter.append(country.toString() + "\n");
        }
        fileWriter.close();

        //Then

        assertTrue(countryFile.exists());


    }
}
