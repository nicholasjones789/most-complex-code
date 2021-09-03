import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Lab14 {
    static boolean num1 = false;
    static boolean num2 = false;
    static boolean num3 = false;
    static boolean num4 = false;
    static boolean num5 = false;
    static Scanner keyboardReader = new Scanner(System.in);
    static ArrayList<Customer> list = new ArrayList<Customer>();
    static ArrayList<Customer> og = new ArrayList<Customer>();
    static int j = 0;
    static int o = 0;

    public static void main(String[] args) {
        choices(mainMenu());
    } // end main
    
    /**
     * This method displays the main menu.
     * @return the user chosen option between 1-6
     */

    public static int mainMenu() {
        System.out.printf("1. Load from a file");
        System.out.printf("%n2. Print the loaded list");
        System.out.printf("%n3. Sort the list based on the nicknames");
        System.out.printf("%n4. sort the list based on the ids");
        System.out.printf("%n5. Print the sorted list");
        System.out.printf("%n6. Exit");
        System.out.printf("%nEnter a number[1-6]: ");
        int displayNum = keyboardReader.nextInt();
        return displayNum;
    } // end mainMenu

    /**
     * This method goes through all the options that the user has available.
     * @param option the chosen input of the user
     */

    public static void choices(int option) {
        try {   
            while (num1 == false) {
                if (option == 1) {
                    System.out.printf("%nEnter the name of the file: ");
                    Scanner fileReader =  new Scanner(new 
                        File(keyboardReader.next()));
                    System.out.printf("Loading from the file is done!%n");
                    System.out.println();
                    int i = 0;
                    while (fileReader.hasNext()) {
                        Customer customers = new Customer(fileReader.next(),
                            fileReader.nextInt());
                        list.add(i, customers);
                        og.add(i, customers);
                        fileReader.nextLine();
                        i++;
                    }
                    num1 = true;
                    choices(mainMenu());
                } 
                if (option == 2 || option == 3 || option == 4 || option == 5) {
                    System.out.printf("No data has been loaded yet!%n");
                    System.out.println();
                    choices(mainMenu());
                }
                if (option == 6) {
                    System.out.printf("End!%n");
                    System.exit(0);
                }
            }
            if (option == 1) {
                System.out.printf("%nEnter the name of the file: ");
                Scanner fileReader =  new Scanner(new 
                    File(keyboardReader.next()));
                System.out.printf("Loading from the file is done!%n");
                System.out.println();
                int i = 0;
                while (fileReader.hasNext()) {
                    Customer customers = new Customer(fileReader.next(),
                        fileReader.nextInt());
                    list.add(i, customers);
                    og.add(i, customers);
                    fileReader.nextLine();
                    i++;
                }
                System.out.println();
                choices(mainMenu());
            }
            if (option == 2) {
                System.out.printf("%n**** Printing the list ****%n");
                o = 0;
                printOriginal(og);
                System.out.println();
                choices(mainMenu());
            }
            while (num3 == false && num4 == false) {
                if (option == 3) {
                    sort1(list);
                    System.out.printf("Sorting is done!%n");
                    System.out.println();
                    num3 = true;
                    choices(mainMenu());
                }
                if (option == 4) {
                    sort2(list);
                    System.out.printf("Sorting is done!%n");
                    System.out.println();
                    num4 = true;
                    choices(mainMenu());
                }
                if (option == 5) {
                    System.out.printf("Nothing is sorted yet!%n");
                    System.out.println();
                    choices(mainMenu());
                }
                if (option == 6) {
                    System.out.printf("End!%n");
                    System.exit(0);
                }
            }
             
            if (option == 3) {
                sort1(list);
                System.out.printf("Sorting is done!%n");
                choices(mainMenu());
            }
            if (option == 4) {
                sort2(list);
                System.out.printf("Sorting is done!%n");
                choices(mainMenu());
            }
            if (option == 5) {
                j = 0;
                printTen(list);
            }
            if (option == 6) {
                System.out.printf("End!%n");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    } // end choices

    /**
     * This method prints the first 10 elements of the array.
     * @param arr an ArrayList of Customer objects
     */

    public static void printTen(ArrayList<Customer> arr) {
        for (int i = 1; i <= 10 && j < arr.size(); i++) {
            System.out.printf("%d. %s%n", j + 1, arr.get(j).toString());
            j++;
        }
        System.out.printf("Enter something to continue/enter s "
            + "to stop: ");
        String yesNo = keyboardReader.next();
        if (yesNo.equals("s")) {
            choices(mainMenu());
        } else {
            printTen(arr);
        }
    } // end printTen

    /**
     * This method prints 10 elements of the original array list.
     * @param og an ArrayList of Customer objects
     */

    public static void printOriginal(ArrayList<Customer> og) {
        for (int i = 1; i <= 10 && o < og.size(); i++) {
            System.out.printf("%d. %s%n", o + 1, og.get(o).toString());
            o++;
        }
        System.out.printf("Enter something to continue/enter s "
            + "to stop: ");
        String yesNo = keyboardReader.next();
        if (yesNo.equals("s")) {
            choices(mainMenu());
        } else {
            printTen(og);
        }
    } // end printOriginal

    /**
     * This method compares to strings based on ascii codes.
     * @param str1 a string
     * @param str2 a string
     * @return an integer, if the integer is negative it means the second
     *         string comes before the first string based on ascii codes
     *         and vice versa
     */

    public static int compare(String str1, String str2) {
        int size1 = str1.length();
        int size2 = str2.length();
        int min = Math.min(size1, size2);
        for (int i = 0; i < min; i++) {
            int ascii1 = (int) str1.charAt(i);
            int ascii2 = (int) str2.charAt(i);
            if (ascii1 != ascii2) {
                return ascii1 - ascii2;
            }
        }
        if (size1 != size2) {
            return size1 - size2;
        } else {
            return 0;
        }
    } // end compare

    /**
     * This method sorts the ArrayList of Customer objects using a
     * bubble sort method.
     * @param arr an ArrayList of Customer objects
     */

    public static void sort1(ArrayList<Customer> arr)  {
        boolean madeSwap;
        do {
            madeSwap = false;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (compare(arr.get(i).getName(), 
                        arr.get(i + 1).getName()) > 0) {
                    Customer temp = new Customer(arr.get(i));
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    madeSwap = true;
                }
            }
        } while (madeSwap);
    } // end sort1
    
    /**
     * This method sorts the ArrayList of Customer objects using a
     * bubble sort method.
     * @param list an ArrayList of Customer objects
     */

    public static void sort2(ArrayList<Customer> list) {
        boolean madeSwap;
        do {
            madeSwap = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getId() > list.get(i + 1).getId()) {
                    Customer temp = new Customer(list.get(i));
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    madeSwap = true;
                }
            }
        } while (madeSwap);
    } // end sort2
} // end class