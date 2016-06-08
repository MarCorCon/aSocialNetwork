    <%@page import="entidades.Usuario"%>
<jsp:include page="index.jsp"></jsp:include>  
   
    <%@ taglib uri="/struts-tags" prefix="s" %>  
    <br/>Welcome,   <s:property value="#session.usuario.nombre"/>  

    
    <s:a href="logout">logout</s:a>