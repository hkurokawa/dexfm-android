package fm.dex.model.entity

import org.greenrobot.greendao.DaoException
import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Generated
import org.greenrobot.greendao.annotation.Id
import org.greenrobot.greendao.annotation.NotNull
import org.greenrobot.greendao.annotation.ToMany
import org.greenrobot.greendao.annotation.Unique

import java.util.Date

@Entity
class Item {

    @Id
    var id: Long = 0

    @NotNull
    @Unique
    var title: String? = null

    @NotNull
    var subTitle: String? = null

    @NotNull
    var description: String? = null

    @NotNull
    var link: String? = null

    @NotNull
    var pubDate: Date? = null

    @ToMany(referencedJoinProperty = "id")
    private var contributor: List<Contributor>? = null

    @NotNull
    var duration: String? = null

    @NotNull
    var fileSize: Long = 0

    @NotNull
    var enclosure: String? = null

    /**
     * Convenient call for [org.greenrobot.greendao.AbstractDao.refresh].
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    fun refresh() {
        if (myDao == null) {
            throw DaoException("Entity is detached from DAO context")
        }
        myDao!!.refresh(this)
    }

    /**
     * Convenient call for [org.greenrobot.greendao.AbstractDao.update].
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    fun update() {
        if (myDao == null) {
            throw DaoException("Entity is detached from DAO context")
        }
        myDao!!.update(this)
    }

    /**
     * Convenient call for [org.greenrobot.greendao.AbstractDao.delete].
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    fun delete() {
        if (myDao == null) {
            throw DaoException("Entity is detached from DAO context")
        }
        myDao!!.delete(this)
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1495664550)
    @Synchronized fun resetContributor() {
        contributor = null
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1547599054)
    fun getContributor(): List<Contributor>? {
        if (contributor == null) {
            val daoSession = this.daoSession ?: throw DaoException("Entity is detached from DAO context")
            val targetDao = daoSession.contributorDao
            val contributorNew = targetDao._queryItem_Contributor(id)
            synchronized(this) {
                if (contributor == null) {
                    contributor = contributorNew
                }
            }
        }
        return contributor
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 881068859)
    fun __setDaoSession(daoSession: DaoSession?) {
        this.daoSession = daoSession
        myDao = daoSession?.itemDao
    }

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 182764869)
    @Transient private var myDao: ItemDao? = null

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    @Transient private var daoSession: DaoSession? = null

    @Generated(hash = 1603708773)
    constructor(id: Long, @NotNull title: String, @NotNull subTitle: String,
                @NotNull description: String, @NotNull link: String,
                @NotNull pubDate: Date, @NotNull duration: String, fileSize: Long,
                @NotNull enclosure: String) {
        this.id = id
        this.title = title
        this.subTitle = subTitle
        this.description = description
        this.link = link
        this.pubDate = pubDate
        this.duration = duration
        this.fileSize = fileSize
        this.enclosure = enclosure
    }

    @Generated(hash = 1470900980)
    constructor() {
    }
}
