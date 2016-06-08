
  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib  prefix="s" uri="/struts-tags" %>
      
    </head>
    <body>
             <jsp:include page="index.jsp"></jsp:include>  
        <s:form action="crearUsuario">
            <s:textfield name="email"  label="Email"/><br>
            <s:textfield name="nombre" label="Nombre"/><br>
            <s:textfield name="apellidos" label="Apellidos"/><br>
            <s:textfield name="password" label="ContraseÃ±a"/><br>
            <s:textfield name="fechaNacimiento" label="Fecha de nacimiento"/><br>
            <s:textfield name="fotoPerfil" label="Foto de perfil"/><br>
            <s:submit name="creado" value="CREAR"/>
        </s:form>
    </body>
</html>
