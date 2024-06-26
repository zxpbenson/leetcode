package com.benson.note.leetcode.zktest;

import java.util.ArrayList;
import java.util.List;

public class Tmp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //list.add("e-0");
        //list.add("e-1");
        //list.add("e-2");
        List<String> subList = list.subList(0, 0);
        for (String sub : subList) {
            System.out.println(sub);
        }
    }
}
