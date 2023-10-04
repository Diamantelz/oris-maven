<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<form style="color: ${cookie.get("color").value}" action="/settings" method="post">
    <h1>Hello!</h1>
    <div>
        <select size="3" name="color" id="">
            <option value="red">Red</option>
            <option value="green">Green</option>
            <option value="black">Black</option>
            <option value="blue">Blue</option>
        </select>
        <input type="submit" value="Save color">
    </div>
</form>

</body>
</html>
