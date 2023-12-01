package aa.bb.corrcc1kotlin_2023_2024

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MesureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesure)
        val lvMesures=findViewById(R.id.lvMesures) as ListView
         val editTemp = findViewById(R.id.editTemp) as EditText //Température
        val sp = findViewById(R.id.spStations) as Spinner //Station
        val npMois = findViewById(R.id.npMois) as NumberPicker //Mois
        val btn=findViewById(R.id.btn) as Button
        //Attacher le listview avec la liste des mesures
        val aaMesures = ArrayAdapter<Mesure>(this@MesureActivity, android.R.layout.simple_list_item_1,
            lstMesure)
        lvMesures.adapter=aaMesures
        npMois.maxValue=12
        npMois.minValue=1
        //Liste des stations
        val lstStation = listOf<Station>(
            Station(100,Region.SUD),
            Station(200,Region.SUD),
            Station(300,Region.NORD),
            Station(400,Region.EST),
            Station(500,Region.EST),
            Station(600,Region.EST),
            Station(700,Region.OUEST),
            )
        var uneStation:Station=lstStation[0] //VAriable qui sera utilisée pour le stockage de la station sélectiionnée dans le spinner

        val aa = ArrayAdapter<Station>(this@MesureActivity, android.R.layout.simple_list_item_1,lstStation)
        sp.adapter=aa
        sp.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,view: View, i: Int, l: Long
            ) {
                //pour modifier le contenu d'un edittext (2 méthodes)
                //editTemp.text =Editable.Factory.getInstance().newEditable(i.toString())
                //editTemp.setText(i.toString())
                uneStation = lstStation[i]

            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

        btn.setOnClickListener(View.OnClickListener {
            val M = Mesure(npMois.value,editTemp.text.toString().toDouble(), uneStation)
            lstMesure.add(M)
            aaMesures.notifyDataSetChanged()

        })



}}