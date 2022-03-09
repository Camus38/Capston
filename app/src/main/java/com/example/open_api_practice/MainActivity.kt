package com.example.open_api_practice

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.example.open_api_practice.databinding.ActivityMainBinding
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import org.w3c.dom.Text
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val view = layoutInflater.inflate(R.layout.fragment_main,null)
        val FragmentA by lazy { MainFrag() }

        val custom = CustomDialog(this)


        setFragment(FragmentA)

        binding.bottom.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.search -> {
                    custom.showDialog(this)
                    custom.setOnClickedListener(object : CustomDialog.ButtonClickListener{
                        override fun onClicked(adress: String) {
                            FragmentA.setValue(adress)

                        }
                    })

                }
            }
            true
        }
    }


    fun setFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment,fragment)
        transaction.commit()
    }


}