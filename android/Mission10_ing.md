#### 지금 하고있는 Mission은 Action Bar,Bottom Bar,Navigation Bar,View Pager가 들어간 일반적인 앱에서 사용하는 화면을 구현하는 Mission이다
```      Fragment1 fragment1 =new Fragment1();
        adapter.addItem(fragment1);

        Fragment2 fragment2 =new Fragment2();
        adapter.addItem(fragment2);

        Fragment3 fragment3 =new Fragment3();
        adapter.addItem(fragment3);
```
#### 이 코드에서 막혔다.. addItem에서 요구하는 type과 내가 집어놓은 type이 달라서 에러가 발생했는데  
#### 다른 프로젝트에서는 에러가 안 났는데 이 프로젝트에서만 이러한 에러가 난다... 아마 전체적인 설계에서 잘못된 부분이 있는 거 같다...
```public Fragment getItem(int position) { 
            return items.get(position);
        }
```
#### 위 코드가 addItem함수다. 일단 소스코드를 모두 검토를 해봐야 한다... 
#### 드디어 에러를 해결했다. 
#### 에러가 난 이유는 내가 프레그먼트를 만들지 않고 일반 자바소스코드로 만들어서  Fragment를 상속받을 때 ```import androidx.fragment.app.Fragment;```가 import가 되야하는데  
#### ```import android.app.Fragment;```가 들어간 것이다. 
