package com.anton.filterfile.filter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Utilities {

  public final static String REGEX_AIRPORT = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

  private static final Properties PROPERTIES = new Properties();
  private static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();
  private static final InputStream INPUT_STREAM = CLASS_LOADER.getResourceAsStream(
      "application.yaml");
  private static final File JAR_FILE = new File(
      Utilities.class.getProtectionDomain().getCodeSource().getLocation().getPath());

  public static String pathAirportFile() {
    try {
      PROPERTIES.load(INPUT_STREAM);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    File fileAirports;
    if (JAR_FILE.isFile()) {
      fileAirports = new File("StageTask/" + PROPERTIES.getProperty("filePath"));
    } else {
      fileAirports = new File(PROPERTIES.getProperty("filePath"));
    }

    return fileAirports.getAbsolutePath();
  }

  public static int defaultNumberOfColumn() {
    try {
      PROPERTIES.load(INPUT_STREAM);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return Integer.parseInt(PROPERTIES.getProperty("defaultValue"));
  }

}
