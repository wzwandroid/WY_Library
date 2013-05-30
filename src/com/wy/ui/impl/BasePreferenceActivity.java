package com.wy.ui.impl;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.wy.AppManager;
import com.wy.ui.IBasePreferenceActivity;

/** 
 * ������Activity����
 *
 * ����: Liu wei
 * 
 * ���䣺i@liuwei.co
 * 
 * ����ʱ��: 2013-1-28
 */
public abstract class BasePreferenceActivity extends PreferenceActivity implements IBasePreferenceActivity{

	protected final String LOG_TAG = this.getClass().getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//����Activity����ջ
		AppManager.getAppManager().addActivity(this);
		//���ؽ�������
		setContentView();
		//��ʼ������ؼ�
		initView();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//����Activity&�Ӷ�ջ���Ƴ�
		AppManager.getAppManager().finishActivity(this);
	}
	
//	/**���ؼ�����������ص�����*/
//	public void onBackPressed() {
//		Intent intent = new Intent(Intent.ACTION_MAIN);
//		intent.addCategory(Intent.CATEGORY_HOME);
//		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // ע�Ȿ�е�FLAG����
//		startActivity(intent);
//	}
}