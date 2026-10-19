//Week 3 Activities - Control Flow I (Decision-Making)

//Name: Otibar, John Carlo Q. 
//Section: DIT 2-7

//Activity 1: Simple Grade Classifier

public class Main {
    public static void main(String[] args) {

        int score_1 = 75;
        int score_2 = 40;

        if (score_1 >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        if (score_2 >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }
}

//Results: 
//PASSED
//FAILED




//Activity 2: Multi-tier Discount System 

public class Main {
    public static void main(String[] args) {

        double purchaseAmount = 6000.00;
        double discountRate;
        String discountTier;

        if (purchaseAmount < 1000) {
            discountRate = 0.00;
            discountTier = "No Discount (0%)";
        } else if (purchaseAmount < 3000) {
            discountRate = 0.05;
            discountTier = "Bronze Tier (5%)";
        } else if (purchaseAmount < 5000) {
            discountRate = 0.10;
            discountTier = "Silver Tier (10%)";
        } else {
            discountRate = 0.15;
            discountTier = "Gold Tier (15%)";
        }

        double discountAmount = purchaseAmount * discountRate;
        double finalPrice = purchaseAmount - discountAmount;

        System.out.println("=== Multi-Tier Discount System ===");
        System.out.println("Purchase Amount: P" + purchaseAmount);
        System.out.println("Discount Tier: " + discountTier);
        System.out.println("Discount Amount: P" + discountAmount);
        System.out.println("Final Discounted Price: P" + finalPrice);
    }
}

//Results: 
/* === Multi-Tier Discount System === */
//Purchase Amount: P6000.0
//Discount Tier: Gold Tier (15%)
//Discount Amount: P900.0
//Final Discounted Price: P5100.0 




//Activity 3: User Login Validator

public class Main {
    public static void main(String[] args) {

        String username = "johncarloqiskolarngbayan@gmail.com";
        String password = "08012007";
        boolean accountLocked = false;

        String enteredUsername = "johncarloqiskolarngbayan@gmail.com";
        String enteredPassword = "08012007";

        System.out.println("=== Login Validator ===");

        if (enteredUsername.equals(username)) {
            System.out.println("Username is correct.");

            if (enteredPassword.equals(password)) {
                System.out.println("Password is correct.");

                if (!accountLocked) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Login failed: Account is locked.");
                }

            } else {
                System.out.println("Login failed: Incorrect password.");
            }

        } else {
            System.out.println("Login failed: Incorrect username.");
        }
    }
}

//Results:
// === Login Validator ===
//Username is correct.
//Password is correct.
//Login successful!


//Activity 4: ATMTransactionAuthorizer
public class Main {
    public static void main(String[] args) {

        String correctUsername = "johncarlo_07";
        String correctPin = "08012006";

        String enteredUsername = "student";
        String enteredPin = "08012007";

        double balance = 25000.00;
        double withdrawalAmount = 5000.00;

        double dailyWithdrawn = 2000.00;
        double dailyLimit;

        String tier;
        double feeRate = 0.0;
        double transactionFee = 0.0;
        double totalDeduction = 0.0;

        boolean approved = false;
        String reason = "";

        System.out.println("=== ATM Transaction Authorizer ===");

        if (enteredUsername.equals(correctUsername)) {
            if (enteredPin.length() == 4
                    && enteredPin.matches("[0-9]{4}")
                    && enteredPin.equals(correctPin)) {

                System.out.println("Login successful.");

                if (balance < 10000) {
                    tier = "Bronze";
                    dailyLimit = 5000;
                } else if (balance < 25000) {
                    tier = "Silver";
                    dailyLimit = 10000;
                } else if (balance < 50000) {
                    tier = "Gold";
                    dailyLimit = 20000;
                } else {
                    tier = "Platinum";
                    dailyLimit = 50000;
                }

                System.out.println("Account Tier: " + tier);
                System.out.println("Account Balance: ₱" + balance);
                System.out.println("Withdrawal Amount: ₱" + withdrawalAmount);

                switch (tier) {
                    case "Bronze":
                        feeRate = 0.02;
                        break;
                    case "Silver":
                        feeRate = 0.015;
                        break;
                    case "Gold":
                        feeRate = 0.01;
                        break;
                    case "Platinum":
                        feeRate = 0.005;
                        break;
                    default:
                        feeRate = 0.0;
                }

                transactionFee = withdrawalAmount * feeRate;
                totalDeduction = withdrawalAmount + transactionFee;

                System.out.println("Transaction Fee: ₱" + transactionFee);
                System.out.println("Daily Withdrawal Limit: ₱" + dailyLimit);

                if (withdrawalAmount > 0) {
                    if (withdrawalAmount + dailyWithdrawn <= dailyLimit) {
                        if (totalDeduction <= balance) {
                            approved = true;
                            reason = "Transaction meets all requirements.";
                        } else {
                            reason = "Insufficient balance to cover withdrawal and fee.";
                        }
                    } else {
                        reason = "Daily withdrawal limit exceeded.";
                    }
                } else {
                    reason = "Withdrawal amount must be greater than zero.";
                }

                if (approved) {
                    System.out.println("Transaction: APPROVED");
                    System.out.println("Amount Withdrawn: ₱" + withdrawalAmount);
                    System.out.println("Transaction Fee: ₱" + transactionFee);
                    System.out.println("Total Deduction: ₱" + totalDeduction);

                    balance -= totalDeduction;
                    System.out.println("Remaining Balance: ₱" + balance);
                } else {
                    System.out.println("Transaction: DENIED");
                    System.out.println("Reason: " + reason);
                }

            } else {
                System.out.println("Transaction: DENIED");
                System.out.println("Reason: Incorrect PIN or PIN must be exactly 4 digits.");
            }
        } else {
            System.out.println("Transaction: DENIED");
            System.out.println("Reason: Incorrect username.");
        }
    }
}


//Results: 
//=== ATM Transaction Authorizer ===
//Transaction: DENIED
//Reason: Incorrect username.



