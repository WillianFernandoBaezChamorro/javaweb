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
import modelo.Tipos;

/**
 *
 * @author luisgm
 */
public class TiposDAO {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("_2023_03_16PU");
    EntityManager em = emf.createEntityManager();
    
    public List<Tipos> listar(){
        TypedQuery query = em.createNamedQuery("Tipos.findAll", Tipos.class);
        return query.getResultList();
    }
    
}
