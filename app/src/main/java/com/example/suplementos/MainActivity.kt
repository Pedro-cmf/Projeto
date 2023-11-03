package com.example.suplementos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.suplementos.adapters.suplementoAdapter
import com.example.suplementos.models.SuplementosRepository
import com.example.suplementos.models.suplementos

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = suplementoAdapter(this,SuplementosRepository.getSuplementos())

        listView.setOnItemClickListener { parent, view, position, id ->
            detalharProduto(position)

        }
        val button = findViewById<Button>(R.id.btnImc)
        button.setOnClickListener {irParaTelaImc() }
    }
    private fun detalharProduto(posicao:Int){
        val intent = Intent(this,DetalhesSuplementoActivity::class.java)
        intent.putExtra("posicao",posicao)
        startActivity(intent)

    }
    private fun irParaTelaImc(){
        val intent = Intent(this,ImcActivity::class.java)
        startActivity(intent)
    }
}