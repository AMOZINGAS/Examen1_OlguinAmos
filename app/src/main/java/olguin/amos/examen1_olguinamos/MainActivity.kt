package olguin.amos.examen1_olguinamos



import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val titulo: TextView = findViewById(R.id.textViewTitle)

        val btnCalcular: Button = findViewById(R.id.buttonCaclular)
//as
        val txtPorcentaje: TextView = findViewById(R.id.textViewPorcentaje)
        val txtCrush: EditText = findViewById(R.id.editTextCrush)
        val txtNombre: EditText = findViewById(R.id.editTextNombre)
        val txtCategoria: TextView = findViewById(R.id.textViewCategoria)

        btnCalcular.setOnClickListener{

            if(txtNombre.text.toString().isNotEmpty() && txtCrush.text.toString().isNotEmpty()){

                var numeroVocalesNombre = txtNombre.text.toString().vocales()
                var numeroVocalesCrush = txtCrush.text.toString().vocales()



                var totalVocales = numeroVocalesCrush + numeroVocalesNombre

                var totalLetas = (txtCrush.text.length + txtNombre.text.length)

                var porcentaje = (totalVocales.toDouble()/totalLetas.toDouble())*100



                txtPorcentaje.text = "${porcentaje}%"

                var categoria = ""

                var color = Color.WHITE

                when{

                    porcentaje in 90.0..100.0 -> {
                        categoria = "Huele a boda"
                        color = Color.RED
                    }
                    porcentaje in 75.0..89.9 -> {
                        categoria = "Te cambian por 500 pesos"
                        color = Color.MAGENTA
                    }
                    porcentaje in 60.0..74.9 -> {
                        categoria = "Te cambian por 5 pesos"
                        color = Color.rgb(255, 111,0)
                    }
                    porcentaje <= 59.9 -> {
                        categoria = "Pobre chamaco"
                        color = Color.BLUE
                    }

                }

                txtCategoria.text = categoria

                txtCategoria.visibility = View.VISIBLE
                txtPorcentaje.visibility = View.VISIBLE
                txtPorcentaje.setBackgroundColor(color)


            }

        }

    }

    fun String.vocales(): Int {

        var numeroVocales = 0

        var vocales: List<Char> = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

        for(v in this){

            for(vocal in vocales){

                if(v == vocal){

                    numeroVocales = numeroVocales + 1

                }

            }

        }

        return numeroVocales


    }

}