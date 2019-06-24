# Simple-api
Simple api for pretest

This is spring boot based A.P.I by using h2 as runtime database

You can run this project by using
```
> mvn clean spring-boot:run
```
Or do unit testing by using

```
> mvn clean test -Dtest=UserControllerTest
```

to initialize database you can run the curl syntax in the first time
```
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/users --data '[{"id":1,"username":"UserA","modules":[{"moduleName":"PromoCard","moduleOrder":1},{"moduleName":"CategoryCard","moduleOrder":2},{"moduleName":"FlashSaleCard","moduleOrder":3},{"moduleName":"HistoryCard","moduleOrder":4},{"moduleName":"NewsCard","moduleOrder":5}]},{"id":2,"username":"UserB","modules":[{"moduleName":"PromoCard","moduleOrder":1},{"moduleName":"NewsCard","moduleOrder":5},{"moduleName":"FlashSaleCard","moduleOrder":3},{"moduleName":"CategoryCard","moduleOrder":2},{"moduleName":"NewsCard","moduleOrder":5}]},{"id":3,"username":"UserC","modules":[{"moduleName":"PromoCard","moduleOrder":1},{"moduleName":"FlashSaleCard","moduleOrder":3},{"moduleName":"CategoryCard","moduleOrder":2},{"moduleName":"NewsCard","moduleOrder":5},{"moduleName":"HistoryCard","moduleOrder":4}]}]'
```
### NOTE: H2 database only available at the runtime because we don't need the real database engine for this simple A.P.I.
you need to call post again after application restart
```
after all, get the user modules by using
```
curl -X GET -H 'Content-Type: application/json' -i 'http://localhost:8080/user/modules?UserId=2'
```
