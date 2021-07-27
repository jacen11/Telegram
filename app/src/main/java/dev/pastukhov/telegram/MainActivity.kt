package dev.pastukhov.telegram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import dev.pastukhov.telegram.databinding.ActivityMainBinding
import dev.pastukhov.telegram.ui.fragments.ChatsFragment
import dev.pastukhov.telegram.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appDrawer:AppDrawer
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(toolbar)
        appDrawer.create()

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.dataContainer, ChatsFragment()).commit()
    }


    private fun initFields() {
        toolbar = binding.mainToolbar
        appDrawer= AppDrawer(this, toolbar)

    }
}
