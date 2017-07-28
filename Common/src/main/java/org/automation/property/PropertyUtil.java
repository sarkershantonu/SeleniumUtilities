package org.automation.property;


import java.io.*;
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

    public void saveProperty(String nameOfPropertyFile, String nameOfProperty, String valueOfProperty) throws IOException {
        output = new FileOutputStream(new File(propertyRoot + nameOfPropertyFile).getAbsoluteFile(), true);//append mode

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

    public void loadPropertyFile(String propertyFileName) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream(new File(propertyRoot+propertyFileName)));
        for (String k : p.stringPropertyNames()) {
            System.setProperty(k, p.getProperty(k));
        }
    }
    public void loadPropertyWithAbsulatePath(String propertyFileName) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream(new File(propertyFileName)));
        for (String k : p.stringPropertyNames()) {
            System.setProperty(k, p.getProperty(k));
        }
    }
    /**
     * Loads all property entry under all property files under a specified path
     *
     * @param folderPath
     * @throws IOException
     */
    public void loadAllDefaultProperties(String folderPath) throws IOException {
        File[] propertyFiles = new File(folderPath).listFiles();
        for (File aPropertyFile : propertyFiles) {

            if (aPropertyFile.getName().endsWith(".properties")) {
                Properties p = new Properties();
                p.load(new FileInputStream(aPropertyFile));
                for (String k : p.stringPropertyNames()) {
                    System.setProperty(k, p.getProperty(k));
                }
            }

        }
    }

    public void loadAllDefaultProperties() throws IOException {
        loadAllDefaultProperties(propertyRoot);
    }

    /***
     * Use this incase you need to load from property path files
     * Specifically needed for environment properties
     * @throws IOException
     */
    public void loadUserProperties() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream(propertyRoot+"user.properties"));
        for (String k : p.stringPropertyNames()) {
           loadPropertyWithAbsulatePath(new File(p.getProperty(k)).getAbsolutePath());
        }
    }


}
