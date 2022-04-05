package com.anton.filterfile.filter;

import static com.anton.filterfile.filter.Utilities.REGEX_AIRPORT;
import static com.anton.filterfile.filter.Utilities.pathAirportFile;

import com.anton.filterfile.pojo.Airport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AirportFilter extends Filter {

  @Override
  public Map<Long, String> iterableFileInMap(int numberOfColumn) {
    Map<Long, String> fieldMap = new LinkedHashMap<>();

    long pointer;

    try(RandomAccessFile randomAccessFile = new RandomAccessFile(pathAirportFile(), "r")) {

      String line;

      while (true) {
        pointer = randomAccessFile.getFilePointer();
        line = randomAccessFile.readLine();
        if (line == null) {
          break;
        }
        String[] fields = line.split(REGEX_AIRPORT, -1);
        fieldMap.put(pointer, fields[numberOfColumn - 1]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fieldMap;
  }

  @Override
  public List<Airport> filterOfColumn(Map<Long, String> map, String subStr, int numOfColumn)
      throws FileNotFoundException {
    RandomAccessFile randomAccessFile = new RandomAccessFile(pathAirportFile(), "r");

    return map
        .entrySet()
        .stream()
        .filter(line -> line.getValue().contains(subStr))
        .map(line -> {
          try {
            randomAccessFile.seek(line.getKey());
            return new Airport(randomAccessFile.readLine(), numOfColumn);
          } catch (IOException e) {
            System.out.println(e.getMessage());
          }
          return null;
        })
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

  }
}
