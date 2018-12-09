package Validator;

public class IdValidatorClass implements Validator {

    private String id;

    public IdValidatorClass(String id) {
        this.id = id;
    }

    public boolean validator() {
        char[] idCharArray = id.toCharArray();
        if (idCharArray.length != 9) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isUpperCase(idCharArray[i])) {
                return false;
            }
        }

        for (int i = 3; i < 9; i++) {
            if (!Character.isDigit(idCharArray[i])) {
                return false;
            }
        }

        int[] factors = {7, 3, 1, 9, 7, 3, 1, 7, 3};
        int[] newMappedId = new int[9];

        for (int i = 0; i < 9; i++) {
            if (idCharArray[i] < 3) {
                newMappedId[i] = ((int) idCharArray[i] - (int) 'A') + 10;
            } else {
                newMappedId[i] = Character.getNumericValue(idCharArray[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += newMappedId[i] * factors[i];
        }
        return sum % 10 == 0;
    }
}
