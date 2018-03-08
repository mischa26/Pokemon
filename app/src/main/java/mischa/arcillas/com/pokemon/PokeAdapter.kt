package mischa.arcillas.com.pokemon

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.poke_row.view.*

/**
 * Created by Mischa on 07/03/2018.
 */
class PokeAdapter(val pokeList: ArrayList<Pokemon>): RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.poke_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val pokemon: Pokemon = pokeList[position]
        holder?.view?.textView_poke_name?.text = pokemon.name
        val pokemonImage = holder?.view?.imageView_poke
        Picasso.with(holder?.view?.context).load(pokemon.pokeImage.frontDefault).into(pokemonImage)
    }
}
    class CustomViewHolder (val view:View): RecyclerView.ViewHolder(view) {

    }

