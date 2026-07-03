package com.example.devise

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des composants graphiques
        val editTextAmount: EditText = findViewById(R.id.editTextAmount)
        val btnCompute: Button = findViewById(R.id.btnCompute)
        val textViewResult: TextView = findViewById(R.id.textViewResult)
        val listViewResult: ListView = findViewById(R.id.listViewResults)

        // Gestion de la liste (l'historique)
        val data: MutableList<String> = ArrayList()
        val stringArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        listViewResult.adapter = stringArrayAdapter

        // Action lors du clic sur le bouton Compute
        btnCompute.setOnClickListener {
            val amountStr = editTextAmount.text.toString()
            if (amountStr.isNotEmpty()) {
                val amount = amountStr.toDouble()
                val result = amount * 11 // Taux de change (Euro -> DH)
                
                // Afficher le résultat actuel
                textViewResult.text = result.toString()
                
                // Ajouter à l'historique
                data.add("$amount € => $result DH")
                stringArrayAdapter.notifyDataSetChanged()
                
                // Vider le champ de saisie
                editTextAmount.setText("")
            }
        }
    }
}