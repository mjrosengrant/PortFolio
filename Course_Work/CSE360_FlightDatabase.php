//This Script was made to fill a database with random flights, that are 
//sorted into Domestic and International Flights.  

<?php

class location{
	public $city;
	public $state;
	public $country;
	public $international;

	public function __construct($city1, $state1, $country1){
		$this->city = $city1;
		$this->state = $state1;
		$this->country = $country1;
	}
}

	
$db_host = "localhost";
$db_username = "root";
$db_pass = '';
$db_name = "airlineaccounts";

$db_con = mysql_connect ($db_host,$db_username,"") or die ("Could not connect to the server");
mysql_select_db($db_name) or die("That database could not be found");

echo "Successful Connection"."<br>";

//Domestic Locations
$newYork = new location('New York','New York','United States');
$sanFrancisco = new location('San Francisco','California','United States');
$phoenix = new location('Phoenix','Arizona','United States');
$chicago = new location('Chicago','Illinois','United States');
$detroit = new location('Detroit','Michigan','United States');
$orlando = new location('Orlando','Florida','United States');
$losAngeles = new location('Los Angeles','California','United States');
$raleigh = new location('Raleigh','North Carolina','United States');
$nashville = new location('Nashville','Tennessee','United States');
$denver = new location('Denver','Colorado','United States');
$atlanta = new location('Atlanta','Georgia','United States');
$dallas = new location('Dallas','Texas','United States');

$domestic = array($newYork, $sanFrancisco, $phoenix, $chicago, $detroit, $orlando,
	$losAngeles, $raleigh, $nashville, $denver, $atlanta, $dallas);	

//International Locations
$london = new location('London','','England');
$dublin = new location('Dublin','','Ireland');
$bangkok = new location('Bangkok','','Thailand');
$athens = new location('Athens','','Greece');
$hongKong = new location('Hong Kong','','China');
$seoul = new location('Seoul','','South Korea');
$tokyo = new location('Tokyo','','Japan');
$berlin = new location('Berlin','','Germany');
$mexicoCity = new location('Mexico City','','Mexico');
$rio = new location('Rio De Janeiro','','Brazil');
$paris = new location('Paris','','France');
$cairo = new location('Cairo','','Egypt'); 

$international = array($london,$dublin,$bangkok, $athens, $hongKong, $seoul,
	$tokyo, $berlin, $mexicoCity, $rio, $paris, $cairo);
	
//sets up 100 random Domestic Flights
for($i =0; $i<100;$i++){

	$startLoc = $domestic[rand(0,11)];
	$endLoc = $domestic[rand(0,11)];

	//Checks if start and end have the same value, and changes destination if necessary
	while($startLoc == $endLoc){
			$endLoc = $domestic[rand(0,11)];
	}
	
	//Creates Random times
	$departHour = strval(rand(0,24));
	$departMin = strval(rand(0,59));
	$departTime = $departHour.":".$departMin;
	
	$arrivHour = strval(rand(0,24));
	$arrivMin = strval(rand(0,59));
	$arrivTime = $arrivHour.":".$arrivMin;
	
	//Creates random Date
	$time = rand( strtotime("Jan 01 2014"), strtotime("Dec 31 2014") );
	$date = date("Y-m-d", $time);
	
	$cost = rand(250,700);

	$query = "INSERT INTO flights (depart_city, depart_st, depart_country,
		depart_time, arrival_city, arrival_st,arrival_country, arrival_time,international_domestic,date,cost)
		VALUES ('$startLoc->city' , '$startLoc->state' , '$startLoc->country', '$departTime', 
		'$endLoc->city' , '$endLoc->state' , '$endLoc->country' , '$arrivTime' , 'Domestic',$date,$cost)";
	
	$result = mysql_query($query,$db_con)or die(mysql_error());
	
	}
	echo "\nDomestic flights successfully added to Database."."<br>";

//Sets up 100 random International Flights	
for($i =0; $i<100;$i++){

	$startLoc = $domestic[rand(0,11)];
	$endLoc = $international[rand(0,11)];
	
	//Creates Random times
	$departHour = strval(rand(0,24));
	$departMin = strval(rand(0,59));
	$departTime = $departHour.":".$departMin;
	
	$arrivHour = strval(rand(0,24));
	$arrivMin = strval(rand(0,59));
	$arrivTime = $arrivHour.":".$arrivMin;
	
	//Random Date
	$time = rand( strtotime("Jan 01 2014"), strtotime("Dec 31 2014") );
	$date = date("Y-m-d", $time);
	
	$cost = rand(500,1200);

	$query = "INSERT INTO flights (depart_city, depart_st, depart_country,
		depart_time, arrival_city, arrival_st,arrival_country, arrival_time,international_domestic,date,cost)
		VALUES ('$startLoc->city' , '$startLoc->state' , '$startLoc->country', '$departTime', 
		'$endLoc->city' , '$endLoc->state' , '$endLoc->country' , '$arrivTime' , 'International', $date,$cost)";
	
	$result = mysql_query($query,$db_con)or die("ERROR: Data not added to Database");
	}
	echo "\nInternational flights successfully added to Database."."<br>";
	
	mysql_close($db_con);

?>
