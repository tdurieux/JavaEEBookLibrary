<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<header>
  <section class="wrap">
    <div class="title">Book Market</div>
    <nav>
      <ul>
        <li><a href="${pageContext.request.contextPath}/p/index.jsp">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/p/book/authors.jsp">Authors</a></li>
        <li><a href="${pageContext.request.contextPath}/p/book/order.jsp">Order</a></li>
          <c:if test="${!usermanager.isConnected()}">
          <li><a href="${pageContext.request.contextPath}/p/user/login.jsp">Login</a></li>
          <li><a href="${pageContext.request.contextPath}/p/user/create.jsp">Register</a></li>
          </c:if>
          <c:if test="${usermanager.isConnected()}">
          <li><a href="${pageContext.request.contextPath}/p/book/create.jsp">Add new book</a></li>
          <li>
          <li>
            <h:form>
              <h:commandButton id="logout" value="Logout" action="#{usermanager.logout}"/>
            </h:form>
          </li>
        </c:if>
      </ul>
    </nav>
  </section>
</header>