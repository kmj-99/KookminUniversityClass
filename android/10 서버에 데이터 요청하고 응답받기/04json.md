- json이란 데이터 통신을 할 때 사용되는 자바스크립트의 데이터 자료구조이다. 우리는 자바로 안드로이드 프로그래밍을 하고 있기때문에 json형태로 오는 데이터를 자바객체로 바꾸어서 다루어야 한다.

#### MainActivity.java - 내가 따로 설정한 날씨이와 관련한 오픈API를 사용해서 json객체를 자바객체로 바꾼다.
```java
public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                makeRequest();
            }
        });

        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
    }

    public void makeRequest() {
        String url = editText.getText().toString();

        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { //응답을 받았을 때 자동으로 호출됨
                        println("응답->" + response);
                        processResponse(response);
                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러->"+error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String ,String> getParams() throws AuthFailureError{ //요청 파라미터를 처리하는 메소드
                Map<String,String> params=new HashMap<String,String>();

                return params;
            }
        };
        request.setShouldCache(false); // 요청을 하고 받아온 응답을 캐싱하면 요청을 보낼 때 새로 보내는 게 아니라 기존의 것을 보내는 경우가 있기에 캐싱을 안하게설정
        requestQueue.add(request);
        println("요청 보냄");

    }


    public void processResponse(String response){
        Gson gson=new Gson();
        WeatherList weatherList=gson.fromJson(response, WeatherList.class);
        // 응답문자열을 MoiveList객체로 변환한다.
        //첫 번쨰 파라미터는 문자열이고,두 번째 파라미터는 어떤 클래스인지를 저장하기 위한 클래스 객체이다.

        println("지역의 수: "+weatherList.response.body.items.size());
    }


    public void println(String data){
        textView.append(data+"\n");
    }

}
```
- gson은 json을 자바객체로 바꾸어주는 역할을 하는 클래스다.
- 매니페스트에는 인터넷과 트래픽을 허용하도록 설정하고, build.grandle에는 `implementation 'com.android.volley:volley:1.1.0'`
- `implementation 'com.google.code.gson:gson:2.8.5'`을 작성한다.

- 느낀 점: 내가 데이터를 직접 가져오고 다루는 과정이 재미있었다!




























