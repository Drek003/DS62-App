<?php
header('Content-Type: application/json');
$conn = new mysqli("localhost", "admin", "1234", "ds6-2");
if ($conn->connect_error) { die("Connection failed: " . $conn->connect_error); }
$categoria_id = intval($_GET['categoria_id']);
$result = $conn->query("SELECT nombre, precio, imagen_url FROM productos WHERE categoria_id = $categoria_id");
$productos = [];
while($row = $result->fetch_assoc()) {
    $productos[] = $row;
}
echo json_encode($productos);
$conn->close();
?>