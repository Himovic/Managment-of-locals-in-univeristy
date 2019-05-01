<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Acceuil</title>
	<link href="StartScreen/css/bootstrap.min.css" rel="stylesheet">
	<link href="StartScreen/css/font-awesome.min.css" rel="stylesheet">
	<link href="StartScreen/css/datepicker3.css" rel="stylesheet">
	<link href="StartScreen/css/styles.css" rel="stylesheet">
	
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
					<li><a class="" href="StartScreen/addLocal.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Ajouter Local
					</a></li>
					<li><a class="" href="StartScreen/ModifLocal.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Modifier Local
					</a></li>
					<li><a class="" href="StartScreen/SuppLocal.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Supprimer Local
					</a></li>
					<li><a class="" href="StartScreen/SearchLocal.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Chercher Local
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-2">
				<em class="fa fa-navicon">&nbsp;</em>EQUIPEMENTS<span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="StartScreen/addEquip.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Ajouter équipement
					</a></li>
					<li><a class="" href="StartScreen/SupprimerEquip.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Supprimer équipemen
					</a></li>
					<li><a class="" href="StartScreen/AllEquipement.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Chercher Equipemen
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-3">
				<em class="fa fa-navicon">&nbsp;</em>CRENEAUX<span data-toggle="collapse" href="#sub-item-3" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li><a class="" href="StartScreen/addCreneau.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Ajouter créneau
					</a></li>
					<li><a class="" href="StartScreen/ModifierCreneau.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Modifier créneau
					</a></li>
					<li><a class="" href="StartScreen/DeleteCreneau.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Supprimer créneau
					</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-4">
				<em class="fa fa-navicon">&nbsp;</em>RESERVATIONS<span data-toggle="collapse" href="#sub-item-4" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-4">
					<li><a class="" href="StartScreen/ReserverLocal.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Réserver un local
					</a></li>
					<li><a class="" href="StartScreen/LibererReservation.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span> Libérer réservation
					</a></li>
				</ul>
			</li>
			<!-- Listes des menus qui sont possiblement visualisés ; contient les calendriers , les graph , ...-->
			<!--<li><a href="widgets.html"><em class="fa fa-calendar">&nbsp;</em> Widgets</a></li>
			<li><a href="charts.html"><em class="fa fa-bar-chart">&nbsp;</em> Charts</a></li>
			<li><a href="elements.html"><em class="fa fa-toggle-off">&nbsp;</em> UI Elements</a></li>
			<li><a href="panels.html"><em class="fa fa-clone">&nbsp;</em> Alerts &amp; Panels</a></li>-->
			<li><a href="index.jsp"><em class="fa fa-power-off">&nbsp;</em>Déconnécter</a></li>
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
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Statistiques</h1>
			</div>
		</div><!--/.row-->
		
		<div class="panel panel-container"><!-- Récupérer les nombres de ces statistiques via les méthods(BD) -->
			<div class="row">
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-teal panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-shopping-cart color-blue"></em>
							<div class="large">120</div>
							<div class="text-muted">Nombre des locaux</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-blue panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-comments color-orange"></em>
							<div class="large">52</div>
							<div class="text-muted">Nombre des réservations</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-orange panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
							<div class="large">24</div>
							<div class="text-muted">Nombre équipements bon état</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-red panel-widget ">
						<div class="row no-padding"><em class="fa fa-xl fa-search color-red"></em>
							<div class="large">25.2k</div>
							<div class="text-muted">Nombre équipements mauvais état</div>
						</div>
					</div>
				</div>
			</div><!--/.row-->
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						Traffic de réservation
						<span class="pull-right clickable panel-toggle panel-button-tab-left"><em class="fa fa-toggle-up"></em></span></div>
					<div class="panel-body">
						<div class="canvas-wrapper">
							<canvas class="main-chart" id="line-chart" height="200" width="600"></canvas>
						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
		<!-- Les méthodes récupérées avant dans le premier contexte des statistiques , -->
		<!-- Ces nombres seront convertis en pourcentage -->
		<div class="row">
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Nombre des locaux</h4>
						<div class="easypiechart" id="easypiechart-blue" data-percent="92" ><span class="percent">92%</span></div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Nombre des réservations</h4>
						<div class="easypiechart" id="easypiechart-orange" data-percent="65" ><span class="percent">65%</span></div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Nombre équipements bon état</h4>
						<div class="easypiechart" id="easypiechart-teal" data-percent="56" ><span class="percent">56%</span></div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Nombre équipements mauvais état</h4>
						<div class="easypiechart" id="easypiechart-red" data-percent="27" ><span class="percent">27%</span></div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
		

	</div>	<!--/.main-->
	
	<script src="StartScreen/js/jquery-1.11.1.min.js"></script>
	<script src="StartScreen/js/bootstrap.min.js"></script>
	<script src="StartScreen/js/chart.min.js"></script>
	<script src="StartScreen/js/chart-data.js"></script>
	<script src="StartScreen/js/easypiechart.js"></script>
	<script src="StartScreen/js/easypiechart-data.js"></script>
	<script src="StartScreen/js/bootstrap-datepicker.js"></script>
	<script src="StartScreen/js/custom.js"></script>
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