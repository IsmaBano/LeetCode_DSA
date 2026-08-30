class Node{
    String tid;
    int time;
    Node prev;
    Node next;
    public Node(String tid,int time){
    this.tid=tid;
    this.time=time;
    prev=null;
    next=null;
    }
}
class AuthenticationManager {
   Node head;
   Node curr;
   HashMap<String,Node> map;
   int timeToLive;
    public AuthenticationManager(int timeToLive) {
    head=new Node("",-1);
    curr=head;
    map=new HashMap<>();
    this.timeToLive=timeToLive;
    }
    public void delete(Node node){
        Node pr=node.prev;
        Node nxt=node.next;
        pr.next=nxt;
        if(nxt!=null){
        nxt.prev=pr;
        }
        
        if(node==curr){
            curr=pr;
        }
    }
    
    public void generate(String tokenId, int currentTime) {
        Node node=new Node(tokenId,currentTime+timeToLive);
        curr.next=node;
        node.prev=curr;
        curr=node;
        map.put(tokenId,node);
        while(head.next!=null && head.next.time<=currentTime){
            map.remove(head.next.tid);
           
            delete(head.next);
        }
    }
    
    public void renew(String tokenId, int currentTime) {
         while(head.next!=null && head.next.time<=currentTime){
            map.remove(head.next.tid);
            delete(head.next);
        }
        if(map.containsKey(tokenId)){
            Node nnode=map.get(tokenId);
            delete(nnode);
         Node node=new Node(tokenId,currentTime+timeToLive);
        curr.next=node;
        node.prev=curr;
        curr=node;
        map.put(tokenId,node);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        while(head.next!=null && head.next.time<=currentTime){
            map.remove(head.next.tid);
            delete(head.next);
        }
        return map.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */