

class MedianofTwoSortedArray {
    private int m;
    private int n;
    private int[] Array1;
    private int[] Array2;

    public double findMedianSortedArrays(int[] Array1, int[] Array2) {
        m = Array1.length;
        n = Array2.length;
        this.Array1 = Array1;
        this.Array2 = Array2;
        
        int a = f(0, 0, (m + n + 1) / 2);
        int b = f(0, 0, (m + n + 2) / 2);
        return (a + b) / 2.0;
    }

    private int f(int i, int j, int k) {//To find the kth smallest element in an array
        if (i >= m) {
            return Array2[j + k - 1];
        }
        if (j >= n) {
            return Array1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(Array1[i], Array2[j]);
        }
        int p = k / 2;
        int x = i + p - 1 < m ? Array1[i + p - 1] : 1 << 30;
        int y = j + p - 1 < n ? Array2[j + p - 1] : 1 << 30;
        return x < y ? f(i + p, j, k - p) : f(i, j + p, k - p);
    }
}


