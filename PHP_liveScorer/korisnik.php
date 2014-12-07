<?php
$con=mysqli_connect("dubrovnik-news.eu","news_user","Crrnd6","news_liveScorer");
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$username = $_POST['username'];
$password = $_POST['password'];
$result = mysqli_query($con,"SELECT k.Ime, k.Prezime, u.Uloga FROM Korisnici k, Uloge u WHERE k.login = '$username' and k.password = '$password' and u.uid = k.ulogeID");
$row = mysqli_fetch_array($result);
$data = $row[0];
if($data){
echo $row[0], " ", $row[1], ": " , $row[2];
}
mysqli_close($con);
?>