package g2048.gamerules;

public class Board {
    private int[][] map;
    public static final int NUMBER_FIXED=2;

    public Board(){
        map= new int[4][4];
        addNumberRandomPosition();
    }

    public Board(int[][] matrix){
        this.map=matrix;
    }

    public void move(Direction dir){
        switch (dir){
            case UP:
                displacement(3);
                addNumberRandomPosition();
                break;
            case LEFT:
                transposeMatrix();
                displacement(3);
                transposeMatrix();
                addNumberRandomPosition();
                break;
            case RIGHT:
                transposeMatrix();
                displacement(0);
                transposeMatrix();
                addNumberRandomPosition();
                break;
            case DOWN:
                displacement(0);
                addNumberRandomPosition();
                break;
        }
    }

    private void displacement(int variation) {
        for(int j=3; j>=0; j--){
            for(int i=3; i>=0; i--){
                int y=Math.abs(variation-i);  //row
                removeZeros(j,i,variation);
                if(map[y][j]!=0){
                    sum(j,i,variation);
                }
            }
        }
    }

    private void removeZeros(int col, int row, int variation){
        int currentRow=Math.abs(row-variation);
        if(map[currentRow][col]==0){
            for(int k=row-1; k>=0; k--){
                int y=Math.abs(variation-k);
                if(map[y][col]!=0){
                    map[currentRow][col]=map[y][col];
                    map[y][col]=0;
                    break;
                }
            }
        }
    }
    private void sum(int col, int row, int variation){
        int currentRow=Math.abs(variation-row);
        for(int k=row-1; k>=0; k--){
            int y=Math.abs(variation-k);
            if(map[y][col]!=0){
                if(map[y][col]==map[currentRow][col]){
                    map[currentRow][col]*=2;
                    map[y][col]=0;
                }
                break;
            }
        }
    }

    public void transposeMatrix(){
        for(int i=0; i< map.length;i++){
            for(int j=i; j< map[i].length ;j++){
                int varAux = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = varAux;
            }
        }
    }

    private void addNumberRandomPosition(){
        boolean addedNumber=false;
        if(containsNumber(0)){
            while(!addedNumber){
                int row=(int)(Math.random()*4);
                int col=(int)(Math.random()*4);
                if(map[row][col]==0){
                    map[row][col]=NUMBER_FIXED;
                    addedNumber=true;
                }
            }
        }

    }

    public boolean containsNumber(int number){
        boolean res=false;
        for(int i=0;i<map.length;i++){
            for(int j=0; j< map[i].length; j++){
                if(map[i][j]==number){
                    res=true;
                    break;
                }
            }
        }
        return res;
    }

    public boolean canMove(){
        boolean res=false;
        for(int i=0;i<map.length-1;i++){
            for(int j=0; j< map[i].length-1; j++){
                if(map[i][j]==0 || map[i][j]==map[i][j+1] || map[i][j]==map[i+1][j])
                    return true;
            }
        }
        return res;
    }
    public int[][] copyMap(){
        int[][] mapCopy= new int[map.length][map.length];
        for(int i=0;i<map.length;i++){
            for(int j=0; j< map[i].length; j++){
                mapCopy[i][j]= map[i][j];
            }
        }
        return mapCopy;
    }
    @Override
    public boolean equals(Object obj) {
        boolean res=false;
        if(obj instanceof Board){
            int[][] mapAux=((Board) obj).map;
            if(mapAux.length==map.length){
                res=true;
                for(int i=0; i<mapAux.length&&res; i++){
                    for(int j=0; j<mapAux.length&&res; j++){
                        if(mapAux[i][j]!=map[i][j]){
                            res=false;
                        }
                    }
                }
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String res="";
        for(int i=0; i<map.length; i++){
            for(int j=0; j< map.length; j++){
                res+= map[i][j]+" ";
            }
            res+="\n";
        }
        return res;
    }
}
