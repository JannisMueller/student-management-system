# JAVA EE / JAX-RS - Labb



- [x] ● Utgå från det projekt ni har skapat under Labb 1.

- [x] ● Lägg till två entiteter, Subject (ämne) och Teacher (lärare).

- [x] ● En student ska kunna ha flera ämnen

- [x] ● Ett ämne har flera studenter och en lärare.

- [x] ● En lärare ska kunna ha flera ämnen.

- [x] ● Det ska finnas möjlighet att via en endpoint få fullständig information om ett ämne
  (det vill säga en lista på deltagande studenter, samt vem som är lärare).




**Endpoints**
Data laddas in via en SampleDataGenerator

```
GET 

get all subjects:
/student-management-system/api/v1/subjects

get all subjects ordered (by name):
/student-management-system/api/v1/subjects/ordered

get subject by name
/student-management-system/api/v1/s ubjects/getByName/{name}

```

