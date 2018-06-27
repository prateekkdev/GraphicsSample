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

        drawCircle(canvas)
        drawRect(canvas)
    }

    fun drawCircle(canvas: Canvas) {
        paint.style = Paint.Style.FILL

        canvas.drawCircle(drawRect.centerX(), drawRect.centerY(), 20f, paint)
    }

    fun drawRect(canvas: Canvas) {

        paint.color = borderColor
        paint.strokeWidth = borderWidth
        paint.style = Paint.Style.STROKE

        var originalRect = RectF(drawRect.width() * 0.35f, drawRect.height() * 0.30f, drawRect.width() * 0.65f, drawRect.height() * 0.70f)

        var otherRect = RectF()

        var transformMatrix = Matrix()

        transformMatrix.preTranslate(originalRect.width() / 2, 0f)
        transformMatrix.preTranslate(0f, originalRect.height() / 2)

        transformMatrix.postScale(0.5f, 0.5f, originalRect.centerX(), originalRect.centerY())

        transformMatrix.postRotate(90f, drawRect.centerX() + originalRect.width() / 2, drawRect.centerY() + originalRect.height() / 2)

        // transformMatrix.mapRect(otherRect, originalRect)


        var path = Path()

        path.addRect(originalRect, Path.Direction.CW)

        path.transform(transformMatrix)

        canvas.drawPath(path, paint)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (w > 0 && h > 0) {
            drawRect.set(0f, 0f, w * 1f, h * 1f)
        }

    }
}