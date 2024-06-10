public static int countFactors(int n){
        int sq=(int)Math.sqrt(n);
        int count=0;

        for(int i=1;i<=sq;i++){          
            if(n%i==0){
                int another=n/i;  
                if(another!=i) count=count+2;
                else count++;
                
            }
        }
        return count;
    }
