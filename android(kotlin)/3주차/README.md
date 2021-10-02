## 이번 3주차 프로젝트는 배달의 민족을 클론코딩하는 것이다. 2주차랑 비슷하지만 좀 더 복잡한 기능을 다루기에 쉽지 않을것이다.
#### 9/30 현재 collapsinglayout을 이용해서 스크롤을 이용하고 있다. 이 레이아웃은 안드로이드의 머터리얼 디자인이다. 대충틀은 잡았는데  
#### addOnOffsetChangedListener를 이용해서 좀 더 세세하게 활용을 할려고 노력중이다.
#### 10/1 현재 addOnOffsetChangedListener와 verticalOffset을 이용해서 collapsing중에 얼마나 collapsing이 되는지를 값으로 추출해서 내가 원하는 구간에 효과를 주었다.  
#### 하지만 현재 문제점이 발생했다. 바로 statusBar을 투명하게 해야한다. 이것만 하면 완벽한데...
- 이 부분은 theme에 들어가서 밑에 코드를 작성하면 된다. 두번쨰코드를 작성해야 비로소 투명해진다.
```.xml
<item name="android:windowTranslucentStatus">true</item>
<item name="android:windowFullscreen">true</item>
```
#### 10/2 현재 배민에서의 핵심적인 기능들은 다 구현했다. 대표적으로 collapsingLayouy활용과 ScrollView에서 setOnScrollChangeListener를 이용해서 기능을 처리하는 게 있었다.
