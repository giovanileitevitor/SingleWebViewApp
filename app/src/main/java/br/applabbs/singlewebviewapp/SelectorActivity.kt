package br.applabbs.singlewebviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.applabbs.singlewebviewapp.Constants.URL_ENVIRONMENT
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
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(URL_ENVIRONMENT, edt_ur.text.toString())
            startActivity(intent)
        }

        rb_group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_prod ->  { edt_ur.setText("https://mei.bradesco/pdpj-fed-mei-web/")  }
                R.id.rb_tu   ->  { edt_ur.setText("https://bancoitau.com.br")   }
                R.id.rb_dev  ->  { edt_ur.setText("https://bancodobrasil.com.br")   }
            }
        }
    }
}