package home;

public class FamilyBankbook {

    protected static int bankbook = 10000;

    protected void deposit(int money){
        bankbook += money;
    }

    protected void withdraw(int money){
        bankbook -= money;
    }
}
