package fm.dex.model.entity

import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Generated
import org.greenrobot.greendao.annotation.Id
import org.greenrobot.greendao.annotation.Unique

@Entity
class Contributor {

    @Id(autoincrement = true)
    var id: Long = 0

    @Unique
    var name: String? = null

    @Generated(hash = 1633064740)
    constructor(id: Long, name: String) {
        this.id = id
        this.name = name
    }

    @Generated(hash = 505775570)
    constructor() {
    }
}
