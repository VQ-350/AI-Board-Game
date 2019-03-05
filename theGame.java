package KALAH;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * Created by Abdullah Alakeel - 3/19/2015  
 * 
 */

/*
 * 			Version (2.4)
 */


/* NEED TO DO:
 * 
 * - Algorithm for Auto mode (Steal, NextTrun , Random input) 
 * - Twitter  
 * - GUI ( Interface ) 
 *  
 */

public class theGame {
	static Random r = new Random();
	static int Player;
	static String tableString = "";
	static boolean win = false;
	static boolean result = false;
	static int[] A = new int [40];
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		// input and output to start the game
		iniGame(3);
    	KalahGUI.gui(); 

		// display is always used after each move
		//displayTable();

		// chose which player you want to start with
		startGame();
		
	}


	public static void iniGame(int points){

		for(int i=0;i<A.length;i++){
			A[i]=points;
		}
		A[6]= 0;
		A[13]= 0;

	}
	
	public static void startGame(){
		System.out.print("Enter Player #(1,2): ");
		Player = scanner.nextInt();
		if(Player==1)
		{
			do{
				move();
				displayTable();
				if(results() == true){
					break;
				}
				Player = 2;
				move2();
				
				displayTable();
				if(results() == true){
					break;
				}
				Player = 1;
			}while(result!=true);
			
			System.out.println("End Of The Game");
		}
		else if(Player==2)
		{
			do{
				move2();
				
				displayTable();
				if(results() == true){
					break;
				}
				Player = 1;
				move();
				displayTable();
				if(results() == true){
					break;
				}
				Player = 2;
			}while(result!=true);

			System.out.println("End Of The Game");
		}
		else{
			System.out.println("ERROR: invalid input.");
			startGame();
		}
	}
	
	public static void displayTable(){
		System.out.print("\n------------------------------------------\n");
		System.out.print("\t ");
		for(int i=5;i>=0;i--)
		{
			System.out.print("[" + A[i] +"]");
		}
		System.out.println();
		System.out.println("[" + A[6] + "]\t\t\t" + "\t   [" + A[13] + "]");
		System.out.print("\t ");
		for(int i=7;i<=12;i++){
			System.out.print("[" + A[i] +"]");
		}

		System.out.print("\n------------------------------------------\n");
		
		tableString = "";
		for(int i=0;i<=13;i++){
			tableString += A[i] + "-";
		}
		System.out.println("tableString: "+ tableString + "\n");
		KalahGUI.gui();
	}	

	public static void move(){
		int value = 0;
		System.out.print("Player 1 Enter move: ");
		//int in = scanner.nextInt();
		int in = autoAlgo(); // input only is 0 for now 
		// done entering command.

		if(in > 5 || in < 0)
		{
			System.out.println("ERROR: Invalid Move");
			infoBox("Invalid Move","Player 1 Error");
			KalahGUI.gui();
			move();
			
		}	
		else if(A[in]==0){
			System.out.println("ERROR: Empty Spot");
			infoBox("Invalid Move","Player 1 Error");
			KalahGUI.gui();
			move();
			
		}
		else{
			System.out.println("Move is: " +  in);
			int k=0;
			int i;
			int loc = 0;
			int steal = 99;
			value = A[in];
			for(i=1;i<=value;i++){
				loc = i+in;
				steal = A[loc];
				A[loc]= ++A[loc];
				if(loc>=14){
					for(int j=value;j<=value;j++){
						loc = k;
						steal = A[loc];
						A[loc]= ++A[loc];
						k++;
					}
				}
			}
			A[in]= 0;

			if(i==++value&&loc==6){
				displayTable();
				if (A[0]==0&&A[1]==0&&A[2]==0&&A[3]==0&&A[4]==0&&A[5]==0){
					// do nothing
				}else{
					System.out.println("You've Extra Move =D");
					infoBox("Player 1 earns a free turn","Free Turn !!");
			
					move();
				}
			}
			else if(i==value&&steal==0){
				if(loc==0&&A[12]!=0){
					A[6]+= A[12] + A[0];
					A[12] = 0;
					A[0] = 0;
				}
				else if(loc==1&&A[11]!=0){
					A[6]+= A[11] + A[1];
					A[11] = 0;
					A[1] = 0;
				}
				else if(loc==2&&A[10]!=0){
					A[6]+= A[10] + A[2];
					A[10] = 0;
					A[2] = 0;
				}
				else if(loc==3&&A[9]!=0){
					A[6]+= A[9] + A[3];
					A[9] = 0;
					A[3] = 0;
				}
				else if(loc==4&&A[8]!=0){
					A[6]+= A[8] + A[4];
					A[8] = 0;
					A[4] = 0;
				}
				else if(loc==5&&A[7]!=0){
					A[6]+= A[7] + A[5];
					A[7] = 0;
					A[5] = 0;
				}
				System.out.println("\nSTOLEN =D");
				//infoBox("PLayer 1 got a steal ","Steal!!");
			}
			
		}

	}

	public static void move2(){
		int value = 0;
		System.out.print("Player 2 enter move: ");
		//int in = scanner.nextInt();
		int in = autoAlgo();
		// done entering command.

		if(in < 7 || in > 12)
		{
			System.out.println("ERROR: Invalid Move");
			infoBox("Invalid Move","Player 2 Error");
			KalahGUI.gui();
			move2();
			
		}	
		else if(A[in]==0){
			System.out.println("ERROR: Empty Spot");
			infoBox("Invalid Move","Player 2 Error");
			KalahGUI.gui();
			move2();
		}
		else{
			System.out.println("Move2 is: " +  in);
			int k=0;
			int i;
			int loc = 0;
			int steal = 99;
			value = A[in];
			for(i=1;i<=value;i++){
				loc = i+in;
				steal = A[loc];
				A[loc]= ++A[loc];
				if(loc>=14){
					for(int j=value;j<=value;j++){
						loc = k;
						steal = A[loc];
						A[loc]= ++A[loc];
						k++;
					}
				}
			}
			A[in]= 0;

			if(i==++value&&loc==13){
				displayTable();
					if (A[7]==0&&A[8]==0&&A[9]==0&&A[10]==0&&A[11]==0&&A[12]==0){
						// do nothing
					}
					else 
					{
						System.out.println("You've Extra Move =D");
						infoBox("PLayer 2 earned a free move","Free Move!!");
						move2();
					}
				}
			else if(i==value&&steal==0){
				if(loc==12&&A[0]!=0){
					A[13]+= A[12] + A[0];
					A[0] = 0;
					A[12] = 0;
				}
				else if(loc==11&&A[1]!=0){
					A[13]+= A[11] + A[1];
					A[1] = 0;
					A[11] = 0;
				}
				else if(loc==10&&A[2]!=0){
					A[13]+= A[10] + A[2];
					A[2] = 0;
					A[10] = 0;
				}
				else if(loc==9&&A[3]!=0){
					A[13]+= A[9] + A[3];
					A[3] = 0;
					A[9] = 0;
				}
				else if(loc==8&&A[4]!=0){
					A[13]+= A[8] + A[4];
					A[4] = 0;
					A[8] = 0;
				}
				else if(loc==7&&A[5]!=0){
					A[13]+= A[7] + A[5];
					A[5] = 0;
					A[7] = 0;
				}
				//System.out.println("\nSTOLEN =D");
				//infoBox("PLayer 2 got a steal ","Steal!!");
			}
			
		}
		
	}
	
	public static boolean results(){
		boolean check = false;
		boolean check2 = false; // check if one of the loop goes right

		if (A[0]==0&&A[1]==0&&A[2]==0&&A[3]==0&&A[4]==0&&A[5]==0){
			for(int i=7;i<=12;i++){
				A[13] += A[i]; 
			}
			result=true;
			check =true;
		}

		else if (A[7]==0&&A[8]==0&&A[9]==0&&A[10]==0&&A[11]==0&&A[12]==0){
				for(int i=0;i<=5;i++){
					A[6] += A[i]; 
				}
				result=true;
				check2 = true;
		}
		
		if(check == true){
			for(int i=7;i<=12;i++){
				A[i] = 0;
			}
			displayTable();
			if (A[6]>A[13])
			{
			System.out.println("Player 1 won !\n");
			infoBox("PLayer 1 WINS !","GAME OVER !");
			}
			 else if (A[6]==A[13])
			 {
				 infoBox("DRAW !","GAME OVER !");
			 }
		}
		else if(check2 == true){
				for(int i=0;i<=5;i++){
				A[i] = 0;
				}
			displayTable();
		 if (A[6]<A[13])
			{
			System.out.println("Player 2 won !\n");
			infoBox("PLayer 2 WINS !","GAME OVER !");
			
			}
		 else if (A[6]==A[13])
		 {
			 infoBox("DRAW !","GAME OVER !");
		 }
			}
		
		return result;
	}

	
	public static int autoAlgo(){
		int algoMove = 0;
		
		try {
		    Thread.sleep(1000);    // wait 10 milliseconds is one second.
		    
		    if(Player==1){
		    	//Player one Algo here  [0] to [5]
				while(KalahGUI.clickState() == false)
				{
					try{
					    Thread.sleep(10);    // wait 10 milliseconds is one second.
						//System.out.println("\nWaiting for move");
						if(KalahGUI.clickState() == true){
							break;
						}
					}catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				{
					KalahGUI.currentState = false;
					algoMove = KalahGUI.V;
				}

		    }
		
			else if(Player==2){
				//Player two Algo here [7] to [12]
				
			//	algoMove = 12; // will return 12 to the move
			//	algoMove = scanner.nextInt(); // just random inputs for testing
				
				while(KalahGUI.clickState() == false)
				{
					try{
					    Thread.sleep(10);    // wait 10 milliseconds is one second.
						//System.out.println("\nWaiting for move");
						if(KalahGUI.clickState() == true){
							break;
						}
					}catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				{
					KalahGUI.currentState = false;
					algoMove = KalahGUI.V;
				}
				/** add new array here for auto algo **/
				
				
			}
		    
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		
		return algoMove;
	}
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
	
