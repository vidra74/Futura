<html>
<head>
<title>Prvi spoj na server</title>
</head>
<body>
<?php
print 'mysqli_connect  </br>';
$con=mysqli_connect("sql5.freemysqlhosting.net","sql544831","aU9!wB8!","sql544831");
print 'provjera mysqli_connect errno </br>';
if (mysqli_connect_errno($con))
{
   echo 'Puklo povezivanje na MySQL: ' . mysqli_connect_error();
}
/*$username = $_GET['username'];
$password = $_GET['password'];*/
print 'mysqli_query </br>';
$result = mysqli_query($con,"SELECT uloga FROM Uloge ");
print "mysqli_fetch_array </br>";
$row = mysqli_fetch_array($result);
print "row[0] </br>";
$data = $row[0];
if($data){
print "podatak: " . $data . "</br>";
}
print "mysqli_close </br>";
mysqli_close($con);
print "Gotovo !!! </br>";
?>
</body>
</html>