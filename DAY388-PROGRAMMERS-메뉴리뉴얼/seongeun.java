import java.util.*;

class Solution {
    
    private static HashMap<String,Integer> map;
    private static int limit = 0;
    private static String order = "";
    private static int max = 0;
    private static void dfs(String tmp, int index, int start) {
        
        if(limit == index) {
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            max = Math.max(max, map.get(tmp));
        } else {
            for( int i = start; i < order.length(); i++) {
                dfs(tmp + order.charAt(i), index + 1, i + 1);
            }
        }
    }
    
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();
        
        //orders 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] str = orders[i].toCharArray();
            Arrays.sort(str);
            orders[i] = String.valueOf(str);
        }
        
        for(int i = 0; i < course.length; i++) {
            max = 0;
            limit = course[i];
            map = new HashMap<>();
            
            //단품으로 가능한 모든 조합 찾기
            for(int j = 0; j < orders.length; j++) {
                order = orders[j];
                //tmp, index, start
                dfs("", 0, 0);
            }
                        
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= 2 && max == entry.getValue()) {
                    result.add(entry.getKey());
                }
            }
            
        }
        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }
}
