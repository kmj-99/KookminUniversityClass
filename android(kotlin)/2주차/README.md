# 이번에 할 프로젝트 주제는 액티비티의 생명주기를 고려해서 자유롭게 앱을 만드는 주제다.
#### 본 프로젝트를 하기전 EM이 내주신 레이아웃구성을 해봐야한다.
#### 9/16 현재 광고이미지를ViewPager2를 이용해서 자동 스크롤을 구현을 했는데 해당 이미지를 누르고 있을 때 카운트를 잠시 멈추는 기능에서 막혔다.. 대체 어떤식으로 해야하지? 
#### 9/17 지금 인텐트를 통해서 액티비티 화면을 전환하는 걸 구현하고 있는데 when안에서 intent가 참조가 안된다.. 왜 그러지? 여기서 현재 삽질을 하고있다.
- 이 부분은 onCreate가 정의가 잘못되어서 그렇다. Parcelablebundle을 받는 부분을 없애면 잘 작동된다.
#### 9/18 현재 바텀바에 특정 아이콘만 클릭했을 때 아무효과도 안 나게 하고싶은 데 잘 안된다.. Ripple effect,selector라는 키워드로 피드백을 받고 찾아보고 있다.
- 이 부분은 바텀바 리스너를 통해서 when으로 어떤 아이콘이 클릭됬는지를 판별했는 데 이떄 특정 아이콘에서 그냥 finish를 하면 그 버튼을 눌렀을 때 나타나는 ripple effect도 사라진다.
- 아래 사진에서 R.id.icon3에 finish()를 주었다.
![2021-09-19 (1)](https://user-images.githubusercontent.com/76093968/133894879-add648c1-272f-4638-a87a-bf5099daebbf.png)
#### 9/20 특정 프레그먼트로 넘어갈 때 반만 나타나게 하고 나머지는 이전 프레그먼트를 투명하게 보여주는 기능을 구현했다.(밑에 이미지 참고)

![2021-09-20 (1)](https://user-images.githubusercontent.com/76093968/134017683-bd73652d-d916-4a02-b992-671d8834dd7f.png)
#### 9/21 주어진 기능을 모두 구현을 했기때문에 좀 더 세세하게 디자인을 잡아주고 있는중이다. ~ing
#### 9/23 현재 중첩 리사이클러뷰를 참고해서 레이아웃을 구성중이다. 근데 3주차랑 겹쳐가지고 더 오래걸리는 거 같다.
- 이부분은 그냥 스크롤뷰를 이용을 하는 게 더 간단할 거 같아서 중첨 리사이클러뷰는 참고만 했다.
#### 9/24 전체적인 틀을 갖추는 건 끝났고 레이아웃의 세세한 부분이랑 생명주기를 이용하아는 것만 코딩하면 끝이다. 
#### 9/25 화면스크롤을 좀 더 역동적으로 보여주기 위해 CollapsingToolbarLayout을 이용해서 레이아웃을 구성하고 있다.
#### 9/26 CollapsingToolbarLayout을 이용해서 레이아웃을 구성했다
![2021-09-26 (1)](https://user-images.githubusercontent.com/76093968/134812206-f4e14c71-8b5c-48fe-a59d-8322012818f6.png)
![2021-09-26 (2)](https://user-images.githubusercontent.com/76093968/134812211-671f7cad-0c91-43e5-9fdd-6137ac727d8e.png)
#### 9/27 기능들은 다 완성했다. 전체적인 틀과 자세한 기능들을 다 구현했기 때문에 레이아웃을 추가하거나 레이아웃디자인을 좀 더 세세하게 작업만 하면된다.  
#### 이런 부분은 그냥 xml만 짜면 되기때문에 사실상 다 구현했다.

![1](https://user-images.githubusercontent.com/76093968/134929969-6eea9d35-af2b-4e44-8939-b6ee198fdd8a.png)
![2](https://user-images.githubusercontent.com/76093968/134929983-bbf08bb2-d3eb-40c7-a9ef-3b7c65341054.png)
![3](https://user-images.githubusercontent.com/76093968/134929995-9d3fa0e1-6def-4453-859d-37580b9ca47b.png)
![4](https://user-images.githubusercontent.com/76093968/134930006-83fba8b0-e3fa-4665-a79e-efbe627a4d86.png)
![5](https://user-images.githubusercontent.com/76093968/134930018-4996783c-5e32-4f74-a6ae-2629a109ff8c.png)


- 위 이미지처럼 xml만 구성하면 끝이다.



