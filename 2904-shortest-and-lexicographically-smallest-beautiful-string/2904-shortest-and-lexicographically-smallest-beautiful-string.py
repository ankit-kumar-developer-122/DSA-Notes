class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        ans = ""
        for i in range(len(s)):
            for j in range(i, len(s)):
                sub = s[i:j+1]
                if sub.count('1') == k:
                    if not ans:
                        ans = sub
                    elif len(sub) < len(ans):
                        ans = sub
                    elif len(sub) == len(ans) and sub < ans:
                        ans = sub
        return ans