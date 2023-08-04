package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //habilitando toolbar
        supportActionBar?.setHomeButtonEnabled(true)

        //mostrando toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //recuperando intent criada na mainactivity pela chave extra_result
        val tvResult = findViewById<TextView>(R.id.textview_result)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val classificacao = if (result < 18.5f){
            "ABAIXO DO PESO"
            //exemplo de range, deixando o codigo mais clean
        } else if (result in 18.5f..24.9f){
            "NORMAL"
        } else if (result in 25f.. 29.9f){
            "SOBREPESO"
        } else if (result in 30f..39.9f){
            "OBESIDADE"
        } else{
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao,classificacao)

    }

    //ao voltar na seta a tela atual é finalizada
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}