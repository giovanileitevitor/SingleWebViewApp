package br.applabbs.singlewebviewapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.applabbs.singlewebviewapp.Constants.URL_ENVIRONMENT
import kotlinx.android.synthetic.main.selector_activity.*

class SelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selector_activity)
        initView()
        initListeners()
    }

    private fun initView(){
        //Load primary environment at Bradesco Network
        edt_ur.setText("https://mei.bradesco/pdpj-fed-mei-web/")
    }

    private fun initListeners(){
        //Set radioGroup onChecked Event
        rb_group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_prod ->  { edt_ur.setText("https://mei.bradesco/pdpj-fed-mei-web/")}
                R.id.rb_tu   ->  { edt_ur.setText("https://www.bradesco.com.br/consorcios")}
                R.id.rb_dev  ->  { edt_ur.setText("https://www.bradesco.com.br/")}
            }
        }

        //Set btn_start onClick Event
        btn_start.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(URL_ENVIRONMENT, edt_ur.text.toString())
            startActivity(intent)
        }
    }
}