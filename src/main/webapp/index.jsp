<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HRM Label Generator</title>
</head>
<body>

<div>
    Supported characters: <code>A-Z 0-9 . , ! ? + - _ ' " #</code><br>
    Here's what they look like: <a href="${pageContext.request.contextPath}/chars.png">image</a>
</div>

<div>
    <form id="form" action="${pageContext.request.contextPath}/generate" method="post">
        <label>
            <input type="text" name="text" maxlength="5" placeholder="max 5 chars" autofocus/>
        </label>
        <button id="submit" type="submit">Generate</button>
    </form>
</div>

<div>
    <label>
        <textarea id="result" cols="85" rows="8" style="resize: none"></textarea>
    </label>
</div>

<script src="app.js" async></script>
</body>
</html>
