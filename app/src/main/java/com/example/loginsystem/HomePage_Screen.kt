package com.example.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginsystem.databinding.ActivityHomePageScreenBinding
import com.example.loginsystem.databinding.ActivityLoginScreenBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class HomePage_Screen : AppCompatActivity() {

    lateinit var binding: ActivityHomePageScreenBinding
    val list = mutableListOf<CarouselItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageScreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home_page_screen)

        ImageSLider()

        var sharedPref = this.getSharedPreferences("MyPref",MODE_PRIVATE)
        var name = sharedPref.getString("name",null)
        var call = sharedPref.getString("call",null)
        var mail = sharedPref.getString("email",null)
        var password = sharedPref.getString("password",null)

        Toast.makeText(this,"$name\n $call\n $mail\n $password",Toast.LENGTH_LONG).show()
    }

    fun ImageSLider(){
        list.add(
            CarouselItem(
                imageUrl = "https://mobimg.b-cdn.net/v3/fetch/3a/3a08f179ebced46897046404b551bda1.jpeg",
                caption = "Photo by Aaron Wu on Unsplash"))
        list.add(
            CarouselItem(
                imageUrl = "https://1.bp.blogspot.com/-CDftRaxwV6U/X21wTjdFl8I/AAAAAAAA8kY/BB900kJMfbwpUktl80OBJtGkTJpYW_Y4QCLcBGAsYHQ/s3840/pier_sunset_rays_184797_1920x1080.jpg",
                caption = "Photo by Aaron Wu on Unsplash"))
        list.add(
            CarouselItem(
                imageUrl = "https://dz2cdn1.dzone.com/storage/article-thumb/7093356-thumb.jpg",
                caption = "Photo by Aaron Wu on Unsplash"))
        list.add(
            CarouselItem(
                imageUrl = "https://www.cleo.com/sites/default/files/2019-08/open-source-software.jpg",
                caption = "Photo by Aaron Wu on Unsplash"))
        list.add(
            CarouselItem(
                imageUrl = "https://www.pibeca.com/wp-content/uploads/2019/04/webdevelopment-bg.jpeg",
                caption = "Photo by Aaron Wu on Unsplash"))
        binding.carousel.setData(list)
    }
}