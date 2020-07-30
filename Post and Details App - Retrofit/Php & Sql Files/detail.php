<?php 

require_once "connection.php";


$post_id = $_GET["blog_id"];

Class posts{
    public $title;
    public $detail;
}

$po = new posts();

$query = $db->prepare("SELECT * FROM blog WHERE blog_id = $post_id ");
$query->execute(array());

$row = $query->fetch(PDO::FETCH_ASSOC);
    
$po->title   = $row["blog_name"];
$po->detail = $row["blog_detail"];

echo json_encode($po,JSON_UNESCAPED_UNICODE);
    
    
    
    

    
