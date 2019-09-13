package gigaclubessentials.gigaclubessentials.checks;

public class isFloat {

    public static boolean isFloat(String eingabe) {
        boolean isValidFloat = false;
        try {
            Float.parseFloat(eingabe);
            isValidFloat = true;
        } catch (NumberFormatException e) {

        }
        return isValidFloat;
    }

}
