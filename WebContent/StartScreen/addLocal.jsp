<%@page import="Functions.EquipementFunction"%>
<%@page import="Model.Equipement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ajouter Local</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
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
	ArrayList<Equipement> listEquipement = EquipementFunction.AllEquipement();
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
						<span class="fa fa-arrow-right">&nbsp;</span> Modifier �quipement
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Supprimer �quipemen
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Chercher �quipement
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-3">
				<em class="fa fa-navicon">&nbsp;</em>RESERVATIONS<span data-toggle="collapse" href="#sub-item-3" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> R�server un local
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Modifier r�servation
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Lib�rer r�servation
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span> Chercher r�servation
					</a></li>
				</ul>
			</li>
			<!-- Listes des menus qui sont possiblement visualis�s ; contient les calendriers , les graph , ...-->
			<!--<li><a href="widgets.html"><em class="fa fa-calendar">&nbsp;</em> Widgets</a></li>
			<li><a href="charts.html"><em class="fa fa-bar-chart">&nbsp;</em> Charts</a></li>
			<li><a href="elements.html"><em class="fa fa-toggle-off">&nbsp;</em> UI Elements</a></li>
			<li><a href="panels.html"><em class="fa fa-clone">&nbsp;</em> Alerts &amp; Panels</a></li>-->
			<li><a href="login.html"><em class="fa fa-power-off">&nbsp;</em>D�conn�cter</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active"></li>
			</ol>
		</div><!--/.row-->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Ajouter un local</h1>
			</div>
		</div><!--/.row-->
		
		<section class="contact-wrap">
		<form action="http://localhost:8080/GestionLocal/LocalCtrl" method="POST" class="contact-form">
    	<input type="hidden" id="hiddenajoutlocal" value="hiddenajoutlocal"/>
    	<label for="">S�lectionner les �quipements</label>
    	<%for(int i=0 ; i< listEquipement.size() ; i++){ %>
			<div class="col-sm-12">
      		<div class="input-block">
        	<input type="checkbox" name = "equipement" value="<%= listEquipement.get(i).getIdEquipement()%>" class="form-control" ><%= listEquipement.get(i).getTypeEquipement()%>
      		</div>
    		</div>
    	<%} %><br /><br />
    	<div class="col-sm-12">
      	<div class="input-block">
        <label for="">Nom du local</label>
        <input type="text" id ="nomlocal" name="nomlocal" placeholder="nom du local" class="form-control" required/>
      </div>
      <div class="input-block">
        <label for="">Nombre table</label>
        <input type="number" id="nbrtable" name="nombretable" placeholder="nombre de tables" class="form-control" required/>
      </div>
    	</div><br /><br />
    <div class="col-sm-12">
      <div class="input-block">
        <label for="">Priorit� des niveaux</label>
        <input type="checkbox" name="niveau" value="L1" class="form-control" />L1
        <input type="checkbox" name="niveau" value="L2" class="form-control" />L2
        <input type="checkbox" name="niveau" value="L3" class="form-control" />L3
        <input type="checkbox" name="niveau" value="M1" class="form-control" />M1
        <input type="checkbox" name="niveau" value="M2" class="form-control" />M2
      </div>
    </div><br /><br />
    <div class="col-sm-12">
      <div class="input-block">
        <label for="">Num�ro</label>
        <input type="number" id="numero" name="numero" placeholder="Numero du local" class="form-control" required/>
      </div>
    </div><br /><br />
    <div class="col-sm-12">
      <div class="input-block textarea">
        <label for="">Etage</label>
        <input type="number" id="etage" name="etage" placeholder="Etage du local" class="form-control" required/>
      </div>
    </div><br /><br />
    <div class="col-sm-12">
      <input type="submit" id="confirmer" value="Confirmer"  class="btn btn-primary btn-lg btn-block"/>
    </div>
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
	<script src="js/getAllId.js"></script>
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