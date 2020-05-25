package org.example;

/**
 * @ClassName ReverseClass
 * @Description 反转数字，溢出则返回0
 * @Date 2020/5/25 9:46
 * @Author wangyong
 * @Version 1.0
 **/
public class ReverseClass {

    /**
     * 最傻的版本
     * @param x
     * @return
     */
    public int reverse(int x) {
        Integer max = Integer.MAX_VALUE;
        Integer min = Integer.MIN_VALUE;
        String origian = String.valueOf(x);
        String reverse = "";
        if(origian.contains("-")){
            origian = origian.substring(1);
        }
        for (int i = origian.length() - 1 ; i >=0 ; i --){
            reverse =  reverse + origian.charAt(i);
        }
        if(x > 0 && reverse.length() == 10){
            Long aLong = Long.valueOf(reverse);
            if(aLong - max > 0){
                return 0;
            }
        }
        if(x < 0 && reverse.length() == 10){
            Long va = 0 - Long.valueOf(reverse);
            if(va < min){
                return 0;
            }
        }
        if(reverse.length() > 10){
            return 0;
        }
        return x > 0 ? Integer.valueOf(reverse) : 0 - Integer.valueOf(reverse);
    }

    /**
     * 改进版
     * @param x
     * @return
     */
    public int reverse2(int x){
        int init= 0;
        //因为是十进制的，所有 x % 10 不停的取出余数， 余数就是个位数
        while (x != 0){
           int pop = x % 10;
           //进行判断
            if(init > Integer.MAX_VALUE/10 || (init == Integer.MAX_VALUE / 10 && pop >= Integer.MAX_VALUE % 10)){
                return 0;
            }
            if(init < Integer.MIN_VALUE /10 || (init == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)){
                return 0;
            }
           init = init * 10 + pop;
           x = (x - pop)/10;
        }
        return init;
    }

    public static void main(String[] args) {
       ReverseClass reverseClass = new ReverseClass();
//        System.out.println(reverseClass.reverse(-1534236469));
        System.out.println(reverseClass.reverse2(-12345));
        System.out.println(-123%12);
    }
}
