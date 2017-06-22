package lesson10.abstractbigexample;

/**
 * Created by Kushn_000 on 20.04.2017.
 */
public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;

    private String currentPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionWorked = new String[10];

    public Employee(String name, int age, int salaryPerMonth) {
        this.name = name;
        this.age = age;
        this.salaryPerMonth = salaryPerMonth;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    abstract void paySalary();

    void changePosition(String newPosition){

        saveCurrentPositionToHistory();
        currentPosition = newPosition;
    }

    private void saveCurrentPositionToHistory(){
        int index = 0;
        for (String pos : positionWorked){
            if (pos == null){
                positionWorked[index] = currentPosition;
                break;
            }
            index++;
        }
    }

    int getBalance(){
        return bankAccount.getBalance();
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
