package com.imooc.utils;

import java.util.Random;

/**
 * Date: 2021/12/24 5:19 下午
 * StringRandom
 * Describe：
 */
public class StringRandom {
    //生成随机数字和字母,
    public String getStringRandom() {

        String val = "T";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < 25; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public  static  void    traceid (){
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());

    }
}
