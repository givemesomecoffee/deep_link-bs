package ru.givemesomecoffee.deeplink_nav

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private var navHostFragment: NavHostFragment? = null
    private var navController: NavController? = null

    private fun init(){
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment?.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.screen1))
        navController?.let { setupActionBarWithNavController(it, appBarConfiguration) }

    }

    // fix backstack bug for up button in action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if (!super.onOptionsItemSelected(item)) {
          when (item.itemId) {
              android.R.id.home -> navHostFragment?.navController?.popBackStack()
              else -> return false
          }
       }
        return true
    }

}