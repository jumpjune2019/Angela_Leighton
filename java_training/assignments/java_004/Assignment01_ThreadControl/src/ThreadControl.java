import java.util.Scanner;

public class ThreadControl {

	static MyThread mt1 = new MyThread("One");
	static MyThread mt2 = new MyThread("Two");
	static MyThread mt3 = new MyThread("Three");
	static MyThread mt4 = new MyThread("Four");
	static MyThread mt5 = new MyThread("Five");

	//initialize controlThread
	static char controlThread = '0';

	public static void main(String[] args) {
		
		
		Scanner userInput = new Scanner(System.in);
		char control = 0;
		
		do 
		{	
			//get userInput
			control = userInput.next().charAt(0);	
			
			if (control == '1' || control == '2' || control == '3' || control == '4' || control == '5' ) {
				selectThread(control);
			}
			else if (controlThread != 0){
				switch (controlThread) {
				case('1'):
					controlOneThread(control, mt1);
					break;
				case('2'):
					controlOneThread(control, mt2);
					break;
				case('3'):
					controlOneThread(control, mt3);
					break;
				case('4'):
					controlOneThread(control, mt4);
					break;
				case('5'):
					controlOneThread(control, mt5);
					break;
				}	
			}
			
		} while(mt1.thrd.isAlive()  || mt2.thrd.isAlive() || mt3.thrd.isAlive() || mt4.thrd.isAlive() || mt5.thrd.isAlive());
		
		System.out.println("This app is not exiting, all threads have been stopped.");
		
		//release resources
		userInput.close();
	}
	
	static void controlOneThread(int control, MyThread thisThread) {
		
		switch(control) {
		case('h'):
		case('H'):
			System.out.println("Setting priority to high");
			thisThread.thrd.setPriority(10);
			break;
		case('l'): 
		case('L'): 
			System.out.println("Setting priority to low");
			thisThread.thrd.setPriority(1);
			break;
		case('n'): 
		case('N'): 
			System.out.println("Setting priority to normal");
			thisThread.thrd.setPriority(5);
			break;
		case('s'):
		case('S'): 
			stopThread(thisThread);
			break;
		}
	}
	
	static void selectThread(char control) {
		boolean changeControl = false;
		
		if (controlThread != control) {
			switch (control) {
			case('1'):
				//check if thread is alive
				if (mt1.thrd.isAlive()) {
					//let control change
					changeControl = true;
				}
				break;
			case('2'):
				//check if thread is alive
				if (mt2.thrd.isAlive()) {
					//let control change
					changeControl = true;
				}
				break;
			case('3'):
				//check if thread is alive
				if (mt3.thrd.isAlive()) {
					//let control change
					changeControl = true;
				}
				break;
			case('4'):
				//check if thread is alive
				if (mt4.thrd.isAlive()) {
					//let control change
					changeControl = true;
				}
				break;
			case('5'):
				//check if thread is alive
				if (mt5.thrd.isAlive()) {
					//let control change
					changeControl = true;
				}
				break;
			}
			
			if (changeControl) {
				//set control thread
				controlThread =  control;
				System.out.println("Controlling thread " + control);
			}
		}
		else if(control == controlThread) 
			//controlThread is set already toggle the thread
			switch (controlThread) {
			case '1':
				//if thread is alive and suspended resume thread
				if (mt1.thrd.isAlive() & mt1.suspended) {
					resumeThread(mt1);
				}
				//if thread is alive and running suspend thread
				else if (mt1.thrd.isAlive() & !mt1.suspended) {
					pauseThread(mt1);
				}
				break;
				
			case '2':
				//if thread is alive and suspended resume thread
				if (mt2.thrd.isAlive() & mt2.suspended) {
					resumeThread(mt2);
				}
				//if thread is alive and running suspend thread
				else if (mt2.thrd.isAlive() & !mt2.suspended) {
					pauseThread(mt2);
				}
				break;
			case '3':
				//if thread is alive and suspended resume thread
				if (mt3.thrd.isAlive() & mt3.suspended) {
					resumeThread(mt3);
				}
				//if thread is alive and running suspend thread
				else if (mt3.thrd.isAlive() & !mt3.suspended) {
					pauseThread(mt3);
				}
				break;
				
			case '4':
				//if thread is alive and suspended resume thread
				if (mt4.thrd.isAlive() & mt4.suspended) {
					resumeThread(mt4);
				}
				//if thread is alive and running suspend thread
				else if (mt4.thrd.isAlive() & !mt4.suspended) {
					pauseThread(mt4);
				}
				break;
				
			case '5':
				//if thread is alive and suspended resume thread
				if (mt5.thrd.isAlive() & mt5.suspended) {
					resumeThread(mt5);
				}
				//if thread is alive and running suspend thread
				else if (mt5.thrd.isAlive() & !mt5.suspended) {
					pauseThread(mt5);
				}
				break;
				
			default:
				break;
		
			}
		
	}
	
	static void stopThread(MyThread myThread) {
		
		//Stop thread
		myThread.mystop();
		
		//List available threads
		System.out.println("The available threads are:");
		if(mt1.thrd.isAlive()) {
			System.out.println("Thread " + mt1.thrd.getName() + ": " + mt1.thrd.getState() + " - Press Key 1 to control");
		}
		if(mt2.thrd.isAlive()) {
			System.out.println("Thread " + mt2.thrd.getName() + ": " + mt2.thrd.getState() + " - Press Key 2 to control");
		}
		if(mt3.thrd.isAlive()) {
			System.out.println("Thread " + mt3.thrd.getName() + ": " + mt3.thrd.getState() + " - Press Key 3 to control");
		}
		if(mt4.thrd.isAlive()) {
			System.out.println("Thread " + mt4.thrd.getName() + ": " + mt4.thrd.getState() + " - Press Key 4 to control");
		}
		if(mt5.thrd.isAlive()) {
			System.out.println("Thread " + mt5.thrd.getName() + ": " + mt5.thrd.getState() + " - Press Key 5 to control");
		}
	}
	
	static void pauseThread(MyThread myThread) {

		//Suspend thread
		myThread.mysuspend();
	}
	
	static void resumeThread(MyThread myThread) {
 
		//Resume thread
		myThread.myresume();
	}
}//end threadone class 