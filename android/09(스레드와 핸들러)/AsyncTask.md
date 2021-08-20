- `AsyncTask`는 하나의 클래스에서 UI작업을 한 번에 해주는 기능을 한다.
- 버튼을 누르면 프로그레스바가 채워지는 실습을 통해 AsyncTask를 사용해보자!  

#### activirt_main.xml - 프로그레스바와 버튼을 세팅
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <ProgressBar
        android:id="@+id/progressBar"
        style="?android:attr/progressBarStyleHorizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:max="100"/>
    <Button
        android:id="@+id/button1"
        android:text="실행"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
    <Button
        android:id="@+id/button2"
        android:text="취소"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
</LinearLayout>
```
#### MainActivity.java - 
```java
public class MainActivity extends AppCompatActivity {
    BackgroundTask task;
    int value;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressBar);

        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                task=new BackgroundTask();
                task.execute();
            }
        });

        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                task.cancel(true);
            }
        });

    }

    class BackgroundTask extends AsyncTask<Integer,Integer,Integer>{
        protected void onPreExecute(){//스레드로 실행되기 전 상태
            value=0;
            progressBar.setProgress(value);
        }

        @Override
        protected Integer doInBackground(Integer... integers) { //스레드로 실행 된 상태
            while(isCancelled()==false){//isCancelled가 true만 취소된거임
                value++;
                if(value>=100){
                    break;
                }else{
                    publishProgress(value); //onProgressUpdate가 호출 됨
                }

                try{
                    Thread.sleep(100);
                }catch (InterruptedException ex){}
            }
            return value; //리턴한 값은 onPostExecute으로 넘어감
        }

        @Override
        protected void onPostExecute(Integer integer) { //스레드로 실행된 후 상태
            progressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue()); //프로그레스 바게이지를 업데이트
        }

        @Override
        protected void onCancelled() {
            progressBar.setProgress(0);
        }
    }
}
```
- 프로그레스 관련한 메소드를 빼면 굉장히 간단하게 스레드를 통해서 UI변경 작업을 할 수 있다.

느낀 점 : 처음에 스레드가 쉽지 않았는데 이제 슬슬 스레드에 대한 감이 잡히기 시작했다!! 




















