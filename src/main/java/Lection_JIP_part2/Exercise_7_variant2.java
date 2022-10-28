package Lection_JIP_part2;

import java.util.Scanner;


/*
Write a program asking the user for five integers (Don't use arrays!). The program
then outputs the sum of squares.
a) Learn how you can start a Java program from the Windows/macOS console, i.e.
without the IDE (i.e. without IntelliJ IDEA)! – Document clearly how it works! –
Your knowledge about using the console should help you.
b) A menu should be implemented with following options: [input numbers],
[calculate sum of squares] and [quit]. All options (except [quit]) return to the
menu after their action has taken place. Erroneous user inputs (e.g. text instead
of an integer) should be checked by the program and require new input from the
user.
 */

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! COMPLETE :)
// WITHOUT ARRAY

public class Exercise_7_variant2 {
    private int counter;
    private StringBuilder data = new StringBuilder("");
    private Scanner scan = new Scanner(System.in);

    public Exercise_7_variant2(int counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        Exercise_7_variant2 example = new Exercise_7_variant2(5);
        example.viewMenu();

    }

    void viewMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("--------- MENU -------------");
            System.out.println("[1] Input numbers");
            System.out.println("[2] Calculate sum of squares");
            System.out.println("[3] Quit");
            String choice = scan.next();
            if (choice.equals("1")) {
                userInPut();

            } else if (choice.equals("2")) {
                if (data.length() == 0) {
                    System.out.println("Please input the numbers !");
                    continue;
                }
                int result = calculateSumSquare();
                System.out.println("For " + data.toString() + " result = " + result);

            } else if (choice.equals("3")) {
                System.out.println("By !");
                scan.close();
                flag = false;
            } else {
                System.out.println("Error of choice item menu !");

            }
        }
    }

    private void userInPut() {
        if (data.length() != 0) {
            data.delete(0, data.length() - 1);
        }
        ;
        for (int i = 0; i < counter; i++) {
            System.out.println(Integer.valueOf(i + 1) + ". Please enter a number - ");
            String temp = scan.next();
            if (temp.matches("[0-9]+")) {
                data.append(temp + ";");
            } else {
                System.out.println("Mistake in format  input. Please, use number ! ");
                i--;
                continue;

            }

        }
    }

    private int calculateSumSquare() {
        int result = 0;
        String[] total = data.toString().split(";");
        for (String temp : total) {
            int num = Integer.parseInt(temp);
            result += num * num;
        }
        return result;
    }
}
