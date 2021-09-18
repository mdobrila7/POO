package task2;

public class MyMatrix implements Sumabil{
    int n;
    int m;
    int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    MyMatrix(int[][] matr, int n, int m) {
        matrix = matr;
        this.n = n;
        this.m = m;
    }

    public void addValue(Sumabil value) {
        if(value instanceof MyMatrix) {
            value = (MyMatrix) value;
            MyMatrix aux = (MyMatrix) value;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m;j ++)
                    matrix[i][j] = matrix[i][j] + aux.getMatrix()[i][j];
        }
    }

}
