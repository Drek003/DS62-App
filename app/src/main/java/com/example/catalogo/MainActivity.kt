package com.example.catalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogo.ui.theme.CatalogoTheme
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuapp.adapter.CatalogoAdapter
import com.tuapp.adapter.CategoriaAdapter

class MainActivity : AppCompatActivity() {
    private var mostrandoCategorias = true
    private lateinit var recyclerView: RecyclerView
    private lateinit var categorias: List<Categoria>
    private lateinit var productosPorCategoria: Map<Int, List<Producto>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalogo)

        // Ejemplo de categorías
        categorias = listOf(
            Categoria(1, "Electrónica", R.drawable.ic_launcher_foreground),
            Categoria(2, "Ropa", R.drawable.ic_launcher_foreground),
            Categoria(3, "Hogar", R.drawable.ic_launcher_foreground)
        )
        // Ejemplo de productos por categoría
        productosPorCategoria = mapOf(
            1 to listOf(
                Producto("Celular", "$200.00", R.drawable.ic_launcher_foreground),
                Producto("Laptop", "$800.00", R.drawable.ic_launcher_foreground)
            ),
            2 to listOf(
                Producto("Camiseta", "$15.00", R.drawable.ic_launcher_foreground),
                Producto("Pantalón", "$25.00", R.drawable.ic_launcher_foreground)
            ),
            3 to listOf(
                Producto("Silla", "$40.00", R.drawable.ic_launcher_foreground),
                Producto("Mesa", "$60.00", R.drawable.ic_launcher_foreground)
            )
        )

        recyclerView = findViewById(R.id.rvCatalogo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mostrarCategorias()
    }

    private fun mostrarCategorias() {
        mostrandoCategorias = true
        recyclerView.adapter = CategoriaAdapter(categorias) { categoria ->
            mostrarProductosDeCategoria(categoria.id)
        }
    }

    private fun mostrarProductosDeCategoria(categoriaId: Int) {
        mostrandoCategorias = false
        val productos = productosPorCategoria[categoriaId] ?: emptyList()
        recyclerView.adapter = CatalogoAdapter(productos)
    }

    override fun onBackPressed() {
        if (!mostrandoCategorias) {
            mostrarCategorias()
        } else {
            super.onBackPressed()
        }
    }
}