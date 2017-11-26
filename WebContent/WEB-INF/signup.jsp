<!DOCTYPE html>
<head>
<title>Inscription</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
</head>
<body>
<div class="reg-w3">
<div class="w3layouts-main">
	<h2>Inscription</h2>
		<form action="Inscription" method="post" enctype="multipart/form-data"> 
			<input type="text" required="" class="ggg" name="nom" placeholder="NOM" 
			value="<c:if test="${ !empty erreurs }"><c:out value="${ utilisateur.nom }"/></c:if>">
			<c:if test="${ !empty erreurs.nom }">
			<span class="erreur">${ erreurs.nom }</span>
			</c:if>
			<input type="email" required="" class="ggg" name="email" placeholder="E-MAIL" 
			value="<c:if test="${ !empty erreurs }"><c:out value="${ utilisateur.email }"/></c:if>">
			<c:if test="${ !empty erreurs.email }">
			<span class="erreur">${ erreurs.email }</span>
			</c:if>
			<input type="password" required="" class="ggg" name="pass" placeholder="MOT DE PASSE" >
			<c:if test="${ !empty erreurs.pass }">
			<span class="erreur">${ erreurs.pass }</span>
			</c:if>
			<label style="font-weight:normal !important;text-align:left;color:#f1aea2;" for="agree">
			Photo</label>
			<input type="file" required="" class="ggg" name="photo" >
			<br><br>
			<h4><input type="checkbox" name="agree" id="agree"/>
			<label style="font-weight:normal !important;position: relative;bottom: 15px;left:25px" for="agree">
			J'accepte les conditions d'utilisation et la politique de confidentialité
			</label></h4>
			<c:if test="${ !empty erreurs.agree }">
			<span class="erreur">${ erreurs.agree }</span>
			</c:if>
				<div class="clearfix"></div>
				<input type="submit" value="S'inscrire">
		</form>
		
			<c:choose>
				<c:when test="${ !empty message }">
					<p style="color:#b6f7b6 !important;">${ message }<a href="<c:url value="/Login"/>">Se connecter</a></p>
				</c:when>
				<c:otherwise>
					<p>Déjà inscrit?<a href="<c:url value="/Login"/>">Se connecter</a></p>
				</c:otherwise>
			</c:choose>
		
</div>
</div>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
