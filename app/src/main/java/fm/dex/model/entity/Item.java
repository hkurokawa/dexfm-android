package fm.dex.model.entity;

import java.util.Date;
import java.util.List;

public final class Item {

    private long id;

    private String title;

    private String subTitle;

    private String description;

    private String link;

    private Date pubDate;

    private List<Contributor> contributor;

    private String duration;

    private long fileSize;

    private String enclosure;

}
