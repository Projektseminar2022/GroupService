# GroupService

## Klassendiagramm

![Klassendiagramm](https://github.com/Projektseminar2022/GroupService/blob/main/documentation/Klassendiagramm.drawio.png)

## Development

### Interfaces:

#### provide:
| link                         | GET                    | POST                          | PUT                   | DELETE             |
|------------------------------|------------------------|-------------------------------|-----------------------|--------------------|
| /group/group                 | @RequestParam UUID     | @RequestBody Group[0]         | @RequestBody Group[0] | @RequestParam UUID |
| /group/all                   |                        | x                             | x                     | x                  |
| /group/by-user               | @RequestParam UUID     | x                             | x                     | x                  |
| /group/get-random-collection |                        | x                             | x                     | x                  |
| /group/get-random-collection | @RequestParam Topic[2] | x                             | x                     | x                  |
| /group/joinGroup             | x                      | @RequestBody MembershipDTO[1] | x                     | x                  |
| /group/leaveGroup            | x                      | @RequestBody MembershipDTO[1] | x                     | x                  |

#### receive:
| link                         | GET              | POST             | PUT              | DELETE |
|------------------------------|------------------|------------------|------------------|--------|
| /group/group                 | Mono\<Group\>[0] | Mono\<Group\>[0] | Mono\<Group\>[0] | x      |
| /group/all                   | Flux\<Group\>[0] | x                | x                | x      |
| /group/by-user               | Flux\<Group\>[0] | x                | x                | x      |
| /group/get-random-collection | Flux\<Group\>[0] | x                | x                | x      |
| /group/get-random-collection | Flux\<Group\>[0] | x                | x                | x      |
| /group/joinGroup             | x                |                  | x                | x      |
| /group/leaveGroup            | x                |                  | x                | x      |


### Postman example
#### [0]
{  
"id": "123e4567-e89b-12d3-a456-426655440003",  
"name": "Kölner Haie Fanclub",  
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
"id": "123e4567-e89b-12d3-a456-426655440000",  
"groups": [],  
"location": {  
"location": "Bonn",  
},  
"name": "John Smith"  
},  
"group": {    
"id": "123e4567-e89b-12d3-a456-426655440003",  
"name": "Kölner Haie Fanclub",  
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
}  

#### Available Topics  
Sport,  
Spazieren,  
Picnic,  
Garten,  
Wintersport,  
Auto,  
Klettern,  
Fliegen,  
Wassersport,  
Motorrad,  
Waesche,  
Photovoltaik,  
Astronomie,  
Fischen,  
Jagen  

### Get mongo Database:  
docker pull mongo  
docker create mongo  
docker ps -a  
docker run --name >container-id< -d -p 27017:27017 mongo  

