<%@page import="Functions.LocalFunction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Local" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Chercher Détail Local</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<link href="css/modifLocal.css" rel="stylesheet">
	<link href="css/addLocal.css" rel="stylesheet">
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
	<%
	String email = (String)request.getSession().getAttribute("email");
	String name = (String)request.getSession().getAttribute("name");
	ArrayList<Local> AllLocal = (ArrayList<Local>)LocalFunction.AllLocal();
	%>
<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span>Bienvenue</span><%=email%></a><!-- Get the email of the administrateur -->
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-usertitle">
				<div class="profile-usertitle-name"><%=name%></div><!-- Get the name of the administrator -->
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
			<li class="active"><a href="index.html"><em class="fa fa-dashboard">&nbsp;</em>Statistiques</a></li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em>LOCAUX<span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Ajouter Local
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Modifier Local
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Supprimer Local
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Chercher Local
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-2">
				<em class="fa fa-navicon">&nbsp;</em>EQUIPEMENTS<span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Modifier équipement
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Supprimer équipemen
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Chercher équipement
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-3">
				<em class="fa fa-navicon">&nbsp;</em>RESERVATIONS<span data-toggle="collapse" href="#sub-item-3" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Réserver un local
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Modifier réservation
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Libérer réservation
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Chercher réservation
					</a></li>
				</ul>
			</li>
			<!-- Listes des menus qui sont possiblement visualisés ; contient les calendriers , les graph , ...-->
			<!--<li><a href="widgets.html"><em class="fa fa-calendar">&nbsp;</em> Widgets</a></li>
			<li><a href="charts.html"><em class="fa fa-bar-chart">&nbsp;</em> Charts</a></li>
			<li><a href="elements.html"><em class="fa fa-toggle-off">&nbsp;</em> UI Elements</a></li>
			<li><a href="panels.html"><em class="fa fa-clone">&nbsp;</em> Alerts &amp; Panels</a></li>-->
			<li><a href="login.html"><em class="fa fa-power-off">&nbsp;</em>Déconnécter</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Page d'acceuil</li>
			</ol>
		</div><!--/.row-->
		<div id="formequipement">
			<section class="contact-wrap">
			
			</section>
			</div>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Chercher un local</h1>
			</div>
		</div><!--/.row-->
		
		<section class="contact-wrap">
			
			<table class="container">
				
				<thead>
					<tr>
					<th><h1>Nom du Local</h1></th>
					<th><h1>Nombre de table</h1></th>
					<th><h1>Etage du Local</h1></th>
					<th><h1>Priorité des Niveaux</h1></th>
					<th><h1>Numéro du Local</h1></th>
					</tr>
				</thead>
				<%
				for(int i=0 ; i<AllLocal.size();i++){
				%>
				<tbody>
				<tr>
				<td><%= AllLocal.get(i).getNom()%></td>
				<td><%= AllLocal.get(i).getNbrtable()%></td>
				<td><%= AllLocal.get(i).getEtage()%></td>
				<td><%= AllLocal.get(i).getNiveau()%></td>
				<td><%= AllLocal.get(i).getNumero()%></td>
				</tr>
				
				
			<%
				}
			%>
			</tbody>
			</table>
			</section>
			
			<section class="contact-wrap">
			<form id="detailLocal" method="POST" action="http://localhost:8080/GestionLocal/LocalCtrl">
			<table>
			<input type="hidden" name="secondmodif" value="secondmodif"/>
			<tr>
			<td><label>Nom du Local</label></td>
			<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
			<td><label>Nombre de table</label></td>
			<td><input type="text" name="nbrtable" id="nbrtable"/></td>
			</tr>
			<tr>
			<td><label>Priorité du Local</label></td>
			<td><input type="text" name="niveau" id="niveau"/></td>
			</tr>
			<tr>
			<td><label>Etage du Local</label></td>
			<td><input type="number" name="etage" id="etage"/></td>
			</tr>
			<tr>
			<td><label>Numéro du Local</label></td>
			<td><input type="number" name="numero" id="numero" /></td>
			</tr>
			<tr>
			<td><label>Equipement présent au local</label></td>
			<td><input type="text" name="equipement" id="equipement" /></td>
			</tr>
			<tr>
			<td><input type="submit" value="Confirmer"/></td>
			</tr>
			</table>
			</form> 
		</section>
		
		
		

	</div>	<!--/.main-->
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/ModifLocal.js"></script>
	<script>
		window.onload = function () {
	var chart1 = document.getElementById("line-chart").getContext("2d");
	window.myLine = new Chart(chart1).Line(lineChartData, {
	responsive: true,
	scaleLineColor: "rgba(0,0,0,.2)",
	scaleGridLineColor: "rgba(0,0,0,.05)",
	scaleFontColor: "#c5c7cc"
	});
};
	</script>
		
</body>
</html>