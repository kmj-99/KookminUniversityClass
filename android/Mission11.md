- 이번 실습은 MainAcitivity에서 editText에 메시지를 적어서 button을 눌러 service에게 전달하면 service는 그 메시지를 다시 MainAcitivity에 전달하면 MainAcitivity는 그 메시지를 밑에 TextView에 띄우는 걸 구현하는 실습이다.

### `MyService.java`를 만들어 service를 구현한다.
```java
public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String new_data=intent.getStringExtra("data");

        Intent showIntent =new Intent(getApplicationContext(),MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| //서비스는 화면이 없기에 화면을 만들기 위해FLAG_ACTIVITY_NEW_TASK를 씀
                Intent.FLAG_ACTIVITY_SINGLE_TOP|//FLAG_ACTIVITY_SINGLE_TOP:화면이 이미 만들어져 있으면 그 화면을 보여달라는 의미이다
                Intent.FLAG_ACTIVITY_CLEAR_TOP); //FLAG_ACTIVITY_CLEAR_TOP:화면이 여러개 쌓여있으면 위에거를 없애라는 의미

        showIntent.putExtra("data",new_data);

        startActivity(showIntent);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
```
### `MainAcitivity.java`에서 `EditText`,`TextView`,`Button`을 다 참조해서 각각 적절한 코드를 작성한다.
```java
public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data=editText.getText().toString();
                Intent intent=new Intent(getApplicationContext(),MyService.class);

                intent.putExtra("data",data);

                startService(intent);
            }
        });

        Intent receiveIntent=getIntent();
        processIntent(receiveIntent);
    }

    protected void onNewIntent(Intent intent){
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent){
        if(intent !=null){
            String data=intent.getStringExtra("data");

            textView.setText(data);
        }
    }


}
```

이번과제는 앞에서 배웠던 서비스와 수신자의 인터랙션을 잘 이해하면 금방 풀 수 있는 수준이었던거 같다. 한마디로 어렵진 않았다.  
하지만 새로운 문법과 새로운 개념이라 아직 어색한 부분이 있다. 이 부분은 계속 반복하면 나아질 거라고 **굳게** 믿고있다.






