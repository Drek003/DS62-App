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
import com.example.catalogo.Producto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalogo) // Usa tu layout XML

        val productos = listOf(
            Producto("Producto 1", "$10.00", R.drawable.ic_launcher_foreground),
            Producto("Producto 2", "$20.00", R.drawable.ic_launcher_foreground),
            Producto("Producto 3", "$30.00", R.drawable.ic_launcher_foreground)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvCatalogo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CatalogoAdapter(productos)
    }
}