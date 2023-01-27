package message.config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

//
//хранит переменные для работы с конфигурационныйм файлом
//
interface InterfaceConfigValue {
    //значения из конфига записываем в массив
    Map <String,String> typeMessage=new HashMap<>();
    //путь к файлу конфигурации
    File pathConfigFile=new File(message.config.InterfaceConfigValue.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"config.properties");
    //void setTypeMessage();
    String getConfigValue(String key);
}
