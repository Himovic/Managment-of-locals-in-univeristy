<%-- 
    Document   : ErrorAuthn
    Created on : 16 oct. 2017, 11:36:29
    Author     : lenovo
--%>

<%@page import="Functions.LoginFunction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Error Authentification</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
  <div class="logoimg">
    <img src="img/logouc2.jpg" alt ="logo"/>
  </div>
  <div class="login-page">
  <div class="form">
    <form class="login-form" method="POST" action="http://localhost:8080/GestionLocal/LoginCtrl">
      <input type="email" name="email" placeholder="Entrez votre email"/>
      <input type="password" name="password" placeholder="Mot de passe"/>
      <input type="submit" name="confirme_login" value="Entrez">
    </form>        
  </div>
        <h3>Email ou Mot de passe sont incorrect</h3>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>

</body>
</html>
