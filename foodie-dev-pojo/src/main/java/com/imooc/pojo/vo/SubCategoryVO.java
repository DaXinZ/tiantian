package com.imooc.pojo.vo;

/**
 * Date: 2022/3/17 2:05 下午
 * SubCategoryVO
 * Describe：
 */
public class SubCategoryVO {
    private   Integer subId;
    private   String  subName;
    private   String  subType;
    private   String  subFatherId;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubFatherId() {
        return subFatherId;
    }

    public void setSubFatherId(String subFatherId) {
        this.subFatherId = subFatherId;
    }
}
