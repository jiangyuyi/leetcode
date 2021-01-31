
package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> headQueue = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1,ListNode n2){
                return n1.val - n2.val;
            }
        });
        for (int i=0;i<lists.length;i++){
            if (lists[i]!=null){
               headQueue.add(lists[i]);
            }
            
        }

        if (headQueue.size()==0){
            return null;
        }

        ListNode tmp = headQueue.poll();
        ListNode current = new ListNode(tmp.val);
        ListNode result = current;
        ListNode next = null;
        if (tmp.next!=null){
            headQueue.offer(tmp.next);
        } 

        while (headQueue.size()>0){
            tmp = headQueue.poll();
            current.next = new ListNode(tmp.val);
            if (tmp.next!=null){
                headQueue.offer(tmp.next);
            }
            current = current.next;
        }

        return result;

    }
}