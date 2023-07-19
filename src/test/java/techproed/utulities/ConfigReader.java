package techproed.utulities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
        .properties uzantili dosyaya erişebilmek için Properties class'ından obje oluşturmamız gerekir.
     bu oluşturduğumuz obje ile akışa aldığımız dosya yolunu properties.load(fis) methodu ile properties
     dosyasındaki bilgileri objemize yükler ve properties dosyasındaki key değerini return ederiz.

     Bunu yapmak için parametreli bir method oluşturur girdiğimiz key'in değerini bize döndürür
     */

    static Properties properties;
    static{
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fis);//--fis`in okudugu bilgileri properties`e yukler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty (String key){

        return properties.getProperty(key);//String olarak girdigim key`in degerini return eder
    }

}
