package org.example;

/**
 * @Classname Palindrome
 * @Description TODO
 * @Date 2021/2/23 19:22
 * @Created wangyong
 */
public class Palindrome {

    public static boolean isPalindrome(int x) {
        String a1 = x + "";
        //判断是否基数偶数
        String a11 = a1.substring(0, a1.length() / 2);
        String a12 = a1.substring(a1.length() % 2 == 0 ? a1.length() / 2 : a1.length() / 2 + 1);
        String a121 = "";
        for (int i = 0; i < a12.length(); i++) {
            a121 = a12.charAt(i) + a121;
        }
        return a121.equals(a11);


    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }
}
