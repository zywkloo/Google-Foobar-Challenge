import java.lang.Math;

public class Challenge2 {
    public static int findNum(int num, int k) {
        if (num == k) return k+1;
        if (num < 3) return 3;
        if (num > Math.floor(k/2)) return (int)Math.floor(k/2) + findNum((int)(num - Math.floor(k/2)), (int)Math.floor(k/2));
        return findNum(num, (int)Math.floor(k/2));
    }

    public static boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        while(n>2){
            int t = n>>1;
            int c = t<<1;
            if(n-c != 0)
                return false;
            n = n>>1;
        }
        return true;
    }

    public static int singleSolution(int h, int num) {
        int k = (int)Math.pow(2,h) - 1;
        if (k <= num) return -1;
        if (isPowerOfTwo(num+1)) return 2*num+1;
        return findNum(num, k);
    }

    public static void main(String[] args) {
        System.out.println(Challenge2.singleSolution(5,19));
        System.out.println(Challenge2.singleSolution(5,14));
        System.out.println(Challenge2.singleSolution(5,28));
        System.out.println(Challenge2.singleSolution(3,7));
        System.out.println(Challenge2.singleSolution(3,3));
        System.out.println(Challenge2.singleSolution(3,5));
        System.out.println(Challenge2.singleSolution(3,1));
    }
}
