package com.nyit.assginment_1;

import java.util.ArrayList;

/*
    Assignment 1, Question 4 (to implement Question 3)
    Longest Common Subsequence (LCS) base on brute force approach
    author: Wenjia Wang
    date: Oct 13, 2022
 */
public class QuestionThree {
    int minLength = 0;
    String common = "";


    public static void main(String[] args) {
        String data = "bbwedhb,bbwkhghtghjkg,bbwoouytt,bbwhyygfdfhhj,bbwhtajsh,bbwkjuy,bbwwwet,bbwssa,bbwqqq,bbwooppoui,bbwggat,bbwjjhhtt,bbwwww,bbwbbbbb,bbwbwbwbwbw,bbwoiuyt,bbwfdsdg,bbww,bbwwt,bbwwo;abbaatt,abbassgty,abbapjirdgh,abbatyyurew,abbaaaaa,abbaaaabbaaa,abbaooiyt,abba,abbatyyrere,abbahhtrdgj,abbattyytre,abbannmn,abbababa,abbatytre,abbaaaaajjtt,abbawqe,abbayuutr,abbaoiur,abbammmnnn,abbayuytesv;peacock,penguin,pet,pen,penny,pencil,per,peach,perk,peak,peek,peer,pest,pens,peon,pets,pear,pearl,peppy,petal;zoozooooo,zooozoo,zooo,zoooooo,zoozozo,zoozo,zoozzz,zoozozozz,zooozzz,zoozzoo,zoozzzzoooo,zoozozozozoz,zoozooooozzzzz,zooooz,zoozzzzz,zoo,zoozzzoozz,zoooozzozozoz,zoozz,zooooz;bat,ball,banana,basket,bag,balloon,bad,bald,bar,band,bend,bash,bake,baby,back,brain,basic,bath,basis,balm;nanann,nanana,nanaaa,nanannn,nanaan,nanaann,nanannaa,nananan,nanaaaannnn,nananaannnaa,nanaaannaaaa,nananananana,nanannnnnnn,nana,nanan,nanaa,nanaaannaan,nanannnaaaa,nanaan,nanaaaannnnn;xyzzz,xyzxx,xyzxyz,xyzyy,xyzxyzxyz,xyzxxyy,xyzxxyyzzy,xyzzzyyxx,xyzyyxxzzzz,xyzyyxxzzzz,xyzyyzzxxxxz,xyzyxzzxy,xyzxxyyxy,xyzzzyyzy,xyzxxzzxz,xyzxxyyzzxyz,xyzxxyyzzzz,xyzyyxxzzyxz,xyzyzxxyz,xyz;aaaa,aaaaaa,aaaaaaa,aaaaaaaaaa,aaaaa,aa,aaa,a,aaaaaaaaaa,aaaaaaaaaaaaaa,aaaaaaaaaaaaaaaa,aaaaaaaa,aaaaaaaaa,aaaaaaaaaaaa,aaaaaaaaa,aaaaaaaaaaa,aaaaaaaaaaaaaaaaa,aaaaaaaaaaaaaaaaa,aaaaaaaaaaa,aaaaaaaaaaaaaaaaaaaa;lmno,lhhtri,llmmnn,ltuiriityh,lmntyuu,lmhutf,mno,lhtrech,lllll,llmmnn,llmmnnooo,lll,lmnopq,lmopiutc,l,lmngtdff,lwef,leak,loutfhh,lqdf;apple,app,apply,appear,appoint,approve,apps,apparel,append,appeal,appose,approach,application,appointed,appraise,approved,appreciate,approval,appendix,applaud";
        QuestionThree qt = new QuestionThree();
        ArrayList<String[]> teams = qt.formatData(data);
        ArrayList<String> commons = qt.findLongestCommonPrefix(teams);
//        test
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Group:" + i);
            for (String s : teams.get(i)) {
                System.out.print(s + "/");
            }
            System.out.println();
            System.out.print("-common:" + commons.get(i));
            System.out.println();
        }

    }


    private ArrayList<String> findLongestCommonPrefix(ArrayList<String[]> teams) {
        int minLength = 0;
        String common = "";
        ArrayList<String> commons = new ArrayList<String>();
        for (String[] team : teams) {
            //init
            minLength = 0;
            common = "";

            for (String str : team) { // find out the shortest word
                if (minLength == 0 || minLength > str.length())
                    minLength = str.length();
            }

            for (int i = 0; i < minLength; i++) {
                char c = ' ';
                for (int j = 0; j < team.length; j++) {
                    if (j == 0)  // record first char
                        c = team[j].charAt(i);
                    else if (c != team[j].charAt(i)) {
                        c = ' ';
                        break;
                    }

                }
                common = common + c;
            }

            commons.add(common);
        }
        return commons;
    }

    public String findLongestCommonPrefix(String[] team) {
        int minLength = 0;
        String common = "";

        for (String str : team) { // find out the shortest word
            if (minLength == 0 || minLength > str.length())
                minLength = str.length();
        }

        for (int i = 0; i < minLength; i++) {
            char c = ' ';
            for (int j = 0; j < team.length; j++) {
                if (j == 0)  // record first char
                    c = team[j].charAt(i);
                else if (c != team[j].charAt(i)) {
                    c = ' ';
                    break;
                }

            }
            common = common + c;
        }

        return common;

    }

    //        cut the whole string to a series of couples in an arraylist
    public ArrayList<String[]> formatData(String data) {
        ArrayList<String[]> teams = new ArrayList<String[]>();
        String[] arrTeams = data.split(";");
        for (String s : arrTeams) {
            String[] team = s.split(",");
            teams.add(team);
        }
        return teams;
    }

}
