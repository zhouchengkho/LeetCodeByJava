import org.omg.CORBA.MARSHAL;

/**
 * Created by zhoucheng on 5/11/17.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int left = 0, right = len - 1;
        while(left < right) {
            max = Math.max(max, getArea(left, right, height));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }

    public int getArea(int i , int j, int[] height) {
        return Math.min(height[i], height[j]) * (Math.abs(i - j));
    }
    public static void main(String[] args) {
        // write your code here
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {0, 2};
        System.out.println(solution.maxArea(height));
    }
}
