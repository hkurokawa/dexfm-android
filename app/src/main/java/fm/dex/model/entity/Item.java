package fm.dex.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class Item {

    @Id
    private long id;

    @NotNull
    @Unique
    private String title;

    @NotNull
    private String subTitle;

    @NotNull
    private String description;

    @NotNull
    private String link;

    @NotNull
    private String pubDate;

    @ToMany(referencedJoinProperty = "id")
    private List<Contributor> contributor;

    @NotNull
    private String duration;

    @NotNull
    private long fileSize;

    @NotNull
    private String enclosure;

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1495664550)
    public synchronized void resetContributor() {
        contributor = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1547599054)
    public List<Contributor> getContributor() {
        if (contributor == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContributorDao targetDao = daoSession.getContributorDao();
            List<Contributor> contributorNew = targetDao._queryItem_Contributor(id);
            synchronized (this) {
                if(contributor == null) {
                    contributor = contributorNew;
                }
            }
        }
        return contributor;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 881068859)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getItemDao() : null;
    }

    /** Used for active entity operations. */
    @Generated(hash = 182764869)
    private transient ItemDao myDao;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public String getEnclosure() {
        return this.enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Generated(hash = 1919618937)
    public Item(long id, @NotNull String title, @NotNull String subTitle, @NotNull String description,
            @NotNull String link, @NotNull String pubDate, @NotNull String duration, long fileSize,
            @NotNull String enclosure) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
        this.duration = duration;
        this.fileSize = fileSize;
        this.enclosure = enclosure;
    }

    @Generated(hash = 1470900980)
    public Item() {
    }
}
