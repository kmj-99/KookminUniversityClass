Pager
=====
## 목차
1. [Pager란?](#-Pager란?)
2. [Pager를 만드는 방법](#-Pager를-만드는-방법)

## 1.Pager란?
#### Pager는 화면을 넘길때 스무스하게 다음화면으로 넘길 수 있게해주는 태그다

## 2.Pager를 만드는 방법
#### fragment를 이용해서 3개의 페이지를 만든다고 가정
#### **1**. ```<androidx.viewpager.widget.ViewPager>```태그를 이용해서 Pager 생성
#### **2**. ```<androidx.viewpager.widget.PagerTitleStrip>```태그를 이용해서 특정 페이지의 정보를 위에 표시
#### **3**. ```MyPagerAdapter pager```로 pager라는 인스턴스를 만든다. Adapter는 뒷단에서 pager와 의사소통을 하는 객체이다
#### **4** 각 fragment를 ```pager.addItem('fragemet_name')```로 adapter에 추가한다
#### **5** ```pager.setAdapter(adapter)```로 dapter를 세팅
- MyPagerAdapter에 대한 자세한 코드
```   class MyPagerAdapter extends FragmentStatePagerAdapter { //븊페이지 안에 보이는 화면을 프레그먼트로 구성
        ArrayList<Fragment> items=new ArrayList<Fragment>();//그 프레그먼트를 관리하는것을 어뎁터로 구성
        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){ //어뎁터에 새로운 프레그먼트 추가
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) { //position에 해당하는프레그먼트를 return
            return items.get(position);
        }

        @Override
        public int getCount() { //ArrayList안에 들어가있는 프레그먼트 개수 return
            return items.size();
        }

        public CharSequence getPageTitle(int position){ //특정 position에 대해 TitleStrip를 설정
            return "페이지"+position;
        }
        
    }
    ```
