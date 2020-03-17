package field;

import java.util.ArrayList;

import cell.Cell;

public class Field {
	
	private static final Location[] adjacent = {
		new Location(-1,-1),new Location(-1,0),new Location(-1,1),
		new Location(0,-1), new Location(0,0), new Location(0,1),
		new Location(1,-1), new Location(1,0), new Location(1,1)
	};
	private int width;
	private int height;
	private Cell[][] field;   
	
	//1
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Cell[height][width];
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	//cell是抽象类，但是其他实现了cell的类的对象就可以，field不在乎，只要你是cell（实现cell的fox和rabbit）就可以了
	public Cell place(int row, int col, Cell o) {   //
		Cell ret = field[row][col];                 //field需要cell,但fox和rabbit都实现了cell，就可以用fox和rabbit的对象，通过cell的桥梁
		field[row][col] = o;
		return ret;
	}
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	
	public Cell[] getNeighbour(int row, int col) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) ) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);
	}
	
	
	public Location[] getFreeNeighbour(int row, int col) {    //得到周边空的邻居
		ArrayList<Location> list = new ArrayList<Location>();
		for ( Location loc : adjacent ) {
			int r = row+loc.getRow();
			int c = col+loc.getCol();
			if ( r >-1 && r<height && c>-1 && c<width && field[r][c] == null ) {
				list.add(new Location(r,c));
			}
		}
		return list.toArray(new Location[list.size()]);
	}
	
	////////////////////////////////////////////
	public boolean placeRandomAdj(int row, int col, Cell cell) {       //按一定的概率放入任意的邻居中
		boolean ret = false;
		Location[] freeAdj = getFreeNeighbour(row, col);
		if ( freeAdj.length >0 ) {
			int idx = (int)(Math.random()*freeAdj.length);
			field[freeAdj[idx].getRow()][freeAdj[idx].getCol()] = cell;
			ret = true;
		}
		return ret;
	}
	//？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
	
	
	public Cell remove(int row, int col) {
		Cell ret = field[row][col];
		field[row][col] = null;
		return ret;
	}
	
	public void remove(Cell cell) {
		for ( int row = 0; row < height; row++ ) {
			for ( int col = 0; col < width; col++ ) {
				if ( field[row][col] == cell ) {
					field[row][col] = null;
					break;
				}
			}
		}
	}
	
	public void clear() {
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}

	public void move(int row, int col, Location loc) {
		field[loc.getRow()][loc.getCol()] = field[row][col];
		remove(row, col);
	}
}

