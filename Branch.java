import java.util.ArrayList;

public class Branch{
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }
    public String getName() {

        return name;
    }
    public ArrayList<Customer> getCustomers() {

        return customers;
    }
    //findCustomer() when called goes thru the ArrayList<Customer>, first return the index get(i) for customer.get(i).
    //a local ArrayList<Customer> is created for a local ArrayList Object(existingCustomer) to hold the index for each iteration of the loop
    // this.customers.get(i) gets the index from the ArrayList<Customer> and assign it to existingCustomer.
    // the variable object.getName() is then compared to the name passed into the findCustomer() Method and return the variable object if FOUND.
    private Customer findCustomer(String customerName){
        for(int i=0; i<customers.size(); i+=1){
            Customer existingCustomer = this.customers.get(i);
            if(existingCustomer.getName().equals(customerName)){
                return existingCustomer;
            }
        }
        return null;
    }
    // testing if the newCustomer exist first. (b/c we are working in the branch class with ArrayList<Customer>
    // use findCustomer() Method to add to the local ArrayList Customer Variable "newCustomer."
    // if the newCustomer exist..
    // return statement: this specific customer (this.customer) by  adding the (new) Customer transaction with name and amount to the existing branch.
    public boolean newCustomer(String customerName, double transactions){
        Customer newCustomer = findCustomer(customerName);
        if(newCustomer == null){
            this.customers.add(new Customer(customerName,transactions));
            return true;
        }
        return false;
    }
    // testing if the customer exist first (test variable:existingCustomer).(b/c we are working in the bank class with ArrayList<Customer>
    // use findCustomer() Method to add to the local ArrayList Customer Variable "existingBranch."
    // if the branch exist, a new customer with name and initial amount will be added to the branch(ArrayList<Customer>
    // return statement has existing customer plus new Customer (constructor, with name and initial amount)
    public boolean addCustomerTransaction(String customerName, double transaction){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(transaction);
            return true;
        }
        return false;
    }

}
