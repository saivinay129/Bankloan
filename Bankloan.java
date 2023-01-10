import java.util.Scanner;

public class BankManager {
    private String accno;
    private String name;
    private long phoneNo;
    protected long balance;
    protected final int K = 15000;
    protected final int Z = 25000;
    int visted =0;
    int vistedloan = 0;
    
    String R = "yes";
    String V = "no";

    public void openAccount() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 16 digit's Account No: ");
        accno = s.nextLine();

        System.out.println("enter the name");
        name = s.nextLine();

        System.out.println("enter your 10 digit's phone no");
        phoneNo = s.nextLong();

        System.out.println("Enter Balance: ");
        balance = s.nextLong();

    }

    public void showAccount() {
        System.out.println("----------Your account detials-------------");
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Phone number of account holder:" + phoneNo);
        System.out.println("Balance: Rs  " + balance);
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) throws Exception {

        String V = "no";
        String eXit;
        BankManager obj = new BankManager();
        obj.openAccount();
        obj.showAccount();

        do {
            System.out.println("There is an upgrade offer for regular users to upgrade their account to premium");
            System.out.println("---------------------------------------------");
            int access;
            Scanner P = new Scanner(System.in);
            System.out.print("enter 1 for upgrade your account to premium  2 for withdrawl 3 for deposit :: ");
            access = P.nextInt();
            System.out.println("---------------------------------------------");

            switch (access) {
                case 1: {

                    UpgradePremium d;
                    d = new UpgradePremium();
                   
                    d.loanBalance = obj.balance;
                    d.visted = obj.visted;
                    d.vistedloan = obj.vistedloan;
                    
                    d.upgradePremium();

                    d.loan();
                    obj.balance = d.loanBalance;
                    
                    obj.visted = d.visted;
                    obj.vistedloan = d.vistedloan;
                    break;
                }

                case 2: {

                    withdrawl g;
                    g = new withdrawl();
                    g.withdrawBalance = obj.balance;

                    g.withDrawl();
                    g.display();
                    obj.balance = g.withdrawBalance;
                    break;
                }

                case 3: {

                    Deposit f;
                    f = new Deposit();
                    f.depositBalance = obj.balance;
                    f.deposit();
                    f.display();
                    obj.balance = f.depositBalance;
                    break;
                }
                default :{
                    System.out.println("Invalid");
                }
            }
            Scanner M = new Scanner(System.in);
            System.out.println("Do you want Exit : (type yes/no)");
            eXit = M.nextLine();
            System.out.println("---------------------------------------------");

        } while (eXit.equals(V));

    }

}
    
class withdrawl extends BankManager {
    private long amt;
    long withdrawBalance;

    public void withDrawl() {

        System.out.println("your Total balance : RS " + withdrawBalance);
        Scanner A = new Scanner(System.in);
        System.out.print("Enter the amount you want to withdraw: ");
        amt = A.nextLong();
        System.out.println("---------------------------------------------");
        if (withdrawBalance >= amt) {
            withdrawBalance -= amt;
            System.out.println("Balance after withdrawal : RS " + withdrawBalance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    public void display() {
        System.out.println("---------------------------------------------");
        System.out.println("Total amount after withdrawl is RS " + withdrawBalance);

    }

}

class UpgradePremium extends BankManager {

    String F;
    long loanBalance;
    

    public void upgradePremium() {
        System.out.println("your Total balance : RS " + loanBalance);
        Scanner U = new Scanner(System.in);
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        System.out.println(
                "NOTE::By upgrade your account to premium,Premium users can get a loan upto total 25000.AND further there many programs and loans will be given to premium users");
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        if (visted == 0) {
            System.out.println("Do you want to upgrade your account to premium: (type yes/no)");
            F = U.nextLine();

            if (F.equals(R)) {
                System.out.println("---------------------------------------------");
                System.out.println("Congratulations for  upgrade your account to premium");
                visted = 1;

            } else {
                System.out.println("---------------------------------------------");
                System.out.println("Thank you for visting");
            }
        } else {
            System.out.println("You already upgrade to premium");
        }
    }

    public void loan() {
        Scanner Y = new Scanner(System.in);
        String L;
        if (vistedloan == 0) {
            System.out.println("---------------------------------------------");
            System.out.println("Do you want take loan : (type yes/no) ");
            L = Y.nextLine();
            System.out.println("---------------------------------------------");
            if (L.equals(R) && (visted==1 && vistedloan==0)) {
                System.out.println("the loanWithPremium amount is " + Z);
                loanBalance += Z;
                System.out.println("Total balance after adding loan with premium amount :: RS " + loanBalance);
                System.out.println("---------------------------------------------");
                vistedloan = 1;

            } else if (L.equals(R) && (visted==0 && vistedloan==0)) {
                System.out.println("the loanWithOutPremium amount is Rs." + K);
                loanBalance += K;
                System.out.println("Total balance after adding loan without premium amount :: RS " + loanBalance);
                System.out.println("---------------------------------------------");
                vistedloan = 1;
            } else {
                System.out.println("---------------------------------------------");
                System.out.println("Thank you for visting");
            }
        } else {
            System.out.println("You already taken loan");
        }

    }

}

class Deposit extends BankManager {
    private long amt;
    long depositBalance;

    public void deposit() {
        System.out.println("your Total balance : RS " + depositBalance);
        Scanner V = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit: ");
        amt = V.nextLong();
        System.out.println("---------------------------------------------");
        depositBalance += amt;
    }

    public void display() {
        System.out.println("Total amount after deposit is RS " + depositBalance);
        System.out.println("---------------------------------------------");

    }
    
}
