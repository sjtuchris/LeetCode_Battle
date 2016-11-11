class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        if (numbers.size()<1)
        	return numbers;

        int i=0;
        int j=numbers.size()-1;
        while (i<j) {
        	if (target < (numbers[i] + numbers[j])){
        		j--;
        	}
        	else if (target > (numbers[i]+numbers[j])){
        		i++;
        	}
        	else{
        		return {i+1,j+1};
        	}
        }
        return {i++, j++};
    }
};
