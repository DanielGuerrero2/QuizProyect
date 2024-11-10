package QuestionUtils;

public  class Question {
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

    public Question(String question, int correctAnswer, String[] options) {
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
   public boolean isCorrect(int answer) {
        return correctAnswer == answer;
    }

    /**
     * Muestra la pregunta y sus opciones en la consola.
     */
    public void display() {
        System.out.println(question);
        // mostrar las opciones de la pregunta
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}