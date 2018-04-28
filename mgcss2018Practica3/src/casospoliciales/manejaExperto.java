/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casospoliciales;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author marcys-okomo
 */
public class manejaExperto {
    private Session sesion;
    private Transaction tx;
    
    Scanner sc = new Scanner(System.in);

    public manejaExperto() {
    }
    
    /**
     * Metodo que inicializa la operacion del Framework a nivel de la BD
     * @throws HibernateException 
     */
    
   public void inicioOperacion() throws HibernateException{
       System.out.println("Comenzando hibernate");
       sesion = HibernateUtil.getSessionFactory().openSession();
       tx = sesion.beginTransaction();
       
   }
   
   /**
    * que tenemos que guardar en la base de datos como objetivo de la operacion
    * @param experto 
    */
   public  void guardaExperto(Experto experto)
   {
       try{
       inicioOperacion();
         System.out.println("\n\t__________Sesion: Guardar Experto  " +experto.getCodexperto() + "__________");
       sesion.save(experto);
       System.out.println("__________Experto Guardado satisfactoriamente__________");
       }catch(HibernateException ex)
       {
           manejaExcepcion(ex);
           throw ex;
           
       }finally{finalizarOperacion();}
   }
   /**
    * Codigo del experto a eliminar. Se puede leer por parametro por el usuario de la BD
    * @param codigoexperto 
    */
   public void eliminarExperto(String idExperto){
       try{
       inicioOperacion();
           sesion.delete(sesion.get(Experto.class, idExperto)); //aqui lo eliminaria dado el codigo
      // sesion.delete(experto);
            System.out.println("__________Experto Eliminado satisfactoriamente__________ " + idExperto);
       }catch(HibernateException ex)
       {
           manejaExcepcion(ex);
           throw ex;
           
       }finally{finalizarOperacion();}
   }
   /**
    * Actualiza el experto pasado por parametro en la BD
    * @param codigoexperto 
    */
   public void actualizarExperto(String idExperto){
       try{
            inicioOperacion();
            Experto experto = (Experto) sesion.get(Experto.class, idExperto);
            System.out.println("\n\t__________Sesion: Actualizando un experto__________ " + idExperto);
            System.out.print("\t\tNuevo Nombre del Experto:");
            experto.setNombre(sc.next());
            System.out.print("\t\tNueva Especialidad del experto:");
            experto.setEspecialidad(sc.next());

            sesion.update(experto);
            System.out.println("__________Experto Actualizado satisfactoriamente__________");
       
       }catch(HibernateException ex)
       {
           manejaExcepcion(ex);
           throw ex;
           
       }finally{finalizarOperacion();}
   }
   /**
    * Obtiene los datos del experto dado su identifcador o codigo
    * @param idExperto 
    */
    public void obtenerExperto(String idExperto){
       try{
            inicioOperacion();
            System.out.println("\n\t__________Sesion: Datos del experto Experto " +idExperto + "__________");
            
            Experto experto = new Experto();
            experto = (Experto) sesion.get(Experto.class, idExperto);
            
            System.out.println(experto);
            System.out.print("__________Experto obtenido satisfactoriamente__________");
       
       }catch(HibernateException ex)
       {
           manejaExcepcion(ex);
           throw ex;
           
       }finally{finalizarOperacion();}
   }
   /**
    * 
    * @param ex
    * @throws HibernateException  Metodo que maneja las excepsiones del framework hibernate
    */
   public void manejaExcepcion( HibernateException ex) throws HibernateException
   {
       tx.rollback();
       System.out.println("Error en acceso a datos  " + ex.getMessage());
       System.exit(0);
   } 
   
   /**
    * Metodo que finaliza la operacion en la base de datos-->Commit
    * @throws HibernateException 
    */
   public void finalizarOperacion() throws HibernateException
   {
       tx.commit();
       sesion.close();
       System.out.println("Cerrando sesion");
               
   }
}
