<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HRM Label Generator</title>
</head>
<body>

<div>
    <form id="form" action="${pageContext.request.contextPath}/generate" method="post">
        <label>
            <input name="text" type="text" placeholder="text" autofocus/>
        </label>
        <label>
            <select name="type">
                <option value="DEFAULT">Default (5 chars)</option>
                <option value="SMALLER">Smaller letters (8 chars × 2 lines)</option>
            </select>
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
