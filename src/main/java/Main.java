import static com.anton.filterfile.filter.Utilities.getNumberOfColumn;

import com.anton.filterfile.filter.AirportFilter;
import com.anton.filterfile.pojo.Airport;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    int numOfColumn = getNumberOfColumn(args);

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите строку: ");
    String subStr = scanner.nextLine();
    scanner.close();

    AirportFilter airportFilter = new AirportFilter();
    Map<Long, String> map = airportFilter.iterableFileInMap(numOfColumn);

    long first = System.currentTimeMillis();
    List<Airport> filterOfColumnList = new ArrayList<>();

    try {
      filterOfColumnList = airportFilter.filterOfColumn(map, subStr, numOfColumn);
      filterOfColumnList.forEach(System.out::println);
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    long end = System.currentTimeMillis() - first;

    System.out.println("Количество найденных строк: " + filterOfColumnList.size() + ". "
        + "Время, затраченное на поиск: " + end + "мс.");
  }
}
