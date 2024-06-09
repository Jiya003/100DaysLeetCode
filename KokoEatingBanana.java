import java.util.Scanner;
import java.util.Arrays;

public class KokoEatingBanana {
    public static int BruteForce(int[] array, int hours){
        Arrays.sort(array);
        int n=array[array.length-1];

        int k=1;
        int totalHours=0;
        for(int i=0;i<n;i++){
            totalHours+=Math.ceil(array[i]/k);
            if(totalHours>hours){
                k++;
            }
        }
        
        
        return k;
    }


    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;

        int low = 1; // Minimum possible speed
        int high = piles[n - 1]; // Maximum possible speed

        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, mid, h)) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }
        
        return low; 
    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        int totalHours = 0;

        for (int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / speed);
        }

        return totalHours <= h;
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("enter length:");
        int n=sc.nextInt();

        int[] array=new int[n];

        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        System.out.println("Enter hour:");
        int hours=sc.nextInt();

        System.out.println(BruteForce(array,hours));
        System.out.println(minEatingSpeed(array,hours));

    }
}
