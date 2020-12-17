package br.applabbs.singlewebviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.selector_activity.*

class SelectorActivity : AppCompatActivity() {

    private lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selector_activity)
        initView()
        initListeners()
    }

    private fun initView(){
        //Load environmnet URLs into components

    }

    private fun initListeners(){
        //Set onClickListeners
        btn_start.setOnClickListener {
            val selectedOption: Int = rb_group.checkedRadioButtonId
            radioButton = findViewById(selectedOption)
            Toast.makeText(this, "Ambiente: ${radioButton.text} :\n ${edt_ur.text}", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        }

        rb_group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_prod ->  { edt_ur.setText("https://bradescoempresas.com.br/prod")  }
                R.id.rb_tu   ->  { edt_ur.setText("https://bradescoempresas.com.br/tu")   }
                R.id.rb_dev  ->  { edt_ur.setText("https://bradescoempresas.com.br/dev")   }
            }
        }
    }
}