package com.ybxcc.testinysx.mytestapp.activity;

import android.database.sqlite.SQLiteDatabase;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ybxcc.testinysx.mytestapp.R;
import com.ybxcc.testinysx.mytestapp.base.BaseActivity;
import com.ybxcc.testinysx.mytestapp.greenDaoBean.DaoMaster;
import com.ybxcc.testinysx.mytestapp.greenDaoBean.DaoSession;
import com.ybxcc.testinysx.mytestapp.greenDaoBean.Shop;
import com.ybxcc.testinysx.mytestapp.greenDaoBean.ShopDao;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ybx on 2017/5/16.
 */

public class GreenDaoTestActivity extends BaseActivity {

    private static DaoSession daoSession;
    private ShopDao shopDao;


    @BindView(R.id.tv_getservice)
    EditText tvGetservice;
    @BindView(R.id.tv_showresult)
    TextView tvShowresult;
    @BindView(R.id.btn_get)
    Button btnGet;

    @Override
    protected void getIntentDate() {
        super.getIntentDate();

        setupDatebase();

        shopDao = daoSession.getShopDao();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_retrofit_test;
    }

    @Override
    protected void initViews() {
        tvShowresult.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @OnClick({R.id.tv_getservice, R.id.btn_get})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_getservice:
                shopDao.insertOrReplace(new Shop());
                
                break;
            case R.id.btn_get:

                break;
            default:
                break;
        }
    }

    /**
     * 配置数据库
     */
    private void setupDatebase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);

        SQLiteDatabase db = helper.getWritableDatabase();

        DaoMaster daoMaster = new DaoMaster(db);

        daoSession = daoMaster.newSession();
    }


    public static DaoSession getDaoInstant() {
        return daoSession;
    }

}
