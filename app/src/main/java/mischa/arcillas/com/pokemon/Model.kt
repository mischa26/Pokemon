package mischa.arcillas.com.pokemon

/**
 * Created by Mischa on 07/03/2018.
 */
data class Pokemon(val id: Int, val name: String, val pokeImage: Sprites)

data class Sprites(val frontDefault: String)