<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bài 1 - Lab 2</title>
</head>
<body>
<form action="/ctrl/ok" method="post">
    <button>OK 1</button>
    <button formmethod="get">OK 2</button>
    <button formaction="/ctrl/ok?x">OK 3</button>
</form>
<p>Kết quả: ${mess}</p>
</body>
</html>