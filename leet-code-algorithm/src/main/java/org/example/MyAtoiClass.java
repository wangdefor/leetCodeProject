package org.example;


import javax.sound.midi.Soundbank;

/**
 * @ClassName MyAtoiClass
 * @Description 反转有效字符串，并输出为数字，溢出为0
 * @Date 2020/5/25 10:18
 * @Author wangyong
 * @Version 1.0
 **/
public class MyAtoiClass {

    /**
     * 0 代表数字 ， 1 代表正号, 2 代表负数
     */
    static int status = 0;

    private static Boolean checkStatus(Character trim){
        if(status == 0 || status == 1 || status == 2){
            if((trim + "").matches("[0-9]")){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public int myAtoi(String str) {
        String trim = str.trim();
        String init = "";
        int currentData = 0;
        if(trim.equals("")){
            return 0;
        }
        if(!(trim.charAt(0)+ "").matches("[0-9]||-||[+]")){
            return 0;
        }
        for (int i = 0; i < trim.length(); i++) {
            if(i == 0){
                //判断是否是正负号
                if((trim.charAt(i) + "").equals("+")){
                    status = 1;
                    continue;
                }
                if((trim.charAt(i) + "").equals("-")){
                    status = 2;
                    continue;
                }
            }
            //校验状态是否正确
            if(!checkStatus(trim.charAt(i))){
                break;
            }
            Integer current = Integer.valueOf(trim.charAt(i) + "");
            if(((status == 0 || status == 1) && !init.equals("+"))){
                currentData = currentData  * 10 + current;
                if ((currentData == Integer.MAX_VALUE / 10&& current >= Integer.MAX_VALUE % 10)|| currentData > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
            }
            if(status == 2 || !init.equals("-")){

            }
            if (!init.equals("+") && !init.contains("-") && !init.equals("")) {
                if ((Integer.valueOf(init) == Integer.MAX_VALUE / 10
                                && Integer.valueOf(trim.charAt(i) + "") >= Integer.MAX_VALUE % 10)
                                || Integer.valueOf(init) > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
            }

            if (!init.equals("-") && init.contains("-")) {
                if ((Integer.valueOf(init) == Integer.MIN_VALUE / 10
                                && (0 - Integer.valueOf(trim.charAt(i) + "")) <= Integer.MIN_VALUE % 10) || Integer.valueOf(init) < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
            }
            init = init + trim.charAt(i) + "";
        }
        if(init.equals("+") || init.equals("-")){
            return 0;
        }

        return Integer.valueOf(init);
    }



    public static void main(String[] args) {
        System.out.println(Integer.valueOf("214748364") == Integer.MAX_VALUE/10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE%10);
        System.out.println(Integer.valueOf("2147483646".charAt(9)));
        System.out.println(Integer.valueOf("2147483646".charAt(9)) >= Integer.MAX_VALUE%10);
        System.out.println(Integer.valueOf("214748364") > Integer.MAX_VALUE/10);
        if(
                (Integer.valueOf("214748364") == Integer.MAX_VALUE/10
                        && Integer.valueOf("2147483646".charAt(9)) >= Integer.MAX_VALUE%10)
                        || Integer.valueOf("214748364") > Integer.MAX_VALUE/10){
            System.out.println("sadsadsad");
        }
        //System.out.println(myAtoi("   -42"));
    }




}
