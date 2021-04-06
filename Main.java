
public class Main {
    public static void main(String[] args) {

        /** Testing Code/Validation
        // First: add bank object
        // second: add (new) Customer with initial opening amount to the first bank object.
        // Third: add another bank object (another new bank to the Branch ArrayList)
        // Fourth: add (new) Customer with initial opening amount to the second bank object
         Fifth: add a transaction to an already existing customer with an existing branch*/

        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 150.54);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);

        /**Debugging/Validation
         * checking to see if a bank that does exist/was not added to the Branch Array does NOT exist*/
        if(!bank.addCustomer("Melbourne", "Brian", 5.53)){
            System.out.println("The Branch Melbourne and Customer does NOT exist!");
        }
        //testing to see if a branch already exist
        if(!bank.addBranch("Adelaide")){
            System.out.println("The branch Adelaide already exist!");
        }
        //testing for a non-existing customer
        if(!bank.addCustomerTransaction("Adelaide", "Jim", 5.55)){
            System.out.println("Customer Jim does NOT exist");
        }


    }

}
