package Lection_JIP_part2;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

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
public class Exercise_7 {
  private  int counter;
   private List<Integer> list=new Vector<>();
   private Scanner scan=new Scanner(System.in);

    public Exercise_7(int counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
       Exercise_7 example=new Exercise_7(5);
       example.viewMenu();

    }
    void viewMenu(){
        boolean flag=true;
        while(flag){
        System.out.println("1. Input data");
        System.out.println("2. Calculate");
        System.out.println("3. Quit");
        int choice=scan.nextInt();
            if(choice==1){
                userInPut();

            }else if(choice==2){
               calculateSumSquare();
            }else if(choice==3){
                System.out.println("By !");
               flag=false;
            }else{
                System.out.println("Error");
                continue;
            }
        }
    }

    private void userInPut() {
        for(int i=0;i<counter;i++){
            System.out.println(Integer.valueOf(i+1)+". Please enter a number - ");
            list.add(scan.nextInt());
        }
    }

    private  int calculateSumSquare(){
        int result=0;
        for (int temp:list) {
        result+=temp*temp;
        }

        return result;
    }
}
