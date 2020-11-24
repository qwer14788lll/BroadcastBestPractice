package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)
        if (isRemember) {
            //将账号和密码都设置到文本中
            val account = prefs.getString("account", "")
            val password = prefs.getString("password", "")
            UserID.setText(account)
            UserPwd.setText(password)
            rememberPass.isChecked = true
        }

        LoginButton.setOnClickListener {
            val id = UserID.text.trim().toString()
            val pwd = UserPwd.text.trim().toString()
            if (id == "123456" && pwd == "123456") {
                val editor = prefs.edit()
                if (rememberPass.isChecked) {
                    editor.putBoolean("remember_password", true)
                    editor.putString("account", id)
                    editor.putString("password", pwd)
                } else {
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "QQ号码或密码错误，请重试", Toast.LENGTH_LONG).show()
            }
        }
    }
}