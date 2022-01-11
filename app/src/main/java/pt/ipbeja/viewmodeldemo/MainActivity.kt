package pt.ipbeja.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.ipbeja.viewmodeldemo.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}