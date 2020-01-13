package cn.ekgc.itrip.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回前端-酒店设施VO（酒店详情页）
 * Created by donghai on 2017/5/11.
 */
@ApiModel(value = "ItripSearchDetailsFacilitiesPolicyHotelVO",description = "查询酒店的设施")
public class ItripSearchFacilitiesHotelVO {
    @ApiModelProperty("[必填] 酒店设施")
    private String facilities;

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
