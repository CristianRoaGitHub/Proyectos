<%-- 
    Document   : index
    Created on : 10-mar-2018, 20:57:54
    Author     : ACER/Cristian Roa Student
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.crisoft.sistemacomercializadora.modelos.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bootstrap Admin Theme v3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="<%= request.getContextPath()%>/styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- styles -->
        <link href="<%= request.getContextPath()%>/styles/css/styles.css" rel="stylesheet">

    </head>
    <% 
        List<Categoria> listaCategorias = (List<Categoria>)  request.getAttribute("categorias");
        
    %>
    <body>
        <jsp:include page="../layouts/header.jsp"></jsp:include>
        <div class="page-content">
            <div class="row">
            <jsp:include page="../layouts/sidebar.jsp"></jsp:include>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">Striped Rows</div>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Id categoria</th>
                                                <th>Nombre Categoria</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for(Categoria cat: listaCategorias){ %>
                                                <tr>
                                                    <td> <%= cat.getCategoriaId() %> </td>
                                                    <td> <%= cat.getNombreCat() %> </td>
                                                </tr>
                                                    
                                                <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <jsp:include page="../layouts/footer.jsp"></jsp:include>



        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>