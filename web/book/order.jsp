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
    <title>Book Market - Order</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css.css">
  </head>
  <body>
    <f:view>
      <jsp:include page="/template/header.jsp" />
    <section class="wrap">
      <h1>Order</h1>
      <ul class="order_books">
        <li class="row list-inline columnCaptions">
          <span>QTY</span>
          <span>ITEM</span>
          <span>Price</span>
        </li>
        <c:set var="total" value="0"/>
        <c:set var="books" value="${ordermanager.getOrder().getBooks()}"/>
        <c:forEach var="item" items="${books}" >
          <li class="order_book row">
            <span class="quantity"><c:out value="${item.value}"/></span>
            <span class="itemName"><c:out value="${item.key.title}"/></span>
            <h:form>
              <h:commandButton value="remove"
                               styleClass="order"
                               action="#{ordermanager.removeBook}">
                <f:param name="title" value="#{item.key.title}" />
              </h:commandButton>
            </h:form>
            <span class="glyphicon glyphicon-remove"></span>
            <span class="price">
              <c:out value="${item.key.price}">
              </c:out>€
            </span>
          </li>
          <c:set var="total" value="${total+item.key.price*item.value}"/>
        </c:forEach>
        <c:if test="${empty ordermanager.getOrder().getBooks()}">
          <li class="no-order_book">
            No ordered book
          </li>
        </c:if>
        <li class="row totals">
          <span class="itemName">Total:</span>
          <span class="price">
            <c:out value="${total}">
              <f:convertNumber currencySymbol="€" groupingUsed="true"
                               maxFractionDigits="2" type="currency"/>
            </c:out>€
          </span>
          <span class="order">
            <h:form id="order">
              <h:commandButton value="ORDER"
                               styleClass="text-center"
                               action="#{ordermanager.checkout()}"/>
              <h:messages style="color: red" globalOnly="true"/>
            </h:form>
          </span>
        </li>
      </ul>
      <div class="clear"></div>
    </section>
  </f:view>
</body>
</html>
