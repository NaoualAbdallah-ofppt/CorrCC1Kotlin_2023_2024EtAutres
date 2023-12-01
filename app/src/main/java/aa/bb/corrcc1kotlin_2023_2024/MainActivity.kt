package aa.bb.corrcc1kotlin_2023_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById(R.id.btn) as Button
        val editT=findViewById(R.id.editTemp) as EditText
        val txt =findViewById(R.id.txtFar) as TextView
        btn.setOnClickListener(View.OnClickListener {
           txt.text= tempFar(editT.text.toString().toDouble()).toString()
          }

        )
    }
}