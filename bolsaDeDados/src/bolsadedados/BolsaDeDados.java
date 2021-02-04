package bolsadedados;

import java.util.Random;
import java.util.Scanner;

/**
 *Programa para lanzar una cantidad de dados definida por nosotros con un modificador que también definimos
 * la clase BolsaDeDados crea e inicializa 6 variables. También crea un objeto de tipo Scanner y otro de tipo Random.
 * Funcionalidades limitadas todavía por extender.
 * 
 * @author Edgar Sánchez Pineda
 * @version 1.0
 * 
 */
public class BolsaDeDados {

    private static int dado = 0; // Defina las caras del dado a lanzar
    private static int cantidadDados = 0; // Define cuántos dados de esas caras vamos a lanzar
    private static int modificadorDado = 0; // Define un modificador numérico entero que se sumará al resultado final
    private static int resultadoTirada = 0; // Almacena el resultado de cada tirada singular
    private static int sumaTiradas = 0; // Almacena el resultado de la suma de todas las tiradas de una ronda
    private static int total = 0; // Suma el total de las tiradas al modificador
    /**
     * Aquí creamos los dos objetos de tipo Random y Scanner.
     */
    private static Random r = new Random();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
    
        preguntas();
    
        cajaDeDados();
    
    }

    public static void cajaDeDados() {
        while (dado != 0 && cantidadDados != 0) {
            switch (dado) {
                case 5:
                    tirarDados();
                    break;
                case 7:
                    tirarDados();
                    break;
                case 9:
                    tirarDados();
                    break;
                case 11:
                    tirarDados();
                    break;
                case 13:
                    tirarDados();
                    break;
                case 21:
                    tirarDados();
                    break;
                case 101:
                    tirarDados();
                    break;
                default: System.out.println("No has introducido un dado válido, volvemos a empezar.");
                break;
                
            }
            preguntas();

        }
        System.out.println("Fin del programa");
    }
      /** 
       * Método cajaDeDados.
       * Este método void contiene el Switch de selección entre dados, y el bucle while con las condiciones de que los dados no sean 0.
     *  Solo acepta los valores 4, 6, 8, 10, 12, 20 y 100, sumándoles 1 a todos ellos. Esto es porque el objeto Random necesita un valor una cifra entera por encima para mostrar los valores contenidos que nos interesan de verdad.
     *  @since 1.0
     *  
     */

    public static void preguntas() {
        System.out.println("¿Cuál es el modificador a aplicar a la tirada?");
        modificadorDado = s.nextInt();
        System.out.println("¿Cuántos dados vas a tirar?");
        cantidadDados = s.nextInt();
        System.out.println("¿Cuántas caras tiene el dado? Puede ser de 4, 6, 8, 10, 12, 20 o 100 caras. Introduce un 0 para finalizar");
        dado = s.nextInt()+1; //Se puede apreciar que te pide un entero y le suma 1
    }
    /**
     * Método preguntas.
     * Este método void realiza las tres preguntas necesarias para que nuestro programa empiece.
     *  Modificador al dado, número de dados y caras del dado. Si el número de dados o las caras del dado es 0, el programa termina.
     *  Te pregunta por los valores 4, 6, 8, 10, 12, 20 y 100, pero les suma 1 a todos esos valores para que el método tirarDados pueda representar correctamente los valores. No obstante, esto nunca se muestra al usuario.
     *  @since 1.0
     *  
     */

    public static void tirarDados() {
        while (cantidadDados != 0 && dado != 0) {
            
            resultadoTirada = r.nextInt(dado);
            if(resultadoTirada == 0){
                resultadoTirada++; //si el resultado es 0, este condicional if le suma 1.
            }
            System.out.print(resultadoTirada + ", "); //pasa por pantalla todas las tiradas individuales
            sumaTiradas += resultadoTirada;// va sumando la acumulación de tiradas
            cantidadDados--; //resta 1 con cada vuelta al contador de cantidad de dados.
        }
        total = modificadorDado + sumaTiradas;//realiza la suma total.
        System.out.println("El total de tu tirada mas el modificador es de " + total);
    }
    /**
     * Método tirarDados.
     * Este método void contiene el núcleo del programa, que es la tirada en sí.
     *  También gestiona la suma de todas las cantidades, tanto dados como el modificador.
     *  Como el método random puede darnos un resultado de 0 que no nos interesa, en el caso de ser así, se le suma 1, convirtiéndolo en el resultado mínimo de 1.
     *  Solo acepta los valores 4, 6, 8, 10, 12, 20 y 100. Con un 0, el bucle finaliza y el programa termina.
     *  @since 1.0
     *  
     */

}
