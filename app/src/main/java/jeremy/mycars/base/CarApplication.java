package jeremy.mycars.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.beanu.arad.AradApplication;
import com.beanu.arad.AradApplicationConfig;
import com.beanu.arad.utils.Log;
import com.beanu.arad.utils.MessageUtils;

/**
 * Created by jeremy16601 on 2015/4/30.
 */
public class CarApplication extends AradApplication {

    // 应用程序上下文
    private static CarApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "n6219v0g3jgm646rgldavm00j3k8ej3zz0nx8trpney72as5", "d2av5edcac7zxq1iri0d9zc88iph4kzg2y7mq0isrsrivpwb");
    }

    /**
     * 静态方法返回程序上下文
     */
    public static synchronized CarApplication getContext() {
        return instance;
    }

    @Override
    protected AradApplicationConfig appConfig() {
        return new AradApplicationConfig();
    }

    @Override
    public void onTrimMemory(int level) {
        Log.e("应用 onTrimMemory ... level:" + level);
    }

    @Override
    public void onLowMemory() {
        Log.e("应用onLowMemory ... ");
    }
}
