<?php

ini_set("display_errors", 1);
error_reporting(1);

include "vendor/autoload.php";

$db = new MysqliDb ('localhost', 'root', 'E5ySdrtFIsGr', 'ppt');

$GetCode = $_GET['code'];


if($GetCode == "1")
{
	$data = Array (
		'code' => 1,
	);

	$db->where ('id', 1);

	$db->update ('handle', $data);

}

if($GetCode == "0")
{
	$data = Array (
		'code' => 0,
	);

	$db->where ('id', 1);

	$db->update ('handle', $data);

}

if($GetCode == "2")
{
	$data = Array (
		'code' => 2,
	);

	$db->where ('id', 1);

	$db->update ('handle', $data);

}