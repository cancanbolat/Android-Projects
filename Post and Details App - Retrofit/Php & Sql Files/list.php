<?php 

require_once "connection.php";

$query = $db->prepare("SELECT * FROM blog");
$query->execute();

$response = array();

while($row = $query->fetch(PDO::FETCH_ASSOC)){
    
    array_push($response, 
               array(
              'blog_id'     => $row["blog_id"],
              'blog_name'   => $row["blog_name"],
              'blog_detail' => $row["blog_detail"],
              'blog_small_detail' => $row["blog_small_detail"]
               )
   );   
}

echo json_encode($response, JSON_UNESCAPED_UNICODE);

?>



