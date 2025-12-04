import java.util.*;

public class Quiz {

    class Question {
        String text;
        String[] options; 
        char correct;

        Question(String text, String[] options, char correct) {
            this.text = text;
            this.options = options;
            this.correct = correct;
        }

        boolean check(char ans) {
            return ans == correct;
        }
    }

    class MCQ extends Question {
        MCQ(String text, String[] options, char correct) {
            super(text, options, correct);
        }
    }

    char getOption(Scanner sc) {
        try {
            return sc.next().toLowerCase().charAt(0);
        } catch (Exception e) {
            System.out.println("Invalid input! Enter a/b/c/d:");
            sc.nextLine();
            return getOption(sc);
        }
    }

    public static void main(String[] args) {

        Quiz qz = new Quiz(); 
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Java Quiz");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello " + name + "! Let's begin.");
        ArrayList<Question> quiz = new ArrayList<>();

        quiz.add(qz.new MCQ(
                "1. Which is NOT a Java keyword?",
                new String[]{"a) int", "b) float", "c) delete", "d) boolean"},
                'c'
        ));

        quiz.add(qz.new MCQ(
                "2. Which is used for console input?",
                new String[]{"a) Scanner", "b) Printer", "c) Keyboard", "d) Writer"},
                'a'
        ));

        quiz.add(qz.new MCQ(
                "3. Which is NOT a loop?",
                new String[]{"a) for", "b) while", "c) repeat", "d) do-while"},
                'c'
        ));

        quiz.add(qz.new MCQ(
                "4. Which is a resizable array?",
                new String[]{"a) Array", "b) ArrayList", "c) HashSet", "d) Queue"},
                'b'
        ));

        quiz.add(qz.new MCQ(
                "5. Which can cause an exception?",
                new String[]{"a) Runtime", "b) Arithmetic", "c) NullPointer", "d) All"},
                'd'
        ));

        quiz.add(qz.new MCQ(
                "6. Which data type is used to store a single character?",
                new String[]{"a) char", "b) int", "c) float", "d) boolean"},
                'a'
        ));

        quiz.add(qz.new MCQ(
                "7. Which symbol starts a single-line comment in Java?",
                new String[]{"a) #", "b) //", "c) <!-- -->", "d) **"},
                'b'
        ));

        quiz.add(qz.new MCQ(
                "8. Which keyword is used to define a class?",
                new String[]{"a) object", "b) class", "c) define", "d) new"},
                'b'
        ));

        quiz.add(qz.new MCQ(
                "9. Which loop always runs at least once?",
                new String[]{"a) for", "b) while", "c) do-while", "d) loop"},
                'c'
        ));

        quiz.add(qz.new MCQ(
                "10. Which package contains the Scanner class?",
                new String[]{"a) java.util", "b) java.io", "c) java.net", "d) java.lang"},
                'a'
        ));

        int score = 0;

        for (Question qu : quiz) {
            System.out.println("\n" + qu.text);

            for (String opt : qu.options) {
                System.out.println(opt);
            }

            System.out.print("Answer: ");
            char userAns = qz.getOption(sc);

            if (qu.check(userAns)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
                System.out.println("Correct answer: " + qu.correct);
            }
        }

        System.out.println("\nYour score: " + score + "/" + quiz.size());
        System.out.println("\nThanks for playing!");
    } 
}
