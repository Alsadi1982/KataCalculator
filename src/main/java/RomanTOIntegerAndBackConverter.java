import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RomanTOIntegerAndBackConverter {

    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }

    /**
     * Method RomanTOIntegerAndBackConverter#intToRoman(int number) converts decimal numerals to roman
     * @param number - decimal numeral for convert
     * @return roman numeral
     */
    public static String intToRoman(int number) {
        if (number >= 4000 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    /**
     * Method RomanTOIntegerAndBackConverter#romanToInt(int number) converts roman numerals to decimal
     * if @param number consists decimal numerals, method will throw IllegalArgumentException
     * @param number - roman numeral for convert
     * @return decimal numeral
     */
    public static int romanToInt (String number){

        if (number.matches(".*[0-9].*") || !number.matches("[M|D|C|L|X|V|I]*")) {
            throw new IllegalArgumentException("Impossible to convert. Wrong roman numeral");
        }

        int arabicNamber = 0;
        int current = 0;
        int previous = 0;
        String romanNumber;

        for( int i = 1; i <= number.length(); i++) {

            romanNumber = number.substring((i -1), i);

            for (NavigableMap.Entry<Integer, String> elem : units.descendingMap().entrySet()) {

                if (elem.getValue().equals(romanNumber)){
                    current = elem.getKey();
                    break;
                }
            }
                if (current > previous) {
                    arabicNamber += current - (previous * 2);
                } else {
                    arabicNamber += current;
                }

                previous = current;

        }

        return arabicNamber;
    }
}
