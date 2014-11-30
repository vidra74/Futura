<?php
$con=mysqli_connect("sql5.freemysqlhosting.net","sql544831","aU9!wB8!","sql544831");
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$username = $_POST['username'];
$password = $_POST['password'];
$result = mysqli_query($con,"SELECT UlogeID FROM Korisnici WHERE login = '$username' AND password = '$password' ");
$row = mysqli_fetch_array($result);
$data = $row[0];
if($data){
echo $data;
}
mysqli_close($con);
?>