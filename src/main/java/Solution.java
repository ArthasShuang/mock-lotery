import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public static int singleNumber(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.get(num)==null){
                map.put(num, 1);
            }else {
                map.put(num, map.get(num)+1);
            }
        }
        int result = map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), 1)).findFirst().orElse(null).getKey();
        return result;
    }
    public static void main(String[] args){
        int[] nums = {2, 3, 4, 5, 5, 4, 3};
        System.out.println(singleNumber(nums));
    }
}