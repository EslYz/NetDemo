package eslyz.netdemo.annotation;

import android.app.Activity;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Created by eslyz on 2016/11/25.
 * 用于activity之间传递值
 */

public class ExtraInject {
    public ExtraInject() {
    }

    public static void bind(Activity activity) {
        Field[] fields = activity.getClass().getDeclaredFields();
        Field[] arr$ = fields;
        int len$ = fields.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Field f = arr$[i$];
            if(f.isAnnotationPresent(Extra.class)) {
                Extra extra = f.getAnnotation(Extra.class);
                if(null != extra) {
                    f.setAccessible(true);
                    String key;
                    if(!"".equals(extra.value())) {
                        key = extra.value();
                    } else {
                        key = f.getName();
                    }

                    try {
                        if("String".equals(f.getType().getSimpleName())) {
                            f.set(activity, activity.getIntent().getStringExtra(key));
                        } else if(!"int".equals(f.getType().getSimpleName()) && !"Integer".equals(f.getType().getSimpleName())) {
                            if(!"boolean".equals(f.getType().getSimpleName()) && !"Boolean".equals(f.getType().getSimpleName())) {
                                if(!"byte".equals(f.getType().getSimpleName()) && !"Byte".equals(f.getType().getSimpleName())) {
                                    if(!"long".equals(f.getType().getSimpleName()) && !"Long".equals(f.getType().getSimpleName())) {
                                        if(!"double".equals(f.getType().getSimpleName()) && !"Double".equals(f.getType().getSimpleName())) {
                                            Object e;
                                            if(!(f.getGenericType() instanceof Serializable) && !f.getGenericType().toString().contains("java.util.ArrayList") && !f.getGenericType().toString().contains("java.util.List")) {
                                                e = activity.getIntent().getExtras().get(key);
                                                f.set(activity, e);
                                            } else {
                                                e = activity.getIntent().getExtras().get(key);
                                                f.set(activity, e);
                                            }
                                        } else {
                                            f.set(activity, Double.valueOf(activity.getIntent().getDoubleExtra(key, 0.0D)));
                                        }
                                    } else {
                                        f.set(activity, Long.valueOf(activity.getIntent().getLongExtra(key, 0L)));
                                    }
                                } else {
                                    f.set(activity, Byte.valueOf(activity.getIntent().getByteExtra(key, (byte)0)));
                                }
                            } else {
                                f.set(activity, Boolean.valueOf(activity.getIntent().getBooleanExtra(key, false)));
                            }
                        } else {
                            f.set(activity, Integer.valueOf(activity.getIntent().getIntExtra(key, 0)));
                        }
                    } catch (IllegalAccessException var9) {
                        var9.printStackTrace();
                    }
                }
            }
        }

    }
}
