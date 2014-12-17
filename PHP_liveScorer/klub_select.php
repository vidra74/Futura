<?php
	$host="dubrovnik-news.eu";
	$uname="news_user";
	$pwd="Crrnd6";
	$db="news_liveScorer";

	$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
	mysql_select_db($db,$con) or die("db selection failed");
	 
	// $id=$_REQUEST['id'];
	 
	$r=mysql_query("select * from Klub"); // where id='$id'",$con);

	while($row=mysql_fetch_array($r))
	{
		$flag["id"]=$row[0];
		$flag["ime_kluba"]=$row["IME_KLUBA"];
		$flag["id_sport"]=$row[2];
		$flag["id_savez"]=$row[3];
		
		print(json_encode($flag));
		
	}
	 
	
	mysql_close($con);
?>