<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<header>
    <h4>Login</h4>
</header>
<section>
    <form action="/account/login" method="post">
        <label for="user">Username</label>
        <input id="user" name="username" value="${username}"> <br>
        <label for="pass">Password</label>
        <input id="pass" name="password" value="${password}"><br>
        <input id="remem" type="checkbox" name="remember" value="true">
        <label for="remem">Remember me?</label> <br>
        <button>Login</button>
    </form>
</section>
<footer>
    <h4>Lab 4 - java 5 spring boot</h4>
</footer>
</body>
</html>