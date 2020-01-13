package cn.ekgc.itrip.pojo.entity;

import java.io.Serializable;
import java.util.Date;
public class ItripHotel implements Serializable {
            private Long id;
            private String hotelName;
            private Long countryId;
            private Long provinceId;
            private Long cityId;
            private String address;
            private String details;
            private String facilities;
            private String hotelPolicy;
            private Integer hotelType;
            private Integer hotelLevel;
            private Integer isGroupPurchase;
            private String redundantCityName;
            private String redundantProvinceName;
            private String redundantCountryName;
            private Integer redundantHotelStore;
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
            public void setHotelName (String  hotelName){
                this.hotelName=hotelName;
            }

            public  String getHotelName(){
                return this.hotelName;
            }
            public void setCountryId (Long  countryId){
                this.countryId=countryId;
            }

            public  Long getCountryId(){
                return this.countryId;
            }
            public void setProvinceId (Long  provinceId){
                this.provinceId=provinceId;
            }

            public  Long getProvinceId(){
                return this.provinceId;
            }
            public void setCityId (Long  cityId){
                this.cityId=cityId;
            }

            public  Long getCityId(){
                return this.cityId;
            }
            public void setAddress (String  address){
                this.address=address;
            }

            public  String getAddress(){
                return this.address;
            }
            public void setDetails (String  details){
                this.details=details;
            }

            public  String getDetails(){
                return this.details;
            }
            public void setFacilities (String  facilities){
                this.facilities=facilities;
            }

            public  String getFacilities(){
                return this.facilities;
            }
            public void setHotelPolicy (String  hotelPolicy){
                this.hotelPolicy=hotelPolicy;
            }

            public  String getHotelPolicy(){
                return this.hotelPolicy;
            }
            public void setHotelType (Integer  hotelType){
                this.hotelType=hotelType;
            }

            public  Integer getHotelType(){
                return this.hotelType;
            }
            public void setHotelLevel (Integer  hotelLevel){
                this.hotelLevel=hotelLevel;
            }

            public  Integer getHotelLevel(){
                return this.hotelLevel;
            }
            public void setIsGroupPurchase (Integer  isGroupPurchase){
                this.isGroupPurchase=isGroupPurchase;
            }

            public  Integer getIsGroupPurchase(){
                return this.isGroupPurchase;
            }
            public void setRedundantCityName (String  redundantCityName){
                this.redundantCityName=redundantCityName;
            }

            public  String getRedundantCityName(){
                return this.redundantCityName;
            }
            public void setRedundantProvinceName (String  redundantProvinceName){
                this.redundantProvinceName=redundantProvinceName;
            }

            public  String getRedundantProvinceName(){
                return this.redundantProvinceName;
            }
            public void setRedundantCountryName (String  redundantCountryName){
                this.redundantCountryName=redundantCountryName;
            }

            public  String getRedundantCountryName(){
                return this.redundantCountryName;
            }
            public void setRedundantHotelStore (Integer  redundantHotelStore){
                this.redundantHotelStore=redundantHotelStore;
            }

            public  Integer getRedundantHotelStore(){
                return this.redundantHotelStore;
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
