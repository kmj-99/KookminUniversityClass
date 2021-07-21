numpy
=====
## 목차
1. [Core Mission](#-Core-Mission)
2. [Bonus Mission 1](#-Bonus-Mission-1)
3. [Bonus Mission 2](#-Bonus-Mission-2)
## Core Mission
- menu("id":"String","name":"String","price":int)을 가지고 CRUD을 구현하는 과제

```
from typing import NewType
from flask import Flask,jsonify,request

from flask_sqlalchemy import SQLAlchemy



core_mission=Flask(__name__)

menus=[
    {"id":1,"name":"Expresso","price":3800},
    {"id":2,"name":"Americano","price":4100},
    {"id":3,"name":"CafeLatte","price":4600},
]


@core_mission.route("/")
def welcom():
    return "hello world"

@core_mission.route("/menus") 
def get_menus():
    return jsonify({"menus":menus})



@core_mission.route("/menus",methods=["POST"])
def create_menu():
    request_data=request.get_json()
    new_menu={
        "id":len(menus)+1,                    
        "name":request_data["name"],
        "price":request_data["price"]
    }
    menus.append(new_menu)
    return jsonify(new_menu)

@core_mission.route("/menus",methods=["PUT"])
def update_menu():
    request_data=request.get_json()
    for i,j in enumerate(menus): # enumerate를 통해서 menus의 인덱스,데이터를 추출
        if request_data["id"] ==j["id"]: #만약 클라이언트가 요청한 id값과 menus의 id 값이 일치하면
            menus[i]=request_data # menus에서 해당 id 값을 가진 데이터를 클라이언트가 보낸 데이터로 교체
    return {}

@core_mission.route("/menus",methods=["DELETE"])
def delete_menu():
    request_data=request.get_json()
    for i,j in enumerate(menus):
        if request_data["id"]==j["id"]:
            del menus[i]
    return {}
    


if __name__=="__main__":
    core_mission.run()

```
- PUT을 구현하는 데 있어서 헤메긴 했지만 enumerate을 이용해서 해결책을 찾았다!


## Bonus Mission 1
- POST에서 데이터를 추가할 때 적절한 id값으로 추가하는 과제

```
@core_mission.route("/menus",methods=["POST"])
def create_menu():
    request_data=request.get_json()
    new_menu={
        "id":len(menus)+1,                    
        "name":request_data["name"],
        "price":request_data["price"]
    }
    menus.append(new_menu)
    return jsonify(new_menu)
 ```
- len()을 통해서 menus의 크기를 구해서 적절한 id값을 유연하게 처리하였다!

## Bouns Mission 2
- 위에서 구현한 API를 데이터베이스과 연결하는 과제
- 일단 나는 ``` from flask_sqlalchemy import SQLAlchemy #ORM형식```을 이용하였다
- 따로 Weapon.py를 만들어서 데이터베이스를 세팅했다.
```
#Weapon.py
from flask_sqlalchemy import SQLAlchemy

db=SQLAlchemy()

class User(db.Model):
    __tablename__='user'

    id=db.Column(db.Integer,primary_key=True)
    userid=db.Column(db.String(32))
    password=db.Column(db.String(128))
 ```
- 그리고 위에서 작성한 API에 아래코드를 추가했다
```
basdir=os.path.abspath(os.path.dirname(__file__))
dbfile=os.path.join(basdir,'db.sqlite')


day3_core_mission.config["SQLALCHEMY_DATABASE_URI"]="sqlite:///"+dbfile
day3_core_mission.config["SQLALCHEMY_COMMIT_ON_TEARDOWN"]=True #데이터베이스 변경사항을 자동커밋
day3_core_mission.config["SQLALCHEMY_TRACK_MODIFICATIONS"]=False
day3_core_mission.config["SECRET_KEY"]="helloworldhi"

db.init_app(day3_core_mission)
db.app=day3_core_mission
db.create_all()
```
- dp가 만들어 지긴 했는데 table을 똑바로 볼 수 있도록 해야하고, 실제로 db에 데이터를 넣어야한다. 하지만 못했다. 계속 삽질하다보면 언젠가 풀리겠지...

