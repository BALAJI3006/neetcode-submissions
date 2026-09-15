// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         ArrayList<HashMap<Character,Integer>> result = new ArrayList<>();
//         List<List<String>> res = new ArrayList<>();
//         ArrayList<Boolean> picked = new ArrayList<>();
//         for(int i=0;i<strs.length;i++){
//             result.add(new HashMap<>());
//             res.add(new ArrayList<>());
//             picked.add(false);
//         }
//         for(int i=0;i<strs.length;i++){
//             for(int j=0;j<strs[i].length();j++){
//                 result.get(i).put(strs[i].charAt(j),result.get(i).getOrDefault(strs[i].charAt(j),0)+1);
//             }
//         }
//         for(int i=0;i<result.size();i++){
//             if(!picked.get(i)){
//                 HashMap<Character,Integer> map1 = result.get(i);
//                 res.get(i).add(strs[i]);
//                 for(int j=i+1;j<result.size();j++){
//                     HashMap<Character,Integer> map2 = result.get(j);
//                     if(map1.equals(map2)){
//                         // picked.set(i,true);
//                         picked.set(j,true);
//                         res.get(i).add(strs[j]);
//                     }
//                 }
//             }
//             // if(res.get(i).isEmpty()){
//             //     res.remove(i);
//             // }
//         }
//         // for(int i=0;i<result.)
//         System.out.println(picked);

//         System.out.println(res);

//         return res;
//     }
// }
// import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Create a canonical form by sorting the string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Add the original string to the appropriate group
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }

        // Collect all the grouped anagrams
        return new ArrayList<>(map.values());
    }
}

