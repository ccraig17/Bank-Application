import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    //ArrayList<Branch> initialised in the Constructor
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    // in order to add a Branch...the findBranch() Method is called
    // an if-Statement is used to test if the branch was found against null;
    // MEANING if the branchName is NOT FOUND, the branchName is added (via the Bank Constructor) to the ArrayLis<Branch>.
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
    //findBranch() when called goes thru the ArrayList<Branch>, first return the index get(i) for branches.get(i).
    //a local ArrayList<Branch> is created for a local ArrayList Object to hold the index for each iteration of the loop
    // the variable object.getName() is then compared to the name passed into the findBranch() Method and return the variable object if FOUND.
    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i += 1) {
            Branch existingBranch = this.branches.get(i);
            if (existingBranch.getName().equals(branchName)) {
                return existingBranch;
            }
        }
        return null;
    }
    // testing if the branch exist first.(b/c we are working in the bank class with ArrayList<Branch>
    // use findBranch() Method to add to the local ArrayList Branch Variable "existingBranch."
    // if the branch exist, a new customer with name and initial amount will be added to the branch(ArrayList<Branch>
    // return statement has existing branch plus new Customer (constructor, with name and initial amount)
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.newCustomer(customerName, initialAmount);
            //return true;
        }
        return false;
    }
    // testing if the branch exist first. (b/c we are working in the bank class with ArrayList<Branch>
    // use findBranch() Method to add to the local ArrayList Branch Variable "existingBranch."
    // if the existingBranch exist..
    // return statement: we can now add a Customer transaction with name and amount to the existing branch.
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.addCustomerTransaction(customerName, amount);
            //return true;
        }
        return false;
    }
    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            //branch.getCustomers() gives the ArrayList of Customers for that branch and assign the testing variable "branchCustomers."
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            //for each iteration of the loop ArrayList index in stored in branchCustomers.get(i)
            for (int i = 0; i < branchCustomers.size(); i += 1) {
                Customer branchCustomer = branchCustomers.get(i);
                // branchCustomer.getName() is used to get the name of the Customer at that index and printout along with its position +1 (to list out starting at 1).
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    //local ArrayList variable (customerTransactions) created to store the ArrayList of Transactions for that branchCustomer (branchCustomer.getTransaction()).
                    ArrayList<Double> customerTransactions = branchCustomer.getTransactions();
                    for (int j = 0; j < customerTransactions.size(); j += 1) {
                        System.out.println("[" + (j + 1) + "]  Amount " + customerTransactions.get(j));
                    }
                }

            }
            return true;
        }else{
            return false;
        }
    }
}


