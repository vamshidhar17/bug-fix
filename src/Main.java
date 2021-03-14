import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }

    private static void optionsSelection() {
        String[] arr = {"\n1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

          Scanner sc = new Scanner(System.in);
          int options = selectOptions(arr);

        do {
            switch (options) {
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses);
                    break;

                case 2:
                    System.out.println("Enter the value to add your Expense:\t");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated");
                    System.out.println(expenses);
                    break;

                case 3:
                    System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...");
                    int con_choice = sc.nextInt();
                    if (con_choice == options) {
                        expenses.clear();
                        System.out.println(expenses);
                        System.out.println("All your expenses are erased!");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                    break;

                case 4:
                    sortExpenses(expenses);
                    break;

                case 5:
                    System.out.println("Enter the expense you need to search:\t");
                    int searchElement = sc.nextInt();
                    searchExpenses(expenses, searchElement);
                    break;

                case 6:
                    closeApp();
                    break;
                default:
                    System.out.println("You have made an invalid choice!");
                    break;
            }
            options = selectOptions(arr);

        } while (options != 6);
    }


    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList, int searchElement) {

        if(arrayList.contains(searchElement)){
            System.out.println("Element " + searchElement + " is present.");
        } else
            System.out.println("Element " + searchElement + " is not present. Please try again");
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

    private static int selectOptions(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
