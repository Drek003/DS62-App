<?php
header('Content-Type: application/json');
$conn = new mysqli("localhost", "admin", "1234", "ds6-2");
if ($conn->connect_error) { die("Connection failed: " . $conn->connect_error); }
$result = $conn->query("SELECT id, nombre, imagen_url FROM categorias");
$categorias = [];
while($row = $result->fetch_assoc()) {
    $categorias[] = $row;
}
echo json_encode($categorias);
$conn->close();
?>