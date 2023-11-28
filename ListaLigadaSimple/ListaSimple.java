public class ListaSimple{
    Node top;

    //Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato){
        if (top == null) { //La lista no está vacía
            top = new Node();
            top.name = dato;
            top.next = null;

            return true;
        }
        else {
            return false;
        }
    }

    public void insertaAntesPrimerNodo(String nombre){
        Node temp; 
        temp = new Node ();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre){
        Node temp = new Node ();
        temp.name = nombre;
        temp.next = null;
        //Node temp2;
        Node temp2 = this.top;

        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;
        temp = null;
        temp2 = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.top;

        //boolean NodoNoEncontrado = true;

        while ( (temp2 != null) 
                && temp2.name.equals(buscado) == false ) {    
                 temp2 = temp2.next;
        }

        if (temp2 != null){  //Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;
            temp = null;
            temp2 = null;
            return true;
        }
        else return false;
    } 

    public void imprimir(){
        for (Node temp = this.top; temp != null; temp = temp.next){
            System.out.print("[ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n"); 
    }

    public String toString(){
        String cadAux = "";
        for (Node temp = this.top; temp != null; temp = temp.next){
            cadAux += "[ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n"; 

        return cadAux;
    }

    
    //Métodos de borrado
    public void borrarPrimerNodo(){
        this.top = this.top.next;
    }

    //Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado){
        Node temp = this.top;

        while ( (temp != null) 
                && temp.name.equals(buscado) == false ) {    
                 temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp = null;
            
            return true;
        }
        else return false;
    }
    
    public Node buscarNodoPorValor(String valor) {
        Node temp = this.top;
        while (temp != null && !temp.name.equals(valor)) {
            temp = temp.next;
        }
        return temp;
    }
    
    public boolean insertarDespuesDeNodo(String buscado, String nuevoNombre) {
        Node temp = this.top;
        while (temp != null && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        if (temp != null) {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoNombre;
            nuevoNodo.next = temp.next;
            temp.next = nuevoNodo;
            return true;
        } else {
            return false; // Nodo buscado no encontrado
        }
    }
    
    public boolean intercambiarNodos(String nodo1, String nodo2) {
        Node temp1 = null, temp2 = null, prev1 = null, prev2 = null;
        Node temp = this.top;

        // Buscar los nodos y sus nodos previos
        while (temp != null) {
            if (temp.name.equals(nodo1)) {
                temp1 = temp;
                break;
            }
            prev1 = temp;
            temp = temp.next;
        }

        temp = this.top;

        while (temp != null) {
            if (temp.name.equals(nodo2)) {
                temp2 = temp;
                break;
            }
            prev2 = temp;
            temp = temp.next;
        }

        // Verificar si ambos nodos fueron encontrados
        if (temp1 != null && temp2 != null) {
            // Actualizar los punteros de los nodos previos
            if (prev1 != null) {
                prev1.next = temp2;
            } else {
                this.top = temp2;
            }

            if (prev2 != null) {
                prev2.next = temp1;
            } else {
                this.top = temp1;
            }

            // Intercambiar los punteros de los nodos
            Node tempNext = temp1.next;
            temp1.next = temp2.next;
            temp2.next = tempNext;

            return true;
        } else {
            return false; // Al menos uno de los nodos no fue encontrado
        }
    }


}













