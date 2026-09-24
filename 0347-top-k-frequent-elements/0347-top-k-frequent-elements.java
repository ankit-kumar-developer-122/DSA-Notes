class Solution {
    class Pair {
        Integer first , second;

        Pair(Integer first , Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    class myComp implements Comparator<Pair> {
        @Override
        public int compare(Pair L , Pair R) {
            return R.first.compareTo(L.first);  
        }
    }

    public int[] topKFrequent(int[] a, int k) {
        HashMap<Integer , Integer> mp = new HashMap<>();

        for(int i = 0; i < a.length; ++i) 
            if(!mp.containsKey(a[i])) 
                mp.put(a[i] , 1);
            else
               mp.put(a[i] , mp.get(a[i]) + 1);    

        ArrayList<Pair> ArL = new ArrayList<>();  

        for(Map.Entry<Integer , Integer> C : mp.entrySet()) {
            ArL.add(new Pair(C.getValue() , C.getKey()));
        }

        Collections.sort(ArL , new myComp());

        int [] ans = new int [k];

        for(int i = 0; i < k; ++i) 
            ans[i] = ArL.get(i).second;

        return ans;     
    }
}