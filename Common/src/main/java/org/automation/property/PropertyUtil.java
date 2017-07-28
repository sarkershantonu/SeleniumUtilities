package org.automation.property;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertyUtil {

    private Properties prop;
    private String propertyRoot;
    private OutputStream output = null;
    private InputStream input = null;

    private PropertyUtil() {
        prop = new Properties();
    }

    public PropertyUtil(String propertyFolder) {
        this();
        this.propertyRoot = propertyFolder + JavaProperties.FILE_SEPERATOR;
    }

    public void setProperty(String nameOfPropertyFile, String nameOfProperty, String valueOfProperty) throws IOException {
        output = new FileOutputStream(new File(propertyRoot+nameOfPropertyFile).getAbsoluteFile(), true);//append mode

        if (getProperty(nameOfPropertyFile, nameOfProperty) != null) {
            prop.setProperty(nameOfProperty, valueOfProperty);
            prop.store(output, "Added at " + System.currentTimeMillis());
        } else {
        }
        output.close();
    }

    public String read(String propertyFileName, String name) throws IOException {
        prop = read(propertyFileName);
        return prop.getProperty(name);
    }

    public Properties read(String propertyFileName) throws IOException {
        prop = new Properties();
        InputStream input = new FileInputStream(propertyRoot + propertyFileName);
        prop.load(input);
        input.close();
        return prop;
    }

    public String getProperty(String nameOfPropertyFile, String nameOfProperty) throws IOException {
        input = new FileInputStream(nameOfPropertyFile);
        //if you need to load from class loaders -> Aulternate way
        //InputStream its = this.getClass().getClassLoader().getResourceAsStream(nameOfPropertyFile);
        if (input != null) {
            prop.load(input);
            input.close();
        } else {
            throw new FileNotFoundException(nameOfPropertyFile + " Not Found");
        }
        return prop.getProperty(nameOfProperty);
    }

    /**
     * Loads all property entry under all property files under a specified path
     *
     * @param folderPath
     * @throws IOException
     */
    public void loadAllPropertyFromFolder(String folderPath) throws IOException {
        File[] propertyFiles = new File(folderPath).listFiles();
        for (File aProperty : propertyFiles) {
            Properties p = new Properties();
            p.load(new FileInputStream(aProperty));
            for (String k : p.stringPropertyNames()) {
                System.setProperty(k, p.getProperty(k));
            }
        }
    }
    public void loadAllPropertyFromFolder() throws IOException {
        loadAllPropertyFromFolder(propertyRoot);
    }
}
