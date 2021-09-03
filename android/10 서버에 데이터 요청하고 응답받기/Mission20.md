- 이번미션은 쉽지않다. 난 json형태의 데이터를 받아서 파싱하는 걸 배웟는데 이 미션에선느 xml을 파싱을 해야한다. 쉽지않다..
### 소스코드를 보았는데 전체적인 흐름이 이해가 되었지만 몇몇 구체적인 개념이 이해가 안된다. 그 중 제일 이해가 안 되는 건 왜 GET이 아니라 POST를 사용하는 지가 제일 의문이다.. 머지?(9/1)
- 해결: 이건 그냥 소스코드의 오류인 거 같다. POST가 아니라 GET이 맞다.
### 현재 문제가 생겼다. 전체 소스코드는 이해가 되었는데 URL의 데이터를 정확히 가져오지 못하는 이슈다. 뭐가문제지..? 아마 데이터를 파싱하는 데에서 문제가 생긴 거 같다. 파싱하는 데 쓰이는 클래스들이 현재 안드로이드 버전에서 지원되지 않아서 생기는 거 같다. 문서를 보면서 리팩토링을 해야겠다..
- 해결: 일단 데이터 파싱은 문제가 없다. http를 활용하여 데이터를 요청하는 로직에서 `conn.setDoOutput(true)`이렇게 설정이 되었는데 이거 내가 데이터를 보낼 때 설정을 하는 것이다. 저걸 지우고 하니까 잘 돌아갔다. 



#### activity_main.xml - 화면 구성
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="10dp"
        >

        <EditText
            android:id="@+id/edit01"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="7"
            android:width="200dp"
            android:hint="RSS 사이트 주소 입력 ..."
            android:text=""
            android:textSize="16sp"
            />

        <Button android:id="@+id/show_btn"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="2"
            android:layout_gravity="center_vertical"
            android:text=" 조회하기 "
            />

    </LinearLayout>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>

```  
#### node_item.xml - 리사이클러뷰의 아이템의 모양을 구성
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:layout_marginTop="4dp"
    android:layout_marginLeft="4dp"
    android:layout_marginRight="4dp" >


    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardBackgroundColor="#FFFFFFFF"
        app:cardCornerRadius="10dp"
        app:cardElevation="5dp"
        app:cardUseCompatPadding="true" >

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="300dp"
            android:layout_margin="8dp">

            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                >
                <ImageView
                    android:id="@+id/iconItem"
                    android:layout_width="40dp"
                    android:layout_height="40dp"
                    android:padding="8dp"
                    android:layout_alignParentLeft="true"
                    android:layout_alignParentTop="true"
                    />
                <LinearLayout
                    android:id="@+id/layout1"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    android:layout_alignParentRight="true"
                    android:layout_alignParentTop="true"
                    android:layout_toRightOf="@+id/iconItem"
                    >
                    <TextView
                        android:id="@+id/dataItem01"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textStyle="bold"
                        android:textSize="16sp"
                        android:padding="4dp"
                        />
                </LinearLayout>
                <LinearLayout
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    android:layout_below="@+id/layout1"
                    >
                    <TextView
                        android:id="@+id/dataItem02"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        />
                    <TextView
                        android:id="@+id/dataItem03"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textColor="#ccf88107"
                        android:textSize="12sp"
                        android:textStyle="bold"
                        android:paddingRight="4dp"
                        />
                </LinearLayout>
            </RelativeLayout>
            <WebView
                android:id="@+id/dataItem04"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:padding="4dp"
                />
        </LinearLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>

```  

#### MainActivity.java
```java
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static String rssUrl = "https://news.sbs.co.kr/news/sitemapRSS.do";


    ProgressDialog progressDialog;
    Handler handler = new Handler();

    RecyclerView recyclerView;
    RSSNewsAdapter adapter;
    ArrayList<RSSNewsItem> newsItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RSSNewsAdapter();
        recyclerView.setAdapter(adapter);



        newsItemList = new ArrayList<RSSNewsItem>();

        final EditText edit01 = findViewById(R.id.edit01);
        edit01.setText(rssUrl);

        Button show_btn = findViewById(R.id.show_btn);
        show_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String inputStr = edit01.getText().toString();
                showRSS(inputStr);
            }

        });

    }

    private void showRSS(String urlStr) {
        try {
            progressDialog = ProgressDialog.show(this, "RSS Refresh", "RSS 정보 업데이트 중...", true, true);
            Log.d("break","showRSS");
            RefreshThread thread = new RefreshThread(urlStr);
            thread.start();

        } catch (Exception e) {
            Log.e(TAG, "Error", e);
        }
    }

    class RefreshThread extends Thread {
        String urlStr;

        public RefreshThread(String str) {
            urlStr = str;
        }

        public void run() {

            try {

                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance(); // DOM object를 만드는 parser를 얻게주는 메소드
                DocumentBuilder builder = builderFactory.newDocumentBuilder();          // parser에서 DOM object를 가져옴

                URL urlForHttp = new URL(urlStr);

                InputStream instream = getInputStreamUsingHTTP(urlForHttp); // InputStream은 모든 바이트기반 인풋스트림의 최상위 클래스이다.

                Document document = builder.parse(instream);                // represents the entire HTML or XML document
                // it is the root of the document tree, and provides the primary access to the document's data.
                int countItem = processDocument(document); //processDocument : Document를 분석하여 몇개의 데이터가 있는지 반환해준다
                Log.d(TAG, countItem + " news item processed.");

                // post for the display of fetched RSS info.
                handler.post(updateRSSRunnable);  //

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public InputStream getInputStreamUsingHTTP(URL url)
            throws Exception
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // 왜 post?
        conn.setDoInput(true); //읽기모드 지정
        

        int resCode = conn.getResponseCode();
        Log.d(TAG, "Response Code : " + resCode);

        InputStream instream = conn.getInputStream();
        return instream;
    }

    /**
     * process DOM document for RSS
     */
    private int processDocument(Document doc) { //데이터 정제하는 함수
        newsItemList.clear();
        Log.d("break","processDocument");
        Element docEle = doc.getDocumentElement(); // start tag 와 end tag안에 있는 내용을 가져옴
        NodeList nodelist = docEle.getElementsByTagName("item"); //item 태그를 모두 가져옴

        int count = 0;
        if ((nodelist != null) && (nodelist.getLength() > 0)) {
            for (int i = 0; i <1; i++) {
                RSSNewsItem newsItem = dissectNode(nodelist, i);
                Log.d("count",newsItem.getTitle());
                if (newsItem != null) {
                    newsItemList.add(newsItem);
                    count++;
                }
            }
        }

        return count;
    }

    private RSSNewsItem dissectNode(NodeList nodelist, int index) { //데이터를 파싱하는 함수
        RSSNewsItem newsItem = null;

        try {
            Log.d("break","dissectNode");
            Element entry = (Element) nodelist.item(index); // start tag와end tag사이의 태그들을 불러온다.

            Element title = (Element) entry.getElementsByTagName("title").item(0);
            Log.d("new_data",title.getTextContent().toString());
            Element link = (Element) entry.getElementsByTagName("link").item(0);
            Element description = (Element) entry.getElementsByTagName("description").item(0);

            NodeList pubDataNode = entry.getElementsByTagName("pubDate");

            if (pubDataNode == null) {
                pubDataNode = entry.getElementsByTagName("dc:date");
            }
            Element pubDate = (Element) pubDataNode.item(0);

            Element author = (Element) entry.getElementsByTagName("author").item(0);
            Element category = (Element) entry.getElementsByTagName("category").item(0);

            String titleValue = null;
            if (title != null) {
                Node firstChild = title.getFirstChild();
                if (firstChild != null) {
                    titleValue = firstChild.getNodeValue();
                }
            }
            String linkValue = null;
            if (link != null) {
                Node firstChild = link.getFirstChild();
                if (firstChild != null) {
                    linkValue = firstChild.getNodeValue();
                }
            }

            String descriptionValue = null;
            if (description != null) {
                Node firstChild = description.getFirstChild();
                if (firstChild != null) {
                    descriptionValue = firstChild.getNodeValue();
                }
            }

            String pubDateValue = null;
            if (pubDate != null) {
                Node firstChild = pubDate.getFirstChild();
                if (firstChild != null) {
                    pubDateValue = firstChild.getNodeValue();
                }
            }

            String authorValue = null;
            if (author != null) {
                Node firstChild = author.getFirstChild();
                if (firstChild != null) {
                    authorValue = firstChild.getNodeValue();
                }
            }

            String categoryValue = null;
            if (category != null) {
                Node firstChild = category.getFirstChild();
                if (firstChild != null) {
                    categoryValue = firstChild.getNodeValue();
                }
            }

            Log.d(TAG, "item node : " + titleValue + ", " + linkValue + ", " + descriptionValue +
                    ", " + pubDateValue + ", " + authorValue + ", " + categoryValue);

            newsItem = new RSSNewsItem(titleValue, linkValue, descriptionValue,
                    pubDateValue, authorValue, categoryValue);

        } catch (DOMException e) {
            e.printStackTrace();
        }

        return newsItem;
    }


    Runnable updateRSSRunnable = new Runnable() {
        public void run() {

            try {
                Log.d("break","updateRSSRunnable");
                Resources res = getResources();
                Drawable rssIcon = res.getDrawable(R.drawable.rss_icon);
                for (int i = 0; i < newsItemList.size(); i++) {
                    RSSNewsItem newsItem = newsItemList.get(i);
                    newsItem.setIcon(rssIcon);
                    adapter.addItem(newsItem);
                }

                adapter.notifyDataSetChanged();

                progressDialog.dismiss();
            } catch(Exception ex) {
                ex.printStackTrace();
            }

        }
    };

}

```
#### RSSNewsAdapter.java- 리사이클러뷰를 컨트롤 하기위해 Adapter을 하나 생성
```java
public class RSSNewsAdapter extends RecyclerView.Adapter<RSSNewsAdapter.ViewHolder>
        implements OnRSSNewsItemClickListener {
    ArrayList<RSSNewsItem> items = new ArrayList<RSSNewsItem>();

    OnRSSNewsItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.node_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        RSSNewsItem item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(RSSNewsItem item) {
        items.add(item);
    }

    public void setItems(ArrayList<RSSNewsItem> items) {
        this.items = items;
    }

    public RSSNewsItem getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, RSSNewsItem item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnRSSNewsItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIcon;
        private TextView mText01;
        private TextView mText02;
        private TextView mText03;
        private WebView mText04;

        public ViewHolder(View itemView, final OnRSSNewsItemClickListener listener) {
            super(itemView);

            mIcon = itemView.findViewById(R.id.iconItem);
            mText01 = itemView.findViewById(R.id.dataItem01);
            mText02 = itemView.findViewById(R.id.dataItem02);
            mText03 = itemView.findViewById(R.id.dataItem03);
            mText04 = itemView.findViewById(R.id.dataItem04);
            Log.d("ViewHolder","Viewholder");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(RSSNewsItem item) {
            mIcon.setImageDrawable(item.getIcon());

            mText01.setText(item.getTitle());
            mText02.setText(item.getPubDate());

            String category = item.getCategory();
            if (category != null) {
                mText03.setText(category);
            }

            setTextToWebView(item.getDescription());
            Log.d("data3","setItem");

        }

        private void setTextToWebView(String msg) {
            Log.d("RSSNewsItemView", "setTextToWebView() called.");

            String outData = msg;

            outData = outData.replace("\"//", "\"http://");

            mText04.loadDataWithBaseURL("http://localhost/", outData, "text/html", "utf-8", null);
            Log.d("data3","http://localhost/"+outData);

        }

    }

}

```

#### RSSNewsItem.java - 파싱된 xml데이터를 담을 클래스
```java

public class RSSNewsItem {

    private String title;
    private String link;
    private String description;
    private String pubDate;
    private String author;
    private String category;

    private Drawable mIcon;

    /**
     * Initialize with icon and data array
     */
    public RSSNewsItem() {
    }

    /**
     * Initialize with icon and strings
     */
    public RSSNewsItem(String title, String link, String description, String pubDate, String author, String category) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.author = author;
        this.category = category;
    }

    /**
     * Set icon
     *
     * @param icon
     */
    public void setIcon(Drawable icon) {
        mIcon = icon;
    }

    /**
     * Get icon
     *
     * @return
     */
    public Drawable getIcon() {
        return mIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Compare with the input object
     *
     * @param other
     * @return
     */
    public int compareTo(RSSNewsItem other) {
        if (title.equals(other.getTitle())) {
            return -1;
        } else if (link.equals(other.getLink())) {
            return -1;
        } else if (description.equals(other.getDescription())) {
            return -1;
        } else if (pubDate.equals(other.getPubDate())) {
            return -1;
        } else if (author.equals(other.getAuthor())) {
            return -1;
        } else if (category.equals(other.getCategory())) {
            return -1;
        }

        return 0;
    }

}

```




### 새로 알게 된 지식  
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


느낀 점: 소스코드를 무작정 신뢰하지 말고 무조건 정답이라고도 생각하면 큰일난다...  
