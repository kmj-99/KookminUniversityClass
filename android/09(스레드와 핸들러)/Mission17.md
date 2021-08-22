- 이번 미션은 `시작`버튼을 누르면 소비자들의 정보가 애니매이션을 통해서 차례차례 보여주는 미션이다.

#### activirt_main.xml - 버튼 2개와 소비자들의 정보를 보여을 프레임레이아웃 1개를 배치한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="시작"/>
    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="취소"/>
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="customer Info"
        android:textSize="30sp"/>

    <FrameLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>




</LinearLayout>
```
#### information.xml - 프레임레이아웃칸데 들어갈 화면을 xml파일을 따로만들어서 구성한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <ImageView
                android:id="@+id/imageView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/ic_launcher_background"
                android:layout_margin="10dp"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">
                <TextView
                    android:id="@+id/textView1"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="name"
                    android:layout_weight="1"/>

                <TextView
                    android:id="@+id/textView2"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="numbers"
                    android:layout_gravity="center_horizontal"
                    android:layout_weight="1"/>
                <TextView
                    android:id="@+id/textView3"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="region"
                    android:layout_gravity="right"
                    android:layout_weight="1"/>

            </LinearLayout>



        </LinearLayout>


    </androidx.cardview.widget.CardView>

</LinearLayout>
```
#### InforMation.java - 소비자들의 정보를 입력하고 추가하는 과정을 하나의 클래스로 묶어서 관리
```java
public class InforMation extends LinearLayout {
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    TextView textView3;

    public InforMation(Context context) {
        super(context);

        init(context);
    }

    public InforMation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.information,this,true);

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        imageView=findViewById(R.id.imageView);
    }

    public void setName(String name) {
        textView1.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }

    public void setAddress(String address) {
        textView3.setText(address);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
```
#### MainActivity.java- 스레드와 애니메이션을 사용해서 동작시키는 과정을 작성
```java
public class MainActivity extends AppCompatActivity {
    InforMation View1;
    InforMation View2;

    Handler handler = new Handler();

    Animation translate_in;
    Animation translate_out;

    FrameLayout container;

    int selected = 1;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);

        View1 = new InforMation(this);
        View1.setName("김준수");
        View1.setMobile("010-2000-2000");
        View1.setAddress("서울시");
        container.addView(View1);

        View2 = new InforMation(this);
        View2.setName("이희선");
        View2.setMobile("010-3000-3000");
        View2.setAddress("부산시");
        container.addView(View2);

        translate_in = AnimationUtils.loadAnimation(this, R.anim.translate_in);
        translate_out = AnimationUtils.loadAnimation(this, R.anim.translate_out);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationThread thread=new AnimationThread();
                thread.start();
            }
        });

        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                running=false;
            }
        });


    }

    class AnimationThread extends Thread {
        public void run() {
            running = true;
            while (running) {
                handler.post(new Runnable() {
                    public void run() {
                        if (selected == 0) {
                            View1.startAnimation(translate_in);
                            View2.startAnimation(translate_out);
                        } else if (selected == 1) {
                            View1.startAnimation(translate_in);
                            View2.startAnimation(translate_out);
                        }
                    }
                });
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
            }
        }
    }


}
```
#### translate_in.xml - 다음 소비자정보가 들어오는 애니매이션을 작성
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"
    >
    <translate
        android:fromXDelta="100%p"
        android:toXDelta="0%p"
        android:duration="2000"
        android:fillAfter="true"
        />
</set>
```
- translate_out.xml은 `android:fromXDelta="0%p"`,`android:toXDelta="-100%p"`이것만 바꾸면 된다.

- 느낀 점 : 이번 미션을 통해서 좀 더 역동적인 화면동작을 할 수 있는 걸 배워서 너무 좋았다.






















