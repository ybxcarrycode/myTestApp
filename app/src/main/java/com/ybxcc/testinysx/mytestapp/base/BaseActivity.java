package com.ybxcc.testinysx.mytestapp.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


/**
 * Created by Administrator on 2017/2/20.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{
    protected Context context;
    protected Handler refreshUi = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//让屏幕保持高亮

        context = BaseActivity.this;

//        initProgressDialog();
        beforeContentView();
        setContentView(getContentViewResId());
        getIntentDate();
        initTitle();
        bindViews();
        initViews();
        initListeners();
        intData();
        getDateForService();

    }

    /**
     * 设置activity view ID
     */
    protected abstract int getContentViewResId();


    /**
     * 初始化 view
     */
    protected abstract void bindViews();


    /**
     * 设置 view (比如：设置背景、大小、是否显示等)
     */
    protected abstract void initViews();


    /**
     * 设置 view 的listener (添加以及实现)
     */
    protected abstract void initListeners();


    /**
     * 添加
     */
//    protected void initProgressDialog() {
//        dialogProgress = DialogProgressHelper.show(BaseActivity.this, null, true, false, true, null);
//    }

    /**
     * 添加view前对activity设置的方法  （比如 设置Window.FEATURE_NO_TITLE等）
     */
    protected void beforeContentView() {
    }


    /**
     * 获取从其他界面传来的参数
     */
    protected void getIntentDate() {
    }


    /**
     * 设置Title
     */
    protected void initTitle() {
    }

    /**
     * 初始化数据 添加本地数据和fragment
     */
    protected void intData() {

    }



    /**
     * 初始加载  获取数据
     */
    protected void getDateForService() {
    }


    /**
     * 隐藏软键盘
     *
     * @param
     */
    protected void hideSoftInput() {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (manager != null && getCurrentFocus() != null
                && getCurrentFocus().getWindowToken() != null) {
            manager.hideSoftInputFromWindow(getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


//    public void showProgressDialog() {
//        try {
//            if (dialogProgress != null && !dialogProgress.isShowing()) {
//                dialogProgress.show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dismissProgressDialog() {
//        if (dialogProgress != null && dialogProgress.isShowing()) {
//            dialogProgress.dismiss();
//        }
//
//    }


    /**
     * 显示提示  (Toast)
     *
     * @param msg 要显示的提示文字
     */
    protected void showToast(final String msg) {
        if (null != refreshUi)
            refreshUi.post(new Runnable() {

                @Override
                public void run() {
                    if (null != context)
                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            });
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            return super.onKeyDown(keyCode, event);
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


}

