package com.nyit.assginment_1;

public class QuestionFour {
    public static void main(String[] args) {
        QuestionFour qf = new QuestionFour();

//        String result = qf.divideUtil(0,);

    }



    private String mergeUtil(String left, String right) {
        String common = "";
        for (int i = 0, j = 0; i < left.length() && j < right.length(); i++, j++) {
            if (left.charAt(i) != right.charAt(j))
                break;
            common += left.charAt(i);
        }
        return common;
    }

    private String divideUtil(int begin, int end, String[] team) {
        if (begin == end)
            return team[begin];
        if (end > begin) {
            int middle = (begin + end) / 2;
            String left = divideUtil(begin, middle, team);
            String right = divideUtil(middle + 1, end, team);
            return mergeUtil(left, right);
        }
        return null;
    }


}