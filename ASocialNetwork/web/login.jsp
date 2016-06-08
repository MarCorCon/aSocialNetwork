    <jsp:include page="index.jsp"></jsp:include>  
   
 
    <%@ taglib uri="/struts-tags" prefix="s" %>  
      
    <s:form action="loginprocess">  
    <s:textfield name="username" label="Name"></s:textfield>  
    <s:password name="userpass" label="Password"></s:password>  
    <s:submit value="login"></s:submit>  
    
    </s:form>  
    
    <s:a href="register">register</s:a>