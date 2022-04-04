import static com.anton.filterfile.filter.Utilities.defaultNumberOfColumn;
import static com.anton.filterfile.filter.Utilities.pathAirportFile;

import com.anton.filterfile.filter.AirportFilter;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int numOfColumn = args.length == 0 ?  defaultNumberOfColumn() : Integer.parseInt(args[0]);

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите строку: ");
    String subStr = scanner.nextLine();
    scanner.close();

    AirportFilter airportFilter = new AirportFilter();
    Map<Long, String> map = airportFilter.iterableFileInMap(numOfColumn);
    System.out.println(pathAirportFile());

    long first = System.currentTimeMillis();
    try {
      airportFilter.filterOfColumn(map, subStr, numOfColumn).forEach(System.out::println);
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    long end = System.currentTimeMillis() - first;

    System.out.println("Количество найденных строк: " + map.size() + ". "
        + "Время, затраченное на поиск: " + end + "мс.");
  }
}
