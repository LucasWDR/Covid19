package com.example.covid19

import android.content.Context
import android.content.Intent
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivities
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_boletim.*
import kotlinx.android.synthetic.main.view_boletim.view.*
import kotlinx.android.synthetic.main.view_boletim.view.viewData

class Boletim_Adapter(val cont: Context, private val boletim: List<Boletim>):
    RecyclerView.Adapter<Boletim_Adapter.VH>(), ListAdapter {

    class VH(item: View):RecyclerView.ViewHolder(item) {
        var data: TextView = item.viewData
        var hora: TextView = item.viewHora
        var casos: TextView = item.viewConfirm
        var obito: TextView = item.viewObito
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_boletim, parent, false)

        view.setOnClickListener(View.OnClickListener {
            val intencao = Intent(cont, MainActivity.Dados::class.java)
            val data = view.viewData.text.toString()

            intencao.putExtra("Data", data)
            startActivity(cont, intencao, null)
        })
        val vh = VH(view)
        return vh
    }

    override fun getItemCount(): Int {
        return boletim.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var boletim__ = boletim[position]

        holder.data.text = boletim__.data
        holder.hora.text = boletim__.hora
        holder.casos.text = boletim__.confirmados.toString()
        holder.obito.text = boletim__.mortes.toString()
    }


    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEnabled(position: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areAllItemsEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }
}
