//TC: O(N+M)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res=new int[n+m];

        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                res[k++]=nums1[i++];
                               
            }
            else{
                res[k++]=nums2[j++];
                //j++;
                //k++;
            }
        }

        while(i<m){
            res[k]=nums1[i];
            i++;
            k++;
        }    

        while(j<n){
            res[k]=nums2[j];
            j++;
            k++;
        }

        for(int b=0;b<(n+m);b++){
            nums1[b]=res[b];
        }

        for(int a=0;a<(n+m);a++){
            System.out.println(nums1[a]+" ");
        }       

    }
}
