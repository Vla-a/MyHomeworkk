package com.example.myhomework.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.GestureDetectorCompat
import com.example.myhomework.R
import kotlin.math.min

class TestCustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : View(context, attributeSet, defStyleAttrs) {

    val star =
        ContextCompat.getDrawable(context, R.drawable.ic_baseline_star_border_24)!!.toBitmap()
    var imageCoords: Pair<Float, Float>? = null
    private val paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    val recognizer = GestureDetectorCompat(context, object :
        GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent?): Boolean {
            imageCoords = e!!.x to e.y
            invalidate()
            return true
        }

        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            imageCoords = e2!!.x to e2.y
            invalidate()
            return true
        }
    })

    init {
        setOnTouchListener { view, motionEvent ->

            recognizer.onTouchEvent(motionEvent)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.YELLOW)

        val radius = min(width, height) / 2 - 10
        canvas.drawCircle(width / 2f, height / 2f, radius.toFloat(), paint)

        if(imageCoords == null){
            canvas.drawBitmap(star, width / 2f - star.width / 2f, height / 2f - star.height / 2f, null)
        }else{
            canvas.drawBitmap(star, imageCoords!!.first - star.width / 2f, imageCoords!!.second - star.height / 2f, null)
        }

    }
}