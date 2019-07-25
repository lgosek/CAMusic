import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class CA {
    private int[] grid;
    private int rule;

    public CA(int rule) {
        this.grid = new int[]{0, 0, 0, 1, 0, 0, 0, 0};
        this.rule = rule;
    }

    public int cellNextState(int leftCellState, int cellState, int rightCellState){
        int num = 4*leftCellState + 2* cellState + rightCellState;
        int nextState = (this.rule >> num) % 2;
        return nextState;
    }

    public void updateCAState(){
        int[] newGrid = new int[8];
        for(int i=0;i<this.grid.length;i++){
            int left = i-1;
            if(left < 0)
                left += grid.length;
            int right = (i+1) % this.grid.length;
            newGrid[i] = cellNextState(grid[left], grid[i], grid[right]);
        }
        this.grid = newGrid;
    }

    public int[] getGrid() {
        return grid;
    }

    public LinkedList<Integer> getNonZeroIndexes(){
        LinkedList<Integer> ret = new LinkedList<>();
        for (int i=0;i<this.grid.length;i++) {
            if(this.grid[i] != 0)
                ret.add(i);
        }
        return ret;
    }
}
