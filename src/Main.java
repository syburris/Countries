import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by stevenburris on 9/23/16.
 */
public class Main {

    static final String COUNTRIES = "countries.txt";
    public static HashMap<String, ArrayList<Country>> country;

    public static void main(String[] args) {
        read();
        System.out.println("WTF MATE?");


    }

    public static HashMap<String, ArrayList<Country>> read() {
        HashMap<String, ArrayList<Country>> countries = new HashMap<>();

        // read the file and place them into hash map
        File file = new File(COUNTRIES);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            ArrayList<Country> countries1 = new ArrayList<>();
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\|");
                Country country = new Country(columns[0], columns[1]);
                country.countryAbbreviation = columns[0];
                country.countryName = columns[1];
                countries1.add(country);
                countries.put(columns[0], countries1);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countries;
    }

}
