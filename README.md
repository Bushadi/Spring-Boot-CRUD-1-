# Spring-Boot-CRUD-1 
Test CRUD using REST API / Used Lombok library also

Create a student
POST - http://localhost:5001/api/v1/school/student
{
    "firstName":"Saman",
    "lastName":"Perera",
    "grade":12,
    "address":"Anuradhapura, Sri lanka"
}

Read s student
GET - http://localhost:5001/api/v1/school/student/2

Update a student
PUT - http://localhost:5001/api/v1/school/student/2
{
    "firstName":"Saman",
    "lastName":"Perera",
    "grade":10,
    "address":"Nugegoda, Sri lanka"
}

Delete a student
DELETE - http://localhost:5001/api/v1/school/student/2
