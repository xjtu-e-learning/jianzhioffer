package com.elearning.chapter2;

public class P2_3 {
    public boolean find_in_martix(int target, int [][] matrix)
    {
        if (matrix != null)
        {
            int row = matrix.length;
            int col = matrix[0].length;
            for (int i = 0; i < row; ++i)
                for(int j = 0; j < col; ++j)
                {
                    if (matrix[i][j] == target)
                        return true;
                    if (matrix[i][j] < target)
                        continue;
                    break;
                }
        }
        return false;

    }
}
