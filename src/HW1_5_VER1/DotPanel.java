package HW1_5_VER1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;
import javax.swing.Timer;


public class DotPanel extends JPanel implements ActionListener {
	private int offsetX;
	private int offsetY;
	private int width;
	private int height;
	private DotList dots;
	private Timer T ;
	private int x;
	
	private Arc2D.Float X1;
	private Pacman p;
	private int XX;
	private int fade;
	private int diameter;
	private int direction;
	
	

	public DotPanel(int width, int height) {
		this.width = width;
		this.height=height;
		this.offsetX = 20;
		this.offsetY = 20;
		dots = new DotList(width, height, 10,30 );
		T = new Timer(200, this);
		this.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent event) {   
	        	 T.start();
	         }
	      });
		
	}

	public DotPanel(int width, int height, int offsetX, int offsetY) {
		this.XX=0;
		this.fade=0;
		this.diameter=40;
		this.direction=1;
		
		this.p = new Pacman(diameter,0,0,direction);
		this.width = width;
		this.height=height;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		dots = new DotList(width, height, 10,30 );
		T = new Timer(100, this);
		this.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent event) {   
	        	 T.start();
	         }
	      });

		
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(255, 100, 100));
		g2.drawRect(offsetX, offsetY, width, height);
		
		for (int i = 0; i < dots.getDots().size(); i++) {
			
			if(dots.getDots().get(i).isVisible())
			g2.fillOval(offsetX+dots.getDots().get(i).getX()-5, offsetX+dots.getDots().get(i).getY()-5, dots.getDots().get(i).getSize(), dots.getDots().get(i).getSize());
		}

		//pacman
		if (XX%2==0){ // �غ�ء���駷�� xx ���Ţ���
			//ત�������ѹ�غ�ҡ
			if (direction==0){
				X1 = new Arc2D.Float(p.getX(), p.getY(), p.getDiameter(), p.getDiameter(), -180, 360, Arc2D.PIE);
			}
			if (direction==1){
				X1 = new Arc2D.Float(p.getX(), p.getY(), p.getDiameter(), p.getDiameter(), 0, 360, Arc2D.PIE);
			}
			if (direction==2){
				X1 = new Arc2D.Float(p.getX(), p.getY(), p.getDiameter(), p.getDiameter(), 90, 360, Arc2D.PIE);
			}
			if (direction==3){
				X1 = new Arc2D.Float(p.getX(), p.getY(), p.getDiameter(), p.getDiameter(), -90, 360, Arc2D.PIE);
			}
		}
		//��һҡ
		else X1 = new Arc2D.Float(p.getX(), p.getY(), p.getDiameter(), p.getDiameter(), p.getStartAngle(), p.getEndAngle(), Arc2D.PIE);
		g2.setBackground(Color.BLUE);
		g2.setColor(Color.YELLOW);
		g2.fill(X1);
		g2.setColor(Color.BLACK);
		g2.draw(X1);
		g2.setColor(Color.BLACK);
		g2.fillOval(p.getEyeX(), p.getEyeY(), p.getEyeSize(),p.getEyeSize());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (dots.isAllClear()){
			dots.genDots(10, 30);
			XX=0;
			x=0;
			//repaint();
		}
		//pacman
		

		if (fade==0&&p.getX()+(diameter+5)>=this.getWidth()){ //������ŧ����ͪ��ͺ�͡��ҧ 360
			direction=3;
			p.setDirection(3);
			fade=1;
		}
		else if  (fade==1&&p.getY()+(diameter+5)>=this.getHeight()){ //�����ǫ�������ͪ��ͺ�͡��ҧ 380
			direction=0;
			p.setDirection(0);
			fade=2;
		}
		else if (fade==2&&p.getX()<=0) { //�����Ǣ������ͪ��������
			direction=2;
			p.setDirection(2);
			fade=3;
		}
		else if (p.getY()<=0&&p.getX()<=0) { //�����Ǣ������Ͷ֧�ش�������
			direction=1;
			p.setDirection(1);
			fade=0;
		}
		p.move(10);
		
		
		if (XX%3==0&&x<dots.getDots().size()){
			dots.getDots().get(x).setVisible(false);
			x++;
			//repaint();
		}
	
		XX++;
		this.repaint();
		

	}

}