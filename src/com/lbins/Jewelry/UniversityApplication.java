package com.lbins.Jewelry;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import com.yixia.camera.VCamera;
//import com.yixia.camera.demo.service.AssertService;
//import com.yixia.camera.util.DeviceUtils;

/**
 * author: ${zhanghailong}
 * Date: 2015/1/29
 * Time: 17:04
 * 类的功能、说明写在此处.
 */
public class UniversityApplication extends Application {
    // 运用list来保存们每一个activity是关键
    private List<Activity> mList = new LinkedList<Activity>();
    private ExecutorService lxThread;
    private Gson gson;
    private RequestQueue requestQueue;
    private SharedPreferences sp;

    private static UniversityApplication application;

    public static Context applicationContext;
    // login user name
    public final String PREF_USERNAME = "username";
    /**
     * 当前用户nickname,为了苹果推送不是userid而是昵称
     */
    public static String currentUserNick = "";
//    public static DemoHXSDKHelper hxSDKHelper = new DemoHXSDKHelper();


//    public LocationClient mLocationClient;
//    public MyLocationListener mMyLocationListener;

//    public TextView mLocationResult,logMsg;
//    public TextView trigger,exit;
//    public Vibrator mVibrator;

//    public static  Double lat;
//    public static  Double lng;

    public static String APP_KEY = "aaffb8b381ad41889df1590f4d870485"; // 2015/10/29

    @Override
    public void onCreate() {
        super.onCreate();
//        CrashHandler crashHandler = CrashHandler.getInstance() ;
//        crashHandler.init(this) ;
        applicationContext = this;
        instance = this;
        application = this;
        requestQueue = Volley.newRequestQueue(this);
        gson = new Gson();
        lxThread = Executors.newFixedThreadPool(20);
        sp = getSharedPreferences("university_manage", Context.MODE_PRIVATE);
        imageLoader = new com.android.volley.toolbox.ImageLoader(requestQueue, new BitmapCache());
        initImageLoader(this);
//        hxSDKHelper.onInit(applicationContext);


        // 设置拍摄视频缓存路径
//        File dcim = Environment
//                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
//        if (DeviceUtils.isZte()) {
//            if (dcim.exists()) {
//                VCamera.setVideoCachePath(dcim + "/Lxpaopao/");
//            } else {
//                VCamera.setVideoCachePath(dcim.getPath().replace("/sdcard/",
//                        "/sdcard-ext/")
//                        + "/Lxpaopao/");
//            }
//        } else {
//            VCamera.setVideoCachePath(dcim + "/Lxpaopao/");
//        }
//        // 开启log输出,ffmpeg输出到logcat
//        VCamera.setDebugMode(true);
//        // 初始化拍摄SDK，必须
//        VCamera.initialize(this);
//
//        // 解压assert里面的文件
//        startService(new Intent(this, AssertService.class));

        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
//        SDKInitializer.initialize(this);


//        mLocationClient = new LocationClient(this.getApplicationContext());
//        mMyLocationListener = new MyLocationListener();
//        mLocationClient.registerLocationListener(mMyLocationListener);
//        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);

//        Config.LOGGING = true;
//        EZOpenSDK.initLib(this, APP_KEY, "");
//        // EZOpenSDK.getInstance().setAccessToken("at.dmtlxyp47nejsckiai1pdwzsdvxmo7jp-8ofxo9vacz-1s48ov1-p3r36v0vj");
//        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(this));

//        Config.LOGGING = true;
//        EZOpenSDK.initLib(this, APP_KEY, "");
//        EZOpenSDK.getInstance().setAccessToken("at.dmtlxyp47nejsckiai1pdwzsdvxmo7jp-8ofxo9vacz-1s48ov1-p3r36v0vj");
//        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(this));
    }


    public static Context getContext() {
        return application;
    }


    /**
     * 获取自定义线程池
     *
     * @return
     */
    public ExecutorService getLxThread() {
        if (lxThread == null) {
            lxThread = Executors.newFixedThreadPool(20);
        }
        return lxThread;
    }

    /**
     * 获取Gson
     *
     * @return
     */
    public Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    /**
     * 获取Volley请求队列
     *
     * @return
     */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(this);
        }
        return requestQueue;
    }

    /**
     * 获取SharedPreferences
     *
     * @return
     */
    public SharedPreferences getSp() {
        if (sp == null) {
            sp = getSharedPreferences("university_manage", Context.MODE_PRIVATE);
        }
        return sp;
    }

    public static DisplayImageOptions options;
    public static DisplayImageOptions txOptions;//头像图片

    public UniversityApplication() {

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.pic_none)
                .showImageForEmptyUri(R.drawable.pic_none)    // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.pic_none)        // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)                           // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)                             // 设置下载的图片是否缓存在内存卡中
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565)          //图片的解码类型
//                .displayer(new RoundedBitmapDisplayer(5))
                .build();                                       // 创建配置过得DisplayImageOption对象

        txOptions = new DisplayImageOptions.Builder()//头像
                .showImageOnLoading(R.drawable.head)
                .showImageForEmptyUri(R.drawable.head)    // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.head)        // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)                           // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)                             // 设置下载的图片是否缓存在内存卡中
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)          //图片的解码类型头像
                .build();
    }

    /**
     * 初始化图片加载组件ImageLoader
     *
     * @param context
     */
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        ImageLoader.getInstance().init(config);
    }

    private com.android.volley.toolbox.ImageLoader imageLoader;

    private class BitmapCache implements com.android.volley.toolbox.ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            int maxSize = 10 * 1024 * 1024;
            mCache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }

    public com.android.volley.toolbox.ImageLoader getImageLoader() {
        return imageLoader;
    }


    private static UniversityApplication instance;

    // 构造方法
    // 实例化一次
    public synchronized static UniversityApplication getInstance() {
        if (null == instance) {
            instance = new UniversityApplication();
        }
        return instance;
    }

    // add Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    // 关闭每一个list内的activity
    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
//    /**
//     * 获取当前登陆用户名
//     *
//     * @return
//     */
//    public String getUserName() {
//        return hxSDKHelper.getHXId();
//    }
//
//    /**
//     * 获取密码
//     *
//     * @return
//     */
//    public String getPassword() {
//        return hxSDKHelper.getPassword();
//    }
//
//    /**
//     * 设置用户名
//     *
//     */
//    public void setUserName(String username) {
//        hxSDKHelper.setHXId(username);
//    }
//
//    /**
//     * 设置密码 下面的实例代码 只是demo，实际的应用中需要加password 加密后存入 preference 环信sdk
//     * 内部的自动登录需要的密码，已经加密存储了
//     *
//     * @param pwd
//     */
//    public void setPassword(String pwd) {
//        hxSDKHelper.setPassword(pwd);
//    }
//
//    /**
//     * 退出登录,清空数据
//     */
//    public void logout(final boolean isGCM,final EMCallBack emCallBack) {
//        // 先调用sdk logout，在清理app中自己的数据
//        hxSDKHelper.logout(isGCM,emCallBack);
//    }
//    /**
//     * 获取内存中好友user list
//     *
//     * @return
//     */
//    public Map<String, User> getContactList() {
//        return hxSDKHelper.getContactList();
//    }
}

