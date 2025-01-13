public class palindromeChallenge {

    public boolean isPalindrome(String s) {
    

    s = s.toLowerCase();
    s = s.replaceAll("[^a-zA-Z0-9]", ""); //Regex expression. May need to reuse in future
    
    int leftSide = 0;
    int rightSide = s.length()-1;

    if(s.length() < 2){
        return true;
    }

    

    while(rightSide > leftSide){


        //System.out.println("Left side = " + s.charAt(leftSide));
        //System.out.println("Right side = " + s.charAt(rightSide));

        if(s.charAt(rightSide) != s.charAt(leftSide)){
            return false;
        }

        rightSide--;
        leftSide++;


    }



        return true; 
    }



    public static void main(String[] args) {
        String testString = "A man, a plan, a canal: Panama";

        palindromeChallenge palindrome = new palindromeChallenge();
        boolean answer = palindrome.isPalindrome(testString);
        System.out.println(answer);


    }
    
}
