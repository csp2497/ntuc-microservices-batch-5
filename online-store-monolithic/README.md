## Search the item with brand

```
GET
localhost:8080/api/items/search/brand/Samsung

Response:
[
    {
        "itemId": 3,
        "name": "note-10",
        "price": 650.0,
        "brandName": "Samsung"
    },
    {
        "itemId": 4,
        "name": "galaxy-10",
        "price": 650.0,
        "brandName": "Samsung"
    }
]
```

## Search the item with name

```
GET
localhost:8080/api/items/search/name/iPhone-8

Response:
[
    {
        "itemId": 1,
        "name": "iPhone-8",
        "price": 800.0,
        "brandName": "Apple"
    }
]
```

## Create order

```
POST
localhost:8080/api/orders

Request:
{
	"items": [1, 2]
}

Response:
Response:
{
    "orderNumber": 1568009104032,
    "items": [
        "iPhone-8",
        "iPhone-8S"
    ],
    "totalPrice": 1650.0
}
```

## GetOrder 


```
GET
localhost:8080/api/orders/1568003580605

Response:
{
    "orderNumber": 1568003580605,
    "items": [
        "iPhone-8",
        "iPhone-8S"
    ],
    "totalPrice": 1650.0
}
```