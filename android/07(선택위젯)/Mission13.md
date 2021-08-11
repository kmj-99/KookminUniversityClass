- 이번 미션은 이름,나이,생년월일을 입력받아서 리사이클러뷰에 추가하는 미션이다.

#### activity_main.xml - 화면 구성을 한다
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="고객정보 추가"
            android:textSize="30sp"/>

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="helo"
            android:textSize="20sp"
            android:layout_marginLeft="150dp"/>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/layout1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/editText1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="이름"
            android:layout_weight="1"/>
        <EditText
            android:id="@+id/editText2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="생년월일"
            android:layout_weight="1"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <EditText
            android:id="@+id/editText3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="전화번호"/>
        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:backgroundTint="@color/cardview_shadow_start_color"
            android:text="추가"/>
    </LinearLayout>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />


</LinearLayout>
```

#### MainActivity.java - activity_main의 자바소스코드를 작성한다.
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="고객정보 추가"
            android:textSize="30sp"/>

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="helo"
            android:textSize="20sp"
            android:layout_marginLeft="150dp"/>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/layout1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/editText1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="이름"
            android:layout_weight="1"/>
        <EditText
            android:id="@+id/editText2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="생년월일"
            android:layout_weight="1"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <EditText
            android:id="@+id/editText3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="전화번호"/>
        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:backgroundTint="@color/cardview_shadow_start_color"
            android:text="추가"/>
    </LinearLayout>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />


</LinearLayout>
```
#### `Person.java` - 이름,나이,생년월일을 한번에 묶어서 클래스로 만듬
```java
package org.techtown.mission13;

import android.util.Log;

public class Person {
    String name;
    String number;
    String birth;
    public Person(String name,String number,String birth){
        this.name=name;
        this.number=number;
        this.birth=birth;

    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBirth(){
        return this.birth;
    }
    public void setBirth(){
        this.birth=birth;
    }
}

```
#### `PersonAdapter.java`- 리스트뷰에 추가한 아이템들을 관리하는 소스코드를 작성
```java
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{
    ArrayList<Person> items =new ArrayList<Person>();

    public void addItems(Person item){
        items.add(item);
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.person,parent,false);
        return new ViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        Person item=items.get(position);
        holder.setItem(item);

    }


    @Override
    public int getItemCount() { //리스트 안에 들어있는 객체의 개수 반환
        return items.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{ //레이아웃과 같은 뷰를 담아둘 객체 만듦
        TextView textView_name;
        TextView textView_number;
        TextView textView_birth;
        public ViewHolder(View itemView){
            super(itemView);

            textView_name=itemView.findViewById(R.id.textView_name);
            textView_number=itemView.findViewById(R.id.textView_number);
            textView_birth=itemView.findViewById(R.id.textView_birth);
            Log.d("break","ViewHolder");
        }

        public void setItem(Person item){
            Log.d("PersonAdapter","setItem");
            textView_name.setText(item.getName());
            textView_number.setText(item.getNumber());
            textView_birth.setText(item.getBirth());

        }
    }
}

``` 
#### `person.xml`- 아이템의 뷰를 구성한다.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <ImageView
                android:layout_width="120dp"
                android:layout_height="120dp"
                app:srcCompat="@mipmap/ic_launcher"
                android:padding="5dp"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">

                <TextView
                    android:id="@+id/textView_name"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="이름"
                    android:layout_weight="1"/>
                <TextView
                    android:id="@+id/textView_number"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="전화번호"
                    android:layout_weight="1"/>
                <TextView
                    android:id="@+id/textView_birth"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="생년월일"
                    android:layout_weight="1"/>
            </LinearLayout>
        </LinearLayout>



    </androidx.cardview.widget.CardView>

</LinearLayout>
```

- 여기까지다. 이번 미션은 리사이클러뷰를 그대로 활용하면 쉽게 풀리는 미션이었다.



















