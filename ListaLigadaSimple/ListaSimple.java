
/**
 * Métodos para manejar la lista enlazada simple.
 * 
 * @author (Miranda Patricia Pérez Camelo) 
 * @version (Noviembre 27, 2023)
 */
public class ListasEnlazadas
{
    // instance variables 
    Node top; //Nodo cabeza

    /**
     * si la lista está vacía se creará e insertará el primer nodo,
     * si la lista no está vacía no se insertará nada.
     */
    public boolean insertarPrimerNodo(Object dato) 
    {
        if (top == null) //comprueba si la lista está vascía o no
        { //la lista está vacía: 
            top = new Node(); //se crea el primer nodo (cabeza)
            top.name = dato; //se le asigna el valor al nodo que se acaba de crear
            top.next = null; //se declara el enlace como null porque solamente se creó el primer nodo (no apunta a nada)
            
            return true; //devuelve que el primer nodo se  insertó
        }
        else
        { //la lista no está vacía
            return false; //devuelve que la lista no estaba vacía
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
        temp.next = this.top; //hace que la el enlace del nodo temp apunte a la cabeza de la lista
        this.top = temp; //ahora la cabeza será el nodo temp
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
        
        //Node temp2;
        Node temp2 = this.top; //se crea temp2 y se le asigna  la cabeza
        
        while (temp2.next != null) //hasta que llegue al último nodo
        {
            temp2 = temp2.next; //irá recorriendo toda la lista
        }//cuahndo llegue al último nodo
        temp2.next = temp; //enlazará el nodo creado al principio de  este método con el último nodo que estaba en la lista convirtiéndolo ahora en el penúltimo y al del principio en el último
        //los nodos temporales creados se vuelven null para que el recolector se los lleve
        temp = null; 
        temp2 = null;
    }
    
    /**
     * sirve para insertar un  nuevo nodo después de otro en específico 
     */
    public boolean insertaEntreNodos(Object nombre, Object buscado)
    {
        Node temp = new Node(); //creación del nodo temp 
        temp.name = nombre; //se le asigna un valor al nodo
        Node temp2 = this.top; //se crea temp2 y se le asigna  la cabeza
                
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
        for (Node temp = this.top; temp != null; temp = temp.next) //irá recorriendo la lista 
        {
            System.out.print("[ " + temp.name + " ] -> "); //mostrará el valor que tenga el nodo actual y una flechita
        }
        
        //cuando termine de recorrer toda la lista mostrará lo siguiente representando el final
        System.out.print("[X]\n"); 
    }
    
    /**
     * sirve para ir añadiendo (mientras recorre la lista) el valor del nodo a la cadena
     */
    public String toString()
    {
        String cadAux = ""; //inicializa una cadena vacía
        for (Node temp = this.top; temp != null; temp = temp.next) //irá recorriendo la lista
        {
            cadAux += "[ " + temp.name + " ] -> "; //va añadiendo el valor del nodo actual y una flechita
        } //termina de recorrer toda la lista
        
        cadAux += "[X]\n"; //fin de la lista
        
        return cadAux; //devuelve la cadena
        
        
    }
    
    /**
     * borra el primer nodo
     */
    public void borrarPrimerNodo()
    {
        this.top = this.top.next; //se asigna como cabeza al nodo que está después de la cabeza
    }
    
    public boolean borrarCualquierNodo(Object buscado)
    {
        Node temp = this.top; //se crea temp y se le asigna  la cabeza
        while ((temp != null) && temp.name.equals(buscado) == false) //recorrerá la lista hasta encontrar el nodo que se solicitó (buscado)
        {
            temp = temp.next; //irá recorriendo toda la lista nodo por nodo
        }
        
        ////verifica si el nodo buscado se encontró
        if (temp!= null)
        { //sí se encontró
            temp.next = temp.next.next; //el nodo que está después de temp será el siguiente nodo del siguiente nodo
            temp = null; //se vuelve null el nodo temporal creado para que el recolector se lo lleve
            
            return true; //devuelve true porque se eliminó el nodo correctamente
        }
        else
        { //no se encontró
            return false; //devuelve false porque el nodo solicitado no se encontró
        }
    }
    
    /**
     * Buscar un nodo por el valor de su campo clave y devolver una referencia.
     */
    public Node buscarNodoPorValor(Object buscado) 
    {
        // initialise instance variables
        Node temp = this.top; //se crea temp y se le asigna  la cabeza
        
        //while ((temp != null) && temp.name.equals(buscado) == false)
        while (temp != null &&! temp.name.equals(buscado)) //recorrerá la lista hasta encontrar lo que se solicitó (buscado)
        {
            temp = temp.next; //irá recorriendo toda la lista nodo por nodo
        } 
        
        return temp; //devuelve el nodo temp si encontró el nodo buscado; sino, temp = null;
    }
    
    /**
     * Buscar un nodo por su campo clave e insertar un nuevo nodo después de él.
     */
    public boolean insertarDespuesDeNodo(Object buscado, Object nuevoNombre)
    {
        Node temp = this.top; //se crea temp y se le asigna  la cabeza
        
        temp = this.buscarNodoPorValor(buscado); //utlizando el método anterior a este se buscará el valor
        
        //verifica si el nodo buscado se encontró
        if (temp != null)
        {
            Node nuevoNodo = new Node(); //creación del nuevo nodo que se quiere insertar
            nuevoNodo.name = nuevoNombre; //se le da un valor al nodo creado
            nuevoNodo.next = temp.next; //el siguiente nodo del nuevoNodo será el siguiente nodo del nodo encontrado
            temp.next = nuevoNodo; //se le enlaza nuevoNodo a temp; es decir, se pone nuevoNodo después de temp
            
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
    public boolean intercambiarNodos(Object nodo1, Object nodo2)
    {
        //inicialización de nodos
        Node temp1 = null, temp2 = null, prev1 = null, prev2 = null;
        Node temp = this.top; //se crea temp y se le asigna  la cabeza
        
        //buscar los nodos y sus nodos previos
        
        while (temp != null)
        {
            //busca el nodo1
            if (temp.name.equals(nodo1)) //si temp = nodo1
            {
                //temp1 se establece en temp y sale del bucle
                temp1 = temp; 
                break;
            }
            else
            { //si temp != nodo1 
                prev1 = temp; //prev1 se establece en temp
                temp = temp.next; //temp sigue recorriendo los siguientes nodos de la lista uno por uno
            }
        }
        
        temp = this.top; //temp se le asigna la cabeza
        
        while (temp != null)
        {
            //busca el nodo2
            if (temp.name.equals(nodo2))
            {
                //temp2 se establece en temp y sale del bucle
                temp2 = temp;
                break;
            }
            else
            {
                prev2 = temp; //prev2 se establece en temp
                temp = temp.next; //temp sigue recorriendo los siguientes nodos de la lista uno por uno
            }
        }
        
        //verificar si ambos nodos fueron encontrados
        if (temp1 != null && temp2 != null)
        {
            //actualiza los punteros de los nodos previos
            
            if (prev1 != null)
            {
                prev1.next = temp2;
            }
            else
            {
                this.top = temp2; //se volvería cabeza porque significaría que no hay nodo previo
            }
            
            if (prev2 != null)
            {
                prev2.next = temp1;
            }
            else
            {
                this.top = temp1; //se volvería cabeza porque significaría que no hay nodo previo
            }
            
            //intercambiar los punteros de los nodos
            Node tempNext = temp1.next; //se crea tempNext y se le asigna el nodo siguiente de temp1
            temp1.next = temp2.next; //ahora el siguiente de temp1 será el siguiente de temp2
            temp2.next = tempNext; //ahora el siguiente de temp2 será el nodo tempNext (el siguiente de temp1)
            
            return true; //devuelve true porque sí se lograron intercambiar los nodos
        }
        else
        {
            return false; //devuelve false porque al menos uno de los nodos no fue encontrado
        }
    }
}













