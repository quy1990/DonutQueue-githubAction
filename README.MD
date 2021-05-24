# Read Me First

# Getting Started

### 1 import DB

import atrify.sql in your DB

### 2 SWAGGER TO TEST REST API

http://localhost:8080/swagger-ui/

Ich habe 2 Endpunkte für Manager und Jim angelegt:

* V1(version 1) Ich habe Queue in Java benutzt, um die Bags zu verwalten
* V2(version 1) Ich hole alle die Orders in MySQl, die nach Priority und Created_date zuzuordnen

V2 kann schneller als V1 sein, weil alle Orders in Mysql vorbereitet werden und Java muss nur sie holen und bearbeiten.
  


