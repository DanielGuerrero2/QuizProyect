import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Ejecutar el quiz
        mainScreen();

    }
    public static void hangman(String palabra) {
        // Palabra a adivinar
        palabra = palabra.toUpperCase();
        String letrasUsadas = ""; // Aquí almacenaremos las letras usadas
        int intentosRestantes = 6;
        char[] progreso = new char[palabra.length()];
        // Inicializar progreso con guiones bajos
        Arrays.fill(progreso, '_');
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Hangman!");
        System.out.println("Intenta adivinar la palabra.");
        // Ciclo principal del juego
        while (intentosRestantes > 0 && new String(progreso).contains("_")) {
            System.out.println("\nPalabra: " + String.valueOf(progreso));
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.print("Introduce una letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);
            if (!Character.isLetter(letra)) {
                System.out.println("Por favor, introduce solo letras.");
                continue;
            }
            if (letrasUsadas.indexOf(letra) != -1) {
                System.out.println("Ya usaste esta letra. Intenta con otra.");
                intentosRestantes--;
                printHangman(intentosRestantes);
                continue;
            }
            letrasUsadas += letra; // Agregar la letra a las usadas
            // Verificar si la letra está en la palabra
            if (palabra.contains(String.valueOf(letra))) {
                System.out.println("¡Correcto!");
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra) {
                        progreso[i] = letra;
                    }
                }
            } else {
                System.out.println("Incorrecto. Pierdes un intento.");
                printHangman(intentosRestantes);
                intentosRestantes--;
            }
        }

        // Verificar el resultado final
        //
        if (!new String(progreso).contains("_")) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabra);
        } else {
            System.out.println("\nLo siento, has perdido. La palabra era: " + palabra);
           System.out.println("Quieres volver al inicio?");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            while (opcion != 1 && opcion != 2) {
                System.out.println("Opción inválida. Intenta de nuevo.");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
            }
            if (opcion == 1) {
                mainScreen();
            }
            System.out.println("Vuelve pronto.");
            scanner.close();
        }
    }
    public static void printHangman(int attemps) {
        switch (attemps) {
            case 0:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
        }
    }
    public static void runQuiz(String[] preguntas, String[][] opciones, int[] respuestasCorrectas) {
        Scanner scanner = new Scanner(System.in);
        int puntaje = 0;
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println((i + 1) + ". " + preguntas[i]);
            for (int j = 0; j < opciones[i].length; j++) {
                System.out.println("   " + j + ") " + opciones[i][j]);
            }
            System.out.print("Ingresa el número de tu respuesta: ");
            int respuestaUsuario = scanner.nextInt();

            if (respuestaUsuario == respuestasCorrectas[i]) {
                System.out.println("¡Correcto!\n");
                puntaje++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta es: " + opciones[i][respuestasCorrectas[i]] + "\n");
            }
        }
        System.out.println("Tu puntaje final es: " + puntaje + " de " + preguntas.length);
        System.out.println("Gracias por jugar.");
        backToMain();
    }
    public static void mainScreen() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"murcielago", "computadora", "programacion", "java", "python", "javascript", "tecnologia", "desarrollo", "aplicacion", "movil"};

        int randomWord = (int) (Math.random() * words.length);
        String[] preguntas = {
                "¿Cuál es la capital de Francia?",
                "¿Cuál es el resultado de sumar 2 y 2?",
                "¿Cuál es el resultado de 2 * 3?",
                "¿Cuál es el resultado de 10 / 2?",
                "¿Cuál es el resultado de 2^3?",
                "¿En qué continente se encuentra Egipto?",
                "¿Cuál es el resultado de 9 * 9?",
                "¿Cuál es la capital de Japón?",
                "¿Qué gas es necesario para la respiración humana?",
                "¿Quién pintó la Mona Lisa?",
                "¿Cuál es el océano más grande del mundo?",
                "¿En qué año llegó el hombre a la Luna?",
                "¿Cuál es el planeta más cercano al sol?",
                "¿Cuál es el río más largo del mundo?",
                "¿Quién es el autor de 'Don Quijote de la Mancha'?",
                "¿Cuál es el resultado de 15 - 7?",
                "¿Qué instrumento mide la temperatura?",
                "¿Cuál es el animal terrestre más rápido?",
                "¿Cuál es el elemento químico representado por 'O'?",
                "¿Qué idioma se habla en Brasil?",
                "¿Cuál es la moneda oficial de Japón?",
                "¿En qué país se encuentra la Torre Eiffel?",
                "¿Qué científico propuso la teoría de la relatividad?",
                "¿Cuál es el color resultante de mezclar rojo y amarillo?",
                "¿Qué país ganó la Copa Mundial de Fútbol en 2018?",
                "¿Cuál es el hueso más largo del cuerpo humano?",
                "¿Cuál es el tercer planeta del sistema solar?",
                "¿Quién escribió 'Romeo y Julieta'?",
                "¿Cuál es la fórmula química del agua?",
                "¿Qué país es famoso por su Carnaval en Río de Janeiro?"
        };
        // Definir las opciones para cada pregunta
        String[][] opciones = {
                {"Roma", "Madrid", "París", "Londres"},
                {"4", "22", "0", "1"},
                {"6", "5", "4", "7"},
                {"5", "4", "3", "2"},
                {"8", "6", "4", "2"},
                {"África", "Asia", "Europa", "América"},
                {"81", "72", "99", "90"},
                {"Beijing", "Seúl", "Tokio", "Bangkok"},
                {"Nitrógeno", "Oxígeno", "Dióxido de carbono", "Hidrógeno"},
                {"Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Miguel Ángel"},
                {"Atlántico", "Pacífico", "Índico", "Ártico"},
                {"1965", "1969", "1972", "1980"},
                {"Venus", "Marte", "Mercurio", "Júpiter"},
                {"Nilo", "Amazonas", "Yangtsé", "Misisipi"},
                {"Miguel de Cervantes", "Gabriel García Márquez", "Federico García Lorca", "Pablo Neruda"},
                {"8", "7", "6", "9"},
                {"Barómetro", "Termómetro", "Anemómetro", "Higrómetro"},
                {"León", "Guepardo", "Tigre", "Antílope"},
                {"Oro", "Oxígeno", "Plata", "Osmio"},
                {"Español", "Portugués", "Inglés", "Francés"},
                {"Yen", "Dólar", "Euro", "Peso"},
                {"Italia", "Francia", "Alemania", "España"},
                {"Isaac Newton", "Albert Einstein", "Nikola Tesla", "Galileo Galilei"},
                {"Verde", "Naranja", "Morado", "Marrón"},
                {"Alemania", "Brasil", "Francia", "Argentina"},
                {"Fémur", "Húmero", "Tibia", "Peroné"},
                {"Mercurio", "Venus", "Tierra", "Marte"},
                {"William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain"},
                {"H2O", "CO2", "O2", "NaCl"},
                {"Argentina", "Colombia", "Brasil", "México"}
        };
        int[] respuestasCorrectas = {
                2, // París
                0, // 4
                0, // 6
                0, // 5
                0, // 8
                0, // África
                0, // 81
                2, // Tokio
                1, // Oxígeno
                2, // Leonardo da Vinci
                1, // Pacífico
                1, // 1969
                2, // Mercurio
                1, // Amazonas
                0, // Miguel de Cervantes
                0, // 8
                1, // Termómetro
                1, // Guepardo
                1, // Oxígeno
                1, // Portugués
                0, // Yen
                1, // Francia
                1, // Albert Einstein
                1, // Naranja
                2, // Francia
                0, // Fémur
                2, // Tierra
                0, // William Shakespeare
                0, // H2O
                2  // Brasil
        };
        System.out.println("Bienvenido a la aplicación");
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Jugar Hangman");
        System.out.println("2. Jugar Quiz");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        while (opcion != 1 && opcion != 2) {
            System.out.println("Opción inválida. Intenta de nuevo.");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
        }
        switch (opcion) {
            case 1:
                hangman(words[randomWord]);
                break;
            case 2:
                runQuiz(preguntas, opciones, respuestasCorrectas);
                break;
            default:
                break;
        }
    }
    public static  void backToMain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quieres volver al inicio?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        while (opcion != 1 && opcion != 2) {
            System.out.println("Opción inválida. Intenta de nuevo.");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
        }
        if (opcion == 1) {
            mainScreen();
        }
        System.out.println("Vuelve pronto.");
    }
}
