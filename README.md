# assignment
Evolent assignment project

This is simple spring boot assignment project. that you can exceute this application by importing in STS and simply run this application and below are the End points.

To add contacts one -by - one  :
Method/URL -  POST  :   http://localhost:8080/api/contact
Request body :
{
    "firstName": "MOHD",
    "lastName": "AZHAR",
    "mobile": "9717175424"
}

To fetch all records 
GET   :  http://localhost:8080/api/allcontacts

To search By ID
GET   :  http://localhost:8080/api/contact/1

To update the status By ID 
POST  : http://localhost:8080/api/contact/1