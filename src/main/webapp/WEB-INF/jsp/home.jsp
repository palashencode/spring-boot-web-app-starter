<%@include file="templates/header.jsp" %>

<div class="container text-center" style="margin-top:200px;background-color:#efefef;padding:50px;">
  <!-- Content here -->
    <h2>${msg}</h2>
    <c:choose>
    <c:when test="${not empty sessionScope.loggedin}">
       <a class="btn btn-danger" href="logout">logout</a>
    <a class="btn btn-success" href="dashboard">dashboard</a>
    </c:when>
    <c:otherwise>
       <a class="btn btn-success" href="login">login</a>
    </c:otherwise>
    </c:choose>

    <c:choose>
    <c:when test="${not empty sessionScope.loggedin}">
       <h3>Welcome ${sessionScope.username}, you are logged in.</h3>
       <h3>Your role is ${sessionScope.role}</h3>
    </c:when>
    <c:otherwise>
       <h3>Welcome Visitor</h3><h4>please login if you know the secret password (jack,manage)</h4>
    </c:otherwise>
    </c:choose>

</div>
