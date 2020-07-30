<?php 

require_once "connection.php";


Class posts{
    public $blog_id;
    public $blog_name;
    public $blog_detail;
    public $blog_small_detail;
}

$po = new posts();

$query = $db->prepare("SELECT * FROM blog");
$query->execute(array());
$counts = $db->query("SELECT COUNT(*) FROM blog")->fetchColumn();

$cou = 0;

echo "[";

while($row = $query->fetch(PDO::FETCH_ASSOC)){
    
    $cou = $cou+1;
    $po->blog_id     = $row["blog_id"];
    $po->blog_name   = $row["blog_name"];
    $po->blog_detail = $row["blog_detail"];
    $po->blog_small_detail = $row["blog_small_detail"];
    
    
    echo json_encode($po,JSON_UNESCAPED_UNICODE);
    
    if($cou != ($counts) ){
        echo ",";
    }
    
    
    
}

echo "]";

?>



