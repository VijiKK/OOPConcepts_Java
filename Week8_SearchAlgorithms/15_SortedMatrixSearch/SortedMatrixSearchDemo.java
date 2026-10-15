/*
 * CONCEPT: Search a matrix whose rows and columns are both sorted ascending.
 *
 * Start at the top-right corner. A value larger than the target eliminates its
 * column, so move left. A smaller value eliminates its row, so move down.
 * The method takes O(rows + columns) time and O(1) auxiliary space.
 */
public class SortedMatrixSearchDemo {

    static int[] search(int[][] matrix, int target) {
        int row = 0;                       // Begin in the first row.
        int column = matrix[0].length - 1; // Begin in the last column.

        while (row < matrix.length && column >= 0) {
            int current = matrix[row][column];
            System.out.println("Check [" + row + "][" + column + "] = " + current);

            if (current == target) {
                return new int[]{row, column};
            }

            if (current > target) {
                column--; // Everything below is even larger; eliminate this column.
            } else {
                row++; // Everything left is smaller; eliminate this row.
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        int[] position = search(matrix, 6);
        System.out.println("Target 6 found at row " + position[0]
                + ", column " + position[1]);
    }
}
