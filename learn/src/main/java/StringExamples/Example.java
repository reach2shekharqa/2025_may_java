package StringExamples;

public class Example {

    public static void main(String[] args) {

        // string liertal

        // thread-safe
        // no synchronization reqd

        String name = "shekhar";//sequence of chars
        String name1 = "shekhar";

        //for above strigs 
        System.out.println(name.equals(name1));

        System.out.println(name == name1);

        // Character [] namearray = {'s','s'};

        // System.out.println(namearray.toString());

        // String a = new String("shekhar");

        // System.out.println(name.equals(a));//content comparsion

        // System.out.println(name == a);//reference comaprasion



    }

}
