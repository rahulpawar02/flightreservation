<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>

<center>
<h2>Complete Reservation</h2></br>
Airline:${flight.operatingAirlines}</br>
Departure City:${flight.departureCity}</br>
Arrival City:${flight.arrivalCity}</br>

<form action="completeReservation" method="post">

<h3>--Passenger Details--</h3>


First Name:<input type="text" name="passengerFirstName"/></br> <!-- name="fistName" is map with entites or model class in firstName object  -->
Middle Name:<input type="text" name="passengerMiddleName"/></br> 
Last Name:<input type="text" name="passengerLastName"/></br>   <!-- name="lastName" is map with model class in lastName -->
Email:<input type="text" name="passengerEmail"/></br>
Phone:<input type="text" name="pasengerPhone"/></br>

<h2>Card Details</h2>

Name on Card:<input type="text" name="nameOnTheCard"/></br>  <!-- name="fistName" is map with entites or model class in firstName object  -->
Card No:<input type="text" name="cardNumber"/> </br>  <!-- name="lastName" is map with model class in lastName -->
Expiry Date:<input type="text" name="expirationDate"/></br>
Three Digit Sec Code:<input type="text" name="securityCode"/></br>

<input type="hidden" name="flightId" value="${flight.id }"/></br>
<input type="submit" value="confirm"/>
</form>

</center>
</body>
</html>
