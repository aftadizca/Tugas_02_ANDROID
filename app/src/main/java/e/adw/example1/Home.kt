package e.adw.example1

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var txt: TextView
    private val FragmentTugas03 = Tugas03()
    private val fragment_tugas_04 = Tugas04()
    private val fragment_tugas_05 = Tugas05()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, FragmentTugas03).commit()

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.tugas_03 -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frame, FragmentTugas03).commit()
            }
            R.id.tugas_04 -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frame, fragment_tugas_04).commit()
            }
            R.id.tugas_05 -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frame, fragment_tugas_05).commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun biruBtn(v: View){
        FragmentTugas03.biruBtn(v)
    }

    fun merahBtn(v: View){
        FragmentTugas03.merahBtn(v)
    }
    fun hijauBtn(v: View){
        FragmentTugas03.hijauBtn(v)
    }

    /*override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN){
            currentFocus?.clearFocus()
        }
        return super.dispatchTouchEvent(ev)

    }*/


}
