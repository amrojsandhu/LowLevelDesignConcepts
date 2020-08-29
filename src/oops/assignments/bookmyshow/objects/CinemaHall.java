package oops.assignments.bookmyshow.objects;

public class CinemaHall {

    private String id;
    private String city;
    private String address;

    public CinemaHall(String id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
