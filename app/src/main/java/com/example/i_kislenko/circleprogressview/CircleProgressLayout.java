package com.example.i_kislenko.circleprogressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CircleProgressLayout extends FrameLayout {

    private float percentage,
            circleLineWidth,
            progressLineWidth;

    private int minViewSize,
            circleColor,
            progressColor,
            startAngle = 90;

    public CircleProgressLayout(Context context) {
        this(context, null, 0);
    }

    public CircleProgressLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        parseAttributes(context, attrs);
    }

    private void parseAttributes(Context context, AttributeSet attrs) {

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressLayout);

        circleLineWidth = array.getDimension(R.styleable.CircleProgressLayout_circleWidth, 0);
        progressLineWidth = array.getDimension(R.styleable.CircleProgressLayout_progressWidth, 0);
        circleColor = array.getColor(R.styleable.CircleProgressLayout_circleColor, 0);
        progressColor = array.getColor(R.styleable.CircleProgressLayout_progressColor, 0);
        array.recycle();
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        super.onSizeChanged(width, height, oldw, oldh);
        setViewSize(width, height);
    }

    private void setViewSize(int width, int height) {
        minViewSize = width < height ? width : height;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        canvas.drawArc(provideRectF(), startAngle, 360, false, makePaint(circleLineWidth, circleColor, false));
        canvas.drawArc(provideRectF(), startAngle, 360 * percentage, false, makePaint(progressLineWidth, progressColor, true));
    }

    private RectF provideRectF() {

        float left, right, top, bottom, padding;
        float height = getMeasuredHeight(), width = getMeasuredWidth();

        padding = circleLineWidth / 2f;

        if (minViewSize == getMeasuredWidth()) {

            left = padding;
            right = minViewSize - padding;
            top = (height / 2f) - (minViewSize / 2f) + padding;
            bottom = (height / 2f) + (minViewSize / 2f) - padding;

        } else {

            left = (width / 2f) - (minViewSize / 2f) + padding;
            right = (width / 2f) + (minViewSize / 2f) - padding;
            top = padding;
            bottom = minViewSize - padding;
        }

        return new RectF(left, top, right, bottom);
    }

    private Paint makePaint(float paintWidth, int color, boolean progressView) {

        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStrokeCap(progressView ? Paint.Cap.BUTT : Paint.Cap.ROUND);
        paint.setStrokeWidth(paintWidth);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    /**
     * Expected passing percentage from 0 to 1, to show progress;
     *
     * @param percentage
     */
    public void setPercentage(float percentage) {

        if (percentage > 1.0f) {
            percentage = 1f;
        }

        this.percentage = percentage;

        invalidate();
    }


}
