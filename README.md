# Work5
获取URL地址并启动隐式Intent的调用

MainActivity.java
   
    public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b1;                         //访问按钮
    private EditText u_url;
    private String urlHead="https://";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        b1= (Button) findViewById(R.id.b1);
        u_url= (EditText) findViewById(R.id.u_url);
        b1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b1:
                //设置intent
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String url= u_url.getText().toString();
                sendIntent.setData(Uri.parse(urlHead+url));  //设置数据
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);                //传递intent启动
                }
                break;

        }
    }
    }
    
 activity_main.xml
     
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="20sp"
            android:hint="输入网址"
            android:layout_weight="1"
            android:id="@+id/u_url"
            />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center_vertical"
        android:orientation="vertical">

        <Button
            android:id="@+id/b1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:text="访问" />

    </LinearLayout>

    <WebView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/my_webView"
        >

    </WebView>

     </LinearLayout>
结果截图：
![Image text](https://raw.githubusercontent.com/hongmaju/light7Local/master/img/productShow/20170518152848.png)
