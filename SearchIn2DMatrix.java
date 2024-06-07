/*
Question No. 74

You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.


*/
class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=0,columns=0;

        rows=matrix.length;
        columns=matrix[0].length;

        int low=0;
        int high=(rows*columns)-1;


        while(low<=high){
            int mid=low+((high-low)/2);


            if(matrix[mid/columns][mid%columns]==target) return true;
            else if(matrix[mid/columns][mid%columns]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
        
    }
}
