<html>
<head>
<title>The Planets</title>
</head>
<body>
	<%
		/* Scriptlet 1 */
		String[] planets = { "Mercury", "Venus", "Earth", "Mars",
				"Jupiter", "Saturn", "Uranus", "Neptune", "Pluto" };
	%>
	<table>
		<tr>
			<th><b>The Planets in order by distance from the Sun</b></th>
		</tr>
		<%
			for (int i = 0; i < planets.length; i++) { /* Scriptlet 2 */
				if (i == 3) { // fourth rock from the sun
		%>
		<tr>
			<td><font color="red"> <%=(planets[i] + ", the red planet").toUpperCase()%></font></td>
		</tr>
		<%
			} else { /* Scriptlet 3 */
		%>
		<tr>
			<td><%=planets[i]%></td>
		</tr>
		<%
			} /* Scriptlet 4 */
	     }
		%>
	</table>
</body>
</html>
