package message.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//
//подключаю интерфейс с переменными
//
public class ConfigValue implements InterfaceConfigValue{

    public ConfigValue(){
        try{
            //проверяю существование файла конфигураций
            if(pathConfigFile.exists()){
                //читаю свойства из файла и присваю значения массиву
                FileInputStream fileStream=new FileInputStream(pathConfigFile);
                try{
                    Properties properties=new Properties();
                    properties.load(fileStream);
                    typeMessage.put("in",properties.getProperty("in"));
                    typeMessage.put("out",properties.getProperty("out"));
                    typeMessage.put("archiveIn",properties.getProperty("archiveIn"));
                    typeMessage.put("archiveOut",properties.getProperty("archiveOut"));
                }catch(IOException ex){
                }finally{
                    fileStream.close();
                }
            }
            else{
            }
        }
        catch(FileNotFoundException ex){
        }
        catch(IOException ex){
        }
        catch(Exception ex){
        }
    }
    //
    //Переопределяю метод для получения значения из массива
    //
    @Override
    public String getConfigValue(String key){
        return typeMessage.get(key);
    }
}
