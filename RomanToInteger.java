class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character,Integer> ht=new HashMap<>();
        ht.put('I',1);
        ht.put('V',5);
        ht.put('X',10);
        ht.put('L',50);
        ht.put('C',100);
        ht.put('D',500);
        ht.put('M',1000);

        //System.out.println(ht);
        int res=ht.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int curr=ht.get(s.charAt(i));
            int prev=ht.get(s.charAt(i-1));

            if(curr>prev){
                res=res+(curr-2*prev);

            }
            else{
                res=res+curr;;
            }
        }
        return res;
    }
}
