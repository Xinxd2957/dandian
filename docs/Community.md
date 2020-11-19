
# Community

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**address** | **String** | 地址 |  [optional]
**areaCode** | **String** | 区 |  [optional]
**capacity** | **Long** |  |  [optional]
**cityCode** | **String** | 市 |  [optional]
**code** | **String** | 代码，举例：小区代号、房屋代号 |  [optional]
**createByUser** | **Long** |  |  [optional]
**createTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**floorSpace** | **Double** | 房屋面积 |  [optional]
**id** | **Long** |  |  [optional]
**latitude** | **String** | 纬度 |  [optional]
**longitude** | **String** | 经度 |  [optional]
**name** | **String** | 名称 |  [optional]
**parentId** | **Long** | 父级id |  [optional]
**pooledSpace** | **Double** | 公摊面积 |  [optional]
**provinceCode** | **String** | 省 |  [optional]
**subType** | **Long** |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | 类型，0.未知,1.街道,2.小区,3.楼宇,4.单元,5.房间号 |  [optional]
**updateByUser** | **Long** |  |  [optional]
**updateTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
UNKNOWN | &quot;UNKNOWN&quot;
STREET | &quot;STREET&quot;
COMMUNITY | &quot;COMMUNITY&quot;
BUILDING | &quot;BUILDING&quot;
UNIT | &quot;UNIT&quot;
ROOM | &quot;ROOM&quot;
PARKINGREGION | &quot;PARKINGREGION&quot;
PARKING | &quot;PARKING&quot;



