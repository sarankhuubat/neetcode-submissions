class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i <= board.length -1; i++){
            for(int j = 0; j <= board[0].length - 1; j++){
                if(board[i][j] == word.charAt(0))
                    if(helper(i, j, board, word, 0))
                        return true;
            }
        }

        return false;
    }

    public boolean helper(int i, int j, char[][] board, String word, int index){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }else if(index == word.length() - 1){
            return true;
        }

        board[i][j] = '#';

        if(helper(i-1, j, board, word, index+1) ||
            helper(i+1, j, board, word, index+1) ||
            helper(i, j-1, board, word, index+1) ||
            helper(i, j+1, board, word, index+1))
            return true;
        
        board[i][j] = word.charAt(index);
        return false;

    }
}
