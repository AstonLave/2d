package uk.ac.solent.a2d

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.content.Context
import android.graphics.BitmapFactory
import android.os.PersistableBundle
import android.util.Log

var c = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = GraphicsView(this)
        setContentView(view)
    }
}

class GraphicsView(ctx: Context) : View(ctx) {
    val p = Paint()
    var xpos = 0f
    var ypos = 0f

    val hero = BitmapFactory.decodeResource(ctx.resources, R.drawable.hero)

    init {
        setOnTouchListener { v, event ->
            Log.d("test", "Touch event: ${event.x} ${event.y}")

            xpos = event.x
            ypos = event.y
            postInvalidate()
            true
        }
    }

    override fun onDraw(canvas: Canvas) {

        /* p.setStyle(Paint.Style.FILL)
         canvas.drawRect(10f, 10f, 110f, 110f, p)
         canvas.drawText(c.toString(), 0f, 200f, p)
         c++*/

        canvas.drawBitmap(hero, xpos, ypos, null)

    }
}

