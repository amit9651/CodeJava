package Test2;

import java.util.HashMap;

public class Problem06 {
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,3,2,4,4};    // 1 1 1 1 1 
		int n= arr.length;
		HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(arr[i], map.getOrDefault(map.get(arr[i]),0)+1);
            
        }
        int count=0;
        for(int key: map.values()){
            if(key >1){
                count++;
            }
        }
        System.out.println(count);
        
	}

}
