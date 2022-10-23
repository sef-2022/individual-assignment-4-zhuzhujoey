package model;


/**
 * Class to hold information about a customer
 */
public class Customer {

    private final String name;
    private final int clientID;
    private Franchise fID;
    private int numberOfServices = -1;

    /**
     * Create a new customer object.
     *
     * @param name:      Name of the customer
     * @param clientID:  Unique id of the customer.
     * @param fID: Franchise that the customer belongs to.
     */
    public Customer(String name, int clientID, Franchise fID) {
        this.name = name;
        this.clientID = clientID;
        this.fID = fID;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return clientID;
    }

    public Franchise getFranchise() {
        return fID;
    }

    public void setFranchise(Franchise fID) {
        this.fID = fID;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public void setNumberOfServices(int numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

}
