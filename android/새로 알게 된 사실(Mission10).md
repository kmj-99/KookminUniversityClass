#### Mission10을 하면서 새로 알게된 사실은 navigation이랑 관련 된 것이다.
- 밑에 코드는 navigation에 있는 각각의 아이콘에 대한 리스너를 정의하는 코드다
```java
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nv_tab1:
                onFragmentSelected(0,null);
                Toast.makeText(getApplicationContext(),"first",Toast.LENGTH_LONG).show();

            case R.id.nv_tab2:
                onFragmentSelected(1,null);
                Toast.makeText(getApplicationContext(),"second",Toast.LENGTH_LONG).show();

            case R.id.nv_tab3:
                onFragmentSelected(2,null);
                Toast.makeText(getApplicationContext(),"three",Toast.LENGTH_LONG).show();

        }
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
```
- 하지만 위 코드로 작성하면 각각의 아이콘을 눌렀을 때 나오는 화면이 끝까지 다 나오는 이슈가 발생한다
- 예를 들어 두 번째 아이콘을 클릭하면 두 번째 프레그먼트,세 번째 프레그먼트가 나와서 결국엔 세번 째 프레그먼트가 화면에 나타난다
- 하지만 밑에 코드처럼 ```if```구문을 활용하여 처리하면 이슈는 해결된다.

```java
    public boolean onNavigationItemSelected(MenuItem item){
        int id= item.getItemId();

        if(id==R.id.nav_0){
            onFragmentSelected(0,null);
        }else if(id==R.id.nav_1){
            onFragmentSelected(1,null);
        }else if(id==R.id.nav_2){
            onFragmentSelected(2,null);
        }else if(id==R.id.nav_user_setting){
        }
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
```
