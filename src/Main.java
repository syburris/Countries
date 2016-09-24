import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by stevenburris on 9/23/16.
 */
public class Main {

    static final String COUNTRIES = "countries.txt";
    public static HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ArrayList<Country> countries= read(COUNTRIES);
        System.out.println("enter a letter");
        Scanner scanner = new Scanner(System.in);

        String firsLetter = scanner.nextLine();
        if (firsLetter.length() > 1) {
            System.out.println("Please only type one letter.");
            main(args);
        }

        /* For ever Country object country within the array list countries
            check the first letter and if the first letter is in the HashMap "countryMap"
            as the key, then get the ArrayList of countries that start with that letter.
            If the ArrayList doesn't exist, create it and add to the HashMap "countryMap".

         */
        for (Country country : countries) {
            String firsLetter2 = String.valueOf(country.abbreviation.charAt(0));
            ArrayList<Country> countryNameBeginsWith = countryMap.get(firsLetter2);
            if ( countryNameBeginsWith == null) {
                countryNameBeginsWith = new ArrayList<>();
            }
            countryNameBeginsWith.add(country);
            countryMap.put(firsLetter2,countryNameBeginsWith);
        }
        ArrayList<Country> countryList = countryMap.get(firsLetter);
        System.out.println(countryList);
        File countryFile = new File(firsLetter + "_countries.txt");
        FileWriter fileWriter = new FileWriter(countryFile);
        for (Country country :countryList) {
            fileWriter.append(country.toString() + "\n");
        }
        fileWriter.close();





    }

    public static ArrayList<Country> read(String countryFile) {
        ArrayList<Country> countries = new ArrayList<>();

        // read the file and place them into ArrayList "countries"
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
