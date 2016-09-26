import jodd.json.JsonSerializer;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by stevenburris on 9/26/16.
 */
public class TestJsonWriter {
    @Test
    public void testJsonWriter() throws IOException {
        //Given
        ArrayList<Country> countries= Main.read("countries.txt");

        //When
        File countryJson = new File("A" + "_countries.json");
        JsonSerializer serializer = new JsonSerializer();
        CountryWrapper wrapper = new CountryWrapper();
        wrapper.country = countries;
        String json = serializer.deep(true).serialize(wrapper);
        FileWriter writeJson = new FileWriter(countryJson);
        writeJson.write(json);
        writeJson.close();

        //Then
        assertTrue(countryJson.exists());



    }
}
