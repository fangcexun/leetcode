package hot100.matrix;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0, left = 0;
        int bottom = row - 1, right = col - 1;

        while (top <= bottom && right >= left) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            // 单行保证不回退
            if (top < bottom) {
                for (int j = right - 1; j > left; j--) {
                    res.add(matrix[bottom][j]);
                }
            }

            // 单列保证不回退
            if (right > left) {
                for (int i = bottom; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return res;
    }
}
