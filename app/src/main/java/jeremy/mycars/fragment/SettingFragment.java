package jeremy.mycars.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import butterknife.ButterKnife;
import butterknife.InjectView;
import jeremy.mycars.R;
import jeremy.mycars.base.BaseFragment;

/**
 * 设置
 */
public class SettingFragment extends BaseFragment {

    @InjectView(R.id.toolbar_title)
    TextView title;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.inject(this, view);
        title.setText(R.string.setting);
        return view;
    }
}
