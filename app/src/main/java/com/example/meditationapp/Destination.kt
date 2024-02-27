package com.example.meditationapp
interface Destination{

    val route:String
}
object Home:Destination{
    override val route = "Homepage"
}
object  article:Destination{
    override val route = "article"
}
object profile:Destination{
    override val route = "Profile"
}
object excrise:Destination{
    override val route = "excrise"
}