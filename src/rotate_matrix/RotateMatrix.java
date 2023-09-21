package rotate_matrix;

public class RotateMatrix {
    public static int[][] rotateMatrix(int[][] matrix) {
        int lastElement = matrix.length - 1;
        return rotateLayer(matrix, 0, lastElement, 0, lastElement);
    }
    private static int[][] rotateLayer(int[][] matrix, int top, int bottom, int left, int right) {
        int counter = 0;
        for(int i = left; i < right; i++) {
            matrix = swap(matrix, bottom - counter, left, top, left + counter);
            matrix = swap(matrix, bottom, right - counter, bottom - counter, left);
            matrix = swap(matrix, top + counter, right, bottom, right - counter);
            counter++;
        }
        top++;
        bottom--;
        left++;
        right--;
        if(top < bottom) {
            return rotateLayer(matrix, top, bottom, left, right);
        }
        return matrix;
    }
    private static int[][] swap(int[][] matrix, int firstRow, int firstColumn, int secondRow, int secondColumn) {
        int temp = matrix[firstRow][firstColumn];
        matrix[firstRow][firstColumn] = matrix[secondRow][secondColumn];
        matrix[secondRow][secondColumn] = temp;
        return matrix;
    }
    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            int j;
            StringBuilder stringBuilder = new StringBuilder("Row ");
            stringBuilder.append(i);
            stringBuilder.append(" : ");
            System.out.print(stringBuilder);
            for(j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };
        matrix = rotateMatrix(matrix);
        printMatrix(matrix);
    }
}
