package com.example.suplementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.suplementos.models.RequisicaoImc
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class ImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        val pesoInput = findViewById<EditText>(R.id.editPeso)
        val alturaInput = findViewById<EditText>(R.id.editAltura)
        val calcularButton = findViewById<Button>(R.id.btnActivity)
        val resultado = findViewById<TextView>(R.id.resultado)

        calcularButton.setOnClickListener {
            val peso:String = pesoInput.text.toString()
            val altura:String = alturaInput.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                val imc = calcularImc(peso, altura)

                withContext(Dispatchers.Main){
                    if (imc != null) {
                        if (imc.bmi.isNotEmpty()){
                            if (imc != null) {
                                resultado.text = "${imc.bmi}"
                            }
                        } else {
                            resultado.text = "Resultado não encontrado"
                        }
                    }
                }
            }
        }
    }
    private fun calcularImc(peso:String, altura:String): RequisicaoImc? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://body-mass-index-bmi-calculator.p.rapidapi.com/metric?weight=${peso}&height=${altura}")
            .get()
            .addHeader("X-RapidAPI-Key", "fa6171fa15msh57cce8ac8237056p1b657djsna02ff45ad98d")
            .addHeader("X-RapidAPI-Host", "body-mass-index-bmi-calculator.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        val responseString = response.body!!.string()
        val imc = Gson().fromJson(responseString,RequisicaoImc::class.java)
        return imc

    }
}