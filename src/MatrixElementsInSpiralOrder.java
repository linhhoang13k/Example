class MatrixElementsInSpiralOrder {
    int[] matrixElementsInSpiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length;
        if (matrix.length == 0) {
            return new int[0];
        }
        int colStart = 0;
        int colEnd = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        while (rowStart < rowEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++) {
                list.add(matrix[rowStart][i]);
                System.out.print(matrix[rowStart][i] + ">");
            }
            rowStart++;
            if (rowEnd == rowStart)
                break;
            for (int j = rowStart; j < rowEnd; j++) {
                list.add(matrix[j][colEnd - 1]);
                System.out.print(matrix[j][colEnd - 1] + "D");
            }

            colEnd--;
            if (colEnd == colStart)
                break;
            for (int i = colEnd - 1; i >= colStart; i--) {
                list.add(matrix[rowEnd - 1][i]);
                System.out.print(matrix[rowEnd - 1][i] + "<");
            }
            rowEnd--;
            for (int j = rowEnd - 1; j >= rowStart; j--) {
                list.add(matrix[j][colStart]);
                System.out.print(matrix[j][colStart] + "U");
            }
            colStart++;
            System.out.println("%");
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}