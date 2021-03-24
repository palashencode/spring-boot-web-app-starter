<%@include file="templates/header.jsp" %>
<div class="container text-center" style="margin-top:200px;background-color:#efefef;padding:50px;">
            <h3>Your personalized dashboard</h3>
        <a class="btn btn-danger" href="logout">logout</a>
    <h3> ${sessionScope.username},${sessionScope.role}</h3>
            <a class="" href="home">Home</a>
</div>