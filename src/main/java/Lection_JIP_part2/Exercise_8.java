package Lection_JIP_part2;

//Write a new program, which prints following output to the console: 22  4444   666666

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NO COMPLETE :)
public class Exercise_8 {
private int countStartSpace;

    public Exercise_8(int countStartSpace) {
        setCountStartSpace(countStartSpace);
    }

    public void setCountStartSpace(int countStartSpace) {
        if (countStartSpace<0){
        countStartSpace=0;
            System.out.println("Error, value must >= 0 !!!!! Now ,value setting  to default (0) ");
        return;
        }
        this.countStartSpace = countStartSpace;
    }

    public static void main(String[] args) {

    }

    void drowTriangle(int countRow){
        int[] numbers=new int[countRow];
        for (int i=0;i<countRow;){
            numbers[i]=2*(i++);
        }


    }
}
