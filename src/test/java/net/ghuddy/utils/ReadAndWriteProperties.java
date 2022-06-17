package net.ghuddy.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadAndWriteProperties {
    private static String file = "src/test/resources/dynamicVariables.properties";
    private static long transactionId = Long.valueOf(ReadAndWriteProperties.getPropertyValue("transactionId"));

    public static String getPropertyValue(String propertyName) {
        Properties prop = new Properties();
        String value = "";
        try {
            InputStream input = new FileInputStream(file);
            // load a properties file
            prop.load(input);

            value = prop.getProperty(propertyName);
            // get the property value and print it out
            System.out.println("Get =: " + value);
            input.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ReadAndWriteProperties.writePropertyValue("transactionId", String.valueOf(transactionId));
        return value;
    }

    public static void writePropertyValue(String property, String value) {
        try {
            Parameters params = new Parameters();
            FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                            .configure(params.properties()
                                    .setFileName(file));
            Configuration config = builder.getConfiguration();
            config.setProperty(property, value);
            builder.save();

        } catch (ConfigurationException io) {
            io.printStackTrace();
        }
    }
}
