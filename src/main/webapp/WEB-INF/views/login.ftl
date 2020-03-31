<!doctype html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{layout}"lang="en">
<head>
    <title>Login</title>
</head>
<body>

<div layout:fragment="content">
    <div class="container main-content">
        <h3>Landon Hotel Employee Login</h3>
        <form th:action="@{/login}" method="post">
            <div th:if="${param.error}">
                <div class="alert alert-danger">
                    Invalid username or password.
                </div>
            </div>
            <div class="form-group row">
                <label for="username" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-6">
                    <input type="text" id="username" name="username" class="form-control" placeholder="Username" autofocus="autofocus">
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-6">
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password" autofocus="autofocus">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>