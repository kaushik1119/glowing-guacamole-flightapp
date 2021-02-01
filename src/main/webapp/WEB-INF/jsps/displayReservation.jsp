<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Complete reservation</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h2>Reservation details</h2>

<h2>Flight details</h2>
Operator: ${flight.operatingAirlines}
Departure city: ${flight.departureCity}
Arrival city: ${flight.arrivalCity}

<form action="completeReservation" method="post">
<h2>Passenger details</h2>
First name: <input type="text" name="passengerFirstName">
Last name: <input type="text" name="passengerLastName">
Email: <input type="text" name="passengerEmail">
Phone: <input type="text" name="passengerPhone">

<h2>Payment details</h2>
    Card number: <input type="text" name="cardNumber">
    CVV: <input type="text" name="cvv">
    <input type="hidden" name="flightId" value="${flight.id}">
<input type="submit" value="Confirm">
</form>

</body>
</html>