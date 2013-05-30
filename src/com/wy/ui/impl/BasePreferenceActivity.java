package com.wy.ui.impl;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.wy.AppManager;
import com.wy.ui.IBasePreferenceActivity;

/** 
 * 描述：Activity基类
 *
 * 作者: Liu wei
 * 
 * 邮箱：i@liuwei.co
 * 
 * 创建时间: 2013-1-28
 */
public abstract class BasePreferenceActivity extends PreferenceActivity implements IBasePreferenceActivity{

	protected final String LOG_TAG = this.getClass().getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//添加Activity到堆栈
		AppManager.getAppManager().addActivity(this);
		//加载界面配置
		setContentView();
		//初始化界面控件
		initView();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//结束Activity&从堆栈中移除
		AppManager.getAppManager().finishActivity(this);
	}
	
//	/**返回键点击触发，回到桌面*/
//	public void onBackPressed() {
//		Intent intent = new Intent(Intent.ACTION_MAIN);
//		intent.addCategory(Intent.CATEGORY_HOME);
//		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 注意本行的FLAG设置
//		startActivity(intent);
//	}
}
