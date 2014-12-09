<html>
<?php
$con=mysql_connect("dubrovnik-news.eu","news_user","Crrnd6","news_liveScorer")
define('DB_NAME', 'news_liveScorer');
define('DB_USER', 'news_user');
define('DB_PASSWORD', 'Crrnd6');
define('DB_HOST', 'dubrovnik-news.eu');

$link = mysql_connect(DB_HOST, DB_USER, DB_PASSWORD);
?>
<head></head>

<title>Forma unosa</title>
<h1 align="center">Forma unosa kluba</h1>
<body>

<form action="klubovi.php" method="post" style="text-align:center">
	Ime kluba: <input type="text" name="IME_KLUBA"><br>
	Sport kluba: <input type="text" name="ID_SPORT"><br>
	Sportski savez: <input type="text" name="ID_SAVEZ"><br>
	
<input type="submit">


	

</body>
 



</html>