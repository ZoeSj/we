package cn.buaa.myweixin;

import java.util.HashMap;
import java.util.Random;

import cn.buaa.myweixin.R;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	private EditText mUser; // �ʺű༭��
	private EditText mPassword; // ����༭��
	Button BtnBindPhone;
	String APPKEY = "12df3e9b5521a";
	String APPSECRETE = "0369d03a1daa65fb52b93d8fa2c262d8";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		mUser = (EditText)findViewById(R.id.login_user_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
		// ��ʼ��SDK
		SMSSDK.initSDK(this, APPKEY, APPSECRETE);
		// ������Ϣ
		BtnBindPhone = (Button) this.findViewById(R.id.forget_passwd);
		BtnBindPhone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ע���ֻ���

				RegisterPage registerPage = new RegisterPage();
				// ע��ص��¼�
				registerPage.setRegisterCallback(new EventHandler() {
					public void afterEvent(int event, int result, Object data) {
						// �жϽ���Ƿ��Ѿ����
						if (result == SMSSDK.RESULT_COMPLETE) {
							// ��ȡ����data
							HashMap<String, Object> maps = (HashMap<String, Object>) data;
							// ����
							String country = (String) maps.get("country");
							// �ֻ���
							String phone = (String) maps.get("phone");
							submitUserInfo(country, phone);
						}
					}
				});
				// ��ʾע�����
				registerPage.show(Login.this);
			}
		});
	}

	// �ύ�û���Ϣ
	public void submitUserInfo(String country, String phone) {
		Random r = new Random();
		String uid = Math.abs(r.nextInt()) + "";
		String nickName = "IM";
		SMSSDK.submitUserInfo(uid, nickName, null, country, phone);

	}

	public void login_mainweixin(View v) {
		if ("sj".equals(mUser.getText().toString())
				&& "123".equals(mPassword.getText().toString())) // �ж� �ʺź�����
		{
			Intent intent = new Intent();
			intent.setClass(Login.this, LoadingActivity.class);
			startActivity(intent);
			// Toast.makeText(getApplicationContext(), "��¼�ɹ�",
			// Toast.LENGTH_SHORT).show();
		} else if ("".equals(mUser.getText().toString())
				|| "".equals(mPassword.getText().toString())) // �ж� �ʺź�����
		{
			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("��¼����").setMessage("�ʺŻ������벻��Ϊ�գ�\n��������ٵ�¼��")
					.create().show();
		} else {

			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("��¼ʧ��").setMessage("�ʺŻ������벻��ȷ��\n������������룡")
					.create().show();
		}

		// ��¼��ť
		/*
		 * Intent intent = new Intent();
		 * intent.setClass(Login.this,Whatsnew.class); startActivity(intent);
		 * Toast.makeText(getApplicationContext(), "��¼�ɹ�",
		 * Toast.LENGTH_SHORT).show(); this.finish();
		 */
	}

	public void login_back(View v) { // ������ ���ذ�ť
		this.finish();
	}
	/*
	 * public void login_pw(View v) { //�������밴ť Uri uri =
	 * Uri.parse("http://3g.qq.com"); Intent intent = new
	 * Intent(Intent.ACTION_VIEW, uri); startActivity(intent); //Intent intent =
	 * new Intent(); //intent.setClass(Login.this,Whatsnew.class);
	 * //startActivity(intent); }
	 */
}
