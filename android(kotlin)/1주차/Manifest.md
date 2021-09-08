### 정의
앱 프로젝트 Source set의 루트에 존해해야 하고, Android 빌드도구,Android 운영체제 및 Google Play에  앱에 대한 필수정보를 나타낸다.

### 매니페스트에서 꼭 선언해야하는 내용  
#### 1.앱의 패키지 이름
앱이 APK를 빌드 할 때 클래스의 네임 스페이스로 활용하한다. 
#### 2.앱의 구성요소(activity,service,receiver,provider)  
4대 컴포넌트라고 불리는 activity,service,receiver,provider을 사용할 때는 매니페스트에 해당 XML요소를 반드시 선언을 해야한다.  
4대 컴포넌트의 실행 로직을 보면 일단 인텐트로 활성화를 한다. 인텐트란 어떤 작업을 실행할 건지에 대한 설명을 담은 메세지 객체이다.  
즉 앱이 인텐트를 시스템에 발행하면 시스템은 매니페스트에 선언된 인턴트 필터를 보고 인텐트를 처리 할 수 있는 요소들을 찾아서 인텐트를 처리하게 된다.  
#### 3.권한
앱은 사용자에게 특정 권한을 부여받아야 한다. 예를 들어 앱이 카메라를 사용해서 어떤 이벤트를 한다면 사용자의 카메라에 엑세스를 해야한다.   
즉 사용자에게 카메라기능을 사용해도 괜찮냐고 물어봐야 하는데 이걸 권한 요청이라고 한다.  
만약 SMS메시지를 보내야 한다면 아래와 같이 권한요청을 해야한다.
```.xml
<uses-permission android : name="android.permission.SEND_SMS"/>
```
#### 4.앱에 필요한 하드웨어 및 소프트웨어 기능,기기호환성(SDK)

앱을 사용하는 데 있어서 카메라 기능이 꼭 필요하다면 이 앱은 카메라기능이 있는 기기만 다운로드 할 수 있도록 제한을 둘 수 있다.(아래 코드 참고)  
```.xml
<uses-freture android android : name="android.hardware.sensor.compass"
					android : required="true" />
```       
이런 경우도 있다. 플랫폼이 업그레이드를 하면서 이전 버전에서는 사용할 수 없는 API가 추가되는 경우가 있는다. 이런 경우 앱이 호환될 수 있는 최소버전을 build.gragle에서 아래와 같이 나타낼 수 있다  
```
android {
  defaultConfig {
    applicationId 'com.example.myapp'

    // 앱을 실행하는 데 있어서 최소로 요구되는 API 레벨
    minSdkVersion 15

    // 구체적인 API레벨
    targetSdkVersion 28

    ...
  }
}
```













