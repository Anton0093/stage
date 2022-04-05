package com.anton.filterfile.filter;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public abstract class Filter {

  public abstract Map<Long, String> iterableFileInMap(int numberOfColumn);

  public abstract List<?> filterOfColumn(Map<Long, String> map, String subStr, int numOfColumn)
      throws FileNotFoundException;

}
