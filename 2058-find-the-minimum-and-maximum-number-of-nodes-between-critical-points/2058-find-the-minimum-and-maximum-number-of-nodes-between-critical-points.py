class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        first_crit = prev_crit = -1
        min_dist = float('inf')
        idx = 1
        prev = head
        curr = head.next
        
        while curr and curr.next:
            if (curr.val > prev.val and curr.val > curr.next.val) or \
               (curr.val < prev.val and curr.val < curr.next.val):
                if first_crit == -1:
                    first_crit = idx
                else:
                    min_dist = min(min_dist, idx - prev_crit)
                prev_crit = idx
            
            prev = curr
            curr = curr.next
            idx += 1
            
        if min_dist == float('inf'):
            return [-1, -1]
        
        return [min_dist, prev_crit - first_crit]