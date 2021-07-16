Fragment
=====
## 목차
1. [정의](#-정의)
2. [특징](#-특징)
3. [생소한 코드](#-생소한-코드)

## 정의
프레그먼트는 하나의 액티비티에서 일부의 화면을 나타낸다.
## 특징
#### 1. 프래그먼트는 액티비티에 속하는 뷰가 아니라서 프래그먼트를 관리하는 객체인 FragmentManager()를 이용하여 찾을 수 있음  
FragmentManager생성 코드  
```java
(MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
```
#### 2. 프레그먼트로 액티비티의 전체화면을 덮어서 하나의 액티비티에서 화면 전환을 구현할 수 있음
#### 프레그먼트로 화면전환을 구현하면 시스템보안을 좀 더 강화할 수 있다.  
#### 3.프레그먼트는 액티비티에서 사용하는 onCreate()가 아니라 onCreateView()메소드를 사용  
## 생소한 코드  
```java
inflater.inflate(R.layout.fragment_main, container, false);
```
    
##### R.layout.fragment_main를 container라고 하는 뷰그룹 안에 넣어달라는 뜻,false는 액티비티화면에 올라가는 시점이 다르기에 false로 함.  
##### LayoutInflater은 XML에 미리 정의해둔 틀을 실제 메모리에 올려주는 역할을 한다.  
##### 즉, LayoutInflater는 XML에 정의된 Resource를 View 객체로 반환해주는 역할을 한다.  
##### 우리가 매번 사용하는 onCreate() 메서드에 있는 setContentView(R.layout.activity_main) 또한 Inflater 역할을 한다  
