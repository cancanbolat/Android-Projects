<?php 

try {
    $db = new PDO("mysql:host=localhost;dbname=xxxxx;charset=utf8", 'xxxxxxx', 'xxxxx');
} catch (PDOException $e) {
    $e->getMessage();
}