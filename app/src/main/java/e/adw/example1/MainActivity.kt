package e.adw.example1

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.textView)

        //merah
        findViewById<Button>(R.id.merahBtn2).setOnClickListener {
           merahBtn(txt)
        }

        findViewById<Button>(R.id.biruBtn2).setOnClickListener {
            biruBtn(txt)
        }

        findViewById<Button>(R.id.hijauBtn2).setOnClickListener {
            hijauBtn(txt)
        }
    }

    fun biruBtn(v:View){
        txt.apply {
            setTextColor(Color.WHITE)
            text = context.getString(R.string.biru)
            setBackgroundColor(Color.BLUE)
        }
    }

    fun merahBtn(v:View){
        txt.apply {
            setTextColor(Color.WHITE)
            text = context.getString(R.string.merah)
            setBackgroundColor(Color.RED)
        }
    }
    fun hijauBtn(v:View){
        txt.apply {
            setTextColor(Color.WHITE)
            text = context.getString(R.string.hijau)
            setBackgroundColor(Color.GREEN)
        }
    }
}
