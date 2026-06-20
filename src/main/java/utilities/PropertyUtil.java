package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static Properties property;
    public static String fetchProperty(String key) throws IOException {
        property=new Properties();
        FileInputStream file =new FileInputStream("config.properties");
        property.load(file);
        return property.get(key).toString();

    }
}

/* using getproperty
public String getReportConfigPath(){
    String reportConfigPath = property.getProperty("reportConfigPath");
    if(reportConfigPath!= null)
        return reportConfigPath;
    else
        throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
}
 */