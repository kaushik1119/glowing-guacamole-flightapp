<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Flights</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h2>Flights available</h2>

<table>
<tr>
    <th>Flight</th>
    <th>Departure city</th>
    <th>Arrival city</th>
    <th>Departure time</th>
</tr>

<c:forEach items="${flights}" var="flight">
<tr>
    <td>${flight.operatingAirlines}</td>
    <td>${flight.departureCity}</td>
    <td>${flight.arrivalCity}</td>
    <td>${flight.estimatedDepartureTime}</td>
    <td><a href="showCompleteReservation?flightId={flight.id}">Select</td>
</tr>

</c:forEach>


</body>
</html>