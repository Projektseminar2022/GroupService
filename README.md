# GroupService

## Klassendiagramm

![Klassendiagramm](https://github.com/Projektseminar2022/GroupService/blob/main/documentation/Klassendiagramm.drawio.png)

## Development

### Get mongo Database: <br>
docker pull mongo <br>
docker create mongo <br>
docker create mongo <br>
docker ps -a <br>
docker run --name <container-id> -d -p 27017:27017 mongo <br>

### Postman example
{  
"id": "123e4567-e89b-12d3-a456-426655440003",  
"creator": 12345,  
"location": {  
"location": "Central Park"  
},  
"members": [12345, 67890, 13579],  
"topic": ["Sport"],  
"condition": {  
"temperatureInC": {  
"min": 20,  
"max": 25  
},  
"windInKmH": {  
"min": 10,  
"max": 15  
},  
"snowInCm": {  
"min": 0,  
"max": 0  
},  
"humidityInPerCent": {  
"min": 50,  
"max": 60  
},  
"precipitationInMm": {  
"min": 0,  
"max": 2  
}  
},  
"hoursBeforeNotification": 2,  
"lastNotificationSend": "2022-06-15T10:00:00Z",  
"message": "Join us for a picnic and outdoor activities at Central Park! Don't forget to bring your own food and drinks."  
}  
