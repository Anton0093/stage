package com.anton.filterfile.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class Filter {

  public abstract Map<Long, String> iterableFileInMap(int numberOfColumn) throws IOException;

  public abstract List<?> filterOfColumn(Map<Long, String> map, String subStr, int numOfColumn)
      throws IOException;

}
