public class isSequenceChallenge {

    public boolean isSubsequence(String s, String t) {

        //Loop through longest String
        //If String are equal length, they must be identical to pass

        //String temp = "";
        /*if(t.length() > s.length()){
            temp = s;
            s = t ;
            t = temp; // s will always be the longer string
        } */ // Apparently T is always less than S.
        //Two Strings can only be equal when the string size is equal. 
        //This, therefore, handles when t.size == t.size
        if(t.equals(s)){
            return true;
        }

        if(s.length() == 0){
            return true;
        }

        //Let the search begin. We start by looking through t for the char at s[0]
        int target = 0;

        for(int i = 0; i < t.length(); i++){
            //System.out.print(t.charAt(i));

            if(s.charAt(target) == t.charAt(i)){ //Found a match!
                target++;
                //System.out.println(target);
                if(target == s.length()) return true; //Match complete

            }

        }




        return false;
    }


    public static void main(String[] args) {

        String string1 = "axc";
        String string2 = "ahbgdc";

        isSequenceChallenge sequence = new isSequenceChallenge();
        boolean condition = sequence.isSubsequence(string1, string2);
        System.out.println(condition);
        
    }
    
}
