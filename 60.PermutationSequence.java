class Solution {
    public String getPermutation(int n, int k) {
        List list = new ArrayList();
        StringBuilder res = new StringBuilder();
        IntStream.range(1, n+1).forEach(
        	nbr -> list.add(nbr)
        );
    
        int numSmallerThanIt = k-1;
        for (int i = 1; i<n; i++) {
            int index = numSmallerThanIt / factorial(n-i);
            res.append(String.valueOf(list.get(index)));
            list.remove(index);
            numSmallerThanIt = numSmallerThanIt % factorial(n-i);
        }
        res.append(String.valueOf(list.get(0)));
        return res.toString();
    }

    private int factorial(int n) {
        int f = 1;
        while (n > 1) {
            f *= n;
            n--;
        }
        return f;
    }
}