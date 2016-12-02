package HW1_5_VER1;

import javax.swing.JFrame;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame x = new JFrame("วาดรูปสี่เหลี่ยม กับ วงกลมโง่ๆ");
	
		x.setSize(360, 380);
		x.setVisible(true);
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DotPanel xx = new DotPanel(300, 300, 20, 20);
		x.add(xx);
		
	}

}