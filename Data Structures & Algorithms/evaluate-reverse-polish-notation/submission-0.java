class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") ||tokens[i].equals("-") ||tokens[i].equals("*") ||tokens[i].equals("/") ){
                int one = s.pop();
                int two= s.pop();
                if(tokens[i].equals("+") ){
                    s.push(one+two);
                }else if(tokens[i].equals("-") ){
                    s.push(two-one);
                }else if(tokens[i].equals("*")){
                    s.push(one*two);
                }else{
                    s.push(two/one);
                }
            }else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}
