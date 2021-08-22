- 이번 미션은 단말기의 갤러리안에 있는 사진들을 가지고 와서 애니매이션을 통해 보여주는 미션이다.

#### activirt_main.xml - 버튼2개와 이미지를 띄울 프레임레이아웃을 배치한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="시작"/>
        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="중지"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="right"
            android:layout_marginRight="10dp"
            android:textSize="16dp"
            android:textColor="#000000"
            android:text="0 개"/>
    </LinearLayout>

    <FrameLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />

</LinearLayout>

```
#### picture_item.xml -프레임레이아웃에 들어갈 화면을 xml을 따로 만들어서 구성한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#ffffffff">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardBackgroundColor="#FFFFFFFF"
        app:cardCornerRadius="10dp"
        app:cardElevation="5dp"
        app:cardUseCompatPadding="true" >

        <LinearLayout
            android:orientation="horizontal"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="8dp">

            <ImageView
                android:layout_width="80dp"
                android:layout_height="80dp"
                android:id="@+id/imageView" />

            <LinearLayout
                android:orientation="vertical"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginLeft="10dp">

                <RelativeLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">
                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:text="Name"
                        android:id="@+id/textView"
                        android:textSize="20sp"
                        android:textColor="#0223e0"
                        android:layout_marginTop="6dp" />
                </RelativeLayout>

                <RelativeLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">
                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerHorizontal="true"
                        android:text="Date"
                        android:id="@+id/textView2"
                        android:textSize="20sp"
                        android:textColor="#4902d6" />
                </RelativeLayout>
            </LinearLayout>
        </LinearLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>
```

#### PictureItemView.java - 이미지를 추가하고 xml과 inflate하는 클래스를 따로 만들어 작성한다.
```java
public class PictureItemView extends LinearLayout {
    TextView textView;
    TextView textView2;

    ImageView imageView;

    BitmapFactory.Options options=new BitmapFactory.Options();

    public PictureItemView(Context context){
        super(context);
        init(context);
    }

    public PictureItemView(Context context, AttributeSet attr){
        super(context , attr);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.pictrue_item,this,true);

        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);

        imageView =findViewById(R.id.imageView);

        options.inSampleSize=12;
    }

    public void setName(String name){
        textView.setText(name);
    }

    public void setDate(String date){
        textView2.setText(date);
    }

    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
    public void setImage(String path){
        Bitmap bitmap=BitmapFactory.decodeFile(path,options);
        imageView.setImageBitmap(bitmap);
    }
}

```
#### ImageInfo.java - 단말기에서 받아온 이지미의 정보를 관리하도록 하는 클래스를 만듬
```java
public class ImageInfo {

    String path;
    String displayName;
    String dateAdded;

    public ImageInfo(String path,String displayName,String dateAdded){
        this.path=path;
        this.displayName=displayName;
        this.dateAdded=dateAdded;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "path='" + path + '\'' +
                ", displayName='" + displayName + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                '}';
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

#### MainActivity.java - 자동으로 권한을 물어봐주는 라이브러리를 참조한다. 그리고 스레드를 이용하여 핵심코드를 작성한다
```java

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
    FrameLayout container;
    Animation translate_in;

    PictureItemView view;

    TextView textView;

    int selected=0;

    boolean running=false;

    Handler handler=new Handler();

    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    int pictureCount=0;

    ArrayList<ImageInfo> pictures;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container=findViewById(R.id.container);
        textView=findViewById(R.id.textView);

        view=new PictureItemView(this);
        view.setName("사진이름");
        view.setDate("일시");
        container.addView(view);

        translate_in= AnimationUtils.loadAnimation(this,R.anim.translate_in);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                pictures=queryAllPictures();

                AnimationThread thread=new AnimationThread();
                thread.start();
            }
        });

        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                running = false;
            }
        });

        AutoPermissions.Companion.loadAllPermissions(this,101); //자동으로 권한을 부여하도록 요청
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResult){ //권한을 요청하면 그 결과가 넘어게 되는데 onRequestPermissionsResult 메소드로 전달받음
        super.onRequestPermissionsResult(requestCode,permissions,grantResult);

        AutoPermissions.Companion.parsePermissions(this,requestCode,permissions,this);// 여러개의 권한을 onGranted 또는 onDenied으로 나누어 호출
    }

    @Override
    public void onDenied(int requestCode, @NonNull String[] permissions){   //사용자가 권한을 거부
        Toast.makeText(this,"permissions denied : "+permissions.length,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGranted(int requestCode,@NonNull String[] permissions){ //사용자가 권한을 승인
        Toast.makeText(this,"permissions granted: "+permissions.length,Toast.LENGTH_LONG).show();
    }

    class AnimationThread extends Thread{
        public void run(){
            running=true;
            while(running){
                handler.post(new Runnable(){
                    public void run(){
                        ImageInfo info=pictures.get(selected);

                        view.setName(info.getDisplayName());
                        view.setDate(info.getDateAdded());
                        view.setImage(info.getPath());

                        view.startAnimation(translate_in);

                        selected+=1;

                        if(selected>pictureCount){
                            selected=0;
                        }
                        textView.setText(selected+"/"+pictureCount+"개");
                    }

                });

                try{
                    Thread.sleep(5000);
                }catch(Exception e){}
            }
        }
    }

    private ArrayList<ImageInfo> queryAllPictures(){
        ArrayList<ImageInfo> result=new ArrayList<>();
        Uri uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI; // MediaStore를 통해서 단말기에 있는 Images의 URL을 참조함
        String[] projection = { MediaStore.MediaColumns.DATA, MediaStore.MediaColumns.DISPLAY_NAME, MediaStore.MediaColumns.DATE_ADDED };
        // 내가 어떠한 정보를 얻어올 건지를 작성

        Cursor cursor = getContentResolver().query(uri, projection, null, null, MediaStore.MediaColumns.DATE_ADDED + " desc");
        // 단말기의 있는 데이터들은 데이터베이스의 쿼리형태로 있기때문에 Cursor울 이용해서 데이터 쿼리형태를 만든다.
        int columnDataIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        int columnNameIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME);
        int columnDateIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATE_ADDED);


        while (cursor.moveToNext()) {
            String path = cursor.getString(columnDataIndex);
            String displayName = cursor.getString(columnNameIndex);
            String outDate = cursor.getString(columnDateIndex);
            String addedDate = dateFormat.format(new Date(new Long(outDate).longValue() * 1000L));
            Log.d("break",path);

            if (!TextUtils.isEmpty(path)) {
                ImageInfo info = new ImageInfo(path, displayName, addedDate);
                result.add(info);
            }


            pictureCount++;
        }

        textView.setText(selected + " / " + pictureCount + " 개");
        Log.d("MainActivity", "Picture count : " + pictureCount);

        for (ImageInfo info : result) {
            Log.d("MainActivity", info.toString());
        }

        return result;
    }


}
```
- 여기서 단밀기정보에 접근하기 위해서 `queryAllPictures()`라는 메소드를 만들었다.

느낀 점 : 이번 실습은 어려웠다.. 일단 단말기 정보에 접근을 하는 게 가장 헷갈렸다. 하지만 이 부분을 빼면 쏘쏘했다!
















