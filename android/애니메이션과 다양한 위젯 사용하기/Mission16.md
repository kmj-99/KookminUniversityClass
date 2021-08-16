- 이번 미션은 url을 입력하는 에디터를 만들어서 url을 입력하여 버튼을 누르면 그 url에 맞는 웹페이지가 열리게 하도록 구현하는 미션이다.
- 이때 버튼을 누르면 url을 입력하는 칸이 사라지고 `패널열기`란 버튼으로 바뀌면서 그 버튼을 누르면 다시 url을 입력하는 칸이 나오도록 해야한다.

#### `activity_main.xml` - 웹뷰를 사용한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:id="@+id/page1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <Button
                android:id="@+id/button1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="이동"/>
            <EditText
                android:id="@+id/editText"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="insert URL"/>
        </LinearLayout>

        <Button
            android:id="@+id/button2"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:visibility="gone"
            android:text="패널열기"/>
        </FrameLayout>

    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```

#### `MainActivity.java`
```java
public class MainActivity extends AppCompatActivity {
    boolean isPageOpen = false;

    Animation translate_up;
    Animation translate_down;

    EditText editText;

    WebView webView;

    Button button1;
    Button button2;

    LinearLayout page1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translate_up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_up);
        editText=findViewById(R.id.editText);
        webView=findViewById(R.id.webView);

        page1=findViewById(R.id.page1);
        translate_up =  AnimationUtils.loadAnimation(this, R.anim.translate_down);
        translate_down = AnimationUtils.loadAnimation(this, R.anim.translate_down);

        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translate_up.setAnimationListener(animationListener);
        translate_down.setAnimationListener(animationListener);



        webView.setWebViewClient(new android.webkit.WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.d("break","shouldOverrideUrlLoading");
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });

        button2=findViewById(R.id.button2);

        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("break","onClick");
                webView.loadUrl(editText.getText().toString());
                page1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.VISIBLE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                page1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.INVISIBLE);
            }
        });

    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
```

#### `translate_down`-애니메이션효과를 세팅한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator">

    <translate
        android:fromYDelta="100%p"
        android:toYDelta="0%p"
        android:duration="500"
        android:repeatCount="0"
        android:fillAfter="true"
        />

</set>
```
#### `translate_up`
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator">

    <translate
        android:fromYDelta="0%p"
        android:toYDelta="100%p"
        android:duration="500"
        android:repeatCount="0"
        android:fillAfter="true"
        />

</set>
```

느낀 점: 뭔가 직접 url을 직접 입력해서 창을 띄운다는 게 빨리 네트워크 소켓부분을 공부하고 싶다는 욕구가 마구 생긴 미션이었다~




































