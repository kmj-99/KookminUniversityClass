Mission10은 일반적으로 많이 쓰이는 앱 화면을 구현하는 것이다. bottombar,actionBar,navigation,fragment,ViewPager등등 여태 배운 프론트엔드 개념들을 전부 활용했다
구현하는 흐름과 느낀점을 정리해 보았다
## 1. 구현의 흐름
### FragmentCallback이라는 인터페이스를 생성하여 특정 프레그먼트를 고르면 화면이 그 프레그먼트로 변하는 코드를 작성
### ViewPager와 Fragment 
- 3개의 fragment.xml을 만든다
- 첫 번째 fragment에 ViewPager를 구현한다.
- pageFragment라는 fragment를 만들어서 화면을 넘길 때 새로운 프레그먼트가 나오는 데 그 새로운 프레그먼트를 생성

### bottombar의 아이콘을 누르면 특정 프레그먼트로 전환되는 기능
- bottombar에 세팅할 버튼들들 menu디렉토리 안에 menu_bottom.xml을 만들어서 거기다가 버튼을 만든다
- MainActivity.java에서 ```onNavigationItemSelected```을 이용해 특정 아이콘이 눌리면 특정 프레그먼트가 나오게 끔 구현

### navigationview 
- navigationview 헤더는 xml파일을 만들어서 구현
- navigationview의 아이콘은 menu디렉토리 안에 xml파일을 만들어서 ```<item>```태그를 이용해서 구현한다
- MainActivity.java에서 ```onNavigationItemSelected```을 이용해 특정 아이콘이 눌리면 특정 프레그먼트가 나오게 끔 구현
### activity_main.xml
- 액션바는 ```<CoordinatorLayout>```,```<AppBarLayout>```,```<ToolBar>```을 이용해서 세팅
- 이미지(프레그먼트)가 나오는 부분은 ```<FrameLayout>```을 이용해서 세팅
- bottombar는 ```<BottomNavigationView>```을 통해서 세팅
- navigationview는 ```<NavigaionView>```을 통해서 세팅 


## 2. 느낀 점
- 이번 과제는 여태 했던 과제중 가장 삽질을 많이 한 과제이기도 하고, 가장 많이 배운 과제이기도 하다
- 삽질을 하면서 중요하다고 느낀 건 바로 **꼼꼼함** 이다. 논리에 맞게 하나도 빠짐없이 완벽히 코드를 작성해야만 앱이 돌아간다
- Fragment라고 해서 다 같은 Fragment가 아니고 , 각각의 소스코드 마다 import도 잘해야한다. 이러한 부분에서 좀 더 코드를 세심하고, 꼼꼼히 보는 게 중요하다고 느꼈다 
