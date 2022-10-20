package com.nyit.assginment_1;

public class QuestionSeven {
    public static void main(String[] args) {
        String base = "bbwedhb,bbwkhghtghjkg,bbwoouytt,bbwhyygfdfhhj,bbwhtajsh,bbwkjuy,bbwwwet,bbwssa,bbwqqq,bbwooppoui,bbwggat,bbwjjhhtt,bbwwww,bbwbbbbb,bbwbwbwbwbw,bbwoiuyt,bbwfdsdg,bbww,bbwwt,bbwwo";

        for (int i = 10000000; i <= 100000000; i += 10000000) {
            String[] data = new QuestionSeven().generateData(i, base);
            QuestionThree qt = new QuestionThree();
            QuestionFour qf = new QuestionFour();
            Long begin = System.currentTimeMillis();
            String common = qt.findLongestCommonPrefix(data);
//            String common = qf.divideUtil(0, data.length - 1, data);
            Long end = System.currentTimeMillis();
            System.out.println("common:" + common + ", size:" + i);
            System.out.println("running time:" + (end - begin));
//            System.out.println("begin:" + begin + " end:" + end);
        }


    }

    private String[] generateData(int size, String base) {
        String[] group = base.split(",");
        String[] data = new String[size];
        int temp = 0;
        for (int i = 0; i < data.length; i++) {
            temp = (int) (Math.random() * group.length);
//            System.out.println(temp);
            data[i] = group[temp];
        }
        return data;

    }

}
