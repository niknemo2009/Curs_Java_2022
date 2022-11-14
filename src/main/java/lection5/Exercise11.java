package lection5;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 Implement the "I pack my back" game in a simple version as a Java program. – The
user shall enter one word after another and must be able to repeat the chain of words.
The program should have a menu to control the flow of the game. (You'll need a way to
clear the console in Java, please see ....
 */
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!! No COMPLETE
public class Exercise11 {
    List<String> data = new ArrayList<>();
    List<String> nameUsers = new ArrayList<>();
    private final int countPlayers;
    String currentPlayerName;
    Scanner scan = new Scanner(System.in);

    public Exercise11(int countPlayers) {
        this.countPlayers = countPlayers;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Exercise11 exercise11 = new Exercise11(3);
//        exercise11.viewMenu();
//Scanner scan=new Scanner( System.in);
//String val=scan.nextLine();
//        System.out.println(val);
     //   clearScreen();
        Scanner conin = new Scanner(System.in);

        int count = 0;
        double sum = 0.0;

        System.out.println("Enter numbers to average.");

        while (conin.hasNext()) {
            if (conin.hasNextDouble()) {
                sum += conin.nextDouble();
                count++;
            } else {
                String str = conin.next();
                if (str.equals("done"))
                    break;
                else {
                    System.out.println("Data format error.");
                    return;
                }
            }
        }

        System.out.println("Average is " + sum / count);
    }




    void viewMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("+++ Game menu  +++ List players - " + nameUsers);
            System.out.println("1. Start game.");
            System.out.println("2. Add players.");
            System.out.println("3. Quit.");
            String choice = scan.next();
            switch (choice) {
                case "1": {
                    play();
                    break;
                }
                case "2": {
                    addPlayers();
                    break;
                }
                case "3": {
                    flag = false;
                    System.out.println("By !");
                    return;

                }

                default: {
                    System.out.println(" Mistake choice  item menu !");

                }
            }

        }


    }


    void addPlayers() {
        nameUsers.clear();
        System.out.println("Menu for adding players !!!!! ");
        for (int i = 0; i < countPlayers; i++) {
            System.out.println("List players -" + nameUsers);
            System.out.println("Nickname " + (i + 1) + "  player is -  ");
            String name = scan.next();
            if (nameUsers.contains(name) == true) {
                System.out.println("Please, change nickname ! Nickname used already.");
                i--;
            } else {
                nameUsers.add(name);
            }
        }
currentPlayerName=nextPlayer();

    }

    void play() {
        if(nameUsers.size()==0){
            System.out.println("Please, add players !");
            return;
        }
        Scanner scan=new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            if(nameUsers.size()==1){
                System.out.println("Congratulation ! "+currentPlayerName +" are winner !" );
               break;

            }
            System.out.println(currentPlayerName + " , please enter phrase - ");

            String variant = scan.nextLine();

            if (this.data.size() == 0) {
                data.add(variant.trim());

            } else {
                if (variant.trim().indexOf(data.get(0)) == 0) {
                    data.add(variant.trim());

                } else {
                    System.out.println("Sorry " + this.currentPlayerName + " game over for you !");
                    nameUsers.remove(this.currentPlayerName);
                }
            }
            this.currentPlayerName = nextPlayer();
        }


    }


    private String nextPlayer() {
        Random rnd = new Random();
        String result = "";
        if (currentPlayerName == null) {
            result = nameUsers.get(rnd.nextInt(nameUsers.size() - 1));
        } else {
            int positionOld = nameUsers.indexOf(this.currentPlayerName);
            int temp = positionOld == (nameUsers.size() - 1) ? 0 : ++positionOld;
            result = nameUsers.get(temp);
        }
        return result;

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clear()
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

}