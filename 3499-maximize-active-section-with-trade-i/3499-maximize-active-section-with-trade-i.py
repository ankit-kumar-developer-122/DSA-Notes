class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        t = "1" + s + "1"
        n = len(t)
        
        # String ko continuous (char, length) blocks mein convert karo
        segments = []
        i = 0
        while i < n:
            j = i
            while j < n and t[j] == t[i]:
                j += 1
            segments.append((t[i], j - i))
            i = j
            
        m = len(segments)
        original_ones = s.count('1')
        max_gain = 0
        
        # Har 1-block ke liye check karo jo dono taraf 0-blocks se surrounded hai
        # Us '1' block ko '0' banane par adjacent 0-blocks merge hokar (len1 + len2) extra gain denge
        for idx in range(1, m - 1):
            char, _ = segments[idx]
            if char == '1' and segments[idx - 1][0] == '0' and segments[idx + 1][0] == '0':
                left_zero_len = segments[idx - 1][1]
                right_zero_len = segments[idx + 1][1]
                
                # Net gain = A + B
                max_gain = max(max_gain, left_zero_len + right_zero_len)
                
        return original_ones + max_gain