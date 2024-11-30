package Test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Problem01 {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,5,5};
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		int flag = n/3;
		
		for(int val: nums) {
			map.put(val, map.getOrDefault(val, 0)+1);
			
		}

		map.keySet().removeIf(key -> map.get(key) <= flag );
		Map<Integer, Integer> sortedMap = new TreeMap<>(map);

		List<Integer> keysList = new ArrayList<>();
		for(Integer x: sortedMap.keySet()) {
			keysList.add(x);
		}
		System.out.println(keysList);
		
		
	}
		
	
}

/*PROBLEM STATEMENT:
You are given an array of integer arr[] where each number represents a vote to a candidate. 
Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 


Note: The answer should be returned in an increasing format.

Examples:

Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.*/






