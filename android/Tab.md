Tab
===
## 목차
1. [Tab이란?](#-Tab)
2. [Tab을 만드는 과정](#-Tab을-만드는-과정)

## 1.Tab이란?
#### ActionBar바로밑에 아이콘들을 생성하고 아이콘을 누를 때마다 그에 맞는 이벤트가 일어나게 해주는 것이다

## 2.Tab을 만드는 과정
- **1.** MainActivity.xml을  전체화면의 비율을 보정해 주는 CoordinatorLayout태그와  AppBarLayout태그안에 
  ToolBar와 탭을 만드는 태그인 TabLayout으로 세팅한다.  
- **2** FrameLayout을 3개 만들고, 탭에 3개의 아이콘을 만들어서 각각 아이콘을 누르면 특정 프레임 레이아웃이
나오도록 한다.  
- **3** FramLayout은 ```onCreateView```로 infalte하고, MainActivity.java에서 3개 fragement대한 객체를 생성  
- **4** ToolBar객체를 만들고 MainActivity.xml에 있는 것과 연결.  
- **5** ```.addTab```을 통해 tab에 추가할 3개의 아이콘을 만든다  
- **6** ```addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()```을 통해 각각의 아이콘에 대한 이벤트 처리를 한다


project name:SampleTab
