package com.arthas.nowcoder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String childrenStr = in.next();
        String parentStr = in.next();
        int j = 0;
        int i = 0;
        for (; i < parentStr.length(); i++) {
            if(Objects.equals(childrenStr.charAt(j), parentStr.charAt(i))) j++;
            if(j >= childrenStr.length()) {i++;break;}
        }
        if (Objects.equals(childrenStr.charAt(j==0?j:j-1), parentStr.charAt(i==0?i:i-1)) && j >= childrenStr.length()) System.out.println("true");
        else System.out.println("false");
    }
}