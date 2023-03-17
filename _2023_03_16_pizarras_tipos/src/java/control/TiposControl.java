/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.TiposDAO;
import java.util.List;
import modelo.Tipos;

/**
 *
 * @author luisgm
 */
public class TiposControl {
    
    public List<Tipos> listar(){
        return new TiposDAO().listar();
    }
    
}
