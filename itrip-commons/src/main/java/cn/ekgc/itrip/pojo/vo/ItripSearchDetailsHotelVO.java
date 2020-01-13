package cn.ekgc.itrip.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回前端-酒店特色和介绍VO
 *
 */
@ApiModel(value = "ItripSearchDetailsHotelVO",description = "查询酒店的特色和介绍")

public class ItripSearchDetailsHotelVO {
    @ApiModelProperty("[必填] 特色名称")
    private String name;
    @ApiModelProperty("[必填] 特色描述")
    private String description;

	public ItripSearchDetailsHotelVO(  String details) {
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
}
