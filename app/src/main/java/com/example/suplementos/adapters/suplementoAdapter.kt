package com.example.suplementos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.suplementos.R
import com.example.suplementos.models.suplementos

class suplementoAdapter(private val context:Context,private val listaSuplementos: List<suplementos>): BaseAdapter() {
    override fun getCount(): Int {
        return listaSuplementos.size
    }

    override fun getItem(position: Int): Any {
        return listaSuplementos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder

        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val suplemento = getItem(position) as suplementos
        viewHolder.imagem.setImageResource(suplemento.imagem)
        viewHolder.nome.text = suplemento.nome
        viewHolder.preco.text = suplemento.preco

        return view
    }

    private class ViewHolder(view:View){
        val imagem:ImageView = view.findViewById(R.id.suplementoImageView)
        val preco:TextView = view.findViewById(R.id.precoTextView)
        val nome: TextView = view.findViewById(R.id.nomeSuplemento)
    }

}