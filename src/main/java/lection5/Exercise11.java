package lection5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 Implement the "I pack my back" game in a simple version as a Java program. – The
user shall enter one word after another and must be able to repeat the chain of words.
The program should have a menu to control the flow of the game. (You'll need a way to
clear the console in Java, please see ....
 */
public class Exercise11 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("/home/yurii/IdeaProjects/Curs_Java_2022/src/main/resources/1.txt"));
        System.out.println("sdsdsds ");
        int var1 = scan.nextInt();

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}