<?php

ini_set("display_errors", 1);
error_reporting(1);

include "vendor/autoload.php";

$db = new MysqliDb ('localhost', 'root', 'E5ySdrtFIsGr', 'ppt');

$db->where('id',1);
$GetCode = $db->get('handle')[0];

echo $GetCode['code'];