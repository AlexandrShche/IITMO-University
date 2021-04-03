package main.worker;

public interface Address extends Comparable<Address>{
    String getStreet();
    String getZipCode();
    Location getTown();
    void setStreet(String street);
    void setZipCode(String zipCode);
    void setTown(Location town);
}
