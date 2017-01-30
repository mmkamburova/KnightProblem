package main.java;

public interface IParsable {

    /**
     * Checks if String input parses into number
     * 
     * @param input
     *            String input
     * @return true if String input parses into number, false otherwise
     */
    public static boolean isParsable(String input) {
        boolean parsable = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(input + " is not a number!");
        }
        return parsable;
    }
}
