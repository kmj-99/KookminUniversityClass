-원래는 ORM을 사용하여 database를 연결할려고 했는데 에상치 못한 에러떄문에 그냥 Mysql을 생으로 연결했다.
- 연동하기전 `Mysql다운`,`vscode에서 MySQL extension다운` ,`pip install pymysql`로 파이썬에서 database를 다룰 수 있도록 도와주는 라이브리인 pymysql다운 을 한다.

- database를 다룰 파이썬파일을 하나 생성한다. 커피 메뉴 테이블을 만들 것이기에 `menu_database.py`을 만든다

```python
## menu_database.py
from typing import Coroutine
import pymysql
from pymysql import cursors
import pandas as pd

def Insert_data(name,price):
    global cursor  
    print(name,price)
    insert_sql="INSERT INTO menu (name,price) VALUES ('{}',{});".format(name,price)
    cursor.execute(insert_sql)
    db.commit()  # database에 commit을 보내야 적용
    
    
    

def Show_database():
    global cursor
    show_sql="SELECT * FROM menu;"
    cursor.execute(show_sql) # sql문법을 실행
    res_sql=cursor.fetchall() # 실행한 결과를 받아옴
    res_sql=pd.DataFrame(res_sql)
    return res_sql


db=pymysql.connect(host="127.0.0.1",port=3306,user="root",passwd="rlaalswnd1",db="test",charset="utf8") #연결하고 싶은 db와 connecting
# host: database의 호스트 번호
# port: 포트번호 , user: 사용자 이름 , passwd: 비밀번호 , db: 테이블 이름

cursor=db.cursor() #Control Structure of DataBase
```  

- sql문법을 각각 변수에 정의한 다음에 상황에 맟춰서 쓸 수 있도록 세팅했다. 그리고 간단한 API도 만들어 봤다.

```python
## database의 데이터를 보여주고,database에 데이터를 저장하는 간단한 APT다.
from typing import NewType
from flask import Flask, json,jsonify,request
import pymysql
import menu_database as db

 #파이썬의 딕셔너리를 jsonify는 자바스크립트에서 사용하는 데이터 저장방식으로 바꿔줌

app=Flask(__name__)

menus=[
    {"id":1,"name":"Expresso","price":3800},
    {"id":2,"name":"Americano","price":4100},
    {"id":3,"name":"CafeLatte","price":4600},
]


@app.route("/showdata")
def welcom():
    database_datas=db.Show_database()
    data=[]
    for i in range(database_datas.shape[0]):
        data.append(list(database_datas.loc[i])) 
    return "{}".format(data)

        
    


# POST /dataAdd : 자료를 자원에 추가한다
@app.route("/dataAdd",methods=["POST"])
def create_menu():
    
    request_data=request.get_json() #{"name":...,"price":...}라는 형태로 얻음,참고로 딕셔너리와 json형태의 데이터는 살짝 다름
                                                       #그래서 get_json을 이용해서 딕셔너리 형태의 데이토를 json형태로 get함
    db.Insert_data(request_data['name'],request_data['price']) # 받은 데이터를 database에 저장한다.
    return "hell"
    

if __name__=="__main__":
    app.run()


```
- `GET`,`POST`정도만 구현했고, `GET`은 database의 모든 데이터를 보여주고 `POST`는 커피와 가격을 추가하도록 구현했다.
