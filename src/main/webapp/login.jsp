  <form role="form" name = "LoginForm" action = "LoginServlet" method = post>
    <div class="form-group">
      <label for="email">Email address:</label>
      <input type="email" class="form-control" id="email" name = "email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" name = "password">
    </div>
    <button type="submit" class="btn btn-default">Log in</button>
  </form>
  <form role = "form" name = "SignUpForm" action = "SignUp.jsp" method = get>
    <button type = "submit" class = "btn btn-default">Sign Up</button>
  </form>

