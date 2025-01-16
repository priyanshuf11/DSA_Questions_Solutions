class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rowLength=matrix.length;
        int colLength=matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i=0;i<rowLength;i++){
            if(rows.contains(i)){
                for(int j=0;j<colLength;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int i=0;i<colLength;i++){
            if(cols.contains(i)){
                for(int j=0;j<rowLength;j++){
                    matrix[j][i]=0;;
                }
            }
        }
    }
}