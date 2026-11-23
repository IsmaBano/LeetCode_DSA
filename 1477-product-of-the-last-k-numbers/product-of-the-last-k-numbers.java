class ProductOfNumbers {
    List<Integer> pref;
    public ProductOfNumbers() {
         pref=new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0){
            pref=new ArrayList<>();
            return;
        }
        pref.add((pref.isEmpty()?1:pref.get(pref.size()-1))*num);
    }
    
    public int getProduct(int k) {
        if(pref.size()<k){
            return 0;
        }
        int n=pref.size();
        int l=n-k-1;
        return pref.get(n-1)/(l>=0?pref.get(l):1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */