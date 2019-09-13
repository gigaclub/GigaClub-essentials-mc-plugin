package gigaclubessentials.gigaclubessentials.checks;

public class isInteger {

    public static boolean isInteger(String eingabe) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(eingabe);
            isValidInteger = true;
        } catch (NumberFormatException e) {

        }
        return isValidInteger;
    }

}
