//Week 4 Activities - Control Flow II (Looping & Jump)

//Name: Otibar, John Carlo Q. 
//Section: DIT 2-7

//Activity 1: Number & Square Printer 

public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i + " | Square: " + (i * i));
        }
    }
}

//Results: 

/* Number: 1 | Square: 1
Number: 2 | Square: 4
Number: 3 | Square: 9
Number: 4 | Square: 16
Number: 5 | Square: 25
Number: 6 | Square: 36
Number: 7 | Square: 49
Number: 8 | Square: 64
Number: 9 | Square: 81
Number: 10 | Square: 100 
*/

//Activity 2: Sum Until Sentinel Value 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number;
        int total = 0;

        System.out.println("Enter integers to add (-1 to stop):");

        System.out.print("Enter a number: ");
        number = input.nextInt();

        while (number != -1) {
            total += number;

            System.out.print("Enter a number: ");
            number = input.nextInt();
        }

        System.out.println("Final total: " + total);

        input.close();
    }
}

//Results:
/* Enter integers to add (-1 to stop):
Enter a number: 10
Enter a number: 5
Enter a number: -3
Enter a number: 8
Enter a number: -1
Final total: 20
*/


//Activity 3: Patter Generator With Early Exit

public class  Main {
    public static void main(String[] args) {

        int size = 5;

        System.out.println("=== Pattern Generator ===");

        for (int row = 1; row <= size; row++) {

            for (int col = 1; col <= size; col++) {

               
                if (col == 3) {
                    continue;
                }

            
                if (col == 5) {
                    break;
                }

                System.out.print("* ");
            }

            System.out.println();
        }
    }
}

//Results:

/*
* * * 
* * * 
* * * 
* * * 
* * * 
*/


//Activity 4: Warehouse Inventory Scanner

import java.util.Scanner;

public class WarehouseInventoryScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] warehouse = {
            {25, 12, -1, 8},
            {5, 30, 3, 15},
            {20, -1, 7, 10}
        };

        int choice;

        do {
            System.out.println("\n=== Warehouse Inventory Scanner ===");
            System.out.println("1. Display Total Inventory");
            System.out.println("2. Find First Critically Low Shelf");
            System.out.println("3. Restock a Shelf");
            System.out.println("4. Exit");

            choice = readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int total = 0;

                    for (int row = 0; row < warehouse.length; row++) {
                        for (int col = 0; col < warehouse[row].length; col++) {
                            if (warehouse[row][col] == -1) {
                                continue;
                            }

                            total += warehouse[row][col];
                        }
                    }

                    System.out.println("Total inventory: " + total);
                    break;

                case 2:
                    int lowStockLimit = 6;
                    boolean found = false;

                    search:
                    for (int row = 0; row < warehouse.length; row++) {
                        for (int col = 0; col < warehouse[row].length; col++) {
                            int stock = warehouse[row][col];

                            if (stock == -1) {
                                continue;
                            }

                            if (stock <= lowStockLimit) {
                                System.out.println(
                                    "First critically low shelf found!"
                                );
                                System.out.println("Row: " + (row + 1));
                                System.out.println("Column: " + (col + 1));
                                System.out.println("Items remaining: " + stock);

                                found = true;
                                break search;
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("No critically low shelves found.");
                    }
                    break;

                case 3:
                    int row = readInt(input, "Enter row number: ") - 1;
                    int col = readInt(input, "Enter column number: ") - 1;

                    if (row < 0 || row >= warehouse.length ||
                        col < 0 || col >= warehouse[row].length) {
                        System.out.println("Invalid shelf location.");
                        break;
                    }

                    if (warehouse[row][col] == -1) {
                        System.out.println(
                            "This shelf is damaged and cannot be restocked."
                        );
                        break;
                    }

                    warehouse[row][col] = restock(
                        input, warehouse[row][col]
                    );

                    System.out.println(
                        "Restocking successful! New stock: "
                        + warehouse[row][col]
                    );
                    break;

                case 4:
                    System.out.println("Exiting inventory scanner...");
                    break;

                default:
                    System.out.println("Invalid choice. Select 1 to 4.");
            }

        } while (choice != 4);

        input.close();
    }

    public static int readInt(Scanner input, String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                input.next();
            }
        }
    }

    public static int restock(Scanner input, int currentStock) {
        int amount = 0;

        while (amount <= 0) {
            amount = readInt(input, "Enter quantity to add: ");

            if (amount <= 0) {
                System.out.println("Quantity must be greater than zero.");
            }
        }

        return currentStock + amount;
    }
}

//Results: 
/* 
=== Warehouse Inventory Scanner ===
1. Display Total Inventory
2. Find First Critically Low Shelf
3. Restock a Shelf
4. Exit
Enter your choice: 1
Total inventory: 155

*/







