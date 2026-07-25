class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer>List=new ArrayList<>();
        while(n>0)
        {
            List.add(n%10);
            n=n/10;

        }
        Collections.sort(List);
        int total=List.size();
        int prod=List.get(total-1)*List.get(total-2);
        return prod;
    }
}