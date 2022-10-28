package Lection_JIP_part2;

//Write a new program, which prints following output to the console: 22  4444   666666.
// Added the ability to change the step of the arithmetic progression and the size of the indent on the left

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!COMPLETE :)
public class Exercise_8 {
    private final int STEP = 3;
    private int countStartSpace;

    public Exercise_8(int countStartSpace) {
        setCountStartSpace(countStartSpace);
    }

    public static void main(String[] args) {
        Exercise_8 ex = new Exercise_8(0);
        ex.drowTriangle(15);
    }

    public void setCountStartSpace(int countStartSpace) {
        if (countStartSpace < 0) {
            countStartSpace = 0;
            System.out.println("Error, value must >= 0 !!!!! Now ,value setting  to default (0) ");
            return;
        }
        this.countStartSpace = countStartSpace;
    }


    void drowTriangle(int highTriangle) {
        if (highTriangle <= 0) {
            System.out.println("High must > 0");
            return;
        }
        for (int i = STEP; i <= STEP * highTriangle; i = i + STEP) {
            drowRow(i, STEP * highTriangle);
        }


    }

    private void drowRow(int currentNum, int maxNum) {
        String subst1 = getSubstr(countStartSpace, " ");
        String subst3 = getSubstr(currentNum, String.valueOf(currentNum));
        String subst2 = getSubstr(getSubstr(maxNum, String.valueOf(maxNum)).length() / 2 - subst3.length() / 2, " ");
        System.out.println(subst1 + subst2 + subst3);
    }

    private String getSubstr(int count, String template) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(template);
        }
        return sb.toString();
    }
}
