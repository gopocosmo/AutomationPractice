package PropertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyFile {
    public FileInputStream fileInputStream;
    public Properties properties;

    //in constructor incarcam fisierul de la o anumita locatie
    public PropertyFile(String path){
        loadFile(path);
    }

    //metoda care incarca fisierul
    public void loadFile(String path){
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/test/resources/" + path + ".properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metoda care returneaza o valoare pe baza a unei chei
    public String getValue(String key){
        return properties.getProperty(key);
    }

    //metoda care returneaza toate valorile + cheile dintr-un fisier
    public HashMap<String, String> getAllValues(){
        HashMap<String, String> values = new HashMap<>();
        for (Object key: properties.keySet()) {
            values.put(key.toString(), properties.getProperty(key.toString()));
        }
        return values;
    }
}
