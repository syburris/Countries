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
    public static String firstLetter1;

    public static void main(String[] args) throws IOException {
        ArrayList<Country> countries= read(COUNTRIES);
        System.out.println("Please enter a letter.");
        Scanner scanner = new Scanner(System.in);
        String firstLetter = scanner.nextLine();
        // converts firstLetter to uppercase
        String firstLetter1 = firstLetter.toUpperCase();
        System.out.println("You entered : " + firstLetter1);

        if (firstLetter1.isEmpty()) {
            System.out.println("You have to enter a letter");
            main(args);
        }

        if (firstLetter1.length() > 1) {
            System.out.println("You may only enter one letter.");
            main(args);
        }

        addToHashMap(countries);
        ArrayList<Country> countryList = countryMap.get(firstLetter1);
        txtWriter(firstLetter1,countryList);
        jsonWriter(firstLetter1,countryList);
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

    // write array list to txt file

    public static void txtWriter(String firstLetter1, ArrayList<Country> countryList) throws IOException {
        File countryFile = new File(firstLetter1 + "_countries.txt");
        FileWriter fileWriter = new FileWriter(countryFile);
        for (Country country : countryList) {
            fileWriter.append(country.toString() + "\n");
        }
        fileWriter.close();
    }

    // write to json
    public static void jsonWriter(String firstLetter1, ArrayList<Country> countryList) throws IOException {
        File countryJson = new File(firstLetter1 + "_countries.json");
        JsonSerializer serializer = new JsonSerializer();
        CountryWrapper wrapper = new CountryWrapper();
        wrapper.country = countryList;
        String json = serializer.deep(true).serialize(wrapper);
        FileWriter writeJson = new FileWriter(countryJson);
        writeJson.write(json);
        writeJson.close();
    }

}
