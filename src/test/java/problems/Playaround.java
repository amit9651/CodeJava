package problems;

import java.util.Arrays;
import java.util.HashMap;

public class Playaround {

    public static void main(String[] args) {

        System.out.println(1+'a'+2);
        System.out.println(1+'a');
        System.out.println(1==1?0:9);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("amit",20);
        map.put("bob",50);
        map.put("cane",90);
        //map.put("bob",10);
        System.out.println(map);
        System.out.println(map.containsKey("amit"));
        System.out.println(map.containsValue(20));
        map.put("amit",map.getOrDefault("amit",0)+1);
        System.out.println(map);

        for(String key:map.keySet()){
            System.out.println("key: "+ key+"value: "+map.get(key));
        }
        for(Integer value:map.values()){
            System.out.println(value);
        }

        String s = " amir ashih   hhhdds amieeeenf a m n 3434 2 @@ ";
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!=' ') {
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
        int marks = (int)20.25;
        float num = 10.669f;
        double score = 20.986;
        int sum = (int)(num + score);
        System.out.println(marks);
        System.out.println(num);
        System.out.println(score);
        System.out.println(sum);
        int[] array1 = {1,2,3,4};
        String[] array2 = {"amit","bob","cane"};
        char[] array3 = {'a','b','c','d'};
        System.out.print(Arrays.toString(array1));
        System.out.println();
        System.out.print(Arrays.toString(array2));
        System.out.println();
        System.out.print(array3);
    }
}
