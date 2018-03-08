package mischa.arcillas.com.pokemon


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.poke_row.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {
    private var pokemonList = ArrayList<Pokemon>()
    private val url = "https://pokeapi.co/api/v2/pokemon/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_main.layoutManager = LinearLayoutManager(this)
        for (i in 1 ..20)
        {
            doAsync{
                val resultJson =  URL(url + i).readText()
                uiThread {
                    val jsonObj = JSONObject(resultJson)

                    val id = jsonObj.getInt("id")
                    val pname = jsonObj.getString("name")
                    val sprites = jsonObj.getString("sprites")
                    val jsonObj2 = JSONObject(sprites)
                    val front_default = jsonObj2.getString("front_default")

                    pokemonList.add(Pokemon(id, pname, Sprites(front_default)))

                    recycler_view_main.adapter = PokeAdapter(pokemonList)
                    if(pokemonList.size!=0)
                    {
                        txtPokemon.text = "You have "+pokemonList.size.toString() + " Pokemons"

                    }
                    if(pokemonList.size == 20){
                        progressBar.visibility = GONE
                    }
                }
            }
        }
    }

}

