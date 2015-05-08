package jeremy.mycars.activity;

import android.os.Bundle;
import android.widget.FrameLayout;


import jeremy.mycars.R;
import jeremy.mycars.base.BaseBackActivity;
import jeremy.mycars.util.Params;
import jeremy.mycars.util.SimpleFactory;

/**
 * 单个fragment的Activity
 */
public class SingleFragmentActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Bundle bundle = getIntent().getExtras();
            String fragmentName = bundle.getString(Params.FRAGMENT_NAME);
            Bundle arguments = bundle.getBundle(Params.ARGUMENTS);
            FrameLayout container = new FrameLayout(this);
            container.setId(R.id.wrap_content);
            setContentView(container);
            getSupportFragmentManager().beginTransaction().add(R.id.wrap_content, SimpleFactory.createFragment(fragmentName, arguments)).commit();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }
}
