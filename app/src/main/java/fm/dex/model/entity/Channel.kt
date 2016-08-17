package fm.dex.model.entity

import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Generated
import org.greenrobot.greendao.annotation.NotNull

@Entity
class Channel {

    @NotNull
    var title: String? = null

    @NotNull
    var description: String? = null

    @NotNull
    var link: String? = null

    @NotNull
    var rss: String? = null

    @NotNull
    var thumbnail: String? = null

    @NotNull
    var keywords: String? = null

    @Generated(hash = 1039619931)
    constructor(@NotNull title: String, @NotNull description: String,
                @NotNull link: String, @NotNull rss: String, @NotNull thumbnail: String,
                @NotNull keywords: String) {
        this.title = title
        this.description = description
        this.link = link
        this.rss = rss
        this.thumbnail = thumbnail
        this.keywords = keywords
    }

    @Generated(hash = 459652974)
    constructor() {
    }
}
