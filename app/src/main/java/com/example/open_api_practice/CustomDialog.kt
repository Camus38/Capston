package com.example.open_api_practice

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext


class CustomDialog(context: Context) {
    private val dialog = Dialog(context)
    private lateinit var spinner : Spinner
    private lateinit var spinner2 : Spinner
    private lateinit var search_button : Button
    var data = Data()


    fun showDialog(context : Context){
        dialog.setContentView(R.layout.custom_dialog_search)
        spinner = dialog.findViewById(R.id.spinner)
        spinner2 = dialog.findViewById(R.id.spinner2)
        search_button = dialog.findViewById(R.id.search_button)

        val adapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,data.city)
        val adapter2 = ArrayAdapter(context,android.R.layout.simple_spinner_item,data.town)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner2.adapter = adapter2


        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        search_button.setOnClickListener {
            onClickedListener.onClicked(spinner.selectedItem.toString())
            onClickedListener.onClicked(spinner2.selectedItem.toString())
            dialog.dismiss()
        }

    }

    interface ButtonClickListener{
        fun onClicked(adress: String)
    }
    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener){
        onClickedListener = listener
    }

}
