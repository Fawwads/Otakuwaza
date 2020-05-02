package com.fawwad.otakuwaza

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.fawwad.otakuwaza.repository.DatabaseHelper
import com.fawwad.otakuwaza.repository.model.Character
import com.fawwad.otakuwaza.repository.model.Collection
import com.fawwad.otakuwaza.repository.model.Quote
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn.setOnClickListener {

            DatabaseHelper()
                .addCollection(
                    makeCollection("Naruto Shippuden",
                        "https://m.media-amazon.com/images/M/MV5BZmQ5NGFiNWEtMmMyMC00MDdiLTg4YjktOGY5Yzc2MDUxMTE1XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_QL50_.jpg",
                        makeCharacter("Naruto",
                            "https://vignette.wikia.nocookie.net/naruto/images/0/09/Naruto_newshot.png/revision/latest?cb=20170621101134",
                            listOf("If you don't like the hand that fate's dealt you with, fight for a new one.",
                                "I'm not gonna run away, I never go back on my word!",
                                "If you don't like your destiny, don't accept it."))
                    ))

            var intent = Intent(this, SecondActivity::class.java)
            val activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, btn, "button")
            startActivity(intent, activityOptionsCompat.toBundle())
        }



    }

    fun makeCollection(collectionName:String,collectionImage:String,character: Character):Collection{
        var characters = arrayListOf<Character>()
        characters.add(character)

        var collection = Collection(collectionName,collectionImage,characters)
        return collection;
    }

    fun makeCharacter(characterName:String, image:String,quotesString:List<String>):Character{
        val quotes = arrayListOf<Quote>()
        for (quote in quotesString){
            quotes.add(Quote(quote))
        }
        return Character(characterName,image,quotes)
    }
}
