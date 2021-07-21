실습과제
========
## 목차
1. [첫 번째 실습과제](#-첫-번째-실습과제)
2. [두 번쨰 실습과제](#-두-번째-실습과제)

## 첫 번째 실습과제
- 주어진 데이터인 weapon(이름(name : str)과 수량(stock : int))을 가지고 API를 구현하는 
```
from math import fabs
from typing import NewType
from flask import Flask,jsonify,request



day3_core_mission=Flask(__name__)

weapon=[
    {"id":1,"name":"Abel","stock":10},
    {"id":2,"name":"Berg","stock":15}
]


@day3_core_mission.route("/")
def welcom():
    return "hello world"

@day3_core_mission.route("/whoami")
def get_gitId():
    return jsonify({"name":"kmj-99"})

@day3_core_mission.route("/echo")
def query():
    args=request.args
    print(args)
    return args



@day3_core_mission.route("/weapon")
def get():
    return jsonify({"weapon":weapon})

@day3_core_mission.route("/weapon",methods=["POST"])
def Create():
    request_data=request.get_json()
    new_weapon={
        "id":len(weapon)+1,
        "name":request_data["name"],
        "stock":request_data["stock"]
    }
    weapon.append(new_weapon)
    return {}

@day3_core_mission.route("/weapon",methods=["PUT"])
def Update():
    request_data=request.get_json()
    for i,j in enumerate(weapon): #weapon에서 인덱스,실제값을 추출
        if j["id"]==request_data["id"]: #만약 클라이언트가 요청한 id가 맞다면
            weapon[i]=request_data # 해당 id의 데이터를 update
    return {}

@day3_core_mission.route("/weapon",methods=["DELETE"])
def Delete():
    request_data=request.get_json()
    for i,j in enumerate(weapon):
        if j["id"]==request_data["id"]:
            del weapon[i]
    return {} 




if __name__=="__main__":
    day3_core_mission.run()
 ```
 - GET,DELETE,PUT,POST를 구현하였고 , 특정 URI에 따라서 특정 함수를 실행하게 했다 

## 두 번쨰 실습과제
- 날씨를 할 수있는 API,가장 가까운 버스정류장의 도착정보를 알려주는 API를 구현하는 것이다
- 이건 Open API를 이용해야 하는 데 이 부분이 아무리 봐도 이해가 가질 않는다.
- 그래서 세션때 물어보고 

