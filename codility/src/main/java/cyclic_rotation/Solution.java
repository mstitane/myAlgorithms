package cyclic_rotation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        int[] result = new Solution().solution(new int[] {  }, 3);
        System.out.println("The result is " + Arrays.toString(result));
    }

    public int[] solution(int[] A, int K) {
        while (K > 0) {
            A = rotation(A);
            K--;
        }
        return A;
    }

    private int[] rotation(int[] a) {

        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
            list.add(0, a[a.length - 1]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
