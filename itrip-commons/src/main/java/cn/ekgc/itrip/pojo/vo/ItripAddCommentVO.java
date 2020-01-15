package cn.ekgc.itrip.pojo.vo;

import cn.ekgc.itrip.pojo.entity.ItripImage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 页面输入-新增评论VO
 * Created by hanlu on 2017/5/7.
 */
@ApiModel(value = "ItripAddCommentVO",description = "添加用户评论VO")
public class ItripAddCommentVO {

    @ApiModelProperty("[必填] 酒店ID")
    private Long hotelId;
    @ApiModelProperty("[必填] 订单ID")
    private Long orderId;
    @ApiModelProperty("[必填] 房型ID")
    private Long productId;
    @ApiModelProperty("[必填，注：接收数字类型] 订单类型(0:旅游产品 1:酒店产品 2:机票产品)")
    private Integer productType;
    @ApiModelProperty("[必填，注：接收数字类型] 是否包含图片(当用户上传评论时检测)0:无图片 1:有图片")
    private Integer isHavingImg;
    @ApiModelProperty("[必填] 位置评分")
    private Integer positionScore;
    @ApiModelProperty("[必填] 设施评分")
    private Integer facilitiesScore;
    @ApiModelProperty("[必填] 服务评分")
    private Integer serviceScore;
    @ApiModelProperty("[必填] 卫生评分")
    private Integer hygieneScore;
    @ApiModelProperty("[必填，注：接收数字类型] 出游类型（数据取自下拉列表）")
    private String tripMode;
    @ApiModelProperty("[必填，注：接收数字类型] 是否满意（0：有待改善 1：值得推荐）")
    private Integer isOk;
    @ApiModelProperty("[非必填] 评论内容")
    private String content;
    @ApiModelProperty("[非必填] 评论图片，根据用户是否上传图片（图片网络路径数组）")
    private ItripImage[] itripImages;


    public Long getOrderId() {
    return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ItripImage[] getItripImages() {
        return itripImages;
    }

    public void setItripImages(ItripImage[] itripImages) {
        this.itripImages = itripImages;
    }

    public Long getHotelId() {
        return hotelId;
    }
    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getIsHavingImg() {
        return isHavingImg;
    }

    public void setIsHavingImg(Integer isHavingImg) {
        this.isHavingImg = isHavingImg;
    }

    public Integer getPositionScore() {
        return positionScore;
    }

    public void setPositionScore(Integer positionScore) {
        this.positionScore = positionScore;
    }

    public Integer getFacilitiesScore() {
        return facilitiesScore;
    }

    public void setFacilitiesScore(Integer facilitiesScore) {
        this.facilitiesScore = facilitiesScore;
    }

    public Integer getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }

    public Integer getHygieneScore() {
        return hygieneScore;
    }

    public void setHygieneScore(Integer hygieneScore) {
        this.hygieneScore = hygieneScore;
    }

    public String getTripMode() {
        return tripMode;
    }

    public void setTripMode(String tripMode) {
        this.tripMode = tripMode;
    }

    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
