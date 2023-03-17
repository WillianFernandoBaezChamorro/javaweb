/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.PizarrasDAO;
import java.util.List;
import modelo.Pizarras;

/**
 *
 * @author luisgm
 */
public class PizarrasControl {
    
    public List<Pizarras> listar(){
        return new PizarrasDAO().listar();
    }
    
    public Pizarras buscar( String p ){
        return new PizarrasDAO().buscar(p);
    }
    
    public void insertar( Pizarras p ){
        new PizarrasDAO().insertar(p);
    }
    
    public void modificar( Pizarras p ){
        new PizarrasDAO().modificar(p);
    }
    
    public void eliminar( Pizarras p ){
        new PizarrasDAO().eliminar(p);
    }
    
}
