package com.anton.filterfile.filter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utilities {

  public final static String REGEX_AIRPORT = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
  private final static String REGEX_NUMBERS = "[0-9]+";

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

  public static int getNumberOfColumn(String[] args) throws NumberFormatException {
    int numOfColumn = 0;

    try {
      if (args.length == 0) {
        numOfColumn = defaultNumberOfColumn();
      } else {
        if (onlyDigits(args[0])) {
          numOfColumn = Integer.parseInt(args[0]);
        } else {
          throw new NumberFormatException(
              "Столбец не является числом, устанавливается значение по умолчанию (2)");
        }
      }

      if (numOfColumn < 1 || numOfColumn > 14) {
        throw new NumberFormatException(
            "Диапазон столбца не от 1 до 14, устанавливается значение по умолчанию (2)");
      }

    } catch (NumberFormatException formatException) {
      numOfColumn = defaultNumberOfColumn();
      System.out.println(formatException.getMessage());
    }

    return numOfColumn;
  }

  private static boolean onlyDigits(String str) {
    Pattern p = Pattern.compile(REGEX_NUMBERS);
    Matcher m = p.matcher(str);

    return m.matches();
  }

}
