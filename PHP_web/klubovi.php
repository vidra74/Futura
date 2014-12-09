<html>
<head>
  <title></title>
</head>
<body>
<h1 align="center"><b>Popis klubova</b></h1>
<?php
define('DB_NAME', 'news_liveScorer');
define('DB_USER', 'news_user');
define('DB_PASSWORD', 'Crrnd6');
define('DB_HOST', 'dubrovnik-news.eu');

$link = mysql_connect(DB_HOST, DB_USER, DB_PASSWORD);

if (!$link) {
	die('Could not connect: ' . mysql_error());
}
$db_selected = mysql_select_db(DB_NAME, $link);
if (!$db_selected) {
die('Can\'t use ' . DB_NAME . ': ' . mysql_error());
}

echo 'Connected successfully';

$value = $_POST['IME_KLUBA'];
$value1 = $_POST['ID_SPORT'];
$value2 = $_POST['ID_SAVEZ'];


$sql = "INSERT INTO klub (IME_KLUBA, ID_SPORT, ID_SAVEZ  ) VALUES ('$value', '$value1', '$value2')";

if (!mysql_query($sql)) {
	die('Error: ' . mysql_error());
}


?>

<table align="center" border=1>
        <thead>
            <tr>
                <td><b>Ime kluba</b></td>
				<td><b>Sport kluba</b></td>
				<td><b>Sportski savez</b></td>
                
            </tr>
        </thead>
        <tbody>
       <?php
         $db_selected = mysql_select_db(DB_NAME);
		if (!$db_selected) {
		die('Can\'t use ' . DB_NAME . ': ' . mysql_error());
		}
            mysql_select_db("news_liveScorer");
            $results = mysql_query("SELECT IME_KLUBA, ID_SPORT, ID_SAVEZ FROM klub");
            while($row = mysql_fetch_array($results)) {
        ?>
                <tr>
                    <td><?php echo $row['IME_KLUBA']?></td>
                    <td><?php echo $row['ID_SPORT']?></td>
					<td><?php echo $row['ID_SAVEZ']?></td>  					
                </tr>

            <?php
            }
			mysql_close();
            ?>   
            </tbody>
            </table>

			
			<h3><center><a href="regkluba.php">Unesi novi klub</a></center></h3> 	


	


</body>


</html>