package java8learning;

public class Implemntation {

    public static void main(String[] args) {

        Anonymus obj = (int a, int b) -> {
            return a % b;
        };

        System.out.println(obj.divide(3, 4));
    }

}
