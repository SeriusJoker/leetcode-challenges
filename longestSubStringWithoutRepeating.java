import java.util.Arrays;

public class longestSubStringWithoutRepeating {
    
    
    //Making this a method since I am probably going to need it in future challenges
    public boolean contains(String[] array, String value) {
        return Arrays.asList(array).contains(value); 
    }

    public int lengthOfLongestSubstring(String s) {
        char currentChar;
        String[] currentSubString = {};
        int currentGreatestLength = 0;
        
        for(int i = 0; i < s.length(); i++){
            currentChar = s.charAt(i);
            
            if(!contains(currentSubString, Character.toString(currentChar))){
                currentSubString[i] = Character.toString(currentChar);
            }
            System.out.print(currentSubString[i]);
        }
        
        
        
        
        return currentGreatestLength;
    }


    public static void main(String[] args) {
        longestSubStringWithoutRepeating subString = new longestSubStringWithoutRepeating();
        String testString = "abcabcbb";
        subString.lengthOfLongestSubstring(testString);


    }
    
}
