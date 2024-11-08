import java.util.Scanner;

/**
 * Clase principal que contiene el método main y la lógica del quiz.
 */
public class Main {
    // clase para construir preguntas
    public static class Question {
        String question;
        int correctAnswer;
        String[] options;
        /**
         * Constructor para inicializar una pregunta.
         *
         * @param question      La pregunta en formato de texto.
         * @param correctAnswer El la respuesta correcta
         * @param options       Las opciones de respuesta.
         */

        Question(String question, int correctAnswer, String[] options) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.options = options;
        }
        /**
         * Verifica si la respuesta proporcionada es correcta.
         *
         * @param answer El numero de la respuesta proporcionada por el usuario.
         * @return true si la respuesta es correcta, false en caso contrario.
         */
        boolean isCorrect(int answer) {
            return correctAnswer == answer;
        }

        /**
         * Muestra la pregunta y sus opciones en la consola.
         */
        void display() {
            System.out.println(question);
            // mostrar las opciones de la pregunta
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
        }
    }
    /**
     * Método principal que ejecuta el programa.
     */

    public static void main(String[] args) {
        // preguntas de geografia
        Question[] questions = {

            new Question("Cuál es la capital de francia?",  1, new String[] { "Paris", "Londres", "Berlin", "Madrid" }),
            new Question("Cual es la capital de españa?",  4, new String[] { "Paris", "Londres", "Berlin", "Madrid" }),
            new Question("Cual es la capital de alemania?",  3, new String[] { "Paris", "Londres", "Berlin", "Madrid" }),
            new Question("Cuál es la capital de reino unido",  2, new String[] { "Paris", "Londres", "Berlin", "Madrid" }),
        };
        //preguntas de matematicas
        Question[]mathQuestions = {
            new Question("Cuanto es 2+2 ",  3, new String[] { "2", "3", "4", "5" }),
            new Question("Cuanto es 3+3?",  2, new String[] { "5", "6", "7", "8" }),
            new Question("Cuanto es 4 + 4?",  3, new String[] { "6", "7", "8", "9" }),
            new Question("Cuanto es  5 + 5?",  1, new String[] { "10", "11", "12", "13" }),
        };
        //preguntas de historia
        Question[]historyQuestions = {
            new Question("En que año inicio la segunda guerra mundial?",  2, new String[] { "1939", "1940", "1941", "1942" }),
            new Question("En que año inicio la primera guerra mundial?",  1, new String[] { "1914", "1915", "1916", "1917" }),
            new Question("En que año inicio la revolucion rusa?",  3, new String[] { "1917", "1918", "1919", "1920" }),
            new Question("En que año inicio la revolucion francesa?",  4, new String[] { "1789", "1790", "1791", "1792" }),
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona una categoria: ");
        System.out.println("1. Geografia");
        System.out.println("2. Matematicas");
        System.out.println("3. Historia");
        System.out.print("Ingresa tu respuesta: ");

        int category = scanner.nextInt();
        while (category < 1 || category > 3) {
            System.out.println("Categoria invalida, intenta de nuevo");
            System.out.print("Ingresa tu respuesta: ");
            category = scanner.nextInt();
        }
        switch (category) {
            case 1:
                buildQuiz(questions);
                break;
            case 2:
                buildQuiz(mathQuestions);
                break;
            case 3:
                buildQuiz(historyQuestions);
                break;
        }
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