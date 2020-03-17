package field; 
 
import java.util.ArrayList;
 
import cell.Cell;
                         //field:我有这么个cell的二维数组，place放进cell或者get拿出cell
public class Field {   //场地; 田; 地; 牧场; 范围; 领域; 视场; 视野;
	private int width;
	private int height;
	private Cell[][] field;  //领域
 
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Cell[height][width];   //创造一个height*width的网格,30*30个类对象
	}
 
	public int getWidth() {
		return width;
	}
 
	public int getHeight() {
		return height;
	}
 
	public Cell place(int row, int col, Cell o) {  //放入该位置o对象的细胞，返回这个位置
		Cell ret = field[row][col];    
		field[row][col] = o;   
		return ret;  
	}
 
	public Cell get(int row, int col) {
		return field[row][col];  //获取细胞
	}
 
	public Cell[] getNeighbour(int row, int col) {  //column
		ArrayList<Cell> list = new ArrayList<Cell>();
		for (int i = -1; i < 2; i++) {   
			for (int j = -2; j < 2; j++) {  //网格的8个邻居,因为是0-29 所以是-1到1
				int r = row + i;
				int c = col + j;                                       
				if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) //不能等于本身
				{
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);   //Cell[list.size()] 对象数组  每一个元素是field[r][c]
		                                                 //相当于cell[r][c]
	}
 
	public void clear() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = null;
			}
 
		}
	}
 
}

