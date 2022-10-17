package com.nyit.assginment_1;

import java.util.ArrayList;

public class QuestionFour {
    public static void main(String[] args) {
        String data = "bbwedhb,bbwkhghtghjkg,bbwoouytt,bbwhyygfdfhhj,bbwhtajsh,bbwkjuy,bbwwwet,bbwssa,bbwqqq,bbwooppoui,bbwggat,bbwjjhhtt,bbwwww,bbwbbbbb,bbwbwbwbwbw,bbwoiuyt,bbwfdsdg,bbww,bbwwt,bbwwo;abbaatt,abbassgty,abbapjirdgh,abbatyyurew,abbaaaaa,abbaaaabbaaa,abbaooiyt,abba,abbatyyrere,abbahhtrdgj,abbattyytre,abbannmn,abbababa,abbatytre,abbaaaaajjtt,abbawqe,abbayuutr,abbaoiur,abbammmnnn,abbayuytesv;peacock,penguin,pet,pen,penny,pencil,per,peach,perk,peak,peek,peer,pest,pens,peon,pets,pear,pearl,peppy,petal;zoozooooo,zooozoo,zooo,zoooooo,zoozozo,zoozo,zoozzz,zoozozozz,zooozzz,zoozzoo,zoozzzzoooo,zoozozozozoz,zoozooooozzzzz,zooooz,zoozzzzz,zoo,zoozzzoozz,zoooozzozozoz,zoozz,zooooz;bat,ball,banana,basket,bag,balloon,bad,bald,bar,band,bend,bash,bake,baby,back,brain,basic,bath,basis,balm;nanann,nanana,nanaaa,nanannn,nanaan,nanaann,nanannaa,nananan,nanaaaannnn,nananaannnaa,nanaaannaaaa,nananananana,nanannnnnnn,nana,nanan,nanaa,nanaaannaan,nanannnaaaa,nanaan,nanaaaannnnn;xyzzz,xyzxx,xyzxyz,xyzyy,xyzxyzxyz,xyzxxyy,xyzxxyyzzy,xyzzzyyxx,xyzyyxxzzzz,xyzyyxxzzzz,xyzyyzzxxxxz,xyzyxzzxy,xyzxxyyxy,xyzzzyyzy,xyzxxzzxz,xyzxxyyzzxyz,xyzxxyyzzzz,xyzyyxxzzyxz,xyzyzxxyz,xyz;aaaa,aaaaaa,aaaaaaa,aaaaaaaaaa,aaaaa,aa,aaa,a,aaaaaaaaaa,aaaaaaaaaaaaaa,aaaaaaaaaaaaaaaa,aaaaaaaa,aaaaaaaaa,aaaaaaaaaaaa,aaaaaaaaa,aaaaaaaaaaa,aaaaaaaaaaaaaaaaa,aaaaaaaaaaaaaaaaa,aaaaaaaaaaa,aaaaaaaaaaaaaaaaaaaa;lmno,lhhtri,llmmnn,ltuiriityh,lmntyuu,lmhutf,mno,lhtrech,lllll,llmmnn,llmmnnooo,lll,lmnopq,lmopiutc,l,lmngtdff,lwef,leak,loutfhh,lqdf;apple,app,apply,appear,appoint,approve,apps,apparel,append,appeal,appose,approach,application,appointed,appraise,approved,appreciate,approval,appendix,applaud";
        QuestionThree qt = new QuestionThree();
        ArrayList<String[]> teams = qt.formatData(data);
        QuestionFour qf = new QuestionFour();
        int i = 0;
        for (String[] team : teams) {
            System.out.println("Group:" + i);
            for (String s : team) {
                System.out.print(s + "/");
            }
            String common = qf.divideUtil(0, team.length-1, team);
            System.out.print(":::" + common);
            System.out.println();
            i++;
        }


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