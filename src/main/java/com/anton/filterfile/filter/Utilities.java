package com.anton.filterfile.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Utilities {

  public final static String REGEX_AIRPORT = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

  private static final Properties prop = new Properties();
  private static final InputStream inputStream = AirportFilter.class.getClassLoader().getResourceAsStream("application.yaml");

  public static String pathAirportFile() {
    try {
      prop.load(inputStream);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return prop.getProperty("filePath");
  }

  public static int defaultNumberOfColumn() {
    try {
      prop.load(inputStream);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return Integer.parseInt(prop.getProperty("defaultValue"));
  }

}
