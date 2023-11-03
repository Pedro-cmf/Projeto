package com.example.suplementos

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.VideoView
import com.example.suplementos.models.SuplementosRepository

class DetalhesSuplementoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suplements)

        val nomeTextView = findViewById<TextView>(R.id.nomeTextView)
        val imagemImageView = findViewById<ImageView>(R.id.imagemImageView)
        val precoTextView = findViewById<TextView>(R.id.precoTextView)
        val descricaoTextView = findViewById<TextView>(R.id.descricao2TextView)
        val comprarButton = findViewById<Button>(R.id.comprarButton)
        val videoView = findViewById<VideoView>(R.id.videoExplicativo)


        val position = intent.getIntExtra("posicao",0)

        val listaSuplementos = SuplementosRepository.getSuplementos()
        val video = listaSuplementos[position].video
        val uri = Uri.parse("android.resource://${packageName}/${video}")
        val midiaControler = MediaController(this)
        midiaControler.setAnchorView(videoView)
        videoView.setMediaController(midiaControler)
        videoView.setVideoURI(uri)

        nomeTextView.text = listaSuplementos[position].nome
        imagemImageView.setImageResource(listaSuplementos[position].imagem)
        precoTextView.text = listaSuplementos[position].preco
        descricaoTextView.text = listaSuplementos[position].descricao
    }

}