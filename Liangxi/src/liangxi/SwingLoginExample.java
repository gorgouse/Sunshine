package liangxi;
//Component add(Component comp)	��ָ�������׷�ӵ���������β��   JFrame��
//void remove(Component comp)	���������Ƴ�ָ�������
//void setFont(Font f)	��������������
//void setLayout(LayoutManager mgr)	���������Ĳ��ֹ�����
//void setBackground(Color c)	��������ı���ɫ
//Panel ��һ���м�������������������������������һ�𣬵������������ӵ�����������ʹ�á�
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
public class SwingLoginExample {
    
    public static void main(String[] args) {    
        // ���� JFrame ʵ��
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ������壬��������� HTML �� div ��ǩ
         * ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
         * ��������ǿ�������ı��ֶΣ���ť�����������
         */
        JPanel panel = new JPanel();    
        // ������
        frame.add(panel);
        /* 
         * �����û�����ķ����������������
         */
        placeComponents(panel);

        // ���ý���ɼ�
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* ���ֲ���������߲���������
         * ������ò���Ϊ null
         */
        panel.setLayout(null);

        // ���� JLabel
        JLabel userLabel = new JLabel("User:");
        /* ������������������λ�á�
         * setBounds(x, y, width, height)
         * x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* 
         * �����ı��������û�����
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // ����������ı���
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /* 
         *�����������������ı���
         * �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // ������¼��ť
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }

}
////JFrame �C java��GUI����Ļ���˼·����JFrameΪ������������Ļ��window�Ķ����ܹ���󻯡���С�����رա�

//JPanel �C Javaͼ���û�����(GUI)���߰�swing�е���������࣬������javax.swing ���У����Խ���Ƕ�ף������ǶԴ����о�����ͬ�߼����ܵ����������ϣ���һ�����������������Լ��뵽JFrame�����С���
//
//JLabel �C JLabel ���������ʾ�ı���ͼ���ͬʱ��ʾ���ߡ�����ͨ�����ô�ֱ��ˮƽ���뷽ʽ��ָ����ǩ��ʾ���б�ǩ�����ںδ����롣Ĭ������£���ǩ������ʾ���ڴ�ֱ���ж��롣Ĭ������£�ֻ��ʾ�ı��ı�ǩ�ǿ�ʼ�߶��룻��ֻ��ʾͼ��ı�ǩ��ˮƽ���ж��롣
//
//JTextField �Cһ�������������������༭�����ı���
//
//JPasswordField �C ��������������һ����������򣬵������Ǻ�(*) ��㴴������(����)
//
//JButton �C JButton ���ʵ�������ڴ�����ť����ʵ���е� "Login"��

