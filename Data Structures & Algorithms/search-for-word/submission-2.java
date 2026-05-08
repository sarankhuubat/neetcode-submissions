class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == word.charAt(0)){
                    if(helper(r, c, board, word, 0))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean helper(int r, int c, char[][] board, String word, int i){
        if(r >= board.length || r < 0 || c >= board[0].length || 
            c < 0 || board[r][c] != word.charAt(i)){
            return false;
        } else if(i == word.length() - 1){
            return true;
        }

        board[r][c] = '#';
        if(helper(r - 1, c, board, word, i + 1) ||
            helper(r + 1, c, board, word, i + 1) ||
            helper(r, c - 1, board, word, i + 1) ||
            helper(r, c + 1, board, word, i + 1)){
                return true;
            }

        board[r][c] = word.charAt(i);
        return false;
    }
}
