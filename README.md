# GroupService

## Klassendiagramm

![Klassendiagramm](https://github.com/Projektseminar2022/GroupService/blob/main/documentation/Klassendiagramm.drawio.png)

## Development

### Interfaces:

| link                         | GET                  | POST                          | PUT                   | DELETE             |
|------------------------------|----------------------|-------------------------------|-----------------------|--------------------|
| /group/group                 | @RequestParam UUID   | @RequestBody Group[0]         | @RequestBody Group[0] | @RequestParam UUID |
| /group/all                   |                      | x                             | x                     | x                  |
| /group/by-user               | @RequestParam UUID   | x                             | x                     | x                  |
| /group/get-random-collection |                      | x                             | x                     | x                  |
| /group/get-random-collection | @RequestParam String | x                             | x                     | x                  |
| /group/joinGroup             | x                    | @RequestBody MembershipDTO[1] | x                     | x                  |
| /group/leaveGroup            | x                    | @RequestBody MembershipDTO[1] | x                     | x                  |


### Postman example
#### [0]
{  
"id": "123e4567-e89b-12d3-a456-426655440003",  
"name": "Joe",  
"creator": 12345,  
"location": {  
"location": "Central Park"  
},  
"members": [],  
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

#### [1]
{  
"user": {  
"id": 1,  
"name": "John Smith",  
"age": 25  
},  
"group": {  
"id": 10,  
"name": "Group 1",  
"description": "A group for people who like sports"  
}  
}

### Get mongo Database:  
docker pull mongo  
docker create mongo  
docker ps -a  
docker run --name >container-id< -d -p 27017:27017 mongo  

