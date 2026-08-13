class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        n = len(s)
        tree_max = [0] * (4 * n)
        tree_prefix = [0] * (4 * n)
        tree_suffix = [0] * (4 * n)
        tree_left_char = [''] * (4 * n)
        tree_right_char = [''] * (4 * n)
        tree_len = [0] * (4 * n)

        def merge(node, left_child, right_child):
            tree_len[node] = tree_len[left_child] + tree_len[right_child]
            tree_left_char[node] = tree_left_char[left_child]
            tree_right_char[node] = tree_right_char[right_child]

            tree_prefix[node] = tree_prefix[left_child]
            if tree_prefix[left_child] == tree_len[left_child] and tree_right_char[left_child] == tree_left_char[right_child]:
                tree_prefix[node] += tree_prefix[right_child]

            tree_suffix[node] = tree_suffix[right_child]
            if tree_suffix[right_child] == tree_len[right_child] and tree_right_char[left_child] == tree_left_char[right_child]:
                tree_suffix[node] += tree_suffix[left_child]

            tree_max[node] = max(tree_max[left_child], tree_max[right_child])
            if tree_right_char[left_child] == tree_left_char[right_child]:
                tree_max[node] = max(tree_max[node], tree_suffix[left_child] + tree_prefix[right_child])

        def build(node, start, end):
            if start == end:
                tree_max[node] = 1
                tree_prefix[node] = 1
                tree_suffix[node] = 1
                tree_left_char[node] = s[start]
                tree_right_char[node] = s[start]
                tree_len[node] = 1
                return

            mid = (start + end) // 2
            left_child = 2 * node
            right_child = 2 * node + 1
            build(left_child, start, mid)
            build(right_child, mid + 1, end)
            merge(node, left_child, right_child)

        def update(node, start, end, idx, ch):
            if start == end:
                tree_left_char[node] = ch
                tree_right_char[node] = ch
                return

            mid = (start + end) // 2
            left_child = 2 * node
            right_child = 2 * node + 1
            if idx <= mid:
                update(left_child, start, mid, idx, ch)
            else:
                update(right_child, mid + 1, end, idx, ch)
            merge(node, left_child, right_child)

        build(1, 0, n - 1)

        ans = []
        for ch, idx in zip(queryCharacters, queryIndices):
            update(1, 0, n - 1, idx, ch)
            ans.append(tree_max[1])

        return ans