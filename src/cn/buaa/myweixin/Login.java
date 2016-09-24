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
	private EditText mUser; // 帐号编辑框
	private EditText mPassword; // 密码编辑框
	Button BtnBindPhone;
	String APPKEY = "12df3e9b5521a";
	String APPSECRETE = "0369d03a1daa65fb52b93d8fa2c262d8";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		mUser = (EditText)findViewById(R.id.login_user_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
		// 初始化SDK
		SMSSDK.initSDK(this, APPKEY, APPSECRETE);
		// 配置信息
		BtnBindPhone = (Button) this.findViewById(R.id.forget_passwd);
		BtnBindPhone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 注册手机号

				RegisterPage registerPage = new RegisterPage();
				// 注册回调事件
				registerPage.setRegisterCallback(new EventHandler() {
					public void afterEvent(int event, int result, Object data) {
						// 判断结果是否已经完成
						if (result == SMSSDK.RESULT_COMPLETE) {
							// 获取数据data
							HashMap<String, Object> maps = (HashMap<String, Object>) data;
							// 国家
							String country = (String) maps.get("country");
							// 手机号
							String phone = (String) maps.get("phone");
							submitUserInfo(country, phone);
						}
					}
				});
				// 显示注册界面
				registerPage.show(Login.this);
			}
		});
	}

	// 提交用户信息
	public void submitUserInfo(String country, String phone) {
		Random r = new Random();
		String uid = Math.abs(r.nextInt()) + "";
		String nickName = "IM";
		SMSSDK.submitUserInfo(uid, nickName, null, country, phone);

	}

	public void login_mainweixin(View v) {
		if ("sj".equals(mUser.getText().toString())
				&& "123".equals(mPassword.getText().toString())) // 判断 帐号和密码
		{
			Intent intent = new Intent();
			intent.setClass(Login.this, LoadingActivity.class);
			startActivity(intent);
			// Toast.makeText(getApplicationContext(), "登录成功",
			// Toast.LENGTH_SHORT).show();
		} else if ("".equals(mUser.getText().toString())
				|| "".equals(mPassword.getText().toString())) // 判断 帐号和密码
		{
			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录错误").setMessage("帐号或者密码不能为空，\n请输入后再登录！")
					.create().show();
		} else {

			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录失败").setMessage("帐号或者密码不正确，\n请检查后重新输入！")
					.create().show();
		}

		// 登录按钮
		/*
		 * Intent intent = new Intent();
		 * intent.setClass(Login.this,Whatsnew.class); startActivity(intent);
		 * Toast.makeText(getApplicationContext(), "登录成功",
		 * Toast.LENGTH_SHORT).show(); this.finish();
		 */
	}

	public void login_back(View v) { // 标题栏 返回按钮
		this.finish();
	}
	/*
	 * public void login_pw(View v) { //忘记密码按钮 Uri uri =
	 * Uri.parse("http://3g.qq.com"); Intent intent = new
	 * Intent(Intent.ACTION_VIEW, uri); startActivity(intent); //Intent intent =
	 * new Intent(); //intent.setClass(Login.this,Whatsnew.class);
	 * //startActivity(intent); }
	 */
}
