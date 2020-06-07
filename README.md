# Hibernate ORM test

## List
1. [Overview](#overview)
2. [Project info](#project-info)
3. [Hibernate config](#hibernate-config)

## Overview

hibernate ORM(Object Relation Mapping) 프레임워크를 설정하고 이용하는 샘플 코드입니다. Main함수에 테스트 실행코드 작성되어 있습니다.
Category 모델과 Product 모델이 일대다 관계로 설정되어있고 License와 Person이 일대일 관계로 설정되어 있습니다.


## Project info

### version
- JDK 1.8
- mysql8
- hibernate 5.3.7

### project structure
- project framework : maven
- directory tree
```
hibernateTest
.
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   ├── main
    │   │   │   └── Main.java
    │   │   └── model
    │   │       ├── Category.java
    │   │       ├── License.java
    │   │       ├── Person.java
    │   │       └── Product.java
    │   └── resources
    │       └── hibernate.cfg.xml
    └── test
        └── java

```


## hibernate config

hibernate 설정을 위한 설정 파일 [hibernate.cfg.xml](https://github.com/NohTaeHwan/Hibernate-sample/blob/master/src/main/resources/hibernate.cfg.xml)입니다.
```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.username"><!--dbUsername--></property>
        <property name="hibernate.connection.password"><!--dbPW--></property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/<!--DB Name--></property>

        <property name="show_sql">true</property>
        <property name="format_sql">false</property>
        <property name="hibernate.hbm2ddl.auto" >create</property>

        <mapping class=""/>
    </session-factory>
</hibernate-configuration>

```
- session-factory 의 프로퍼티에서 "dbUsername", "dbPW" 부분에 각각 자신이 설정한 username과 password를 넣으면 됩니다.
- 바로 밑에 줄 url에서 "DB Name"으로 주석되있는 곳에 매핑할 DB이름을 넣어주면 됩니다.
- hibernate.hbm2ddl.auto 프로퍼티에 대한 내용은 [여기 참조!](https://velog.io/@think2wice/Hibernate-hbm2ddl.auto-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EC%84%A4%EC%A0%95)
- show_sql 은 매핑될 때 변환되어지는 sql문을 보여주는 옵션이고 format_sql은 보여지는 sql을 포맷팅하여 보여주는 옵션입니다.
- mapping class는 Model로 이용될 클래스들의 주소를 넣어주면됩니다. ex)`<mapping class="model.model.Product"/>`

