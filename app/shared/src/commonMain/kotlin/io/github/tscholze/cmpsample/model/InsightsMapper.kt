
data class InsightsMapper(val id: String, val name: String, val entityType:String, val imageUrl:String, val heading:String, val subHeading:String, val url:String, val urlLabel:String) {
}

interface ButtonClickCallback {
    fun onButtonClick()
}