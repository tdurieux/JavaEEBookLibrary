<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Market</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css.css">
  </head>
  <body>
    <jsp:include page="header.jsp" />

    <h2>Books</h2>
    <ul class="books">
      <c:forEach var="book" items="#{bookmanager.getBooks()}" >
        <li>
          <div class="bk-book book-<%= (Math.random() > 0.5 ? 1 : 3)%> bk-bookdefault">
            <div class="bk-front">
              <div class="bk-cover">
                <h2>
                  <span class="author">${book.author}</span>
                  <span class="title">${book.title}</span>
                  <span class="year">${book.year}</span>
                </h2>
              </div>
            </div>
            <div class="bk-left">
              <h2>
                <span class="author">${book.author}</span>
                <span class="title">${book.title}</span>
              </h2>
            </div>
          </div>
          <div class="bk-info">
            <a class="button" href="${pageContext.request.contextPath}/p/add-book.jsp?title=${book.title}">Add to ship list</a>
          </div>
        </li>
      </c:forEach>
      <c:if test="${empty bookmanager.getBooks()}">
        <div class="no-book">
          No book found
        </div>
      </c:if>
    </ul>
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>

  </body>
</html>
