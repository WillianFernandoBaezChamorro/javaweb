/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.Pizarras;

/**
 *
 * @author luisgm
 */
public class PizarrasDAO {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("_2023_03_16PU");
    EntityManager em = emf.createEntityManager();
    
    
    public List<Pizarras> listar(){
        TypedQuery query = em.createNamedQuery("Pizarras.findAll", Pizarras.class);
        return query.getResultList();
    }
    
    public Pizarras buscar( String id ){
        Integer idInt = Integer.parseInt(id);
        Pizarras p = new Pizarras(idInt);
        p = em.find(Pizarras.class, p.getId());
        return p;
    }
    
    public void insertar( Pizarras p ){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void modificar( Pizarras p ){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void eliminar( Pizarras p ){
        em.getTransaction().begin();
        p = em.find(Pizarras.class, p.getId());
        if(p!=null ){
            em.remove(p);
        }
        em.getTransaction().commit();
    }
    
}
