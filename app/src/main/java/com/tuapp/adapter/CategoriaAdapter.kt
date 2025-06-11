package com.tuapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogo.Categoria
import com.example.catalogo.R

class CategoriaAdapter(
    private val categorias: List<Categoria>,
    private val onCategoriaClick: (Categoria) -> Unit
) : RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {

    class CategoriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCategoria: ImageView = itemView.findViewById(R.id.imgCategoria)
        val tvNombreCategoria: TextView = itemView.findViewById(R.id.tvNombreCategoria)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria, parent, false)
        return CategoriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val categoria = categorias[position]
        holder.imgCategoria.setImageResource(categoria.imagenResId)
        holder.tvNombreCategoria.text = categoria.nombre
        holder.itemView.setOnClickListener { onCategoriaClick(categoria) }
    }

    override fun getItemCount(): Int = categorias.size
}
