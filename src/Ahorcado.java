import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        
        // Clase scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Declaraciones y asignaciones
        String palabraSecreta = "campeones";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Inicialización del arreglo con guiones bajo
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        // Estructura de control: Iteretiva (Bucle)
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';    
        }

        // Bucle Principal del juego

        while (!palabraAdivinada && intentos < intentosMaximos) {
             // Muestra estado actual de la palabra     // Esto se usa cuando tenemos palabras de char para formar un String
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduzca una letra, por favor");
            // Usamos la clase scanner para pedir la letra
            char letra;
            try {
                letra = Character.toLowerCase(scanner.next().charAt(0)); // CharAt es para recorrer una palabra
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, introduzca una sola letra");
                continue;
            }

            boolean letraCorrecta = false;

            // Verificar si la letra está en la palabra secreta
           for (int i = 0; i < palabraSecreta.length(); i++) {
                // Estructura de control condicional
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;                  
                }
           
            }

            // Actualizar el estado del juego según la letra ingresada
            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te queda " + (intentosMaximos - intentos) + " intentos.");
                
            }

            // Verificar si se ha adivinado toda la palabra
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }

        }

        // Mensaje fin del juego    
        if (!palabraAdivinada) {
            System.out.println("¡Qué pena, te has quedado sin intentos! GAME OVER, INSERT COIN");
            
        }

            scanner.close();
    }
}