- 이번 실습은 Mission11과 비슷하다.  
- 액티비티 화면에서 `EditText`,`Button`,`TextView`를 차례대로 세팅을 해서 `EditText`에 메시지를 쓰고 버튼을 누르면 service에서 받는다.
- service에서 액티비티에서 받은 메시지를 그대로 다시 보낸다. 이때 액티비티에서는 broadcast로 받는다. 이 과정을 구현하는 게 이번 실습이다.

- 메시지를 service에 보내는 건 Mission11과 같다. 중요한 건 바로 수신자를 등록하는 코드다. 
```java
//onCreate()
//수신자를 등록하는 코드.
        MyReceiver receiver=new MyReceiver();

        IntentFilter filter=new IntentFilter(); 
        filter.addAction("org.techtown.broadcast.SHOW");
        registerReceiver(receiver,filter);

```
- `IntentFilter` 객체를 하나 생성해서 `.addAction()`으로 수신자를 구분할 텍스트를 집어넣는다. 그리고 `registerReceiver`로 수신자 등록한다.  

- 그리고 `onCreate()`안에서 `BroadcastReceiver`를 정의한다.
```java
    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            String data=intent.getStringExtra("data");
            Toast.makeText(getApplicationContext(),"MyReceiver()",Toast.LENGTH_LONG).show();
            textView.setText(data);


        }
    }
 ```
- service에서 온 메시지를 `MyReceiver`로 받는다.  

참고로 service에서는 `startActivity`가 아니라 `sendBroadcast()`로 Intentn를 브로드캐스트로 보낸다.
