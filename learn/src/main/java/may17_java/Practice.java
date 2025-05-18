package may17_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Practice {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException {

        String filePath = System.getProperty("user.dir") + "\\learn\\src\\main\\java\\may17_java\\" + "login.yaml";

        InputStream ip = new FileInputStream(filePath);

        Yaml yaml = new Yaml();


        Map<String,Object> fullData = yaml.load(ip);

        Map<String,Object> loginData =(Map<String,Object> ) fullData.get("login");

        for(Map.Entry<String,Object> realdata : loginData.entrySet()){

            System.out.println(realdata.getKey());
            Map<String,Object> data= (Map<String,Object>) realdata.getValue();


            String type= (String) data.get("type");

        }

        
        

    }

}
