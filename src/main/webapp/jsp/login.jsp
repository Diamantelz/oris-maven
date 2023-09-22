<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../resources/styles/style.css">
</head>
<body>
<div class="main-layer">
    <div class="form-layer">
        <div class="auth-title">
            <h1>Авторизация</h1>
            <p>Введите ваши данные для входа</p>
        </div>

        <div class="input-data">
            <form action="/login" method="post">
                <input type="email" name="email" class="data-field input-distance" placeholder="Email">
                <input type="password" name="password" class="data-field" placeholder="Пароль"> <br>
                <input type="checkbox" class="remember-me-checkbox"> запомнить меня<br>
                <button type="submit" class="login-submit-button login-button-distance">Войти</button>
                <a href="/registration"><button type="button" class="login-submit-button login-button-distance">Регистрация</button></a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
