- 이번미션은 쉽지않다. 난 json형태의 데이터를 받아서 파싱하는 걸 배웟는데 이 미션에선느 xml을 파싱을 해야한다. 쉽지않다..
- 소스코드를 보았는데 전체적인 흐름이 이해가 되었지만 몇몇 구체적인 개념이 이해가 안된다. 그 중 제일 이해가 안 되는 건 왜 GET이 아니라 POST를 사용하는 지가 제일 의문이다.. 머지?(9/1)
- 현재 문제가 생겼다. 전체 소스코드는 이해가 되었는데 URL의 데이터를 정확히 가져오지 못하는 이슈다. 뭐가문제지..? 아마 데이터를 파싱하는 데에서 문제가 생긴 거 같다. 파싱하는 데 쓰이는 클래스들이 현재 안드로이드 버전에서 지원되지 않아서 생기는 거 같다. 문서를 보면서 리팩토링을 해야겠다..

### 새로 얼게 된 지식  
**RenderScript**  
계산이 많은 작업을 Android에서 높은 성능으로 실행하기 위한 프레임워크입니다

//Android 12부터 지원이 중단되기에 사용하지 않는 것이 좋다.
Scripting languages 와 programing lanuages의 차이
 programming languages are compiled whereas scripting languages are interpreted, and the programming languages run independently but scripts do not.

(스크립트 언어의 예시:PHP, Perl, and Python)  
**Element**  
xml에서의 논리 요소로 Start-tag와 End-tag 사이에 데이터를 담는데 사용한다
// 현재 안드로이드에서는 지원을 안함 
DOM 파서
xml 문서의 모든 내용을 메모리에 트리 형태로 펼친 후 읽는 파서이기 때문에 특정 태그 재접속 속도가 대단히 빠르고, 임의의 노드를 여러번 읽을 수 있습니다  

**GC(garbage collection)**  
프로그램이 동적으로 할당했던 메모리 영역 중에서 필요없게 된 영역을 해제하는 기능이다
브룩스포인터
이 포인터는 메모리 워드를 하나 더 써서 이전 GC(가비지수집단계)단계에서 객체가 재배치됐는지 여부를 표시하고 새 버전 객체 콘텐츠의 위치를 가리킨다.
shadow$_klass_ & shadow$_monito
브룩스 포인터를 지원하기위해 추가된것  

**디버깅을 하는 2가지 방법**  
- 1. 처음 부터 디버깅 모드로 실행 -> 처음부터 실행하면 앱이 느려지기에 2번쨰방법을 이용하는 경우가 있음
- 2. 앱이 동작하고 있는 도중에 특정시점에서 실행 
