package com.ybxcc.testinysx.mytestapp.activity

import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.ybxcc.testinysx.mytestapp.R
import com.ybxcc.testinysx.mytestapp.base.BaseActivity
import com.ybxcc.testinysx.mytestapp.greenDaoBean.DaoMaster
import com.ybxcc.testinysx.mytestapp.greenDaoBean.DaoSession
import com.ybxcc.testinysx.mytestapp.greenDaoBean.Shop
import com.ybxcc.testinysx.mytestapp.greenDaoBean.ShopDao

import butterknife.BindView
import butterknife.OnClick

/**
 * Created by Ybx on 2017/5/16.
 */

class GreenDaoTestActivity : BaseActivity() {
    private var shopDao: ShopDao? = null


    @BindView(R.id.tv_getservice)
    internal var tvGetservice: EditText? = null
    @BindView(R.id.tv_showresult)
    internal var tvShowresult: TextView? = null
    @BindView(R.id.btn_get)
    internal var btnGet: Button? = null

    override fun getIntentDate() {
        super.getIntentDate()

        setupDatebase()

        shopDao = daoInstant!!.shopDao
    }

    override fun getContentViewResId(): Int {
        return R.layout.activity_retrofit_test
    }

    override fun initViews() {
        tvShowresult!!.movementMethod = ScrollingMovementMethod.getInstance()
    }

    @OnClick(R.id.tv_getservice, R.id.btn_get)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.tv_getservice -> shopDao!!.insertOrReplace(Shop())
            R.id.btn_get -> {
            }
            else -> {
            }
        }
    }

    /**
     * 配置数据库
     */
    private fun setupDatebase() {
        val helper = DaoMaster.DevOpenHelper(this, "shop.db", null)

        val db = helper.writableDatabase

        val daoMaster = DaoMaster(db)

        daoInstant = daoMaster.newSession()
    }

    companion object {

        var daoInstant: DaoSession? = null
            private set
    }

}
