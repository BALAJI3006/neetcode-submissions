class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder("");
        for(String i:strs){
            s.append(i);
            s.append("\u241F");
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> res = new ArrayList<>();
        String s="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='\u241F'){
                res.add(s);
                s="";
            }else{
                s+=""+str.charAt(i);
            }
        }
        return res;
    }
}
