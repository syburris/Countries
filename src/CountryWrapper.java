import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stevenburris on 9/23/16.
 */
public class CountryWrapper {

public static ArrayList<Country> country;

    public CountryWrapper() {

    }

    public static ArrayList<Country> getCountry() {
        return country;
    }

    public static void setCountry(ArrayList<Country> country) {
        CountryWrapper.country = country;
    }
}
