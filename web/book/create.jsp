<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Market - Create New Book</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css.css">
  </head>
  <body>
    <f:view>
      <jsp:include page="/template/header.jsp" />
    <section class="wrap">
      <h1>Create New Book</h1>
      <h:form id="create">            
        <h:panelGrid columns="3" border="0">
          Title: <h:inputText id="title"
                       requiredMessage="*"
                       value="#{bookmanager.bookTitle}"
                       required="true"/>  
          <h:message for="create:title" style="color: red"/>
          Author: <h:inputText id="author"
                       requiredMessage="*"
                       value="#{bookmanager.bookAuthor}"
                       required="true"/>
          <h:message for="create:author" style="color: red"/>
          Year: <h:inputText id="year"
                       requiredMessage="*"
                       value="#{bookmanager.bookYear}"
                       required="true"/>
          <h:message for="create:year" style="color: red"/>
          Price: <h:inputText id="price"
                       requiredMessage="*"
                       value="#{bookmanager.bookPrice}"
                       required="true"/>
          <h:message for="create:price" style="color: red"/>
        </h:panelGrid>
        <h:commandButton id="submit" 
                         value="Create"
                         action="#{bookmanager.createBook}"/>
        <h:messages style="color: red" globalOnly="true"/>
      </h:form>
    </section>
  </f:view>
</body>
</html>
