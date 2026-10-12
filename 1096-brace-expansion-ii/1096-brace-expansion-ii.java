class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = new HashSet<>();
        
        int firstBrace = expression.indexOf('{');
        if (firstBrace == -1) {
            result.add(expression);
            List<String> sortedList = new ArrayList<>(result);
            Collections.sort(sortedList);
            return sortedList;
        }
        
        int lastBrace = -1;
        int depth = 0;
        for (int i = firstBrace; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') depth++;
            else if (expression.charAt(i) == '}') depth--;
            
            if (depth == 0) {
                lastBrace = i;
                break;
            }
        }
        
        String prefix = expression.substring(0, firstBrace);
        String middle = expression.substring(firstBrace + 1, lastBrace);
        String suffix = expression.substring(lastBrace + 1);
        
        List<String> subExpressions = new ArrayList<>();
        int commaDepth = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : middle.toCharArray()) {
            if (c == '{') commaDepth++;
            else if (c == '}') commaDepth--;
            
            if (c == ',' && commaDepth == 0) {
                subExpressions.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        subExpressions.add(sb.toString());
        
        for (String sub : subExpressions) {
            List<String> expanded = braceExpansionII(prefix + sub + suffix);
            result.addAll(expanded);
        }
        
        List<String> sortedList = new ArrayList<>(result);
        Collections.sort(sortedList);
        return sortedList;
    }
}