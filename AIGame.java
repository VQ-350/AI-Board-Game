package kalah;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

//Credits: A.Alakeel UOIT 2015

public class theGame {
	static Random r = new Random();
	static int Player;
	static String tableString = "";
	static boolean win = false;
	static boolean result = false;
	static int[] A = new int [40];
	static Scanner scanner = new Scanner(System.in);


	static int[] testA = new int [14]; 
	static int randomMove; 
	static int newMove; 
	static boolean repeatCheck; 
	static int test1; 
	static int test2; 
	static int aaa; 
	static int bbb; 
	static int repeatMove; 
	static int stealMove = 99; 
	static boolean repCheck = false; 
	static boolean stealCheck = false; 
	static int newRandom;
	static boolean enemyCheck = false;
	static int store = 0;
	static int enemyMove;
	static int moveCounter = 0;
	static int maxMove = 99;
	static int writeCheck;


	public static void main(String[] args) throws IOException{
		// input and output to start the game
		iniGame(3);
		//KalahGUI.gui(); 

		// display is always used after each move
		displayTable();

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

	public static void startGame() throws IOException{
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
			if (A[6]<A[13])
			{
				System.out.println("Player 2 won !\n");
				//infoBox("PLayer 2 WINS !","GAME OVER !");
			}
			else if (A[6]>A[13])
			{
				System.out.println("Player 1 won !\n");
				//infoBox("PLayer 1 WINS !","GAME OVER !");
			}
			else if (A[6]==A[13])
			{
				System.out.println("DRAW !\n");
				//infoBox("DRAW","GAME OVER !");

			}
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
		//KalahGUI.gui();
	}	

	public static void move() throws IOException{
		int value = 0;
		System.out.print("Player 1 Enter move: ");
		//KalahGUI.frame.dispose();
		//int in = scanner.nextInt();
		int in = autoAlgo(); // input only is 0 for now 
		// done entering command.

		if(in > 5 || in < 0)
		{
			System.out.println("ERROR: Invalid Move");
			//infoBox("Invalid Move","Player 1 Error");
			//KalahGUI.gui();
			move();

		}	
		else if(A[in]==0){
			System.out.println("ERROR: Empty Spot");
			//infoBox("Invalid Move","Player 1 Error");
			//KalahGUI.gui();
			move();

		}
		else{
			System.out.println("Move is: " +  in);
			int k=0;
			int bk=0;
			int i;
			int loc = 0;
			int steal = 99;
			value = A[in];
			A[in] = 0;
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
			if(in == 5){
				if(value>=8){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[13];
					System.out.println("Skipped 13");
				}
			}
			else if(in == 4){
				if(value>=9){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[13];
					System.out.println("Skipped 13");
				}
			}
			else if(in == 3){
				if(value>=10){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[13];
					System.out.println("Skipped 13");
				}
			}
			else if(in == 2){
				if(value>=11){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[13];
					System.out.println("Skipped 13");
				}
			}
			else if(in == 1){
				if(value>=12){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[13];
					System.out.println("Skipped 13");
				}
			}
			else if(in == 0){
				if(value>=13){			
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[13];
					System.out.println("Skipped 13");
				}
			}

			if(i==++value&&loc==6){
				displayTable();
				if (A[0]==0&&A[1]==0&&A[2]==0&&A[3]==0&&A[4]==0&&A[5]==0){
					// do nothing
				}else{
					System.out.println("You've Extra Move =D");
					//infoBox("Player 1 earns a free turn","Free Turn !!");

					move();
				}
			}
			else if(i==value&&steal==0){
				if(loc==0&&A[12]!=0){
					A[6]+= A[12] + A[0];
					A[12] = 0;
					A[0] = 0;
					System.out.println("\n Stolen Points at 12");
				}
				else if(loc==1&&A[11]!=0){
					A[6]+= A[11] + A[1];
					A[11] = 0;
					A[1] = 0;
					System.out.println("\n Stolen Points at 11");
				}
				else if(loc==2&&A[10]!=0){
					A[6]+= A[10] + A[2];
					A[10] = 0;
					A[2] = 0;
					System.out.println("\n Stolen Points at 10");
				}
				else if(loc==3&&A[9]!=0){
					A[6]+= A[9] + A[3];
					A[9] = 0;
					A[3] = 0;
					System.out.println("\n Stolen Points at 9");
				}
				else if(loc==4&&A[8]!=0){
					A[6]+= A[8] + A[4];
					A[8] = 0;
					A[4] = 0;
					System.out.println("\n Stolen Points at 8");
				}
				else if(loc==5&&A[7]!=0){
					A[6]+= A[7] + A[5];
					A[7] = 0;
					A[5] = 0;
					System.out.println("\n Stolen Points at 7");
				}
				//infoBox("PLayer 1 got a steal ","Steal!!");
			}

		}

	}

	public static void move2() throws IOException{
		int value = 0;
		System.out.print("Player 2 enter move: ");
		//KalahGUI.frame.dispose();
		//int in = scanner.nextInt();
		int in = autoAlgo();
		// done entering command.

		if(in < 7 || in > 12)
		{
			System.out.println("ERROR: Invalid Move");
			//infoBox("Invalid Move","Player 2 Error");
			//KalahGUI.gui();
			move2();

		}	
		else if(A[in]==0){
			System.out.println("ERROR: Empty Spot");
			//infoBox("Invalid Move","Player 2 Error");
			//KalahGUI.gui();
			move2();
		}
		else{
			System.out.println("Move2 is: " +  in);
			int k=0;
			int i;
			int loc = 0;
			int steal = 99;
			value = A[in];
			A[in] = 0;
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
			if(in == 7){
				if(value>=13){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[6];
					System.out.println("Skipped 6");
				}
			}
			else if(in == 8){
				if(value>=12){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[6];
					System.out.println("Skipped 6");
				}
			}
			else if(in == 9){
				if(value>=11){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[6];
					System.out.println("Skipped 6");
				}
			}
			else if(in == 10){
				if(value>=10){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[6];
					System.out.println("Skipped 6");
				}
			}
			else if(in == 11){
				if(value>=9){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[6];
					System.out.println("Skipped 6");
				}
			}
			else if(in == 12){
				if(value>=8){
					steal = A[++loc];
					--loc;
					A[++loc]= ++A[loc];		
					--A[6];
					System.out.println("Skipped 6");
				}
			}

			if(i==++value&&loc==13){
				displayTable();
				if (A[7]==0&&A[8]==0&&A[9]==0&&A[10]==0&&A[11]==0&&A[12]==0){
					// do nothing
				}
				else 
				{
					System.out.println("You've Extra Move =D");
					//infoBox("PLayer 2 earned a free move","Free Move!!");
					move2();
				}
			}
			else if(i==value&&steal==0){
				if(loc==12&&A[0]!=0){
					A[13]+= A[12] + A[0];
					A[0] = 0;
					A[12] = 0;
					System.out.println("\n Stolen Points at 0");
				}
				else if(loc==11&&A[1]!=0){
					A[13]+= A[11] + A[1];
					A[1] = 0;
					A[11] = 0;
					System.out.println("\n Stolen Points at 1");
				}
				else if(loc==10&&A[2]!=0){
					A[13]+= A[10] + A[2];
					A[2] = 0;
					A[10] = 0;
					System.out.println("\n Stolen Points at 2");
				}
				else if(loc==9&&A[3]!=0){
					A[13]+= A[9] + A[3];
					A[3] = 0;
					A[9] = 0;
					System.out.println("\n Stolen Points at 3");
				}
				else if(loc==8&&A[4]!=0){
					A[13]+= A[8] + A[4];
					A[4] = 0;
					A[8] = 0;
					System.out.println("\n Stolen Points at 4");
				}
				else if(loc==7&&A[5]!=0){
					A[13]+= A[7] + A[5];
					A[5] = 0;
					A[7] = 0;
					System.out.println("\n Stolen Points at 5");
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


	public static int autoAlgo() throws IOException{
		int algoMove = 0;

		try {
			Thread.sleep(1000);    // wait 10 milliseconds is one second.

			if(Player==1){
				//Player one Algo here  [0] to [5]
				/*				while(KalahGUI.clickState() == false)
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
				}*/
				algoMove= makeMove();
				moveCounter++;
				System.out.println("MOVE NUMBER: " + moveCounter);
				//algoMove = scanner.nextInt();


			}

			else if(Player==2){
				//Player two Algo here [7] to [12]

				//	algoMove = 12; // will return 12 to the move
				//algoMove = scanner.nextInt(); // just random inputs for testing
				algoMove = r.nextInt(7)+6;
				//algoMove = scanner.nextInt();
				/*while(KalahGUI.clickState() == false)
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
				}*/

				/** add new array here for auto algo **/


			}

		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}


		return algoMove;
	}


	/*---------------------------------ALGORITHM STARTS HERE (Change only if needed!)---------------------------------
	 * PLAYER 1 ALGO v3.7
	 * 
	 * UPDATED 31/03/2015
	 * 
	 * LATEST UPDATE:
	 * 
	 * - Changed ALGO priority to go to enemy points check before repeats or steals
	 * - To go to SPLITTING POINTS ALGO, move now has to be > 4
	 * 
	 * LIST OF FEATURES:
	 * 
	 * - Repeat Checker
	 * - Steal Checker
	 * - Random Generation + Verification (last option, and checker to make sure random value is valid)
	 * - Empty Slot Verification (ensures no empty slot move is passed)
	 * - Enemy Points calculator (checks for board stabilization)
	 * - Splitting points (to prevent ALL 0's on our side)
	 * - Last move checker (prevents game from going into Splitting Points algorithm and crashing on last move)
	 * - Outputs all moves and descriptions to external MoveLog.txt file
	 * 
	 * TESTING (Against RANDOM ALGO):
	 * 
	 * - 26/03/2015: WIN 4/6 Games -- 67% Win Rate
	 * - 29/03/2015: WIN 22/25 Games --  88% Win Rate -- 2 losses from 0's -- 1 general loss
	 * 
	 * 
	 * ALL COMMENTS ARE NEEDED FOR TESTING PURPOSES!
	 * 
	 * */
	public static int makeMove() throws IOException{


		for(int i =0;i <= 13;i++)
			testA[i] = A[i];
		System.out.println(Arrays.toString(testA));

		enemyChecker();
		p1CheckRepeat();
		p1CheckSteal();

		System.out.println("REP CHECK: " + repCheck);
		System.out.println("STEAL CHECK: " + stealCheck);


		/*		if(enemyCheck == true){
			newMove = maxMove;
			System.out.println("REPEAT DETECTED! BUT BOARD INBALANCED! GO TO SPLITTING POINTS ALGO ");

			//makeMove();
		}
		 */
		if(repCheck == true && enemyCheck == true){
			newMove = maxMove;
			System.out.println("REPEAT DETECTED! BUT BOARD INBALANCED! GO TO SPLITTING POINTS ALGO ");
			writeCheck = 1;
			//makeMove();
		}

		else if(repCheck == false && enemyCheck == true){
			newMove = maxMove;
			System.out.println("INBALANCE!");
			writeCheck = 2;
			//makeMove();
		}

		else if(repCheck == true && enemyCheck == false){
			newMove = repeatMove;
			System.out.println("ONLY REPEAT DETECTED!");
			writeCheck = 3;
			//makeMove();
		}

		/*	else if(repCheck == true && enemyCheck == true){
			newMove = enemyMove;
			System.out.println("REPEAT DETECTED! BUT BOARD INBALANCED! GO TO SPLITTING POINTS ALGO ");

			//makeMove();
		}*/
		else if(stealCheck == true && stealMove!=99){

			newMove = stealMove;
			System.out.println("STEAL FOUND!");
			writeCheck = 4;
		}
		else{
			System.out.println("NO MOVE ");
			//makeMove();				
			randMove();
			newMove = newRandom;
			writeCheck = 5;
		}

		System.out.println("DONE TURN ");
		System.out.println("NEW MOVE: " + newMove);
		System.out.println("REP Move: " + repeatMove);
		System.out.println("ENEMY CHECK MOVE: " + maxMove);
		System.out.println("Steal Move: " + stealMove + "\n\n");

		writeToText();
		
		return newMove;

	}

	public static void writeToText() throws IOException{
		
			FileWriter out = new FileWriter("MoveLog.txt", true);
		    
			if(writeCheck == 1){
				out.write("MOVE: " + newMove + " -- Repeat detected but board was not balanced, went to SPLITTING POINTS ALGO");
				out.write("\r\n");

			}
			if(writeCheck == 2){
				out.write("MOVE: " + newMove + " -- Board was not balanced, went to SPLITTING POINTS ALGO");
				out.write("\r\n");

			}
			if(writeCheck == 3){
				out.write("MOVE: " + newMove + " -- Only a repeat was detected, went to REPEAT ALGO");
				out.write("\r\n");

			}
			if(writeCheck == 4){
				out.write("MOVE: " + newMove + " -- Steal move was found, went to STEALING POINTS ALGO");
				out.write("\r\n");

			}
			if(writeCheck == 5){
				out.write("MOVE: " + newMove + " -- No preferrable move was found, go to last option");
				out.write("\r\n");

			}

			out.close();
			
	}
		

	public static int randMove() {

		Random newRand = new Random();
		randomMove = newRand.nextInt(6);
		System.out.println("RANDOM GENERATED: " + randomMove);

		emptyCheck(randomMove);

		return randomMove;


	}

	public static void emptyCheck(int w){

		if(testA[w]!=0&&w!=6&&w!=13){
			newRandom=w;
			System.out.println("PASSED RANDOM GENERATED: " + newRandom);
		}
		else
		{
			do{
				Random newRand = new Random();
				randomMove = newRand.nextInt(6);	
			}while(testA[randomMove]==0|randomMove==6|randomMove==13);

			newRandom = randomMove;
			System.out.println("NEW RANDOM GENERATED: " + newRandom);

		}
	}


	//Checks to see if enemy's total points are LESS THAN 2x our points
	public static void enemyChecker(){
		int totalPlayer2Points = testA[7] + testA[8] + testA[9] + testA[10] + testA[11] + testA[12] + testA[13];
		int player1Points = testA[6];


		System.out.println("TOTAL PLAYER 2 POINTS: " + totalPlayer2Points);
		System.out.println("TOTAL PLAYER 1 POINTS: " + player1Points);


		boolean emptySlot = false;

		if(testA[0]!=0&&testA[1]==0&&testA[2]==0&&testA[3]==0&&testA[4]==0&&testA[5]==0){
			emptySlot = true;
		}
		if(testA[0]==0&&testA[1]!=0&&testA[2]==0&&testA[3]==0&&testA[4]==0&&testA[5]==0){
			emptySlot = true;
		}
		if(testA[0]==0&&testA[1]==0&&testA[2]!=0&&testA[3]==0&&testA[4]==0&&testA[5]==0){
			emptySlot = true;
		}
		if(testA[0]==0&&testA[1]==0&&testA[2]==0&&testA[3]!=0&&testA[4]==0&&testA[5]==0){
			emptySlot = true;
		}
		if(testA[0]==0&&testA[1]==0&&testA[2]==0&&testA[3]==0&&testA[4]!=0&&testA[5]==0){
			emptySlot = true;
		}
		if(testA[0]==0&&testA[1]==0&&testA[2]==0&&testA[3]==0&&testA[4]==0&&testA[5]!=0){
			emptySlot = true;
		}

		System.out.println("EMPTYSLOT: " + emptySlot);


		if(totalPlayer2Points > player1Points && emptySlot == false && moveCounter > 4){
			enemyCheck = true;
			System.out.println("P2 > P1...Begin block count tests!");

			findMax();
			System.out.println("SPLITTING POINTS NOW" + "\n\n");

		}
		else{
			enemyCheck = false;
		}

		emptySlot = false;


		System.out.println("POINT CHECK: " + enemyCheck);
	}

	public static void findMax(){

		int max = testA[0];
		maxMove = 0;
		int i = 1;
		int val = 0;

		while(i<=5){
			val = testA[i];

			if (val < max){
				i++;
				System.out.println("1 MAX: " + max);

				System.out.println("1 MAX MOVE: " + maxMove);

			}

			if (val >= max){
				max = val;
				maxMove = i;
				i++;
				System.out.println("2 MAX: " + max);

				System.out.println("2 MAX MOVE: " + maxMove);
			}

		}

		System.out.println("MAX MOVE: " + maxMove);
	}


	public static int p1CheckSteal(){


		if(testA[0]==0&&testA[12]!=0){
			//System.out.println("aERRORRRRRR!!!!!!! ");

			for(int i = 1, j =12;i<=5;i++, j--){
				//System.out.println("bERRORRRRRR!!!!!!! ");

				if(testA[i]==j){
					//System.out.println("cERRORRRRRR!!!!!!! ");

					stealMove = i;
					testA[6]+= testA[12] + testA[0];
					testA[12] = 0;
					testA[0] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
				//System.out.println("dERRORRRRRR!!!!!!! ");

			}
			//System.out.println("eERRORRRRRR!!!!!!! ");

		}
		else if(testA[1]==0&&testA[11]!=0){
			//	System.out.println("2ERRORRRRRR!!!!!!! ");

			for(int i = 2, j =12;i<=5;i++, j--){

				if(testA[i]==j){

					stealMove = i;
					testA[6]+=testA[11] + testA[1];
					testA[11] = 0;
					testA[1] = 0;
					stealCheck = true;


				}
				else{
					stealCheck=false;
				}

			}

			for(int i = 0, j = 1; i >= 0; i--, j++){


				if(testA[i]==j){

					stealMove = i;
					testA[6]+=testA[11] + testA[1];
					testA[11] = 0;
					testA[1] = 0;
					stealCheck = true;


				}
				else{
					stealCheck=false;
				}

			}

		}
		else if(testA[2]==0&&testA[10]!=0&&testA[1]!=0){
			//System.out.println("3ERRORRRRRR!!!!!!! ");

			for(int i = 3, j =12;i<=5;i++, j--){
				if(testA[i]==j){
					stealMove = i;
					testA[6]+= testA[10] + testA[2];
					testA[10] = 0;
					testA[2] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
			}
			for(int i = 1, j = 1; i >= 0; i--,j++){
				if(testA[i]==j){
					stealMove = i;
					testA[6]+= testA[10] + testA[2];
					testA[10] = 0;
					testA[2] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
			}
		}
		else if(testA[3]==0&&testA[9]!=0&&testA[2]!=0){
			//	System.out.println("4ERRORRRRRR!!!!!!! ");

			for(int i = 4, j =12;i<=5;i++, j--){
				if(testA[i]==j){
					stealMove = i;
					testA[6]+= testA[9] + testA[3];
					testA[9] = 0;
					testA[3] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
			}
			for(int i = 2, j = 1; i >= 0; i--,j++){
				if(testA[i]==j){
					stealMove = i;
					testA[6]+= testA[9] + testA[3];
					testA[9] = 0;
					testA[3] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
			}
		}
		else if(testA[4]==0&&testA[8]!=0&&testA[3]!=0){
			//System.out.println("5ERRORRRRRR!!!!!!! ");

			for(int i = 5, j =12;i<=5;i++, j--){
				if(testA[i]==j){
					stealMove = i;
					testA[6]+= testA[8] + testA[4];
					testA[8] = 0;
					testA[4] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
			}
			for(int i = 3, j = 1; i >= 0; i--,j++){
				if(testA[i]==j){
					stealMove = i;
					testA[6]+= testA[8] + testA[4];
					testA[8] = 0;
					testA[4] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
			}
		}
		else if(testA[5]==0&&testA[7]!=0&&testA[4]!=0){
			//	System.out.println("6ERRORRRRRR!!!!!!! ");

			for(int i = 4, j = 1; i >= 0; i--,j++){
				if(testA[i]==j){
					stealMove = i;
					testA[6]+= testA[7] + testA[5];
					testA[7] = 0;
					testA[5] = 0;
					stealCheck = true;

				}
				else{
					stealCheck=false;
				}
			}
		}

		else{
			stealCheck = false;
			stealMove = 99;

		}


		return stealMove;

	}


	public static int p1CheckRepeat(){


		if (A[0]!=6&&A[1]!=5&&A[2]!=4&&A[3]!=3&&A[4]!=2&&A[5]!=1){
			repCheck = false;
		}

		if (testA[0]==6){
			testA[0] = 0;
			testA[6]++;
			repeatMove = 0;
			repCheck = true;
		}
		else if (testA[5]==1){
			testA[5] = 0;
			testA[6]++;
			repeatMove = 5;
			repCheck = true;
		}
		else if (testA[4]==2){
			testA[4] = 0;
			testA[6]++;
			repeatMove = 4;
			repCheck = true;
		}
		else if (testA[3]==3){
			testA[3] = 0;
			testA[6]++;
			repeatMove = 3;
			repCheck = true;
		}
		else if (testA[2]==4){
			testA[2] = 0;
			testA[6]++;
			repeatMove = 2;
			repCheck = true;
		}
		else if (testA[1]==5){
			testA[1] = 0;
			testA[6]++;
			repeatMove = 1;
			repCheck = true;
		}

		return repeatMove;

	}


	public static void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
}
