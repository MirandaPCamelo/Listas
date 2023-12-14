/**
 * Métodos para manejar la lista doblemente enlazada.
 * 
 * @author (Miranda Patricia Pérez Camelo) 
 * @version (Noviembre 27, 2023)
 */
public class ListasEnlazadas
{
    // instance variables 
    Node topForward; //enlace siguiente
    Node topBackward; //enlace anterior
    
    /**
     * si la lista está vacía se creará e insertará el primer nodo,
     * si la lista no está vacía no se insertará nada.
     */
    public boolean insertarPrimerNodo(Object dato) 
    {
        if (topForward == null) //comprueba si la lista está vascía o no
        { //la lista está vacía: 
            topForward = new Node(); //se crea un nuevo nodo y topForward apuntará a este nuevo nodo
            topForward.name = dato; //se le asigna el valor al nodo que se acaba de crear
            //se declaran como null porque solamente se creó el primer nodo (no apunta a nada)
            topForward.previous = null;
            topForward.next = null; 
            topBackward = topForward; //topBAckward ahora apuntará al nuevo nodo
            
            return true; //devuelve que el primer nodo se insertó
        }
        else
        { //la lista no está vacía
            return false; //devuelve que la lista no estaba vacía; por lo tanto, no se insertó ningún nodo
        }
    }
    
    /**
     * se creará un nodo y se insertará al inicio de la lista.
     */
    public void insertaAntesPrimerNodo(Object nombre)
    {
        Node temp; //creación de un nodo temporal 
        temp = new Node(); //asignación del nodo a objeto
        temp.name = nombre; //se le asigna un valor al nodo
        temp.next = this.topForward; //el enlace del nuevo nodo apuntará al nodo actual en la cabeza
        this.topForward.previous = temp; //previous apuntará al nuevo nodo
        this.topForward = temp; //topForward se actualiza para apuntar al nuevo nodo (el que ahora es el primer nodo de la lista)
        temp = null; //el nodo temp que se creó se vuelve nulo para que el recolector lo deseche 
    }
    
    /**
     * se creará un nodo y se insertará al final de la lista.
     */
    public void insertaAlFinal(Object nombre)
    { 
        Node temp = new Node(); //creación y asignación del nodo temp a objeto
        temp.name = nombre; //se le asigna un valor al nodo
        temp.next = null; //hace que el enlace del nodo temp sea null porque este nodo es el final de la lista (no puede enlazar a otro nodo porque ya es el final)
        
        temp.previous = this.topBackward; //previous se establece para apuntar al nodo actualmente al final de la lista (topBackward)
        this.topBackward.next = temp; //next del nodo actualmente al final de la lista se establece para apuntar al nuevo nodo
        this.topBackward = temp; //topBackward ahora apuntará al nuevo nodo (que ahora es el último nodo de la lista)
        temp = null; //el nodo temp que se creó se vuelve nulo para que el recolector lo deseche
    }
    
    /**
     * sirve para insertar un  nuevo nodo después de otro en específico 
     */
    public boolean insertaEntreNodos(Object nombre, Object buscado)
    {
        Node temp = new Node(); //creación del nodo temp 
        temp.name = nombre; //se le asigna un valor al nodo
        Node temp2 = this.topForward; //se crea temp2 y se le asigna  la cabeza
        
        while ((temp2 != null) && temp2.name.equals(buscado) == false)
        //recorrerá la lista hasta encontrar el nodo que se solicitó (buscado)
        {
            temp2 = temp2.next; //irá recorriendo toda la lista nodo por nodo
        }
        
        //verifica si el nodo buscado se encontró
        if (temp2 != null)
        { //como se encontró el nodo buscado, se insertará temp después de temp2 (el nodo buscado)
           temp.next = temp2.next; //el siguiente nodo del nodo temp será el siguiente nodo del nodo encontrado
           temp2.next = temp; //el siguiente nodo del nodo encontrado ahora es el nuevo nodo
           
           //se actualizan debido a la inserción 
           temp.previous = temp2;
           temp.next.previous = temp;
           
           //los nodos temporales creados se vuelven null para que el recolector se los lleve
           temp = null;
           temp2 = null;
           
           return true; //devuelve true porque se insertó el nodo correctamente
        }
        else
        {
            return false; //devuelve false porque el nodo solicitado no se encontró
        }
    }
    
    /**
     * sirve para imprimir el valor de cada nodo que está en la lista 
     */
    public void imprimir()
    {
        System.out.print("[X]");
        
        for (Node temp = this.topForward; temp != null; temp = temp.next) //irá recorriendo la lista 
        {
            System.out.print(" <- [ " + temp.name + " ] -> "); //mostrará el valor que tenga el nodo actual y una flechita
        }
        
        //cuando termine de recorrer toda la lista mostrará lo siguiente representando el final
        System.out.print("[X]\n"); 
    }
    
    /**
     * sirve para ir añadiendo (mientras recorre la lista) el valor del nodo a la cadena
     */
    public String toString()
    {
        String cadAux = "[X]"; //inicializa una cadena 
        
        for (Node temp = this.topForward; temp != null; temp = temp.next) //irá recorriendo la lista
        {
            cadAux += " <- [ " + temp.name + " ] -> "; //va añadiendo el valor del nodo actual y una flechita
        } //termina de recorrer toda la lista
        
        cadAux += "[X]\n"; //fin de la lista
        
        return cadAux; //devuelve la cadena
        
        
    }
    
    /**
     * borra el primer nodo
     */
    public void borrarPrimerNodo()
    {
        this.topForward = this.topForward.next; //se asigna como cabeza al nodo que está después de la cabeza
        this.topForward.previous.next = null; // se pone como null el nodo que se acab de eliminar
        this.topForward.previous = null; //establece previous como null potque ahora es el primer nodo de la lista
    }
    
    public boolean borrarCualquierNodo(Object buscado)
    {
        Node temp = this.topForward; //se crea temp y se le asigna  la cabeza para iniciar desdeel principio de la lista
        
        while ((temp != null) && temp.name.equals(buscado) == false) //recorrerá la lista hasta encontrar el nodo que se solicitó (buscado)
        {
            temp = temp.next; //irá recorriendo toda la lista nodo por nodo
        }
        
        //verifica si el nodo buscado se encontró
        if (temp!= null)
        { //sí se encontró
            temp.next = temp.next.next; //se salta el nodo que se va a eliminar
            temp.next.previous.previous = null; //se elimina la referencia al nodo anterior al que se va a eliminar
            temp.next.previous.next = null; // se elimina la referencia al nodo siguiente al que se va a eliminar
            temp.next.previous = temp; //se ajusta la referencia del nodo siguiente al nodo actual
            temp = null; //se vuelve null el nodo temporal creado para que el recolector se lo lleve
            
            return true; //devuelve true porque se eliminó el nodo correctamente
        }
        else
        { //no se encontró
            return false; //devuelve false porque el nodo solicitado no se encontró
        }
    }
    
    public void borrarUltimoNodo()
    {
        this.topBackward = this.topBackward.previous; //se mueve al nodo anterior al último nodo
    this.topBackward.next.previous = null; //se elimina la referencia al nodo anterior al último nodo
    this.topBackward.next = null; //se elimina la referencia al último nodo
    }
    
    /**
     * Buscar un nodo por el valor de su campo clave y devolver una referencia.
     */
    public Node buscarNodoPorValor(Object buscado) 
    {
        // initialise instance variables
        Node temp = this.topForward; //se crea temp y se le asigna  la cabeza
        
        //while ((temp != null) && temp.name.equals(buscado) == false)
        while (temp != null) //recorrerá la lista hasta encontrar lo que se solicitó (buscado)
        {
            if (temp.name.equals(buscado))
            {
                return temp;
            }
            temp = temp.next; //irá recorriendo toda la lista nodo por nodo
        } 
        
        return null; //devuelve null porque el nodo no se encontró
    }
    
    /**
     * Buscar un nodo por su campo clave e insertar un nuevo nodo después de él.
     */
    public boolean insertarDespuesDeNodo(Object buscado, Object nuevoNombre)
    {
        Node nodoBuscado = buscarNodoPorValor(buscado);
    
        if (nodoBuscado != null)
        {
            //comprobar si nodoBuscado es el último de la lista
            if (nodoBuscado.next == null)
            {
                insertaAlFinal(nuevoNombre);
            }
            else
            {
                Node nuevoNodo = new Node(); //creación del nuevo nodo que se quiere insertar
                nuevoNodo.name = nuevoNombre; //se le da un valor al nodo creado
                nuevoNodo.next = nodoBuscado.next; //el siguiente nodo del nuevoNodo será el siguiente nodo del nodo encontrado
                nodoBuscado.next = nuevoNodo; //se le enlaza nuevoNodo a temp; es decir, se pone nuevoNodo después de temp
                
                nuevoNodo.previous = nodoBuscado;
                nuevoNodo.next.previous = nuevoNodo;
            }
            return true; //devuelve true porque se insertó el nodo correctamente
        }
        else
        { //el nodo solicitado no se encontró
            return false; //devuelve false porque no se insertó nada
        }
    }
    
    /**
     * Intercambiar un nodo por otro buscado.
     */
    public boolean intercambiarNodos(Object nombre, Object buscado)
    {
        //inicialización de nodos
        Node nodo1 = buscarNodoPorValor(buscado); 
        Node nodo2 = buscarNodoPorValor(buscado);
        
        if (nodo1 != null && nodo2 != null)
        {
            Object temp = nodo1.name;
            nodo1.name = nodo2.name;
            nodo2.name = temp;
            return true;
        }
        
        return false;
    }
}













