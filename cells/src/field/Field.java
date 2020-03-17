package field; 
 
import java.util.ArrayList;
 
import cell.Cell;
                         //field:������ô��cell�Ķ�ά���飬place�Ž�cell����get�ó�cell
public class Field {   //����; ��; ��; ����; ��Χ; ����; �ӳ�; ��Ұ;
	private int width;
	private int height;
	private Cell[][] field;  //����
 
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Cell[height][width];   //����һ��height*width������,30*30�������
	}
 
	public int getWidth() {
		return width;
	}
 
	public int getHeight() {
		return height;
	}
 
	public Cell place(int row, int col, Cell o) {  //�����λ��o�����ϸ�����������λ��
		Cell ret = field[row][col];    
		field[row][col] = o;   
		return ret;  
	}
 
	public Cell get(int row, int col) {
		return field[row][col];  //��ȡϸ��
	}
 
	public Cell[] getNeighbour(int row, int col) {  //column
		ArrayList<Cell> list = new ArrayList<Cell>();
		for (int i = -1; i < 2; i++) {   
			for (int j = -2; j < 2; j++) {  //�����8���ھ�,��Ϊ��0-29 ������-1��1
				int r = row + i;
				int c = col + j;                                       
				if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) //���ܵ��ڱ���
				{
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);   //Cell[list.size()] ��������  ÿһ��Ԫ����field[r][c]
		                                                 //�൱��cell[r][c]
	}
 
	public void clear() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = null;
			}
 
		}
	}
 
}

