package com.unique.yyz.passs.app

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.unique.yyz.passs.app.core.FlowerPassword
import android.view.View
import android.widget.EditText
import android.content.ClipboardManager
import android.content.Context
import android.content.ClipData
import android.widget.Toast

fun String.gen(): String = FlowerPassword.encrypt("yourpassword", this + "youkeyfix")

public class MainActivity : Activity(), View.OnClickListener {
    var editText: EditText? = null


    override fun onClick(v: View) {
        when (v.id) {
            R.id.genButton -> {
                val key = editText?.text
                if (key != null && key.length > 0) cpPass(key.toString()) else Toast.makeText(this, "no input!!!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!canRun()) this.finish()
        initView()
    }

    fun canRun(): Boolean = true

    fun initView() {
        editText = findViewById(R.id.keyText) as EditText?
    }

    fun cpPass(key: String) {
        (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip = ClipData.newPlainText("password", key.gen())
        Toast.makeText(this, "Copyed!", Toast.LENGTH_SHORT).show()
        onBackPressed()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
