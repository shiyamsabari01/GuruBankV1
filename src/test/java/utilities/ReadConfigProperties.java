package utilities;

import java.util.Properties;

public class ReadConfigProperties {
    public void loadProperties() {
        Properties properties=new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Constants.APP_URL= properties.getProperty("URL");
        Constants.USERNAME=properties.getProperty("username");
        Constants.PASSWORD= properties.getProperty("password");
        Constants.BROWSER= properties.getProperty("Browser");
    }
}
