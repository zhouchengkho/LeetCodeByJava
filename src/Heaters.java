import java.util.Arrays;

/**
 * Created by zhoucheng on 7/26/17.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int res = Math.abs(houses[0] - heaters[0]);
        for(int house : houses) {
            while(i < heaters.length-1 && (heaters[i] + heaters[i+1]) < house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(house-heaters[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Heaters solution = new Heaters();
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println(solution.findRadius(houses, heaters));
    }
}
