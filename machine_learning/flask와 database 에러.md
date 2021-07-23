```
from flask import Flask 
from flask_migrate import Migrate #파이썬 모델을 이용해 테이블을 생성하고 컬럼을 추가하는 등의 작업을 할 수 있게 해줌
from flask_sqlalchemy import SQLAlchemy #파이썬 ORM 라이브러리
import config #pip3 install config 를 통해서 다운받아야 사용가능
import app
```
- 위와같이 필요한 라이브러리를 import한다. 이떄 외부 모듈인 config는 not defiend 에러가 나길래  
``pip3 install config``을 사용해서 해결했다

- 현재 https://wikidocs.net/81043 사이트를 보면서 database와 flask를 연결하는 걸 하고있다  
- 하지만 ```Use 'FLASK_APP=app:name' to specify one.``` 라는 에러가 계속 난다. StackOverflow에 이 에러에 대한 답변이 있는데    
환경변수를 설정을 해야하는데 내가 윈도우를 쓰고있어서 윈도우 버전으로 ```set FLASK_APP=file.py```이런식으로 하는 것이다.
- 하지만 저렇게 해도 계속 에러가 난다....... 머가 문제지? 
