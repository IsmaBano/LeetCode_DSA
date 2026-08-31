/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int min;
    int max;
    int firstd=0;
    public void solve(ListNode head,int prev ,int d,int pd){
        if(head==null){
            return;
        }
        ListNode next=head.next;
        if(next!=null && prev!=-1){
            if((next.val>head.val && prev>head.val)||(next.val<head.val && prev<head.val)){
               if(pd==0){
                firstd=d;
               }else{
                max=d-firstd;
                min=Math.min(min,d-pd);
               }
               solve(head.next,head.val,d+1,d);
            }else{
                solve(head.next,head.val,d+1,pd);
            }
        }else{
             solve(head.next,head.val,d+1,pd);
        }
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        min=Integer.MAX_VALUE;
        max=0;
        //max - last c-first c min curr c - pc
        solve(head,-1,0,0);
        if(min==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{min,max};
    }
}