
<%
	String userInput = (String) request.getParameter("sentence");
	if (userInput == null) {
		userInput = "Antidisestablishmentarianism rules OK";
	}
%>
<html>
<head>
<title>Sentence Analyzer</title>
</head>
<body>
	<p>Type in a sample sentence to analyze:</p>
	<form method="GET" action="sentenceAnalyzer.jsp">
		<input size="80" name="sentence" type="text" value="<%=userInput%>" />
		<br />
		<input type="submit" />
	</form>
	<p>
		Average length of word is
		<%=avgWordLength(userInput)%>.
	</p>
</body>
</html>
<%!private double avgWordLength(String sentence) {
		java.util.StringTokenizer st = new java.util.StringTokenizer(sentence,
				" ");
		double wordCount = st.countTokens();
		int totalChars = 0;
		while (st.hasMoreTokens()) {
			totalChars += st.nextToken().length();
		}
		return totalChars / wordCount;
	}%>
