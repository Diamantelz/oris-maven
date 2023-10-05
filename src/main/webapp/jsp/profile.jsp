<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Profile</title>
  <link rel="stylesheet" href="../resources/styles/style.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="profile-page">
  <div class="container">
    <div class="caption">
      <h1 class="caption-params">Профиль</h1>
    </div>
    <div class="row prifile-columns">
      <div class="col-sm-4">
        <div class="block-info">
            <h3>Подробности</h3>
            <h5>Имя:</h5>
            <h6>-</h6>

            <h5>Возраст:</h5>
            <h6>-</h6>

            <h5>Пол:</h5>
            <h6>-</h6>

            <h5>Расположение:</h5>
            <h6>-</h6>

            <h5>Почта:</h5>
            <h6>${personByUUID.email}</h6>

            <h5>Дата рождения:</h5>
            <h6>-</h6>

            <h5>Никнейм:</h5>
            <h6>${personByUUID.nickname}</h6>

        </div>
      </div>
      <div class="col-sm-4">
        <div class="block-photo-links">
          <h3>Фотография профиля</h3>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="block-about-me">
          <h3>Обо мне</h3>
          <h6>Lorem ipsum dolor sit amet consectetur adipisicing elit. Itaque iste qui commodi esse nisi molestiae, ab, nemo quibusdam, porro vitae iusto veniam ipsum perspiciatis molestias dicta at. Excepturi, suscipit commodi!</h6>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>
