<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Market - Authors</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css.css">
  </head>
  <body>
    <f:view>
      <jsp:include page="/template/header.jsp" />
    <section class="wrap">
      <h1>Authors</h1>
      <ul class="auhtors">
        <c:forEach var="author" items="#{bookmanager.getAuthors()}" >
          <li class="author">
            <a href="${pageContext.request.contextPath}/p/book/author.jsp?author=${author}"> ${author}</a>
          </li>
        </c:forEach>
        <c:if test="${empty bookmanager.getAuthors()}">
          <li class="no-book">
            No Author found
          </li>
        </c:if>
      </ul>
      <div class="clear"></div>
    </section>
  </f:view>
</body>
</html>
