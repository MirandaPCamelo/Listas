import java.util.Scanner;
/**
 * Main.
 * 
 * @author (Miranda Patricia Pérez Camelo) 
 * @version (Noviembre 27, 2023)
 */
public class Main
{
    // instance variables - replace the example below with your own
    static Scanner lectura = new Scanner(System.in);
    /**
     * Llama a los métodos de la clase ListasEnlazadas para ejecutarlos
     */
    public static void main (String[] args)
    {
        // llama a los métodos de la clase "ListasEnlazadas"
        ListasEnlazadas lista = new ListasEnlazadas();
        
        System.out.println("insertarPrimerNodo");
        lista.insertarPrimerNodo("I3A");
        System.out.print(lista);
        System.out.println("");
        
        System.out.println("insertaAntesPrimerNodo");
        lista.insertaAntesPrimerNodo("Miranda");
        System.out.print(lista);
        System.out.println("");
        
        System.out.println("insertaAlFinal");
        lista.insertaAlFinal("Estructura de datos");
        System.out.print(lista);
        System.out.println("");
        
        System.out.println("insertaEntreNodos");
        lista.insertaEntreNodos("Pérez","Miranda");
        System.out.print(lista);
        System.out.println("");
        
        System.out.println("imprimir");
        lista.imprimir();
        System.out.println("");
        
        //llama a los métodos de la clase "ListasLigadasSimplesTarea"
        System.out.println("buscarNodoPorValor");
        Node nodoBuscado = lista.buscarNodoPorValor("Miranda");
        System.out.println(nodoBuscado.name);
        //System.out.print(lista);
        System.out.println("");
        
        System.out.println("insertarDespuesDeNodo");
        lista.insertarDespuesDeNodo("Estructura de datos","Listas ligadas simples");
        System.out.print(lista);
        System.out.println("");
        
        System.out.println("intercambiarNodos");
        lista.intercambiarNodos("Listas ligadas simples","I3A");
        System.out.print(lista);
        System.out.println("");
        
        System.out.println("Lista Ligada Simple:");
        System.out.print(lista); //imprime la lista
    }
}
