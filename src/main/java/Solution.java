public class Solution {

    public static void main(String[] args) {
        int sol = new Solution().solution(new int[]{1,2,3,2});
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        if(n == 3){
            return 0;
        }
        int maxEnding = 0;
        int maxSlice =0;
        int maxSliceLeft[] = new int[n];

        for(int i=1; i<n-1;i++){
            maxEnding = Math.max(0, maxEnding+A[i]);
            maxSliceLeft[i] = maxEnding;
        }
        int a = maxEnding;
        int[] maxSliceRight = new int[n];
        maxEnding = 0;
        maxSlice =0;
        for(int i=n-2;i>=1;i--){
            maxEnding = Math.max(0,maxEnding+A[i]);
            maxSliceRight[i] = maxEnding;
        }
        int b=maxEnding;
        int maxDoubleSlice =0;
        for(int i=1;i<n-1;i++){
            maxDoubleSlice = Math.max(maxDoubleSlice,maxSliceLeft[i-1]+maxSliceRight[i+1]);
        }
        for(int i=0;i<maxSliceLeft.length;i++){
            a = maxSliceLeft[0];
            if(maxSliceLeft[i]!=a){
                b=maxSliceLeft[i];
            }
        }
        return (maxDoubleSlice/(a+b));

    }
}


