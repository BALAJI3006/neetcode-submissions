class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean isValid=true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(square(board,i,j) && row(board,i) && col(board,j)){
                        continue;
                    }else{
                        isValid=false;
                        break;
                    }
                }
            }
            if(!isValid){
                break;
            }
        }
        return isValid;
    }
    public boolean square(char[][] board,int i,int j){
        HashSet<Character> set  = new HashSet<>();
        int sr = (i/3)*3;
        int sc = (j/3)*3;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if(board[sr+x][sc+y]=='.'){
                    continue;
                }
                if(set.add(board[sr+x][sc+y])){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public boolean row(char[][] board,int row){
        HashSet<Character> set  = new HashSet<>();
        for(int i=0;i<9;i++){
            if(board[row][i]=='.'){
                continue;
            }
            if(set.add(board[row][i])){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean col(char[][] board,int col){
        HashSet<Character> set  = new HashSet<>();
        for(int i=0;i<9;i++){
            if(board[i][col]=='.'){
                continue;
            }
            if(set.add(board[i][col])){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
