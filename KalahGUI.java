package KALAH;

//arun gireesan**

import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class KalahGUI  {
	
	public static Boolean currentState = false;
	public static int V=0;
    private JFrame frame;

    /**
     * Launch the application.
     */
public static void gui() 
    
    {



        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KalahGUI window = new KalahGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */




    public KalahGUI()

    {

        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize()

    {
    	

    	 String AA = Arrays.toString(theGame.A);
         String B[]=AA.substring(1,AA.length()-1).split(", ");
         
         
       
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setBounds(100, 100, 763, 266);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
    	JLabel playerlbl = new JLabel("Player:  "+theGame.Player);
		playerlbl.setForeground(Color.WHITE);
		playerlbl.setFont(new Font("Ubuntu", Font.BOLD, 15));
		playerlbl.setBounds(1, 1, 70, 15);
		frame.getContentPane().add(playerlbl);
        
        
        
        
        Panel panel = new Panel();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 5;
            	frame.dispose();
            	initialize();
            }
        });
        panel.setBackground(Color.WHITE);
        panel.setBounds(123, 36, 79, 59);
        frame.getContentPane().add(panel);

        JLabel lblNewLabel_1 = new JLabel(B[5]);
        panel.add(lblNewLabel_1);

        Panel panel_1 = new Panel();
        panel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 4;
            	frame.dispose();
            	initialize();
            }
        });
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(208, 36, 79, 59);
        frame.getContentPane().add(panel_1);

        JLabel lblNewLabel_2 = new JLabel(B[4]);
        panel_1.add(lblNewLabel_2);

        Panel panel_2 = new Panel();
        panel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 3;
            	frame.dispose();
            	initialize();
            }
        });
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(293, 36, 79, 59);
        frame.getContentPane().add(panel_2);

        JLabel lblNewLabel_3 = new JLabel(B[3]);
        panel_2.add(lblNewLabel_3);

        Panel panel_3 = new Panel();
        panel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 2;
            	frame.dispose();
            	initialize();
            }
        });
        panel_3.setBackground(Color.WHITE);
        panel_3.setBounds(378, 36, 79, 59);
        frame.getContentPane().add(panel_3);

        JLabel lblNewLabel_4 = new JLabel(B[2]);
        panel_3.add(lblNewLabel_4);

        Panel panel_4 = new Panel();
        panel_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 1;
            	frame.dispose();
            	initialize();
            }
        });
        panel_4.setBackground(Color.WHITE);
        panel_4.setBounds(463, 36, 79, 59);
        frame.getContentPane().add(panel_4);

        JLabel lblNewLabel_5 = new JLabel(B[1]);
        panel_4.add(lblNewLabel_5);

        Panel panel_5 = new Panel();
        panel_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 0;
            	frame.dispose();
            	initialize();
            }
        });
        panel_5.setBackground(Color.WHITE);
        panel_5.setBounds(548, 36, 79, 59);
        frame.getContentPane().add(panel_5);

        JLabel lblNewLabel_6 = new JLabel(B[0]);
        panel_5.add(lblNewLabel_6);

        Panel panel_6 = new Panel();
        panel_6.setBackground(Color.WHITE);
        panel_6.setBounds(35, 36, 79, 162);
        frame.getContentPane().add(panel_6);

        JLabel lblNewLabel = new JLabel(B[6]);
        panel_6.add(lblNewLabel);

        Panel panel_7 = new Panel();
        panel_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 7;
            	frame.dispose();
            	initialize();
            }
        });
        panel_7.setBackground(Color.LIGHT_GRAY);
        panel_7.setBounds(123, 139, 79, 59);
        frame.getContentPane().add(panel_7);

        JLabel lblNewLabel_8 = new JLabel(B[7]);
        panel_7.add(lblNewLabel_8);

        Panel panel_8 = new Panel();
        panel_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 8;
            	frame.dispose();
            	initialize();
            }
        });
        panel_8.setBackground(Color.LIGHT_GRAY);
        panel_8.setBounds(208, 139, 79, 59);
        frame.getContentPane().add(panel_8);

        JLabel lblNewLabel_9 = new JLabel(B[8]);
        panel_8.add(lblNewLabel_9);

        Panel panel_9 = new Panel();
        panel_9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 9;
            	frame.dispose();
            	initialize();
            }
        });
        panel_9.setBackground(Color.LIGHT_GRAY);
        panel_9.setBounds(293, 139, 79, 59);
        frame.getContentPane().add(panel_9);

        JLabel lblNewLabel_10 = new JLabel(B[9]);
        panel_9.add(lblNewLabel_10);

        Panel panel_10 = new Panel();
        panel_10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 10;
            	frame.dispose();
            	initialize();
            }
        });
        panel_10.setBackground(Color.LIGHT_GRAY);
        panel_10.setBounds(378, 139, 79, 59);
        frame.getContentPane().add(panel_10);

        JLabel lblNewLabel_11 = new JLabel(B[10]);
        panel_10.add(lblNewLabel_11);

        Panel panel_11 = new Panel();
        panel_11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 11;
            	frame.dispose();
            	initialize();
            }
        });
        panel_11.setBackground(Color.LIGHT_GRAY);
        panel_11.setBounds(463, 139, 79, 59);
        frame.getContentPane().add(panel_11);

        JLabel lblNewLabel_12 = new JLabel(B[11]);
        panel_11.add(lblNewLabel_12);

        Panel panel_12 = new Panel();
        panel_12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            	currentState = true;
            	V = 12;
            	frame.dispose();
            	initialize();
            }
        });
        panel_12.setBackground(Color.LIGHT_GRAY);
        panel_12.setBounds(548, 139, 79, 59);
        frame.getContentPane().add(panel_12);

        JLabel lblNewLabel_13 = new JLabel(B[12]);
        panel_12.add(lblNewLabel_13);

        Panel panel_13 = new Panel();
        panel_13.setBackground(Color.LIGHT_GRAY);
        panel_13.setBounds(636, 35, 79, 163);
        frame.getContentPane().add(panel_13);

        JLabel lblNewLabel_7 = new JLabel(B[13]);
        panel_13.add(lblNewLabel_7);

    }
    
    public static int getCurrentMove(){
    	
    	return V;
    }
    public static boolean clickState(){

    	return currentState;
    }

}
