# [common]

### TextView

화면에 text를 추가할 때 사용

### Button

화면에 버튼을 추가할 때 사용

### ImageView

화면에 이미지를 추가할 떄 사용

### RecyclerView

여러개의 뷰를 묶어서 스크롤형태로 보여주는 뷰그룹

### FragemntContainerView

프레그먼트를 좀 더 구체적으로 디자인하기 위한 뷰

### ScrollView

뷰그룹내에 있는 뷰들을 스크롤할 수 있도록 해줌

### Switch

두개의 옵션중 하나를 고르는 기능을 할 수있는 토글이다

# [text]

### TextView

화면에 text를 추가할 때 사용

### PlainText

키보드 입력을 표시함

### password

패스워드 입력 키보드 표시

### password(Numeric)

패스워드 입력 키보드를 표시하는데 숫자만 입력하도록 표시

### E-mail

이메일을 쓰기위한 입력키보드 표시

### Phone

폰번호를 입력위한 입력키보드 표시

### PostalAddress

사용자가 우편번호 형식의 텍스트를 입력하기 쉽게 키보드 맨 윗줄에 길게 탭했을 때 숫자가 입력

### Multiline Text

새 줄을 추가하기 위해 Enter 키를 추가하여 표준 텍스트 키보드를 표시

### Time

사용자가 시간 형식의 텍스트(예) 12:20)를 입력하기 쉽게 ":" 문자를 추가하여 숫자 키보드를 표시

### Date

사용자가 날짜 형식의 텍스트(예) 2020/09/23)를 입력하기 쉽게 "/"문자를 추가하여 숫자 키보드를 표시

### Number

기본 숫자 키보드를 표시합니다. '-', ',' '.' 등의 부호가 입력되지 않음

### Number(Singed)

기본 숫자 키보드를 표시 , 시작시 + 또는-문자를 허용(양수,음수)

숫자를 입력하는 도중에는 '-'를 입력할 수 없고, 이 외에 ','와 '.'를 쓸 수 없음

### Number(Decimal)

기본 숫자 키보드를 표시, 소수점('.')을 허용합니다. '-'와 ','는 사용할 수 없음

### AutoCompleteTextView

사용자가 입력하는 동안 자동 완성 제안을 표시하는 편집 가능한 텍스트보기.

### MultiAutoCompleteTextView

AutoCompleteTextView사용자가 전체 내용 대신 입력하는 텍스트의 하위 문자열에 대한 완성 제안을 표시

### CheckedTextView

체크박스를 제공하는 뷰이다.

### TextlnputLayout

텍스트를 입력하는 곳이 레이아웃의 속성을 가지게 한다.

즉 레이아웃처럼 텍스트를 설정 할 수 있다

# [Button]

### Button

화면에 버튼을 추가한다

### ImageButton

이미지버튼을 화면에 추가한다.

### Chip

타원형의 텍스트를 표현하는 버튼

### ChipGroup

Chip을 여러개 모아놓은 그룹

### RadioButton

체크박스 형태의 버튼

### RadioGroup

여러개의 RadioButton을 모아놓아서 선택할 수 있도록 묶음

### ToggleButton

ON/OFF상태를 표시해주는 토글형태의 버튼

### Switch

두개의 옵션중 하나를 고르는 기능을 할 수있는 토글이다

### FloatingActionButton

두개의 옵션중 하나를 고르는 기능을 할 수있는 토글이다

### FloatingActionButton

UI에 떠있는 듯한 느낌의 버튼

# [Widget]

### WebView

요청한 URL에 해당하는 웹페이지를 보여줌

### VideoView

뷰를 상속받고 액티비티에 동영상을 넣음

즉, 비디오를 보여주는 뷰

### CalendarView

캘린더를 보여주는 뷰

//View를 상속받아 캘린더를 넣음

### ProgressBar

원형형태의 실시간 게이지를 나타내는 뷰

### ProgressBar(Horizontal)

가로형태의 실시간 게이지를 나타내는 뷰

### SeekBar

드래그가 가능하도록 만든 ProgressBar의 확장뷰

### SeekBar(Discrete)

SeekBar에 임의의 점을 찍어 그곳을 지나가도록 하는 뷰

### RatingBar

SeekBar 및 ProgressBar의 확장으로 별표로 등급 을 표시

### SearchView

사용자가 검색어 입력 후 search provider 에게 검색을 요청할 수 있는 UI 를 제공

### TexttureView

TextureView를 사용하여 비디오나 openGL 같은 콘텐츠 스트림을 표시 할 수 있습니다

### SurfaceView

뷰 계층 구조에 포함 된 형식과 크기의 제어가 가능한 전용 드로잉 표면을 제공

### Horizontal Divider

수평으로 나눔

### Veritical Divider

수직으로 나눔

# [container]

### Spinner

여러개의 아이템중 하나를 선택하게 할 수 있도록 함

### RecyclerView

여러개의 뷰(아이템)들을 하나로 묶어서 (뷰그룹) 스크롤 형태로 제공

### ScrollView

위아래로 스크롤 할 수 있도록 해주는 뷰

### HorizontalScrollView

수평으로 스크롤 할 수 있도록 해주는 뷰

### NestedScrollView

한 화면에 여러개의 스크롤을 사용할 때 사용하는 뷰

### ViewPager2

Page를 바꾸는 슬라이드 동작을 하는 View이고 ViewPager 에서 이전되었다.

세로방향,오른쪽에서 왼쪽으로등등 ViewPager보다 더 많은 기능을 제공한다.

### CardView

둥근 모서리와 그림자로 디자인 할 수 있도록 도와줌

### AppBarLayout

AppBarLayout은 앱 바 개념의 많은 특징, 스크롤 제스처를 구현하는 LinearLayout(vertical)이다.

### BottonAppBar

위에 바가 아니고 밑에 바를 설정하고 싶을 때 사용한다

### NavigationView

DrawerLayout에 들어있는 뷰로서 앱을 위한 표준 navigation menu이다. 즉 숨겨져 있다가 메뉴 아이콘을 누르면 메뉴가 나타난다

### BottomNavigationView

앱을 위한 표준 navigation menu이다. 쉽게 말해서 하단바라고 보면 된다.

### Toolbar

앱에 있는 각종 콘텐츠를 사용하기 위한 표준도구모움이다.

### TableLayout

탭의 수평 레이아웃을 제공한다

### TabItem

TabLayout 레이아웃 내에서 탭 항목

### ViewStub

실행 시 레이아웃 리소스를 느리게 인플레이트 하는데 사용되는 사이즈가 0인 보이지 않는 뷰이다.

### <include>

레이아웃에 재사용 가능한 구성요소를 추가

### FragmentContainerView

프레그먼트를 위해 만들어지는 사용자지정 레이아웃이다.

프레임 레이아웃을 포함하고 있고, 프레그먼트 트랜잭션을 잘 핸들링 할 수 있다.

### NavHostFragment

navigation이 발생할 수 있도록 레이아웃 내에 영역을 제공

### <view>

다른 View들을 포함하고 있거나 포함할 수 있는 View를 뜻한다.

### <requestFocus>

해당 뷰를 포커스 한다.

# [Helpers]

### Group

여러 뷰들의 visibility를 그룹으로 묶어 관리하기 편하게 해준다.

### Barrier

입력을 통해 여러개의 위젯을 참조할 수 있다. 그리고 가상의 가이드 라인을 만들어서

참조받은 위젯들이 Barrier에 맞게 크기/위치가 변경되도록 한다,

### Guideline

가로/세로축 방향을 가진 가상의 뷰로 뷰의 위치를 잡는 데 도움이 되는 유틸리티 클래스이다

### Layer

모형을 겹처서 한꺼번에 출력할 수 있다.

### ImageFilterView

이미지를 표시하며 색조, 명도, 색온도, 대비 등의 수정이 가능한 뷰

### ImageFilterButton

이미지를 표시하며 색조, 명도, 색온도, 대비 등의 수정이 가능한 버튼

### MockView

레이아웃을 프로토타입화하는 데 유용한 보기

# [google]

### AdView

화면에 구글의 광고를 표시할 수 있다.

### MapView

화면에 구글 지도에서 데이터와 지도를 함께 표시할 수 있다.

참고 : Legacy는 안드로이드에서 더이상 지원을 하지 않는다

### 여기까지 팔레트의 모든 항목을 조사해보았다. Layout부분은 따로 페이지를 만들 예정이다. 생각보다 항목들이 너무 많았고,

### 아직 이해가 되지 않는 부분도 있는 데 그건 앞으로 많은 과제들을 수행하면서 자연스럽게 이해가 되리라 믿는다!
