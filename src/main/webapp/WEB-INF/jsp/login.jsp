<html>

    <head>
    <title>Spring Boot Web Application</title>
    <%@include file="templates/header.jsp" %>
    </head>
</head>
<body>



<div class="login-form">




    <c:if test="${not empty errorMessage}">       
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>

    <form action="login" method="post">
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input type="text" name="user" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input type="password" name="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        <%-- <div class="clearfix">
            <label class="float-left form-check-label"><input type="checkbox"> Remember me</label>
            <a href="#" class="float-right">Forgot Password?</a>
        </div>         --%>
    </form>
    <%-- <p class="text-center"><a href="#">Create an Account</a></p> --%>
</div>
</body>
</html>