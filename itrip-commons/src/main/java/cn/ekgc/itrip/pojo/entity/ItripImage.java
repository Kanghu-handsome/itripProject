package cn.ekgc.itrip.pojo.entity;

import java.io.Serializable;
import java.util.Date;
public class ItripImage implements Serializable {

            private Long id;
            private String type;
            private Long targetId;
            private Integer position;
            private String imgUrl;
            private Date creationDate;
            private Long createdBy;
            private Date modifyDate;
            private Long modifiedBy;

            public void setId (Long  id){
                this.id=id;
            }

            public  Long getId(){
                return this.id;
            }
            public void setType (String  type){
                this.type=type;
            }

            public  String getType(){
                return this.type;
            }
            public void setTargetId (Long  targetId){
                this.targetId=targetId;
            }

            public  Long getTargetId(){
                return this.targetId;
            }
            public void setPosition (Integer  position){
                this.position=position;
            }

            public  Integer getPosition(){
                return this.position;
            }
            public void setImgUrl (String  imgUrl){
                this.imgUrl=imgUrl;
            }

            public  String getImgUrl(){
                return this.imgUrl;
            }
            public void setCreationDate (Date  creationDate){
                this.creationDate=creationDate;
            }

            public  Date getCreationDate(){
                return this.creationDate;
            }
            public void setCreatedBy (Long  createdBy){
                this.createdBy=createdBy;
            }

            public  Long getCreatedBy(){
                return this.createdBy;
            }
            public void setModifyDate (Date  modifyDate){
                this.modifyDate=modifyDate;
            }

            public  Date getModifyDate(){
                return this.modifyDate;
            }
            public void setModifiedBy (Long  modifiedBy){
                this.modifiedBy=modifiedBy;
            }

            public  Long getModifiedBy(){
                return this.modifiedBy;
            }

}
