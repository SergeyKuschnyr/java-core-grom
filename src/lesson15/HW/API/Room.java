package lesson15.HW.API;

import java.util.Date;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class Room {
    private long id;
    private int price;
    private int persons;
    private Date dateAvailableFrom;
    private String hotelName;
    private String CityName;

    public Room(long id, int price, int persons, Date dateAvailableFrom, String hotelName, String cityName) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotelName = hotelName;
        CityName = cityName;
    }

    public Room(int price, int persons, String hotelName, String cityName) {
        this.price = price;
        this.persons = persons;
        this.hotelName = hotelName;
        CityName = cityName;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getPersons() {
        return persons;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!(price - 50 <= room.getPrice() && room.getPrice() <= price + 50)) return false;
        if (persons != room.persons) return false;
        if (!(hotelName == room.hotelName)) return false;
        return CityName == room.CityName;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + persons;
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + CityName.hashCode();
        return result;
    }
}
