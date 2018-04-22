# CircleProgressView

  Android custom frame layout to show process percentage and some content on layer above layout.

  You can customize circle width and progress width, also you can set a colors to circle and progress lines; 
  
  To use this view your should define a width and height in layout. The main idea of this view is showing some content on layer 
  above in frame layout when we are showing progress. You can add any views inside this frame layout.
 
    
  <br />
   
  ![alt text](https://raw.githubusercontent.com/ikislenko93/CircleProgressView/master/app/src/main/res/drawable/progress_layout_example_1.png)
  ![alt text](https://raw.githubusercontent.com/ikislenko93/CircleProgressView/master/app/src/main/res/drawable/progress_layout_example_2.png)
  ![alt text](https://raw.githubusercontent.com/ikislenko93/CircleProgressView/master/app/src/main/res/drawable/progress_layout_example_3.png)
  
  <br />
  
    <com.example.i_kislenko.circleprogresslayout.CircleProgressLayout
 
         android:id="@+id/less_than_circle_layout"

         android:layout_width="80dp"</b>
         android:layout_height="80dp"</b>

         android:layout_centerInParent="true"
         android:layout_margin="5dp"
         
         app:circleColor="@android:color/holo_orange_light"
         app:circleWidth="5dp"

         app:progressColor="@android:color/holo_green_dark"
         app:progressWidth="3dp">

    <TextView
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"

         android:layout_gravity="center"

         android:fontFamily="@font/avenir_roman"

         android:gravity="center"

         android:includeFontPadding="false"

         android:padding="15dp"

         android:text="HERE IS YOUR TEXT OR CONTENT"
         android:textSize="6sp" />

     </com.example.i_kislenko.circleprogresslayout.CircleProgressLayout>
   
   <br />
   
   To set percentage you need call progressLayout.setPercentage(0.5f); in class and you will see 50% percentage;
