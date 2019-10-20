import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAssistedInstruction {

    public static int setDifficulty(){
        Scanner scnr = new Scanner(System.in);
        int difficulty;

        System.out.println("What level of difficulty would you like to work at? (Highest level is 4).");
        difficulty = scnr.nextInt();

        return difficulty;
    }

    public static int difficultyToDigits(int difficulty){
        int maxNum;

        if (difficulty == 1){
            maxNum = 10;
        }
        else if (difficulty == 2){
            maxNum = 100;
        }
        else if (difficulty == 3){
            maxNum = 1000;
        }
        else {
            maxNum = 10000;
        }

        return maxNum;
    }

    public static int arithmeticType(){
        Scanner scnr = new Scanner(System.in);
        int arithmetic;

        System.out.println("What type of arithmetic problem would you like to study?");
        System.out.println("1 - Addition");
        System.out.println("2 - Multiplication");
        System.out.println("3 - Subtraction");
        System.out.println("4 - Division");
        System.out.println("5 - Mixed Bag");
        arithmetic = scnr.nextInt();

        return arithmetic;
    }

    public static int additionProblem(int firstNum, int secondNum){
        int correctAnswer = firstNum + secondNum;

        System.out.println("How much is " + firstNum + " plus " + secondNum + "?");

        return correctAnswer;
    }

    public static int multiplicationProblem(int firstNum, int secondNum){
        int correctAnswer = firstNum * secondNum;

        System.out.println("How much is " + firstNum + " times " + secondNum + "?");

        return correctAnswer;
    }

    public static int subtractionProblem(int firstNum, int secondNum){
        int correctAnswer = firstNum - secondNum;

        System.out.println("How much is " + firstNum + " minus " + secondNum + "?");

        return correctAnswer;
    }

    public static int divisionProblem(int firstNum, int secondNum){
        if (secondNum == 0){
            secondNum = 1;
        }

        int correctAnswer = firstNum / secondNum;

        System.out.println("How much is " + firstNum + " divided by " + secondNum + "? (Answer the whole number only, no remainder).");

        return correctAnswer;
    }

    public static int mixedProblem(int firstNum, int secondNum){
        SecureRandom rand = new SecureRandom();
        int randNum1to4 = rand.nextInt(5);
        int correctAnswer = 0;

        switch (randNum1to4){
            case 1:
                correctAnswer = additionProblem(firstNum, secondNum);
                break;
            case 2:
                correctAnswer = subtractionProblem(firstNum, secondNum);
                break;
            case 3:
                correctAnswer = multiplicationProblem(firstNum, secondNum);
                break;
            default:
                correctAnswer = divisionProblem(firstNum, secondNum);
                break;
        }
        return correctAnswer;
    }

    public static int arithmeticTypeToQuestion(int mathType, int firstNum, int secondNum){
        int correctAnswer = 0;
        if (mathType == 1){
            correctAnswer = additionProblem(firstNum, secondNum);
        }
        else if (mathType == 2){
            correctAnswer = multiplicationProblem(firstNum, secondNum);
        }
        else if (mathType == 3){
            correctAnswer = subtractionProblem(firstNum, secondNum);
        }
        else if (mathType == 4){
            correctAnswer = divisionProblem(firstNum, secondNum);
        }
        else{
            correctAnswer = mixedProblem(firstNum, secondNum);
        }

        return correctAnswer;
    }

    public static int newQuestion(int difficulty, int mathType, int firstNum, int secondNum) {
        SecureRandom rand = new SecureRandom();
        int maxNum = difficultyToDigits(difficulty);

        firstNum = rand.nextInt(maxNum);
        secondNum = rand.nextInt(maxNum);
        int correctAnswer;

        //pull in mathtype and set equal to correctAnswer?
        correctAnswer = arithmeticTypeToQuestion(mathType, firstNum, secondNum);


        return correctAnswer;
    }

    public static void correctResponse() {
        //switch statement to issue response
        SecureRandom rand = new SecureRandom();
        int randNum1to4 = rand.nextInt(5);

        switch (randNum1to4) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            default:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    public static void incorrectResponse() {
        SecureRandom rand = new SecureRandom();
        int randNum1to4 = rand.nextInt(5);

        switch (randNum1to4) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            default:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    public static void testResults(int numQuestions, int correctAnswers){
        //calculate percentage correct
        double percentCorrect = correctAnswers / (double) numQuestions * 100;
        final int PASSING_METRIC = 75;

        System.out.println("Number answered correct: " + correctAnswers);
        System.out.printf("Your score: %.0f %%. %n", percentCorrect);

        if (percentCorrect < PASSING_METRIC){
            System.out.println("Please ask your teacher for extra help.");
        }
        else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }

    public static void main(String args[]) {
        //instances and variables
        SecureRandom rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);

        final int NUMQUESTIONS = 10;
        int questionNumber = 1;
        int numCorrect = 0;

        int[] posIntegers = new int[2];

        double correctAnswer;
        double userAnswer;
        int difficultyLevel;
        int mathType;
        int newSession = 1;

        while (newSession > 0){
            //start new session
            //difficulty
            difficultyLevel = setDifficulty();
            mathType = arithmeticType();

            //ask user question
            while (questionNumber <= NUMQUESTIONS) {
                //ask question, increment question number
                correctAnswer = newQuestion(difficultyLevel, mathType, posIntegers[0], posIntegers[1]);
                questionNumber = questionNumber + 1;

                //student input
                userAnswer = scnr.nextDouble();

                //check answer
                if (Math.abs(userAnswer - correctAnswer) <= 0.001) {
                    correctResponse();
                    numCorrect ++;
                }
                else {
                    incorrectResponse();
                }
            }
            //print results of test
            testResults(NUMQUESTIONS, numCorrect);

            //prompt for new session
            System.out.println("Start a new session? 1 to restart, 0 to quit.");
            newSession = scnr.nextInt();

            questionNumber = 1;
            numCorrect = 0;

        }

    }
}