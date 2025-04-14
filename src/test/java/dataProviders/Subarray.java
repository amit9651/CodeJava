package dataProviders;

public class Subarray {

    public static void main(String[] args) {
        int[] num = {6,2,-1,0,-9,-1,2,9};
        int n = num.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

                currSum = currSum + num[i];
                maxSum = Math.max(maxSum,currSum);
                if(currSum < 0){
                    currSum = 0;
                }

        }
        System.out.println(maxSum);

    }
}
