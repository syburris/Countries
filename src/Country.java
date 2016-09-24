/**
 * Created by stevenburris on 9/23/16.
 */
public class Country {

    String countryAbbreviation;
    String countryName;

    public Country(String countryAbbreviation, String countryName) {
        this.countryAbbreviation = countryAbbreviation;
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }
}
