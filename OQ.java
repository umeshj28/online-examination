import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OQ{
	private static final String[] Questions = {
		"Who developed Java?",
		"What is the file extension for a compiled java class?",
		"Which keyword is used for inheritance in java?",
		"Full form JVM",
		"Which java keyword is used for exception handling?"
	};
	
	private static final String[] Options = {
		"A. James Gosling\t B. Brendan Elich\t C. Mark Zukenburg\t D. Larry Page",
		"A. .java\t B. .jar\t C. .class\t D. .bytecode",
		"A. Inheritance\t B. extends\t C. implements\t D. inheritsFrom",
		"A. Java Virtual Machine\t B. Java Visual Machine\t C. Java Verification Model\t D. Java Variable Method",
		"A. error\t B. catch\t C. throw\t D. try",
	};

	private static final char[] Answers = {'A', 'C', 'B', 'A', 'D'};
	private String username;
	private String passcode;
	private int score;

	public void OQ() {
		this.username = "";
		this.passcode = "";
		this.score = 0;
	}

	public void startExam(){
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<Questions.length; i++){
			System.out.println("Question "+(i+1)+": "+Questions[i]);
			System.out.println(Options[i]);
			
			Timer time = new Timer();
			time.schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println("Time's up!!");
					
				}
			}, 10000);
			
			char userAnswer = getUserAnswer(sc);
			time.cancel();
		
			if(userAnswer == Answers[i]){
				System.out.println("Correct!\n");
				score++;
			}
			else{
				System.out.println("Incorrect");
				System.out.println("The correct answer is "+Answers[i]+ ".\n");
			}
		}
	
	}

	private char getUserAnswer(Scanner sc){
		char userAnswer;
		do{
			System.out.print("Your answer (A, B, C, D): ");
			userAnswer = Character.toUpperCase(sc.next().charAt(0));
		} while (userAnswer < 'A' || userAnswer  > 'D');
			return userAnswer;
	}


	private void saveScore(){
		
		if(score > 3)
			System.out.println("Well done!!Your have passed the Quiz.");
		else
			System.out.println("Failed. Try again!!");

	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		OQ Quiz = new OQ();

		while(true) {
			System.out.println("1. Register for Quiz ");
			System.out.println("2. Update my profile ");
			System.out.println("3. Start Quiz ");
			System.out.println("4. Results ");
			System.out.println("5. Exit ");
			int choice = sc.nextInt();

			switch(choice){
				case 1:
					System.out.println("Enter your Username: ");
					Quiz.username = sc.next();
					System.out.println("Enter your passcode: ");
					Quiz.passcode = sc.next();
					System.out.println("You have successfully registered for your quiz");
					break;

				case 2:
					System.out.println("Enter your new passcode: ");
					Quiz.passcode = sc.next();
					break;

				case 3:
					System.out.println("All The Best");
					System.out.println("Let's begin the quiz!!");
					Quiz.startExam();
					break;

				case 4:
					Quiz.saveScore();
					break;

				case 5:
					System.out.println("Exiting....Thank you for participating!!");
					sc.close();
					System.exit(0);

				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}

					

			