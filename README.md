# JAVA EE / JAX-RS - Labb



- [x] ● CRUD-funktionalitet ska implementeras (Create, Read, Update, Delete) 

- [x] ● Data om en student ska kunna hämtas med efternamn som en Query Parameter

- [x] ● När en ny student ska läggas till, är alla fält obligatoriska utom telefonnummer

- [x] ● Anropen ska returnera meningsfulla Response Codes

- [x] ● Skapa minst en egen exception

- [x] ● Felhantering ska finnas för varje CRUD-metod, och felmeddelande ska returneras i

​	JSON-format **Kommentar: felhantering för Delete och Put görs i studentservice metoden**



**Endpoints**

```
GET

all:
/student-management-system/api/v1/students

by ID:
/student-management-system/api/v1/students/{id}
 QueryParameter = id;

by last name:
/student-management-system/api/v1/students/lastname

QueryParameter = lastName;
exempel: http://localhost:8080/student-management-system/api/v1/students/lastname?		lastName=Mueller
```

```
POST

/student-management-system/api/v1/students
 
JSON-body:
  { 
	"firstName": "Jannis",
	"lastName" : "Mueller",
	"email": "jannis@test.se",
	"phoneNumber": "01234567"
}
```

```
PUT

/student-management-system/api/v1/students/{id}

QueryParameter = id;

JSON-body:
{ 
  "id": 1,
	"firstName": "Jannis",
	"lastName" : "Mueller",
	"email": "jannis@test.se",
	"phoneNumber": "01234567"
}
```

```
DELETE
/student-management-system/api/v1/students/{id}

QueryParameter = id;

```

