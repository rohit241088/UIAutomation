package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PropertyHelper {
    private Properties properties=null;

    public PropertyHelper(String propertyPath){
        FileInputStream in= null;
        try {
            in = new FileInputStream(propertyPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties=new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean ifKeyExist(String key){
        Iterator<Object> keys=this.properties.keySet().iterator();
        while(keys.hasNext()){
            String currentKey=keys.next().toString();
            if(key.toLowerCase().compareTo(currentKey.toLowerCase())==0){
                return true;
            }
        }
        return false;
    }

    public Object getKeyValue(String key) {
        if (this.ifKeyExist(key)) {
         return this.properties.get(key);
        }
        return null;
    }

    public Object returnUpdatedObjectValue(String key, String regex,int index){
       Object value=this.getKeyValue(key);
      if(value!=null){
        value= ((String)value).split(regex)[index];
      }
return (Object)value;
    }




}
