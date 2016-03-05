<%--
  Created by IntelliJ IDEA.
  User: almukthar
  Date: 13/2/16
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Offline Browser Backend Web API</title>
  <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="jumbotron">
    <h2>Offline Browser WebText Extraction Engine</h2>
    <p>Welcome to the Web API for the Offline Browser Android App</p>
    </br>
</div>
<p>This WebApp is Responsible for Removing and Purifying the Web Page from Surples,Unwanted Contents and turning them into Plain Text Form</p>
<form action="ExtractServlet" method="get">
  Enter URL : <input type="text" name="url" class="mytext" placeholder="http://www.somesite.com">
  <select name="OutputType" class="div-inline">
    <option value="1">Plain Text</option>
    <option value="2">HTML</option>
    <option value="3">JSON</option>
  </select>
  <select name="ExtractorType" class="div-inline">
    <option value="1">Article Extractor</option>
    <option value="2">Keep Everything Extractor</option>
  </select>
  </br></br>
  <input type="submit" name="btnSubmit" class="btn-primary">&nbsp;<input type="reset" name="btnReset" class="btn-primary">
</form>
</body>
<style type="text/css">
  html {
    text-align: center;
  }
  .mytext {
    width: 300px;
  }
  .div-inline{
    display:inline-block;
  }
</style>
<div class="navbar navbar-fixed-bottom">
<p>This Project Is Developed Under the Guidance of <strong>Dr.Antony P.J</strong>(Co-ordinator of PG Studies,KVGCE) by <strong>Abdul Ashif</strong> and <strong>Rohan D'Souza</strong></p>
</div>
<div id="below_footer">
  <p></p>
</div>
</html>
