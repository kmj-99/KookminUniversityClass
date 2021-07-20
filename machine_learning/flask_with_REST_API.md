- **flask:** 파이썬으로 작성 된 웹 프레임워크이다.
- **API:** 서버와 클라이언트 간의 인터페이스르 제공해주는 프로그램이다.
- **REST API:** 웹 서버가 요청을 응답하는 방법 중 하나로 Resource의 관점으로 접근
- **REST API의 예시**```GET```,```POST```,```PUT```,```DELETE```등등으로 API를 제공한다

## 코드 세팅
- ```from flask import Flask,jsonify,request```으로 헤더를 설정
- ``` file_name=Flask(__name__)```으로 flask선언
- ```@file_name.route('URL_name')```라고 하면 밑에 함수를 실행한다. 이떄 methods의 디폴트는 GET이고 다른 메소드를 접근할 때는   
methods=["METHODS"]형태로 써주어야 함

참고: vsCode에 있는 app.py
