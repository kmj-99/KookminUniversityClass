Action bar
==========
## 목차
1. [Action Bar란?](#-Action-Bar란?)
2. [Action Bar에 Icon 넣는 방법](#-Action-Bar에-Icon-넣는-방법)

## 1.Action Bar란?
#### Action Bar는 애뮬레이터를 뛰우면 상단에 바가 있는데 그걸 Action Bar라고 한다
#### menu.xml을 만들어서 세팅을 하고 Action Bar에 띄우기 가능- 자세한 건 2번에서....


## 2.Action Bar에 Icon 넣는 방법
#### res에서 Directory를 하나 생성을 한다.->Directory에서 xml파일을 하나 만들고 세팅한다->그리고 MainActivity.xml과 연결한다(말로는 쉽지만 만만치 않았다...)
***
#### 실제 코드로 더 자세히 살펴보자!  
#### 1.menu라는 Directory를 생성하고 그 안에 menu.xml파일을 생성  
#### 2.```<item>```태그를 사용해서 아이콘을 채운다. 그러면 Action bar에 아이콘이 채워짐
#### 이때 태그안에 내가 지정한 image를 ```android:icon```을 이용해서 집어넣으면 Action bar에 아이콘이 추가 됨
#### 3. getMenuInflater().inflate를 이용해서 MainActivity.xml의 Action bar에 미리 만들어놓은 menu.xml을 inflate한다.
```jave
    public boolean onCreateOptionsMenu(Menu menu) {  
    getMenuInflater().inflate(R.menu.menu_main,menu); // menu_main을 menu에 붙힘,getMenuInfalter().inflate을 사용하여서 menu생성  
   return true;
}
```
#### 4. 각 아이콘에 대하여 이벤트 처리를 하고싶으면 onOptionsItemSelected함수를 정의하여서 처리한다

```java
public boolean onOptionsItemSelected(@NonNull MenuItem item)
```

project name : SampleOptionMenu
    
