package com.nettour.pavesandoapp.ui.entry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nettour.pavesandoapp.R

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        supportFragmentManager
            .beginTransaction()
            .add(
                R.id.fragmentContainerView,
                StartFragment())
            .commit()
    }
}
