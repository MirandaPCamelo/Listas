import java.util.Scanner;
public class UsaLista{
    static Scanner lectura = new Scanner(System.in);
    public static void main(String[] args){
        ListaDoble lista = new ListaDoble();

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
        Node nodoEncontrado = lista.buscarPorValor(valorBuscado);

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
        Node nodoEncontrado2 = lista.buscarPorValor(valorBuscado2);

        if (nodoEncontrado != null) {
            // Insertar un nuevo nodo después del nodo encontrado
            String nuevoValor = "NodoNuevo";
            lista.insertarDespuesDeNodo(valorBuscado, nuevoValor);

            System.out.println("Lista después de la inserción:");
            lista.imprimir();
        } else {
            System.out.println("Nodo no encontrado. No se realizará la inserción.");
        }
        
        //Método intercambiarNodos
        System.out.println("Lista antes del intercambio:");
        lista.imprimir();
        System.out.println("--Intercambiar un nodo por otro buscado.--");
        System.out.println("Proporciona el nodo 1 a intercambiar");
        String nodo1 = lectura.nextLine();
        System.out.println("Proporciona el nodo 2 a intercambiar");
        String nodo2 = lectura.nextLine();
 
        //Intercambiar los nodos
        lista.intercambiarNodos(nodo1, nodo2);

        System.out.println("Lista después del intercambio:");
        lista.imprimir();
    }


}