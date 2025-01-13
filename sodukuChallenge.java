import java.util.HashSet;

public class sodukuChallenge {

    public boolean areRowsCorrect(char[][] board){

        HashSet<Character> seen = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                //System.out.print(board[i][j] + " ");
                if(board[i][j] != '.'){
                    if(!seen.contains(board[i][j])){
                        seen.add(board[i][j]);
                        //System.out.print(board[i][j] + " ");
                    } else {
                        seen.clear();
                        return false; 
                    }
                }

                

            }
            System.out.println();
            seen.clear();

        }
        return true;

    }


    public boolean areColumnsCorrect(char[][] board){
        HashSet<Character> seen = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                //System.out.print(board[i][j] + " ");
                if(board[j][i] != '.'){
                    if(!seen.contains(board[j][i])){
                        seen.add(board[j][i]);
                        //System.out.print(board[j][i] + " ");
                    } else {
                        seen.clear();
                        return false; 
                    }
                }

                

            }
            System.out.println();
            seen.clear();

        }
        return true;
    }

    public boolean areThreeByThreeCorrect(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Character> seen = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.') {
                            if (!seen.add(board[i][j])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        
        if(areRowsCorrect(board) && areColumnsCorrect(board) && areThreeByThreeCorrect(board)){
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        sodukuChallenge soduku = new sodukuChallenge();
        char[][] board = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};


        boolean value = soduku.areRowsCorrect(board);
        boolean value2 = soduku.areColumnsCorrect(board);
        boolean value3 = soduku.areThreeByThreeCorrect(board);
        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);
    }
    
}
