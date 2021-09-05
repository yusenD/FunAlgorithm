import java.util.List;

class Solution {
    
    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        StringBuilder x = new StringBuilder();
        return res;
    }

    public void backTracking(String s, int startIndex){
        if(startIndex >= s.length()){
            return;
        }
        for(int i = startIndex; i < s.length ; i++){
            String ss = s.substring(startIndex, i);
            if(!isReverseString(ss)){
                continue;
            }

            path.add(ss);

            backTracking(s, i + 1);

            int last = path.size() - 1;
            path.remove(last);
        }
    }

    public boolean isReverseString(String s){
        if(s.length == 1) return true;
        for(int i = 0, j = s.length()-1; i<j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}