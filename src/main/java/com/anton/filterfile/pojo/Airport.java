package com.anton.filterfile.pojo;

import static com.anton.filterfile.filter.Utilities.REGEX_AIRPORT;

public class Airport implements Comparable<Airport> {

  private final int numOfColumn;

  private final Integer id;
  private final String name;
  private final String region;
  private final String country;
  private final String iataCode;
  private final String icaoCode;
  private final Double latitude;
  private final Double longitude;
  private final Integer height;
  private final String gmt;
  private final Character code;
  private final String timeZone;
  private final String airportField;
  private final String ourAirportsField;

  public Airport(String line, int numOfColumn) {
    String[] fields = line.split(REGEX_AIRPORT, -1);

    this.id = Integer.parseInt(fields[0]);
    this.name = fields[1];
    this.region = fields[2];
    this.country = fields[3];
    this.iataCode = fields[4];
    this.icaoCode = fields[5];
    this.latitude = Double.parseDouble(fields[6]);
    this.longitude = Double.parseDouble(fields[7]);
    this.height = Integer.parseInt(fields[8]);
    this.gmt = fields[9];
    this.code = fields[10].charAt(1);
    this.timeZone = fields[11];
    this.airportField = fields[12];
    this.ourAirportsField = fields[13];
    this.numOfColumn = numOfColumn;

  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getRegion() {
    return region;
  }

  public String getCountry() {
    return country;
  }

  public String getIataCode() {
    return iataCode;
  }

  public String getIcaoCode() {
    return icaoCode;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Integer getHeight() {
    return height;
  }

  public String getGmt() {
    return gmt;
  }

  public Character getCode() {
    return code;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public String getAirportField() {
    return airportField;
  }

  public String getOurAirportsField() {
    return ourAirportsField;
  }


  @Override
  public String toString() {
    return
        id + ", " + name + ", " + region + ", " + country + ", " + iataCode + ", " + icaoCode + ", "
            + latitude + ", " + longitude + ", " + height + ", " + gmt + ", " + code + ", "
            + timeZone + ", " + airportField + ", " + ourAirportsField;
  }

  @Override
  public int compareTo(Airport airport) {
    switch (numOfColumn + 1) {
      case 1:
        return airport.id.compareTo(id);
      case 2:
        return airport.name.compareTo(name);
      case 3:
        return airport.region.compareTo(region);
      case 4:
        return airport.country.compareTo(country);
      case 5:
        return airport.iataCode.compareTo(iataCode);
      case 6:
        return airport.icaoCode.compareTo(icaoCode);
      case 7:
        return airport.latitude.compareTo(latitude);
      case 8:
        return airport.longitude.compareTo(longitude);
      case 9:
        return airport.height.compareTo(height);
      case 10:
        return airport.gmt.compareTo(gmt);
      case 11:
        return airport.code.compareTo(code);
      case 12:
        return airport.timeZone.compareTo(timeZone);
      case 13:
        return airport.airportField.compareTo(airportField);
      case 14:
        return airport.ourAirportsField.compareTo(ourAirportsField);
      default:
        return 0;
    }
  }
}
