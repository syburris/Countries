import jodd.json.JsonSerializer;

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
        System.out.println("Please enter an upper case letter.");
        Scanner scanner = new Scanner(System.in);
        String firstLetter = scanner.nextLine();

        // if the user input isn't an upper case letter, loop back and ask for an upper case letter
        while (!firstLetter.matches("^[A-Z]+$")) {
            System.out.println("Please enter an upper case letter.");
            firstLetter = scanner.nextLine();
            // If the input is more than one character, restart the program
            if (firstLetter.length() > 1) {
                System.out.println("Please only type one letter.");
                firstLetter = scanner.nextLine();
            }
        }

        addToHashMap(countries);
        ArrayList<Country> countryList = countryMap.get(firstLetter);
        txtWriter(firstLetter,countryList);
        jsonWriter(firstLetter,countryList);
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

    // write array list to txt file

    public static void txtWriter(String firstLetter, ArrayList<Country> countryList) throws IOException {
        File countryFile = new File(firstLetter + "_countries.txt");
        FileWriter fileWriter = new FileWriter(countryFile);
        for (Country country : countryList) {
            fileWriter.append(country.toString() + "\n");
        }
        fileWriter.close();
    }

    /* For every Country object country within the array list countries
            check the first letter and if the first letter is in the HashMap "countryMap"
            as the key, then get the ArrayList of countries that start with that letter.
            If the ArrayList doesn't exist, create it and add to the HashMap "countryMap".
     */
    public static void addToHashMap (ArrayList<Country> countries) {
        for (Country country : countries) {
            String firsLetter2 = String.valueOf(country.abbreviation.charAt(0));
            ArrayList<Country> countryNameBeginsWith = countryMap.get(firsLetter2);
            if ( countryNameBeginsWith == null) {
                countryNameBeginsWith = new ArrayList<>();
            }
            countryNameBeginsWith.add(country);
            countryMap.put(firsLetter2,countryNameBeginsWith);
        }
    }

    // write to json
    public static void jsonWriter(String firstLetter, ArrayList<Country> countryList) throws IOException {
        File countryJson = new File(firstLetter + "_countries.json");
        JsonSerializer serializer = new JsonSerializer();
        CountryWrapper wrapper = new CountryWrapper();
        wrapper.country = countryList;
        String json = serializer.deep(true).serialize(wrapper);
        FileWriter writeJson = new FileWriter(countryJson);
        writeJson.write(json);
        writeJson.close();
    }

}
