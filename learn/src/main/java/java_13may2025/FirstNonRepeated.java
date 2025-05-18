package java_13may2025;

public class FirstNonRepeated {

    public static void main(String[] args) {

        String input = "swiss";

        int length = input.length();

        char[] charstr = input.toCharArray();

        for (int i = 0; i < length; i++) {
            int j;
            for (j = i + 1; j < length; j++) {
                if (charstr[i] == charstr[j]) {
                    break;//char is repeated
                }
            }
            if (j == length) {
                System.out.println("First non-repeated character is: " + charstr[i]);
                break;
            }
        }
    }

}
