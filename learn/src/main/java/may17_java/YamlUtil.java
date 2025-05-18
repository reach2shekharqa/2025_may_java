package may17_java;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlUtil {

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Object> finalsection = new LinkedHashMap<>();// login

        Map<String, Object> usernamesection = new LinkedHashMap<>();

        usernamesection.put("type", "textbox");
        usernamesection.put("locator", "#id");

        Map<String, Object> login = new LinkedHashMap<>();

        login.put("username", usernamesection);

        finalsection.put("login", login);

        System.out.println(finalsection);


        //key - login 
        //value - object[username]

        for(Map.Entry<String,Object> entry : finalsection.entrySet()){

            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }



        // String filepath = "learn\\src\\main\\java\\may17_java\\a.yml";

        // System.out.println(filepath);

        // InputStream ip = new FileInputStream(filepath);

        // Yaml yaml = new Yaml();

        // Map<String, Object> data;

        // data = yaml.load(ip);

        // System.out.println(data);

    }

}
