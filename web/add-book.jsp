<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Market - Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css.css">
  </head>
  <body>
    <jsp:include page="header.jsp" />

    <f:view>
      <h:messages style="color: red"
                  showDetail="true"/>
      <h:form id="login">
        <h:panelGrid columns="2" border="0">
          Username: <h:inputText id="username" 
                       value="#{usermanager.username}"/>        
          Password: <h:inputSecret id="password"
                         value="#{usermanager.password}"/>
        </h:panelGrid>
        <h:commandButton id="submit" 
                         type="submit"
                         value="Login"
                         action="#{usermanager.validateUser}"/>
        <br>
      </h:form>

    </f:view>

  </body>
</html>
