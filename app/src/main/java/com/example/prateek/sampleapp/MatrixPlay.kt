package com.example.prateek.sampleapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MatrixPlay(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    // Some colors for the face background, eyes and mouth.
    private var borderColor = Color.BLACK
    // Face border width in pixels
    private var borderWidth = 4.0f
    // View size in pixels
    private var size = 320

    private var drawRect = RectF()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = borderColor
        paint.strokeWidth = borderWidth
        paint.style = Paint.Style.STROKE

        canvas.drawRect(0f, 0f, drawRect.width() / 2f, drawRect.height() / 2f, paint)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (w > 0 && h > 0) {
            drawRect.set(0f, 0f, w * 1f, h * 1f)
        }

    }
}