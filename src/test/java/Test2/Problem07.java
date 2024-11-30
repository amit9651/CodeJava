package Test2;

import java.nio.channels.Pipe.SourceChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Problem07 {
	
	/*Given an integer array arr[ ], your task is to find the minimum number of increment operations 
	 * required to make all the array elements unique. i.e. no value in the array should occur more than once. 
	 * In one operation, a value can be incremented by 1 only.

Note: The answer will always fit into a 32-bit integer.

Examples :

Input: arr[] = [3, 2, 1, 2, 1, 7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7]. It can be shown that it is impossible for the array 
to have all unique values with 5 or less operations.*/
	
	public static void main(String[] args) {
		
		int[] arr = {3, 2, 1, 2, 1, 7};
		int n = arr.length;
		int flag=0;
		int count =0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		System.out.println("++");
		
		Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
			
			if(entry.getValue()>1) {
				System.out.println("keyyy: "+entry.getKey()+"-"+entry.getValue());
				count = count + entry.getValue()-1;
				int key = entry.getKey()+1;
				int value = entry.getValue()-1;
				System.out.println("key---value--"+key+"-"+value);
				if(map.containsKey(key)) {
					map.put(key, map.get(key)+value);
				}
				else {
					map.put(key, value);
				}
				
				map.put(entry.getKey(), 1);
				flag=1;
			}
			System.out.println("**"+entry.getKey()+"-"+entry.getValue());
			
			if(flag!=1) {
				break;
			}
			else {
				flag=0;
			}
		}
		
		System.out.println(count);
		
		
	}

}
