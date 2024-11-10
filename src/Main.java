import java.util.Scanner;
import QuestionUtils.Question;

/**
 * Clase principal que contiene el método main y la lógica del quiz.
 */
public class Main {
    // clase para construir preguntas

    /**
     * Método principal que ejecuta el programa.
     */

    public static void main(String[] args) {

        // Crear un array de preguntas
        Question[] questions = {
            new Question("¿Cuál es la capital de Francia?", 3, new String[]{"Roma", "Madrid", "París", "Londres"}),
            new Question("¿Cuál es el resultado de sumar 2 y 2?", 1, new String[]{"4", "22", "0", "1"}),
            new Question("¿Cuál es el resultado de 2 * 3?", 0, new String[]{"6", "5", "4", "7"}),
            new Question("¿Cuál es el resultado de 10 / 2?", 0, new String[]{"5", "4", "3", "2"}),
            new Question("¿Cuál es el resultado de 2^3?", 3, new String[]{"8", "6", "4", "2"})
        };
        // Construir y ejecutar el quiz
        buildQuiz(questions);

    }
    /**
     * Construye y ejecuta el quiz basado en el array de preguntas proporcionado.
     *
     * @param questions Array de preguntas a utilizar en el quiz.
     */
    public  static void buildQuiz(Question [] questions){
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        for (Question question : questions) {
            question.display();
            System.out.print("Ingresa tu respuesta: ");
            int answer = scanner.nextInt();
            if (question.isCorrect(answer)) {
                correctAnswers++;
            }
        }
        System.out.println("Obtuviste un puntaje de " + correctAnswers + " de " + questions.length + " preguntas");
    }
}