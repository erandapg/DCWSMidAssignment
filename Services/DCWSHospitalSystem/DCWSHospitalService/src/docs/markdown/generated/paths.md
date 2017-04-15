## Paths
### getAllActiveOpco
```
GET /rest/opco/getAllActiveOpco
```

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|OpcoResList|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* opco-rest-service

### getOpcoById
```
GET /rest/opco/getOpcoById/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|OpcoResponse|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* opco-rest-service

### updatePrefixSuffix
```
PUT /rest/opco/updatePrefixSuffix
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|opcoRequest|opcoRequest|true|OpcoRequest||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|OpcoResponse|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* opco-rest-service

### createPackage
```
POST /rest/package/createPackage
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|pkgCreateRequest|pkgCreateRequest|true|PackageCreateRequest||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|PackageResponseRoot|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* package-rest-service

### getAllPackages
```
GET /rest/package/getAllPackages
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|opcoId|opcoId|true|integer (int64)||
|QueryParameter|status|status|false|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|PackageResList|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* package-rest-service

### getPackageById
```
GET /rest/package/getPackageById/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|PackageResponseRoot|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* package-rest-service

### updatePackage
```
PUT /rest/package/updatePackage
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|pkgUpdRequest|pkgUpdRequest|true|PackageUpdateRequest||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|PackageResponseRoot|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* package-rest-service

### createSME
```
POST /rest/sme/createSME
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|smeRequest|smeRequest|true|SMERequest||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|SMEResponse|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* sme-rest-service

### getAllSMEByOpcoId
```
GET /rest/sme/getAllSMEByOpcoId/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|SMEResList|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* sme-rest-service

### getSMEById
```
GET /rest/sme/getSMEById/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|SMEResponse|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* sme-rest-service

### searchSME
```
GET /rest/sme/searchSME/{id}/{smeName}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|integer (int64)||
|PathParameter|smeName|smeName|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|SMEResList|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* sme-rest-service

### updateSME
```
PUT /rest/sme/updateSME
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|smeRequest|smeRequest|true|SMERequest||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|Success|SMEResList|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|
|500|Failure|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* sme-rest-service

### createUser
```
POST /rest/user/createUser
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|userRequest|userRequest|true|UserRequest||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|201|Created|UserResponse|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* user-rest-service

