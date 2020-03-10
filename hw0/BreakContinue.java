public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        int sum;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            if (a[i] <= 0) {
                continue;
            }
            for (int j = i; j <= (i + n); j++) {
                if (j >= a.length) {
                    break;
                }
                sum += a[j];
            }
            a[i] = sum;
        }
    }
    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
        int[] b = {1, -1, -1, 10, 5, -1};
        int m = 2;
        windowPosSum(b, m);

        // Should print -1, -1, -1, 14, 4, -1
        System.out.println(java.util.Arrays.toString(b));
    }
}
