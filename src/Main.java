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
        int intentosRestantes = 10;
        char[] progreso = new char[palabra.length()];
        // Inicializar progreso con guiones bajos
        Arrays.fill(progreso, '_');
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Hangman!");
        System.out.println("Intenta adivinar la palabra.");
        // Ciclo principal del juego del ahorcado
        // sigue mientras haya intentos restantes y la palabra no esté completa (o sea, contenga guiones bajos)
        while (intentosRestantes > 0 && new String(progreso).contains("_")) {
            System.out.println("\nPalabra: " + String.valueOf(progreso));
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.print("Introduce una letra: ");
            // Leer la letra introducida por el usuario
            char letra = scanner.nextLine().toUpperCase().charAt(0);
            //Verificar si es una letra
            if (!Character.isLetter(letra)) {
                System.out.println("Por favor, introduce solo letras.");
                continue;
            }
            // Verificar si la letra ya fue usada
            if (letrasUsadas.indexOf(letra) != -1) {
                System.out.println("Ya usaste esta letra. Intenta con otra.");
                intentosRestantes--;
                printHangman(intentosRestantes);
                continue;
            }
            letrasUsadas += letra; // Agregar la letra a las usadas

            //si la palabra contiene la letra, se muestra un mensaje de correcto y se actualiza el progreso
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
        // Si el ciclo termina y la palabra no contiene guiones bajos, el usuario ganó
        if (!new String(progreso).contains("_")) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabra);
        } else {
            // Si el ciclo termina y la palabra contiene guiones bajos, el usuario perdió
            System.out.println("\nLo siento, has perdido. La palabra era: " + palabra);
           System.out.println("Quieres volver al inicio?");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            // Verificar que la opción sea válida
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
    // Método para ejecutar el quiz
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
    // Método para mostrar la pantalla principal
    public static void mainScreen() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"murcielago", "computadora"};
        //seleccionar una palabra aleatoria para el juego del ahorcado
        int randomWord = (int) (Math.random() * words.length);
        System.out.println("Bienvenido a la aplicación");
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Jugar Hangman");
        System.out.println("2. Jugar Quiz");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        // Verificar que la opción sea válida
        while (opcion != 1 && opcion != 2) {
            System.out.println("Opción inválida. Intenta de nuevo.");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
        }
        // Ejecutar el juego seleccionado
        switch (opcion) {
            case 1:
                hangman(words[randomWord]);
                break;
            case 2:
                selectQuiz();
                break;
            default:
                break;
        }
    }
    // Método para volver al menú principal
    public static  void backToMain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quieres volver al inicio?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        // Verificar que la opción sea válida
        // Si la opción no es 1 ni 2, pedir al usuario que ingrese una opción válida
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
    // Metodo para seleccionar  el quiz
    public static void selectQuiz(){
        // Preguntas de Historia
        String[] preguntasHistoria = {
                "¿En qué año comenzó la Segunda Guerra Mundial?",
                "¿Quién fue el primer presidente de los Estados Unidos?",
                "¿En qué año cayó el Imperio Romano de Occidente?",
                "¿Qué cultura construyó las pirámides de Egipto?",
                "¿Quién descubrió América?",
                "¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?",
                "¿Quién fue Napoleón Bonaparte?",
                "¿En qué año ocurrió la Revolución Francesa?",
                "¿Quién fue el último zar de Rusia?",
                "¿Qué país lideró la Carrera Espacial durante la Guerra Fría?"
        };
        String[][] opcionesHistoria = {
                {"1938", "1939", "1940", "1941"}, // Segunda Guerra Mundial
                {"Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"}, // Primer presidente
                {"476 d.C.", "1492 d.C.", "800 d.C.", "1453 d.C."}, // Caída del Imperio Romano
                {"Romana", "Egipcia", "Mesopotámica", "Maya"}, // Pirámides
                {"Cristóbal Colón", "Fernando de Magallanes", "Américo Vespucio", "Hernán Cortés"}, // Descubrimiento de América
                {"1776", "1783", "1801", "1754"}, // Declaración de Independencia
                {"Rey de Francia", "General y emperador de Francia", "Explorador francés", "Filósofo francés"}, // Napoleón
                {"1776", "1789", "1799", "1804"}, // Revolución Francesa
                {"Pedro el Grande", "Nicolás II", "Alejandro I", "Iván el Terrible"}, // Último zar de Rusia
                {"Estados Unidos", "Rusia", "Reino Unido", "China"} // Carrera Espacial
        };
        int[] respuestasCorrectasHistoria = {1, 1, 0, 1, 0, 0, 1, 1, 1, 0};
// Preguntas de Ciencia
        String[] preguntasCiencia = {
                "¿Cuál es el órgano más grande del cuerpo humano?",
                "¿Qué gas es esencial para la respiración humana?",
                "¿Cuál es el planeta más cercano al Sol?",
                "¿Qué científica descubrió el radio y el polonio?",
                "¿Qué partícula subatómica tiene carga positiva?",
                "¿Qué teoría propone el origen del universo?",
                "¿Qué animal es conocido como el más rápido del mundo?",
                "¿Qué tipo de célula no tiene núcleo?",
                "¿Qué metal es líquido a temperatura ambiente?",
                "¿Qué aparato se usa para medir los terremotos?"
        };
        String[][] opcionesCiencia = {
                {"Hígado", "Corazón", "Piel", "Cerebro"}, // Órgano más grande
                {"Oxígeno", "Nitrógeno", "Hidrógeno", "Dióxido de carbono"}, // Gas respiración
                {"Mercurio", "Venus", "Tierra", "Marte"}, // Planeta más cercano
                {"Marie Curie", "Rosalind Franklin", "Jane Goodall", "Ada Lovelace"}, // Científica
                {"Protones", "Neutrones", "Electrones", "Quarks"}, // Partícula positiva
                {"Big Bang", "Evolución", "Placas tectónicas", "Radiación"}, // Origen del universo
                {"Guepardo", "Halcón", "Delfín", "Caballo"}, // Animal rápido
                {"Procariota", "Eucariota", "Somática", "Plasmática"}, // Sin núcleo
                {"Plata", "Oro", "Mercurio", "Cobre"}, // Metal líquido
                {"Barómetro", "Sismógrafo", "Termómetro", "Anemómetro"} // Medir terremotos
        };
        int[] respuestasCorrectasCiencia = {2, 0, 0, 0, 0, 0, 0, 0, 2, 1};

// Preguntas de Geografía
        String[] preguntasGeografia = {
                "¿Cuál es la capital de Australia?",
                "¿Qué continente tiene la mayor cantidad de países?",
                "¿Cuál es el río más largo del mundo?",
                "¿En qué océano se encuentra el Triángulo de las Bermudas?",
                "¿Cuál es el país más grande del mundo por superficie?",
                "¿En qué país se encuentra el Monte Everest?",
                "¿Cuál es la isla más grande del mundo?",
                "¿Qué país tiene más territorios en Oceanía?",
                "¿En qué continente está el desierto del Sahara?",
                "¿Cuál es la capital de Japón?"
        };
        String[][] opcionesGeografia = {
                {"Sídney", "Canberra", "Melbourne", "Brisbane"}, // Capital Australia
                {"África", "Asia", "Europa", "América del Sur"}, // Continente con más países
                {"Nilo", "Amazonas", "Yangtsé", "Misisipi"}, // Río más largo
                {"Atlántico", "Pacífico", "Índico", "Ártico"}, // Triángulo de las Bermudas
                {"Rusia", "Canadá", "China", "Estados Unidos"}, // País más grande
                {"India", "China", "Nepal", "Pakistán"}, // Monte Everest
                {"Madagascar", "Groenlandia", "Borneo", "Nueva Guinea"}, // Isla más grande
                {"Australia", "Nueva Zelanda", "Fiyi", "Papúa Nueva Guinea"}, // Más territorios
                {"Asia", "África", "América", "Europa"}, // Sahara
                {"Tokio", "Kioto", "Osaka", "Hiroshima"} // Capital Japón
        };
        int[] respuestasCorrectasGeografia = {1, 0, 0, 0, 0, 2, 1, 0, 1, 0};
        String[] preguntasDeportes = {
                "¿Qué deporte se practica en Wimbledon?",
                "¿Cuál es el deporte más popular en el mundo?",
                "¿En qué deporte se usa un disco llamado 'puck'?",
                "¿Qué país ganó la Copa Mundial de Fútbol en 2018?",
                "¿Cuántos jugadores tiene un equipo de baloncesto en la cancha?",
                "¿Qué deporte incluye los movimientos 'ollie' y 'kickflip'?",
                "¿En qué ciudad se celebraron los primeros Juegos Olímpicos modernos?",
                "¿Qué equipo de fútbol americano ganó más Super Bowls?",
                "¿Qué deporte usa un palo para golpear una pequeña pelota blanca en el césped?",
                "¿Qué arte marcial se originó en Japón y usa llaves y lanzamientos?"
        };
        String[][] opcionesDeportes = {
                {"Tenis", "Fútbol", "Críquet", "Rugby"}, // Wimbledon
                {"Fútbol", "Baloncesto", "Béisbol", "Críquet"}, // Más popular
                {"Hockey sobre hielo", "Hockey sobre césped", "Béisbol", "Baloncesto"}, // Disco puck
                {"Francia", "Brasil", "Alemania", "España"}, // Mundial 2018
                {"5", "6", "7", "8"}, // Baloncesto jugadores
                {"Skateboarding", "Snowboarding", "Surfing", "Parkour"}, // Ollie y kickflip
                {"Atenas", "Roma", "Londres", "París"}, // Juegos Olímpicos modernos
                {"Patriots", "Steelers", "Cowboys", "49ers"}, // Super Bowls
                {"Golf", "Hockey", "Críquet", "Polo"}, // Palo y pelota
                {"Karate", "Taekwondo", "Judo", "Kung-Fu"} // Artes marciales
        };
        int[] respuestasDeportes = {0, 0, 0, 0, 1, 0, 0, 1, 0, 2};
// Preguntas de Matemáticas
        String[] preguntasMatematicas = {
                "¿Cuál es el resultado de 12 + 7?",
                "¿Qué es el perímetro de un círculo?",
                "¿Cuál es el resultado de 15 - 9?",
                "¿Cuánto es 5 al cuadrado?",
                "¿Qué significa el término 'pi'?",
                "¿Cuál es el área de un triángulo con base 6 y altura 4?",
                "¿Cuánto es 81 dividido entre 9?",
                "¿Qué es un número primo?",
                "¿Cuál es el número más pequeño divisible por 2 y 3?",
                "¿Qué es una fracción equivalente?"
        };
        String[][] opcionesMatematicas = {
                {"19", "20", "21", "22"}, // 12 + 7
                {"Área", "Radio", "Diámetro", "Circunferencia"}, // Perímetro círculo
                {"6", "5", "7", "8"}, // 15 - 9
                {"15", "20", "25", "30"}, // 5 al cuadrado
                {"Un número irracional", "Un número entero", "Un número primo", "Un número complejo"}, // Pi
                {"10", "12", "14", "16"}, // Área triángulo
                {"8", "9", "10", "11"}, // 81 / 9
                {"Número divisible solo por 1 y sí mismo", "Número divisible por otros números", "Número entero negativo", "Número irracional"}, // Número primo
                {"6", "7", "8", "9"}, // Mínimo divisible
                {"Fracciones iguales", "Fracciones diferentes", "Fracciones con igual numerador", "Fracciones con igual denominador"} // Fracción equivalente
        };
        int[] respuestasMatematicas = {1, 3, 0, 2, 0, 1, 1, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona una categoría para el quiz:");
        System.out.println("1. Historia");
        System.out.println("2. Ciencia");
        System.out.println("3. Geografía");
        System.out.println("4. Deportes");
        System.out.println("5. Matemáticas");
        System.out.print("Ingresa el número de la categoría: ");
        int categoria = scanner.nextInt();
        // Verificar que la categoría sea válida
        while (categoria < 1 || categoria > 5) {
            System.out.println("Categoría inválida. Intenta de nuevo.");
            System.out.print("Ingresa el número de la categoría: ");
            categoria = scanner.nextInt();
        }
        // Ejecutar el quiz de la categoría seleccionada
        switch (categoria) {
            case 1:
                runQuiz(preguntasHistoria, opcionesHistoria, respuestasCorrectasHistoria);
                break;
            case 2:
                runQuiz(preguntasCiencia, opcionesCiencia, respuestasCorrectasCiencia);
                break;
            case 3:
                runQuiz(preguntasGeografia, opcionesGeografia, respuestasCorrectasGeografia);
                break;
            case 4:
                runQuiz(preguntasDeportes, opcionesDeportes, respuestasDeportes);
                break;
            case 5:
                runQuiz(preguntasMatematicas, opcionesMatematicas, respuestasMatematicas);
                break;
            default:
                break;
    }
    }
}