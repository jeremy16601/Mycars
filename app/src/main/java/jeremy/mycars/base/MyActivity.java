package jeremy.mycars.base;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.beanu.arad.base.BaseActivity;
import com.beanu.arad.base.ToolBarActivity;
import com.umeng.analytics.MobclickAgent;


/**
 * Activity基类
 *
 * @author jeremy16601
 */
public class MyActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        //屏蔽menu键
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
