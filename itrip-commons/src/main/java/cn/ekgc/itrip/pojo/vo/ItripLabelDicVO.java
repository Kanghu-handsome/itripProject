package cn.ekgc.itrip.pojo.vo;

/**
 * 返回前端-通用字典VO
 * Created by hanlu on 2017/5/11.
 */
public class ItripLabelDicVO {

    private Long id;
    private String name;
    private String description;
    private String pic="";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return (pic==null?"":pic);
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
