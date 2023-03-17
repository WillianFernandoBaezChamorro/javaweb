<%-- 
    Document   : pizarras
    Created on : 16/03/2023, 06:37:14 PM
    Author     : luisgm
--%>

<%@page import="modelo.Tipos"%>
<%@page import="modelo.Pizarras"%>
<%@page import="java.util.List"%>
<%@page import="control.TiposControl"%>
<%@page import="control.PizarrasControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizarras</title>
    </head>
    <body>
        <h1 align="center">Pizarras</h1>



        <%
            PizarrasControl pizarrasControl = new PizarrasControl();
            TiposControl tiposControl = new TiposControl();
            Pizarras pizarraObj = null;

            String reg = request.getParameter("reg");
            if (reg == null) { // listado
        %>


        <table border="1" align="center" width="90%">
            <tr>
                <th>ID</th>
                <th>Tipo</th>
                <th>Descripcion</th>
                <th>Dimension</th>
                <th>Material</th>
                <th width="5%">  <a href="?reg=si">Nuevo</a>   </th>
                <th width="5%"></th>
            </tr>

            <%
                List<Pizarras> pizarrases = pizarrasControl.listar();
                for (int i = 0; i < pizarrases.size(); i++) {
                    pizarraObj = pizarrases.get(i);
            %>

            <tr>
                <td> <%= pizarraObj.getId()%> </td>
                <td> <%= pizarraObj.getTiposId().getDescripcion()%> </td>
                <td> <%= pizarraObj.getDescripcion()%> </td>
                <td> <%= pizarraObj.getDimensiones()%> </td>
                <td> <%= pizarraObj.getMaterial()%> </td>
                <td align="center"> <a href="?reg=si&id=<%= pizarraObj.getId()%>">Mod</a> </td>
                <td align="center"> <a href="Spizarras?del=si&id=<%= pizarraObj.getId()%>">Del</a> </td>
            </tr>

            <%
                }
            %>


        </table>





        <%
        } else { // formulario

            Tipos tiposId = null;
            String descripcion = "";
            String dimension = "";
            String material = "";

            String id = request.getParameter("id");
            if (id != null) {
                pizarraObj = pizarrasControl.buscar(id);
                tiposId = pizarraObj.getTiposId();
                descripcion = pizarraObj.getDescripcion();
                dimension = pizarraObj.getDimensiones();
                material = pizarraObj.getMaterial();
            }


        %>


        <form action="Spizarras" method="post">

            <table border="1" align="center">
                <tr>
                    <td>Id</td>
                    <td> <%= id %> </td>
                </tr>
                <tr>
                    <td>Tipo</td>
                    <td> 
                        <select name="tipos_id">
                            <option value="">** Seleccione</option>                            
                            <%                                
                                List<Tipos> tiposes = tiposControl.listar();
                                for (int i = 0; i < tiposes.size(); i++) {
                            %>
                            <option value="<%= tiposes.get(i).getId()%>" <%
                                    if( (id!=null) && ( tiposId.getId()==tiposes.get(i).getId() ) ){
                                        out.print( "selected" );
                                    }
                                    %>>
                                <%= tiposes.get(i).getDescripcion()%>
                            </option>
                            <%
                                }
                            %>                            
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td>
                        <input type="text" name="descripcion" value="<%= descripcion %>" placeholder="descd" />
                    </td>
                </tr>
                <tr>
                    <td>Dimension</td>
                    <td>
                        <input type="text" name="dimension" value="<%= dimension %>" />
                    </td>
                </tr>
                <tr>
                    <td>Material</td>
                    <td>
                        <input type="text" name="material" value="<%= material %>" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" align="center">

                        <input type="hidden" name="id" value="" />
                        <a href="?">Cancelar</a> &nbsp; 
                        <input type="submit" />

                    </td>
                </tr>
            </table>


        </form>


        <%
            }
        %>






    </body>
</html>
