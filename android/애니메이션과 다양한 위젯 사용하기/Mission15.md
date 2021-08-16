- 이번 미션은 버튼을 누르면 애니메이션 효과를 써서 고객정보 입력화면으로 넘기는 기능을 구현하는 미션이다.

#### `MainActivity.java`
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <Button
            android:id="@+id/button1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:text="입력화면으로"/>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/page"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:layout_gravity="right"
        android:visibility="gone">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="고객정보 입력"/>

        <EditText
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:hint="이름"/>
        <EditText
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:hint="나이"/>
        <EditText
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:hint="생년월일"/>

        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="저장"
            android:layout_gravity="center_horizontal"/>
    </LinearLayout>


</FrameLayout>
```

#### `MainActivity.java`
```java
public class MainActivity extends AppCompatActivity {
    boolean isPageOpen=true;
    Animation translate_left;
    Animation translate_right;
    LinearLayout page;

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page=findViewById(R.id.page);
        translate_left =  AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translate_right = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translate_left.setAnimationListener(animationListener);
        translate_right.setAnimationListener(animationListener);


        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("break","onClick");
                page.setVisibility(View.VISIBLE);
                page.startAnimation(translate_left);
            }
        });

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                page.setVisibility(View.INVISIBLE);
                page.startAnimation(translate_right);

            }
        });
    }

        private class SlidingPageAnimationListener implements Animation.AnimationListener{

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isPageOpen){
                    button1.setVisibility(View.INVISIBLE);
                    isPageOpen=false;
                }else{
                    button1.setVisibility(View.VISIBLE);
                    isPageOpen=true;
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        }

}
```

#### `translate_left`-애니메이션 효과를 세팅
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator">
    <translate
        android:fromXDelta="100%p"
        android:toXDelta="0%p"
        android:duration="500"
        android:repeatCount="0"
        android:fillAfter="true"
        />
</set>
```
#### `translate_right`- 애니메이션 효과 세팅
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator">
    <translate
        android:fromXDelta="0%p"
        android:toXDelta="100%p"
        android:duration="500"
        android:repeatCount="0"
        android:fillAfter="true"
        />
</set>
```

느낀 점 : 이번미션은 배웠던 개념을 고대로 활용하여 금방 풀엇다. 하지만 아직은 애니메이션의 동작과정이 어색한 부분이 있었다.







