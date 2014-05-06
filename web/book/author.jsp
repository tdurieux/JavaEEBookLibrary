<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Market</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css.css">
  </head>
  <body>
    <f:view>
      <jsp:include page="/template/header.jsp" />
    <section class="wrap">
      <h2>${bookmanager.author}'s Books</h2>
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
              <h:form id="order-${book.title}">
                <span class="price">${book.price}€ x</span>
                <h:inputText requiredMessage="*"
                             id="${book.title}-quantity"
                             value="1"
                             styleClass="quantity"
                             required="true">
                  <f:convertNumber type="number" integerOnly="true" minIntegerDigits="0"/>
                </h:inputText>
                <h:commandButton value="Order"
                                 styleClass="order"
                                 action="#{ordermanager.addBookToCart}">
                  <f:param name="title" value="#{book.title}" />
                </h:commandButton>
              </h:form>
            </div>
          </li>
        </c:forEach>
        <c:if test="${empty bookmanager.getBooks()}">
          <li class="no-book">
            No book found
          </li>
        </c:if>
      </ul>
      <div class="clear"></div>
    </section>
  </f:view>
</body>
</html>
