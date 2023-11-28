public class ListaDoble{

    Node topForward;
    Node topBackward;

    //Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato){
        if (topForward == null) { //La lista está vacía
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;
            
            topBackward = topForward;

            return true;
        }
        else {
            return false;
        }
    }
    
    public void imprimir(){
        System.out.print("[X]"); 

        for (Node temp = this.topForward; temp != null; temp = temp.next){
            System.out.print(" <- [ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n"); 
    }
    
    public String toString(){
        String cadAux = "[X]";
        for (Node temp = this.topForward; temp != null; temp = temp.next){
            cadAux += " <- [ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n"; 

        return cadAux;
    }

    public void insertaAntesPrimerNodo(String nombre){
        Node temp; 
        temp = new Node ();
        temp.name = nombre;
        temp.next = this.topForward;
        this.topForward.previous = temp;
        this.topForward = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre){
        Node temp = new Node ();
        temp.name = nombre;
        temp.next = null;
        
        temp.previous = this.topBackward;
        this.topBackward.next = temp;
        this.topBackward = temp;
        temp = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        //boolean NodoNoEncontrado = true;

        while ( (temp2 != null) 
                && temp2.name.equals(buscado) == false ) {    
                 temp2 = temp2.next;
        }

        if (temp2 != null){  //Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;

            temp.previous = temp2;
            temp.next.previous = temp;

            temp = null;
            temp2 = null;
            
            return true;
        }
        else return false;
    } 
    
    //Métodos de borrado
    public void borrarPrimerNodo(){
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }

    public void borrarUltimoNodo(){
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }

    
    //Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado){
        Node temp = this.topForward;

        while ( (temp != null) 
                && temp.name.equals(buscado) == false ) {    
                 temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;
            
            return true;
        }
        else return false;
    }
    
      public Node buscarPorValor(String valorBuscado) {
        Node temp = this.topForward;

        while (temp != null && !temp.name.equals(valorBuscado)) {
            temp = temp.next;
        }

        return temp;
    }
    
    public void insertarDespuesDeNodo(String valorBuscado, String nuevoValor) {
        Node temp = buscarPorValor(valorBuscado);

        if (temp != null) {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoValor;

            nuevoNodo.next = temp.next;
            nuevoNodo.previous = temp;
        
            if (temp.next != null) {
                temp.next.previous = nuevoNodo;
            }
            
            temp.next = nuevoNodo;
        }
    }
    
    public void intercambiarNodos(String valorNodo1, String valorNodo2) {
        Node nodo1 = buscarPorValor(valorNodo1);
        Node nodo2 = buscarPorValor(valorNodo2);

        if (nodo1 != null && nodo2 != null) {
            // Intercambiar referencias next
            Node tempNext = nodo1.next;
            nodo1.next = nodo2.next;
            nodo2.next = tempNext;

            // Intercambiar referencias previous
            Node tempPrevious = nodo1.previous;
            nodo1.previous = nodo2.previous;
            nodo2.previous = tempPrevious;

            // Actualizar referencias de nodos adyacentes
            if (nodo1.next != null) {
                nodo1.next.previous = nodo1;
            }
            if (nodo2.next != null) {
                nodo2.next.previous = nodo2;
            }
            if (nodo1.previous != null) {
                nodo1.previous.next = nodo1;
            }
            if (nodo2.previous != null) {
                nodo2.previous.next = nodo2;
            }
        }
    }


    //TODO: Crear el método para borrar el nodo buscado
    //Adecuación del método de borrado: borrarCualquierNodo()

}













