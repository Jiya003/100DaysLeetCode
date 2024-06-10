class Solution {
    public void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] array1 = new int[n1];
        int[] array2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            array1[i] = array[l + i];
        }
        for (int j = 0; j < n2; j++) {
            array2[j] = array[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = array1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = array2[j];
            j++;
            k++;
        }
    }

    public void Sort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            Sort(array, l, m);
            Sort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }

    public int heightChecker(int[] heights) {
        int[] sortedHeights = heights.clone(); 
        int n = heights.length;
        int count = 0;

        Sort(sortedHeights, 0, n - 1); 

        for (int i = 0; i < n; i++) {
            if (heights[i] != sortedHeights[i]) {
                count++;
            }
        }
        return count;
    }
}
