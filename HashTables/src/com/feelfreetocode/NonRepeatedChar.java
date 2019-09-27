package com.feelfreetocode;
import java.util.HashMap;
import java.util.Map;

public class NonRepeatedChar {

    public static void main(String[] args) {
       char value =  getFirstNonRepeatedChar("FeelFreeToCode");
        System.out.println(value);
    }

    public static char getFirstNonRepeatedChar(String s){
        char[] chars = s.toCharArray();
        Map<Character , Integer> map = new HashMap<>();
        for(Character ch : chars){
            Integer prevValue = map.get(ch);
            if(prevValue == null){
                map.put(ch , 1);
            }else{
                map.put(ch , prevValue + 1);
            }
        }

        for(Character ch : chars){
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }
}
