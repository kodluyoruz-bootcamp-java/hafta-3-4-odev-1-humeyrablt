package CityCodeMap.Cities;

import CityCodeMap.İnterfaces.Clock;

import java.text.SimpleDateFormat;

import java.util.*;

public class City implements Comparable,  Clock {

    private String name;
    private String gmt;
    private String code;

    public City(String name, String gmt, String code) {
        this.name = name;
        this.gmt = gmt;
        this.code = code;
    }

    public City(String name, String gmt) {
        this.name = name;
        this.gmt = gmt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gmt);
    }

    @Override
    public String toString() {
        return "" +
                "City='" + name + '\'' +
                ", gmt='" + gmt + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object object) {

        City city = (City)object;

        return this.name.compareTo(city.name);

    }

    @Override
    public void showTime() {
        SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
        f.setTimeZone(TimeZone.getTimeZone(":"));
        System.out.println(f.format(GregorianCalendar.getInstance().getTime()));

    }

}
