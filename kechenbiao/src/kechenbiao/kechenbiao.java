package kechenbiao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class kechenbiao implements TableModel {
	private String[] title= {
			"周一","周二","周三","周四","周五","周六","周日"
	};
	private String[][] data=new String[8][7];
	public kechenbiao()
	{
		for(int i=0;i<data.length;i++)
			for(int j=01;j< data.length-1;j++)//j<data[i].length=7;
			{
				data[i][j]=" ";
			}
			
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		

	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		
		return String.class;  //数据都是String
	}
	

	@Override
	public int getColumnCount() {  //表格列数
		
		return 7;
	}

	@Override
	public String getColumnName(int arg0) { //每一列的名称
		
		return title[arg0];
	}

	@Override
	public int getRowCount() {  //表格行数
		
		return 8;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		return data[arg0][arg1];
	}
	

	@Override      //是否是格子编辑表
	public boolean isCellEditable(int arg0, int arg1) {
		
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		data[arg1][arg2] = (String)arg0;

	}

}
