package jeremy.mycars.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;
import com.beanu.arad.utils.Log;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jeremy.mycars.R;
import jeremy.mycars.base.MyActivity;


public class MainActivity extends MyActivity {


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

    @Override
    public boolean setupToolBarLeftButton(ImageView leftButton) {
        return false;
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


}
