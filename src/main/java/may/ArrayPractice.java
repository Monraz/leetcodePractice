package may;

import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        // Initializing a 2D array that represents an apartment building
        String[][] apartments = {
                {"Apt 101", "Apt 102"},
                {"Apt 201", "Apt 202"}
        };

        // Adding a new floor to the apartment building
        apartments = addNewFloor(apartments, new String[]{"Apt 301", "Apt 302"});

        // TODO: Make a walk visiting each apartment on every floor of the updated building.
        for (String[] floor : apartments) {
            for (String apartment : floor) {
                System.out.print(apartment + " ");
            }
            System.out.println();
        }
    }

    // TODO: Add a method `addNewFloor` to add a new floor with apartments to our 'apartment building'.
    private static String[][] addNewFloor(String[][] apartments, String[] newApartments) {
        apartments = Arrays.copyOf(apartments, apartments.length + 1);
        apartments[apartments.length - 1] = newApartments;
        return apartments;
    }
}