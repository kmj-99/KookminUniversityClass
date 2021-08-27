  - 이번 미션은 EditText에 url을 입력하면 해당 웹페이지와,그 웹페이지의 코드를 두 화면에 보여주는 미션이다.
  
  #### activity_main.xml- 화면을 구성한다
  ```xml
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <EditText
            android:id="@+id/editText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Insert Url"
            android:layout_weight="1"/>
        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="5"
            android:layout_marginLeft="5dp"
            android:text="요청"/>


    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:layout_margin="5dp">

        <ScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_margin="5dp"
            android:layout_weight="1">
            <TextView
                android:id="@+id/textView"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>
        </ScrollView>

        <WebView
            android:id="@+id/webView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_margin="5dp"
            android:layout_weight="1"/>
    </LinearLayout>



</LinearLayout>
```
#### MainActivity.java- Http를 이용하여 데이터를 요청하고 응답받는다. 또한 응답받은 데이터대로 UI를 변경해야 하기에 Handler를 이용한다
```java
public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    WebView webView;

    StringBuilder output=new StringBuilder();


    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        webView=findViewById(R.id.webView);

        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new android.webkit.WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                requestThread thread=new requestThread();
                thread.start();
                webView.loadUrl(editText.getText().toString());
            }
        });
    }


    class requestThread extends Thread{
        public void run(){
            Http_request();
            handler.post(new Runnable(){
                    public void run(){
                        textView.setText(output.toString());
                }
            });

        }

    }

    public void Http_request(){
        String url_str=editText.getText().toString();

        try{


            URL url= new URL(url_str);

            HttpURLConnection conn=(HttpURLConnection) url.openConnection();

            if(conn!=null){
                conn.setConnectTimeout(1000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                int response_code=conn.getResponseCode();

                BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line=null;
                if(response_code==200){

                    while(true){
                        line=reader.readLine();
                        if(line==null) break;

                        output.append(line+"\n");
                    }

                }
                reader.close();
                conn.disconnect();
            }

        }catch(Exception e){
            Log.d("error",e.toString());
        }

    }

}
```

- 느낀 점 : 이번미션은 어려운 내용은 없었다. 여태 배운 스레드,핸들러,웹요청메소드만 알고있으면 쉽게 풀리는 미션이였다.














