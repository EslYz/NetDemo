package eslyz.netdemo.utils;

import android.app.Activity;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eslyz on 2016/11/25.
 */

public class ActivityManager {

    public static List<Activity> list = new ArrayList<>();

    public static void saveThisActivity(Activity activity){
        if (!list.contains(activity)){
            list.add(activity);
        }
    }

    public static void remove(Activity activity){
        if (list.contains(activity)){
            list.remove(activity);
        }
    }

    public static void finishTargetActivity(Activity activity){
        for (int i = 0,size = list.size(); i < size; i++){
            Activity act = list.get(i);
            if (TextUtils.equals(act.getClass().getSimpleName(),activity.getClass().getSimpleName()) && !act.isFinishing()){
                act.finish();
                list.remove(i);
                i--;
                size--;
            }
        }
    }

}
