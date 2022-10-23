package model;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Implement and test {Service.addCustomerToService } that respects the following:
 *
 *  <ul>
 *
 *      <li> Get the number of services a customer is currently using </li>
 *      <li> A customer cannot hold more than 3 services</li>
 *      <li> Throws an exception if a customer is already using the same service</li>
 *      <li> Get the number of customers associated with the service offered by a franchise</li>
 *      <li> A service offered by a franchise cannot have more than 500 customers. </li>
 *      <li> If this limit is reached for a franchise, then customer is not added to the service</li>
 *  </ul>
 * <p>
 * NOTE: You are expected to verify that the constraints to add a new customer to a service are met.
 * <p>
 * Each test criteria must be in an independent test method .
 * <p>
 * Initialize the test object with setUp method.
 */
public class AddCustomerToService {

    List<Service> serviceList = new ArrayList<>();
    List<Customer> customerList = new ArrayList<>();
    final int MAX_SERVICE = 3;
    final int MAX_CUSTOMER = 500;

    @BeforeEach
    @DisplayName("SetUp")
    void setUp() {

        for (int i = 0; i < MAX_SERVICE; i++) {
            Service service = new Service("Service" + i, i);
            service.setFranchise(new Franchise());
            serviceList.add(service); //to set up the service list
        }

        for (int i = 0; i < MAX_CUSTOMER; i++) {
            Customer customer = new Customer("Customer" + i, i, new Franchise());
            customerList.add(customer); // to set up the customer list
        }

        for (int i = 0; i < MAX_SERVICE; i++) {
            for (int j = 0; j < MAX_CUSTOMER; j++) {
                Random random = new Random();
                int index = random.nextInt(MAX_SERVICE);
                Service service = serviceList.get(index);
                Customer customer = customerList.get(j);
                service.addCustomerToService(customer, service.getFranchise());
                // to add the customer to the service
            }
        }
    }

    @RepeatedTest(value = 500, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Get the number of services a customer is currently using and less than 3")
    void int_getNumberOfService(RepetitionInfo repetitionInfo) {
        int index1 = repetitionInfo.getCurrentRepetition() - 1;
        assertTrue(customerList.get(index1).getNumberOfServices() < MAX_SERVICE);
        // to check if the number of services a customer is currently using is less than 3
    }

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Get the number of customers with the service and less than 500")
    void int_getNumberOfCustomers(RepetitionInfo repetitionInfo) {
        int index = repetitionInfo.getCurrentRepetition() - 1;
        assertTrue(serviceList.get(index).getCustomer().size() < MAX_CUSTOMER);
        // to check if the number of customers with the service is less than 500
    }
}