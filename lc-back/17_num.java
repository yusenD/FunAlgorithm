import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<Character, String> numString = new HashMap<>();
    private List<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        numString.put('0', "");
        numString.put('1', "");
        numString.put('2', "abc");
        numString.put('3', "def");
        numString.put('4', "ghi");
        numString.put('5', "jkl");
        numString.put('6', "mno");
        numString.put('7', "pqrs");
        numString.put('8', "tuv");
        numString.put('9', "wxyz");
        numString.put('*', "");
        numString.put('#', "");
        lookingBack(0, digits);
        return res;
    }

    public void lookingBack(int startIndex, String digits){
        if(startIndex == digits.length()){
            res.add(path.toString());
            return;
        }
        String s = numString.get(digits.charAt(startIndex));
        if(s.length() <= 0){
            lookingBack(startIndex+1, digits);
        }
        for(int i = 0; i < s.length(); i++){
            path.append(s.charAt(i));
            lookingBack(startIndex + 1, digits);
            int lastIndex = path.length()-1;
            path.deleteCharAt(lastIndex);
        }


    }
}