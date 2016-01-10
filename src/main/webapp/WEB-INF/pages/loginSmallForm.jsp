  <form action="login" role="form" name = "LoginForm" method = post>
    <c:if test="${param.error != null}">
      <div class="alert alert-danger">
        <p>Invalid username and password.</p>
      </div>
    </c:if>
    <c:if test="${param.logout != null}">
      <div class="alert alert-success">
        <p>You have been logged out successfully.</p>
      </div>
    </c:if>
    <div class="form-group">
      <label for="username">Email address:</label>
      <input type="text" class="form-control" id="username" name = "username">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name = "password">
    </div>
    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
    <button type="submit" class="btn btn-default">Log in</button>
  </form>

