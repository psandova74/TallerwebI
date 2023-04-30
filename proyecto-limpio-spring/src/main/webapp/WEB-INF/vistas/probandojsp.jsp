<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%><html>
<head>
<title>Probando 1, 2, 3...</title>
</head>
<body>
<header>
	<h1>Probando JSP</h1>
</header>
<main>
	<section>
		<%
		double num = Double.parseDouble(request.getAttribute("numeroRamdom").toString());
		//double num = Math.random();
		if(num > 0.95){
			
		
		%>
			<h2>Tendras un dia de suerte</h2><p> (<%= num  %>>) </p>
		<%
		} else {
		%>
			<h2>Segui participando</h2><p> (<%= num  %>>) </p>	
		<%
		}
		%>	
		
	<%--
		<ul>
		<%
			String[] versions = (String[]) request.getAttribute("windows");
			for (String version : versions){
		%>
			<li><%= version %></li>
		<%
			}
		%>				
		</ul>
		--%>
	
	</section>

</main>

</body>
</html>