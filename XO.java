import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class XO implements ActionListener {
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title = new JPanel();
	JPanel button = new JPanel();
	JLabel text = new JLabel();
	JButton[] butt = new JButton[9];
	boolean turn_1;
	
	
	XO(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TIC-TAC-TOE");
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(120,20,37));
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\Game_01\\src\\BATMAN.png");
		frame.setIconImage(image.getImage());
		
		text.setBackground(new Color(168,81,138));
		text.setForeground(Color.GREEN);
		text.setFont(new Font("Arial",Font.BOLD,55));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Tic-Tac-Toe");
		text.setOpaque(true);
		
		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 500, 100);
		
		button.setLayout(new GridLayout(3,3));
		button.setBackground(new Color(99,76,24));
		
		for(int i=0;i<9;i++) {
			butt[i]=new JButton();
			button.add(butt[i]);
			butt[i].setFont(new Font("Times New Roman",Font.BOLD,124));
			butt[i].setFocusable(false);
			butt[i].addActionListener(this);
		}
		
		title.add(text);
		frame.add(title,BorderLayout.NORTH);
		frame.add(button);
		
		firstturn();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==butt[i]) {
				if(turn_1) {
					if(butt[i].getText()=="") {
						butt[i].setForeground(new Color(71,71,71));
						butt[i].setText("X");
						turn_1=false;
						text.setText("O plays");
						check();
					}
				}
				else {
					if(butt[i].getText()=="") {
						butt[i].setForeground(new Color(17,17,17));
						butt[i].setText("O");
						turn_1=true;
						text.setText("X plays");
						check();
					}	
				}	
			}
		}
	}
	public void firstturn(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			turn_1=true;
			text.setText("X plays");
		}
		else {
			turn_1=false;
			text.setText("O plays");
		}
			
		
	}
	public void check() {
		if((butt[0].getText()=="X")&&(butt[1].getText()=="X")&&(butt[2].getText()=="X")) {
			xW(0,1,2);
		}
		if((butt[3].getText()=="X")&&(butt[4].getText()=="X")&&(butt[5].getText()=="X")) {
			xW(3,4,5);
		}
		if((butt[6].getText()=="X")&&(butt[7].getText()=="X")&&(butt[8].getText()=="X")) {
			xW(6,7,8);
		}
		if((butt[0].getText()=="X")&&(butt[3].getText()=="X")&&(butt[6].getText()=="X")) {
			xW(0,3,6);
		}
		if((butt[4].getText()=="X")&&(butt[1].getText()=="X")&&(butt[7].getText()=="X")) {
			xW(4,1,7);
		}
		if((butt[2].getText()=="X")&&(butt[5].getText()=="X")&&(butt[8].getText()=="X")) {
			xW(2,5,8);
		}
		if((butt[0].getText()=="X")&&(butt[4].getText()=="X")&&(butt[8].getText()=="X")) {
			xW(0,4,8);
		}
		if((butt[2].getText()=="X")&&(butt[4].getText()=="X")&&(butt[6].getText()=="X")) {
			xW(2,4,6);
		}
		if((butt[0].getText()=="O")&&(butt[1].getText()=="O")&&(butt[2].getText()=="O")) {
			oW(0,1,2);
		}
		if((butt[3].getText()=="O")&&(butt[4].getText()=="O")&&(butt[5].getText()=="O")) {
			oW(3,4,5);
		}
		if((butt[6].getText()=="O")&&(butt[7].getText()=="O")&&(butt[8].getText()=="O")) {
			oW(6,7,8);
		}
		if((butt[0].getText()=="O")&&(butt[3].getText()=="O")&&(butt[6].getText()=="O")) {
			oW(0,3,6);
		}
		if((butt[4].getText()=="O")&&(butt[1].getText()=="O")&&(butt[7].getText()=="O")) {
			oW(4,1,7);
		}
		if((butt[2].getText()=="O")&&(butt[5].getText()=="O")&&(butt[8].getText()=="O")) {
			oW(2,5,8);
		}
		if((butt[0].getText()=="O")&&(butt[4].getText()=="O")&&(butt[8].getText()=="O")) {
			oW(0,4,8);
		}
		if((butt[2].getText()=="O")&&(butt[4].getText()=="O")&&(butt[6].getText()=="O")) {
			oW(2,4,6);
		}
	}
	public void xW(int a,int b,int c) {
		butt[a].setBackground(Color.ORANGE);
		butt[b].setBackground(Color.ORANGE);
		butt[c].setBackground(Color.ORANGE);
		
		for(int i=0;i<9;i++) {
			butt[i].setEnabled(false);
		}
		text.setText("X win");
	}
	public void oW(int a,int b,int c) {
		butt[a].setBackground(Color.RED);
		butt[b].setBackground(Color.RED);
		butt[c].setBackground(Color.RED);
		
		for(int i=0;i<9;i++) {
			butt[i].setEnabled(false);
		}
		text.setText("O win");
		}
}
