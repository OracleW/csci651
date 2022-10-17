package com.nyit.assginment_1;

import java.util.ArrayList;

/*
    Assignment 1, Question 2 (to implement Question 1)
    Longest Common Subsequence (LCS) base on brute force approach
    author: Wenjia Wang
    date: Oct 13, 2022
 */
public class QuestionTwo {

    public static void main(String[] args) {
//      Input TestCases_LCS
        String data = "abcde,ace;lmnopq,xyz;peacock,penguin;ttybace,bclknm;canada,vancouver;book,table;spptap,pxtxsap;common,communicate;xyzxyz,axbyyzz;yellow,melon;csstxbst,astsbksty;example,analyze";
        QuestionTwo qt = new QuestionTwo();
        ArrayList<String[]> temp = qt.formatData(data);
        for (String[] arrStr : temp) {
            String common = qt.findLongestCommonSub(arrStr[0], arrStr[1]);
            System.out.println("[" + arrStr[0] + "," + arrStr[1] + "]:" + common);
        }


    }

    //    brute force approach
    private String findLongestCommonSub(String first, String second) {
        String common = "";
        for (int i = 0; i < second.length(); i++) {
            for (int j = 0; j < first.length(); j++) {
                if (second.charAt(i) == first.charAt(j) && j >= i) {
                    common = common + second.charAt(i);
                    break;
                }

            }
        }

        return common;
    }

    //    cut the whole string to a series of couples in an arraylist
    private ArrayList<String[]> formatData(String data) {
        ArrayList<String[]> couples = new ArrayList<String[]>();
        String[] arrStr = data.split(";");
        for (String s : arrStr) {
            String[] couple = s.split(",");
            couples.add(couple);
        }
        return couples;
    }


}
