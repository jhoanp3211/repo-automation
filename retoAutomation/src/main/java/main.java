import models.Persona;

public class main {

    public static void main(String[] args) throws Exception {
    String direccion= "insumo.txt";

        System.out.println("1. El archivo contiene los siguientes datos");
        Persona.toStringLista(direccion);

        System.out.println( "\n2. El numero de filas del archivo es: "+Persona.sLista(direccion).size());

        System.out.println("\n3. Datos de los asociados");
        Persona.toStringListaPersonas(direccion);


    }
}
