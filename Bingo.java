import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bingo implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title = new JPanel();
	JPanel button = new JPanel();
	JLabel text = new JLabel();
	JButton[] butt = new JButton[25];
	
	Bingo(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BINGO!!!");
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(10,140,247));
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\Game_01\\src\\BATMAN.png");
		frame.setIconImage(image.getImage());
		
		text.setBackground(new Color(18,81,18));
		text.setForeground(Color.PINK);
		text.setFont(new Font("Arial",Font.BOLD,55));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("BINGO!!!");
		text.setOpaque(true);
		
		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 500, 150);
		
		button.setLayout(new GridLayout(5,5));
		button.setBackground(new Color(9,36,124));
		
		String[] sar = new String[25];
		ArrayList<Integer> list = getnos(25, 1, 25);
        for (int i = 0; i < list.size(); i++) {
            sar[i] = "" + list.get(i);
        }
		
		
		for(int i=0;i<25;i++) {
			butt[i]=new JButton();
			button.add(butt[i]);
			butt[i].setFont(new Font("Times New Roman",Font.BOLD,50));
			butt[i].setFocusable(false);
			butt[i].addActionListener(this);
			butt[i].setText(sar[i]);
		}
		
		
		title.add(text);
		frame.add(title,BorderLayout.NORTH);
		frame.add(button);
		
		firstturn();
		
	}
	public static ArrayList<Integer> getnos(int size, int min,
            int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();
        while (numbers.size() < size) {
            int randomNumber = random.nextInt((max - min) + 1) + min;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
 
        return numbers;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<25;i++) {
			if(e.getSource()==butt[i]) {
				butt[i].setForeground(Color.black);
				butt[i].setBackground(Color.yellow);
				check();
			
			}}}
	
	public void firstturn(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		text.setText("Play");
			
		
	}
				
	public void check() {
		int c=0;
		if((butt[0].getBackground()==Color.yellow)&&
			(butt[1].getBackground()==Color.yellow)&&
			(butt[2].getBackground()==Color.yellow)&&
			(butt[3].getBackground()==Color.yellow)&&
			(butt[4].getBackground()==Color.yellow))
			c++;
		if((butt[5].getBackground()==Color.yellow)&&
				(butt[6].getBackground()==Color.yellow)&&
				(butt[7].getBackground()==Color.yellow)&&
				(butt[8].getBackground()==Color.yellow)&&
				(butt[9].getBackground()==Color.yellow))
				c++;
		if((butt[10].getBackground()==Color.yellow)&&
				(butt[11].getBackground()==Color.yellow)&&
				(butt[12].getBackground()==Color.yellow)&&
				(butt[13].getBackground()==Color.yellow)&&
				(butt[14].getBackground()==Color.yellow))
				c++;
		if((butt[15].getBackground()==Color.yellow)&&
				(butt[16].getBackground()==Color.yellow)&&
				(butt[17].getBackground()==Color.yellow)&&
				(butt[18].getBackground()==Color.yellow)&&
				(butt[19].getBackground()==Color.yellow))
				c++;
		if((butt[20].getBackground()==Color.yellow)&&
				(butt[21].getBackground()==Color.yellow)&&
				(butt[22].getBackground()==Color.yellow)&&
				(butt[23].getBackground()==Color.yellow)&&
				(butt[24].getBackground()==Color.yellow))
				c++;		
		if((butt[0].getBackground()==Color.yellow)&&
				(butt[5].getBackground()==Color.yellow)&&
				(butt[10].getBackground()==Color.yellow)&&
				(butt[15].getBackground()==Color.yellow)&&
				(butt[20].getBackground()==Color.yellow))
				c++;
		if((butt[4].getBackground()==Color.yellow)&&
				(butt[8].getBackground()==Color.yellow)&&
				(butt[12].getBackground()==Color.yellow)&&
				(butt[16].getBackground()==Color.yellow)&&
				(butt[20].getBackground()==Color.yellow))
				c++;
		if((butt[0].getBackground()==Color.yellow)&&
				(butt[6].getBackground()==Color.yellow)&&
				(butt[12].getBackground()==Color.yellow)&&
				(butt[18].getBackground()==Color.yellow)&&
				(butt[24].getBackground()==Color.yellow))
				c++;
		if((butt[1].getBackground()==Color.yellow)&&
				(butt[6].getBackground()==Color.yellow)&&
				(butt[11].getBackground()==Color.yellow)&&
				(butt[16].getBackground()==Color.yellow)&&
				(butt[21].getBackground()==Color.yellow))
				c++;
		if((butt[2].getBackground()==Color.yellow)&&
				(butt[7].getBackground()==Color.yellow)&&
				(butt[12].getBackground()==Color.yellow)&&
				(butt[17].getBackground()==Color.yellow)&&
				(butt[22].getBackground()==Color.yellow))
				c++;
		if((butt[3].getBackground()==Color.yellow)&&
				(butt[8].getBackground()==Color.yellow)&&
				(butt[13].getBackground()==Color.yellow)&&
				(butt[18].getBackground()==Color.yellow)&&
				(butt[23].getBackground()==Color.yellow))
				c++;
		if((butt[4].getBackground()==Color.yellow)&&
				(butt[9].getBackground()==Color.yellow)&&
				(butt[14].getBackground()==Color.yellow)&&
				(butt[19].getBackground()==Color.yellow)&&
				(butt[24].getBackground()==Color.yellow))
				c++;
		
		win(c);
	}
	public void win(int a) {
		if(a==1)
				text.setText("B");
		if(a==2)
			text.setText("BI");
		if(a==3)
			text.setText("BIN");
		if(a==4)
			text.setText("BING");		
		if(a>=5) {
			text.setText("You win BINGO!!! ");
			
		
		for(int i=0;i<25;i++) {
			butt[i].setEnabled(false);
		}}
		
	}
	
}
