package fm.dex.model.entities

data class Item(
        val id: Long = 0,
        val title: String,
        val subTitle: String,
        val description: String,
        val link: String,
        val pubDate: String,
        // contains contributors id
        val contributorsId: String,
        val duration: String,
        val fileSize: Long,
        val enclosure: String
)