public class Solution {
    public int[] twoSum(int[] numbers, int target) {
 		int[] res = new int[2];
 		if (numbers == null || numbers.length < 2) {
 			return numbers;
 		}       
    	Map<Integer, Integer> remainSet= new HashMap<Integer, Integer>();
    	for (int i = 0; i<numbers.length; i++) {
    		if (remainSet.containsKey(numbers[i])) {
    			res[0] = remainSet.get(numbers[i]) + 1;
    			res[1] = i + 1;
    			return res;
    		}
    		else {
    			remainSet.put(target - numbers[i],i);
    		}
    	}
    	return res;
    }
}
