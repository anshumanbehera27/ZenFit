package com.example.materialapp3

interface Destination{
    val route:String
}
object Home:Destination{
    override val route = "Content"
}
object  Favoritepart:Destination{
    override val route = "Favoritepart"
}