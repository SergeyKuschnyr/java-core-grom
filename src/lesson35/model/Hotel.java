package lesson35.model;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class Hotel {
    private long id;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
