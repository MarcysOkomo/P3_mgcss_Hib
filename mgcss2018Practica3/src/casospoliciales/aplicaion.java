/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casospoliciales;

import java.util.Scanner;
import org.apache.derby.impl.store.raw.xact.EscalateContainerKey;

/**
 *
 * @author marcys-okomo
 */
public class aplicaion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Iniciando la aplicacion");
        
        //declaracion de opjetos -->Pregunta 1
        Scanner sc = new Scanner(System.in);
        manejaExperto maneja = new manejaExperto();
        Experto  experto1 = new Experto();
        Colabora colabora1 = new Colabora();
        CasoPolicial caso1 = new CasoPolicial();
        
        
        int op;
        do{
            //menu de la aplicacion
            System.out.println("\n\t__________Menu: MENEJA EXPERTO__________");
            System.out.println("\t\t1.- Guardar Experto en la BD");
            System.out.println("\t\t2.- Eliminar Experto en la BD");
            System.out.println("\t\t3.- Actualizar Experto en la BD");
            System.out.println("\t\t4.- Obtener Experto en la BD");
            System.out.print("\t\t0.- Salir");
            System.out.print("\t Elige opcion:");
            op=sc.nextInt();
            
            //Empieza el switch
           switch(op)
           {
               case 1: //Se le puede adjuntar la opcion de leer datos por teclado al guardar experto.
                   System.out.println("__________Sesion: Guardar experto__________");
                   experto1 = new Experto("2043", "Buatengs","Guinea Ecuatorial", "Infomatica" );
                   maneja.guardaExperto(experto1);
                   
                   break;
               case 2:
                   
                   System.out.println("__________Sesion: Eliminar experto__________");
                   //experto1 = new Experto("2011", "Marcelin","Guinea Ecuatorial", "Infomatica" );
                   System.out.print("\n\t\tInserte el codigo del experto que quiere Eliminar:");
                   maneja.eliminarExperto(sc.next());
                  // maneja.eliminarExperto("2011"); 
                   break;
                   
               case 3:
                    System.out.println("__________Sesion: Actualizar experto__________");
                    System.out.print("\n\t\tInserte el codigo del experto que quiere Actualizar:");
                    
                    maneja.actualizarExperto(sc.next());
                   // maneja.actualizarExperto("2011");
                   break;
               case 4:
                   
                   System.out.println("__________Sesion: Obtener experto__________");
                   System.out.print("Inserte el codigo del experto que quiere Obtener:");
                   maneja.obtenerExperto(sc.next()); 
                  // maneja.obtenerExperto("2011"); 
                   break;
               case 0:
                   
                   System.out.println("Saliendo del menu MANEJA EXPERTO");
                   break;
           }
           
        }while(op != 0);
        
            
        
        
        //maneja.guardaExperto(experto1);
       // maneja.actualizarExperto(experto1);
       // maneja.eliminarExperto("2030");
        
        System.out.println("Saliendo de la aplicacion");
        
        }
    
}
