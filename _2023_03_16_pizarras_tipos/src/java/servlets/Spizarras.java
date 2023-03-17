/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.PizarrasControl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pizarras;
import modelo.Tipos;

/**
 *
 * @author luisgm
 */
public class Spizarras extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            PizarrasControl pizarrasControl = new PizarrasControl();
            String id = request.getParameter("id");
            Integer idInt = null;
            if ( !id.equals("") ) {
                idInt = Integer.parseInt(id);
            }
            String tipos_id = request.getParameter("tipos_id");
            Tipos tiposId = null;
            if( tipos_id!=null ){
                tiposId = new Tipos( Integer.parseInt(tipos_id) );
            }
            String descripcion = request.getParameter("descripcion");
            String dimension = request.getParameter("dimension");
            String material = request.getParameter("material");
            Pizarras p = new Pizarras(idInt, descripcion, dimension, material, tiposId);
            if( id==null ){ // insertar
                pizarrasControl.insertar(p);
            } else {
                if( request.getParameter("del")==null ){ // mod
                    pizarrasControl.modificar(p);
                } else { // elim
                    pizarrasControl.eliminar(p);
                }
            }
            response.sendRedirect("pizarras.jsp");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
