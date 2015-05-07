package jeremy.mycars.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;
import com.beanu.arad.base.BaseActivity;
import com.beanu.arad.utils.Log;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jeremy.mycars.R;


public class MainActivity extends BaseActivity {


    @InjectView(R.id.showRs)
    TextView showContent;
    @InjectView(R.id.toolbar_title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        title.setText("首页");
        //测试添加
//        AVObject ms = new AVObject("cars");
//        ms.put("name", "jeremy");
//        ms.put("conten", "how much ?");
//        ms.put("time", 10);
//        ms.saveInBackground();
    }

    @OnClick(R.id.btn_show)
    void setBshow() {
        AVQuery<AVObject> query = new AVQuery<AVObject>("cars");
        query.getInBackground("5541f6e2e4b0e2a915843262", new GetCallback<AVObject>() {
            public void done(AVObject g, AVException e) {
                if (e == null) {
                    showContent.setText("数据：" + g.get("name"));
                    Log.e("获取分数 比分是：" + g.getInt("time"));
                } else {
                    Log.e("获取分数 错误: " + e.getMessage());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
