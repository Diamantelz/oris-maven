<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="../resources/styles/style.css">
</head>
<body>
<div class="main-layer">
    <div class="reg-form-layer">
        <div class="reg-title">
            <h1>Регистрация</h1>
            <p>Уже есть аккаунт? <a href="/login">Войти</a></p>
            <p>Заполните все поля</p>
        </div>

        <div class="input-data">
            <form action="/registration" method="post">
                <input type="text" name="nick_name" class="data-field input-distance" placeholder="Ник">
                <input type="email" name="email" class="data-field input-distance" placeholder="Email">
                <input type="password" name="password" class="data-field input-distance" placeholder="Пароль">
                <input type="password" name="password_repeat" class="data-field" placeholder="Повторите пароль"> <br>
                <button type="submit" class="login-submit-button login-button-distance">Регистрация</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
