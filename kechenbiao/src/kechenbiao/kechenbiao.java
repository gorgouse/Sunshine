package kechenbiao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class kechenbiao implements TableModel {
	private String[] title= {
			"��һ","�ܶ�","����","����","����","����","����"
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
		
		return String.class;  //���ݶ���String
	}
	

	@Override
	public int getColumnCount() {  //�������
		
		return 7;
	}

	@Override
	public String getColumnName(int arg0) { //ÿһ�е�����
		
		return title[arg0];
	}

	@Override
	public int getRowCount() {  //�������
		
		return 8;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		return data[arg0][arg1];
	}
	

	@Override      //�Ƿ��Ǹ��ӱ༭��
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
