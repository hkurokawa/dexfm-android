package fm.dex.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Contributor {

    @Id(autoincrement = true)
    private long id;

    @Unique
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Generated(hash = 1633064740)
    public Contributor(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 505775570)
    public Contributor() {
    }
}
