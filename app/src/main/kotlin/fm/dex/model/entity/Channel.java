package fm.dex.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class Channel {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String link;

    @NotNull
    private String rss;

    @NotNull
    private String thumbnail;

    @NotNull
    private String keywords;

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getRss() {
        return this.rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(hash = 1039619931)
    public Channel(@NotNull String title, @NotNull String description,
            @NotNull String link, @NotNull String rss, @NotNull String thumbnail,
            @NotNull String keywords) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.rss = rss;
        this.thumbnail = thumbnail;
        this.keywords = keywords;
    }

    @Generated(hash = 459652974)
    public Channel() {
    }
}
