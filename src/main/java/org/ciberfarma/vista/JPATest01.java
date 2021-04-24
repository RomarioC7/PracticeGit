package org.ciberfarma.vista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.ciberfarma.modelo.Usuario;

public class JPATest01 {

	public static void main(String[] args) {
		
		// Crear un objeto de Usuario a grabar
		Usuario u = new Usuario();
		//u.setCodigo(10); es autoincrement
		u.setNombre("Giannela");
		u.setApellido("Pierina");
		u.setUsuario("giannela@ciber.com");
		u.setClave("123");
		u.setFnacim("2000/10/15");
		u.setTipo(1);
		u.setEstado(1);
		
		// grabar el objeto
		// 1. fabricar el acceso a los datos //llama al pom.xml debe estar el noimbe en xml.
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// 3. empezar mi transacci�n
		em.getTransaction().begin();
		// proceso a realizar (persistencia)
		em.persist(u);//si solo es registrar usas esto.	
		//em.merge(u);//si los datos existen, va actualizar
		// 4. confirmar la transacci�n
		em.getTransaction().commit();
		
		//cerramos el manejador
		em.close();
	}

}
