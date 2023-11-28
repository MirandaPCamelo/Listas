import java.util.Scanner;
public class UsaLista{
    static Scanner lectura = new Scanner(System.in);
    public static void main(String[] args){
        ListaSimple lista = new ListaSimple();

        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("R", "A");
        lista.imprimir();
        System.out.print(lista);
        
        
        //Método buscarNodoPorValor
        System.out.println("--Buscar un nodo por el valor de su campo clave y devolver una referencia--");
        System.out.println("Proporciona la clave del nodo");
        String valorBuscado = lectura.nextLine();
        Node nodoEncontrado = lista.buscarNodoPorValor(valorBuscado);

        if (nodoEncontrado != null) {
            System.out.println("Nodo encontrado con valor " + valorBuscado);
        } else {
            System.out.println("Nodo no encontrado con valor " + valorBuscado);
        }
        
        //Imprimir la lista antes de la inserción
        System.out.println("Lista antes de la inserción:");
        lista.imprimir();

        //Método insertarDespuesDeNodo
        System.out.println("--Buscar un nodo por su campo clave e insertar un nuevo nodo después de él--");
        System.out.println("Proporciona la clave del nodo");
        String valorBuscado2 = lectura.nextLine();
        String nuevoNombre = "NuevoNodo";

        boolean exitoInsercion = lista.insertarDespuesDeNodo(valorBuscado2, nuevoNombre);

        //Imprimir la lista después de la inserción
        System.out.println("\nLista después de la inserción:");
        lista.imprimir();

        if (exitoInsercion) {
            System.out.println("Inserción exitosa después de " + valorBuscado2);
        } else {
            System.out.println("No se pudo encontrar el nodo " + valorBuscado2 + " para la inserción.");
        }
        
        //Método intercambiarNodos
        System.out.println("--Intercambiar un nodo por otro buscado.--");
        System.out.println("Proporciona el nodo 1 a intercambiar");
        String nodo1 = lectura.nextLine();
        System.out.println("Proporciona el nodo 2 a intercambiar");
        String nodo2 = lectura.nextLine();
 

        boolean exitoIntercambio = lista.intercambiarNodos(nodo1, nodo2);

        //Imprimir la lista después del intercambio
        System.out.println("\nLista después del intercambio:");
        lista.imprimir();

        if (exitoIntercambio) {
            System.out.println("Intercambio exitoso entre " + nodo1 + " y " + nodo2);
        } else {
            System.out.println("No se pudo realizar el intercambio. Uno o ambos nodos no encontrados.");
        }
    }


}