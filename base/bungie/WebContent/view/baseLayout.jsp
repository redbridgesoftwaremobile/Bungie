<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<title>Registro</title>
<link href="styles/tiendaVirtual.css" rel="stylesheet" type="text/css">
<script src="scripts/registro.js"    type="text/javascript"></script>
</head>
<body>
<div class="container">
   <tiles:insertAttribute name="header"/>
   <aside>
   <tiles:insertAttribute name="menu"/>
   </aside>
   <article class="content">   
   <section>
   <tiles:insertAttribute name="title" />
   <tiles:insertAttribute name="body" />
   <tiles:insertAttribute name="navegacion" />
   </section>>
   </article>>
   <footer>
   <tiles:insertAttribute name="footer" />
   </footer>
</div>   
</body>
</html>