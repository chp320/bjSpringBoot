<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/05/19
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Side Menu Example</title>
</head>
<body>
    <div id="sideMenu">
        <ul>
            <li><a href="#" id="menu1">Menu 1</a></li>
            <li><a href="#" id="menu2">Menu 2</a></li>
            <li><a href="#" id="menu3">Menu 3</a></li>
        </ul>
    </div>

    <script>
        // get the menu items by their IDs.
        var menu1 = document.getElementById("menu1");
        var menu2 = document.getElementById("menu2");
        var menu3 = document.getElementById("menu3");

        // add click event listeners to the menu items.
        menu1.addEventListener("click", function () {
            showAlert("Menu 1 clicked!");
        });

        menu2.addEventListener("click", function () {
            showAlert("Menu 2 clicked!");
        });

        menu3.addEventListener("click", function () {
            showAlert("Menu 3 clicked!");
        });

        // function to show an alert.
        function showAlert(message) {
            alert(message);
        }
    </script>
</body>
</html>
