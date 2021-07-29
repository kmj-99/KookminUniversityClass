- 감성분석을 하는 머신러닝,딥려닝 모델을 활용해서 실제 API를 통해 인터랙션을 해보았다
- API코드는 밑에와 같다. 출처: 프로그래머스 스쿨
```
from flask import Flask, request, json
from model import MLModelHandler, DLModelHandler

app = Flask(__name__)

# assign model handler as global variable [2 LINES]

ml_handler=MLModelHandler()
dl_handler=DLModelHandler()



@app.route("/predict", methods=["POST"])
def predict():
    # handle request and body
    body = request.get_json()
    text = body.get('text', '')
    text = [text] if isinstance(text, str) else text
    do_fast = body.get('do_fast', True) 

    # model inference [2 LINES]
    if do_fast:
        predictions=ml_handler.handle(text)
    else:
        predictions=dl_handler.handle(text)

    # response
    result = json.dumps({str(i): {'text': t, 'label': l, 'confidence': c}
                         for i, (t, l, c) in enumerate(zip(text, predictions[0], predictions[1]))})
    return result


if __name__ == "__main__":
    app.run(host='0.0.0.0', port='5000', debug=True)
```

- 다른 터미널(client에 해당)을 켜서 특정 데이터에 대한 감성분석을 할 수 있다
- 데이터를 request하는 방법은 총 두가지 이다.
### 1. ```curl```커맨드를 사용
- ```cur -d {"text":[data],"use_fast":True or false} \```
- ```-H "Content-Type: application/json" \```
- ```http://포트번호/predict``` 이때 ```https```로 하면 에러가 난다
- 위 코드를 차례대로 입력하면 감성분석한 결과를 얻을 수 있다
### 2. ```import requsets```를 사용
- 이 방법은 더 간단하다
- ```imoprt requests``` 
- ```url="http:포트번호/predic"```
- ```data={"text"[data],"use_fast":True or false}```
- 위 코드를 차례대로 치면 감성분석한 결과를 얻을 수 있다.


## 느낀점: 아직 부족하지만 그래도 전체적인 웹어플리케이션의 동작 방법을 아는 거 몸으로 느껴서 정말 좋은 실습이었다
