<?php
	header('Content-Type: text/html; charset=utf-8');
	$host="dubrovnik-news.eu";
	$uname="news_user";
	$pwd="Crrnd6";
	$db="news_liveScorer";
	
	$return_arr = array();

	$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
	mysql_query("SET NAMES 'utf8'");
	mysql_query("SET CHARACTER SET utf8");
	mysql_query("SET SESSION collation_connection = 'utf8_unicode_ci'");
	
	mysql_select_db($db,$con) or die("db selection failed");
	 
	// $id=$_REQUEST['id'];
	 
	$r=mysql_query("select * from Klub"); // where id='$id'",$con);

	while($row=mysql_fetch_array($r))
	{
		$row_array["id"]=$row[0];
		$row_array["ime_kluba"]=$row["IME_KLUBA"];
		$row_array["id_sport"]=$row[2];
		$row_array["id_savez"]=$row[3];
		
		array_push($return_arr,$row_array);
		
		
	}
	print(json_encode($return_arr)); 
	
	mysql_close($con);
?>