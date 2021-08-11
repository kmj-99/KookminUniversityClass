- 이번 미션은 리사이클러뷰를 사용해서 밑에 사진처럼 구성하는 것이다.

![스크린샷(15)](https://user-images.githubusercontent.com/76093968/129060500-aa9f0a49-6b8e-4a51-82e5-1ce3511ca007.png)

#### `activity_main.xml` -  화면구성을 한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity"
    android:layout_margin="10dp"
    >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="쇼핑상품"
        android:textSize="30sp"/>
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@drawable/border"/>
</LinearLayout>
```

#### `MainActivity.java` - activirt_main에 맞게 소스코드를 작성한다.
```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

       ItemAdapter adapter=new ItemAdapter();

       adapter.addItems(new Item(R.drawable.coat,"롱코트","160,000","명철 기획상품"));
       adapter.addItems(new Item(R.drawable.shirt,"와이셔츠","80,000","특가상품"));
       adapter.addItems(new Item(R.drawable.shoes,"조깅화","220,000","특가상품"));
       adapter.addItems(new Item(R.drawable.sunglasses,"선글라스","300,000","명철 기획상품"));
       recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ItemAdapter.ViewHolder holder, View view, int position) {
                Log.d("PersonAdapter","onItemClick");
                Item item=adapter.getItem(position);
                showToast("아이탬 선택됨: "+item.getName());
            }
        } );






    }

    public void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}
```
#### `item.java` - 이미지,이름,가격,정보를 묶어서 클래스를 만든다.
```java
public class Item {
    int image;
    String name;
    String price;
    String info;
    public Item(int image,String name,String price, String info){
        this.image=image;
        this.name=name;
        this.price=price;
        this.info=info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

```
#### `itemAdapter.java` - 리사이클러뷰에 있는 아이템들을 관리하는 소스코드 작성
```java
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    ArrayList<Item> items=new ArrayList<Item>();
    OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
    public void addItems(Item item){
        items.add(item);
    }
    public Item getItem(int position){
        return items.get(position);
    }


    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_view,parent,false);
        return new ViewHolder(itemView,listener);
    }



    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        Item item=items.get(position);
        holder.setItem(item);

    }



    @Override
    public int getItemCount() { //리스트 안에 들어있는 객체의 개수 반환
        return items.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{ //레이아웃과 같은 뷰를 담아둘 객체 만듦
        ImageView imageView;
        TextView name_text;
        TextView price_text;
        TextView info_text;
        public ViewHolder(View itemView,final OnItemClickListener listener){
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            name_text=itemView.findViewById(R.id.name_text);
            price_text=itemView.findViewById(R.id.price_text);
            info_text=itemView.findViewById(R.id.info_text);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Log.d("PersonAdapter","onClick");
                    int position=getAdapterPosition();//getAdapterPosition(): 뷰홀더에 표시할 아이템이 어탭터에서 몇 번째인지 정보를 반환함.즉 아이템의 인덱스 정보를 반환
                    if(listener!=null){
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });


        }

        public void setItem(Item item){
            imageView.setImageResource(item.getImage());
            name_text.setText(item.getName());
            price_text.setText(item.getPrice());
            info_text.setText(item.getInfo());

        }
    }
}

```

#### `OnItemClickListener.java` - MainActivity.java와 ItemAdapter.java를 연결하여 클릭할 때 토스트메시지를 띄우도록 도와주는 인터페이스 작성
```java
public interface OnItemClickListener {
    public void onItemClick(ItemAdapter.ViewHolder holder , View view, int position);
}

```

#### `item_view.xml`- 리사이클러뷰에 있는 아이템뷰를 구성한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:background="@drawable/item_border"
    android:layout_margin="10dp"
>

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="100dp"
        app:srcCompat="@drawable/ic_launcher_background"
        android:layout_gravity="center_horizontal"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <TextView
            android:id="@+id/name_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="23"
            android:textSize="25sp"
            android:layout_weight="1"/>
        <TextView
            android:id="@+id/price_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="213"
            android:textSize="25sp"
            android:layout_weight="1"/>
    </LinearLayout>

    <TextView
        android:id="@+id/info_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="234"
        android:textSize="25sp"
        android:layout_marginTop="10dp"/>
</LinearLayout>
```

- 이런식으로 코드를 짜면 된다. 


느낀점: 이번 미션을 수행할 때 아이템 클릭 이벤트를 처리하는 부분에서 살짝 헤멨다. 그거말고는 여태 배운거 활용만 하면 되기에 괜찮았다.


























