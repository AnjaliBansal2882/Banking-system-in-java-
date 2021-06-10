import java.util.Scanner;
class Account
{
    String name;
    String type;
    String bank;
    int balance;
    int number;
    Account()
    {
        name = "NULL";
        type = "Savings";
        bank = "HDFC";
        balance = 0;
        number = 0;
    }
    Account(String name, String type, String bank, int balance, int number)
    {
        this.name = name;
        this.type = type;
        this.bank = bank;
        this.balance = balance;
        this.number = number;
    }
}
class User extends Account
{
    User(String name, String type, String bank, int balance, int number)
    {
        super(name,type,bank,balance,number);
    }
     void CreateAccount()
     {
        Scanner obj = new Scanner(System.in);
        System.out.println("Please enter your name : ");
        this.name = obj.nextLine();
        System.out.println("Please enter the type of bank account : ");
        this.type = obj.nextLine();
        System.out.println("Please enter initial balance amount : ");
        this.balance = obj.nextInt();
        this.number = (int)((Math.random()*1000)+9000);

        System.out.println("\t Your account number is: "+this.number);
        System.out.println("\t -------------Account created successfully------------");
        System.out.println("\t -----------Please remember your login details-----------");


     }
     void Deposit(int amt)
     {
        this.balance = this.balance + amt;
        System.out.println("\t New balance : "+this.balance);
        
        System.out.println("\t -----------Balance updated succcessfully----------");
     } 
     void Withdraw(int amt)
     {
        this.balance = this.balance-amt;
        System.out.println("\t New balance : "+this.balance);
        
        System.out.println("\t -----------Balance Withrawal succcessfull----------");
     } 
     void CheckBalance()
     {
        System.out.println("\t Current Balance: "+this.balance);
     }
     void Display()
     {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your account number : ");
        int n = sc.nextInt();
        if(this.number==n)
        {
            System.out.println("\t Name: "+this.name);
            System.out.println("\t Bank: "+this.bank);
            System.out.println("\t Account number: "+this.number);
            System.out.println("\t Type of account: "+this.type);
            System.out.println("\t Current Balance: "+this.balance);
        }
     }


}
class BankTest
{
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        Boolean quit = false;
        User u1 = new User("NULL","Savings","HDFC",0,0000);
        do
        {
            System.out.println();
            System.out.println();
            System.out.println("----------MENU----------");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check Current Balance");
            System.out.println("5. Display account details");
            System.out.println("6. Quit");
            System.out.println("Please enter your choice: ");
            int n = obj.nextInt();
            switch(n)
            {
                case 1: u1.CreateAccount();
                        break;
                case 2: {
                            System.out.println("Please enter you account number : ");
                            int a = obj.nextInt();
                            if(a==u1.number)
                            {
                                System.out.println("Please enter the amount to be deposited");
                                int amt = obj.nextInt();
                                u1.Deposit(amt);
                            }
                        }
                        break;
                case 3: {
                            System.out.println("Please enter you account number : ");
                            int b = obj.nextInt();
                            if(b == u1.number)
                            {
                                System.out.println("Please enter the amount to be withdrawn");
                                int amt = obj.nextInt();
                                u1.Withdraw(amt);
                            }   
                        }
                        break;
                case 4: {
                            System.out.println("Please enter your account number: ");
                            int c = obj.nextInt();
                            if(c == u1.number)
                            {
                                u1.CheckBalance();
                            }

                        }
                        break;
                case 5: u1.Display();
                        break;
                case 6: quit = true;
                        break;
                default: System.out.println("\t Invalid Choice");

            }
        }
        while(!quit);
        System.out.println("\t -----------Thankyou for visiting-------------");
    }
}