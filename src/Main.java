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
        read(COUNTRIES);
        System.out.println("enter a letter");
        Scanner scanner = new Scanner(System.in);


    }

    public static ArrayList<Country> read(String countryFile) {
        ArrayList<Country> countries = new ArrayList<>();

        // read the file and place them into hash map
        File file = new File(COUNTRIES);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\|");
                Country country = new Country(columns[0], columns[1]);
                countries.add(country);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countries;
    }

}
