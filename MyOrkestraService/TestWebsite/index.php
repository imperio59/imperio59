<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orkestra Client (JS)</title>
<script type="text/javascript">
var thrift = {};
</script>
<script type="text/javascript" src="./js/thrift.js"></script>
<script type="text/javascript" src="./js/auto-gen/OrkestraService.js"></script>
<script type="text/javascript" src="./js/auto-gen/Service_types.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
</head>
<body>
<div id="response">
</div>

<script type="text/javascript">

$(window).ready(function () {
	var transport = new Thrift.Transport("http://localhost:4242");
    var protocol  = new Thrift.Protocol(transport);
    var client    = new thrift.OrkestraServiceClient(protocol);
    
	var message = client.sayHi("Yo man");
	$('#response').html(message);
});

</script>
</body>
</html>