package eslyz.netdemo.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by nashxk on 15/11/2.
 */
public class StoreInfo implements Serializable {

    public Long id;
    public Long userId;
    public String storeName;
    public String storeNickName;
    public String contactName;
    public String contactMobile;
    public String wechat;
    public Long storeProvinceId;
    public Long storeCityId;
    public Long storeDistrictId;
    public Long storeStreetId;
    public String storeAddress;
    public String storeType;
    public String storePhoto;
    public String storeBrief;
    public String businessTimeBegin;
    public String businessTimeEnd;
    public String sellerType;
    public String remark;
    public String shareStoreUrl;
    public Boolean collect;//true，收藏；false，未收藏
    public String storeProvinceName;
    public String storeCityName;
    public String storeDistrictName;
    public String storeStreetName;
    public String storeLon;
    public String storeLat;
    public Long goodsNum;
    public String bannerDesc;
    public String bannerImg;
    //add by yanlu @2016/1/6
    public String imUsername;

    public List<String> bizBrandList;

    public List<String> bizCatList;

    public List<String> bizCarList;

    public String bizBrand; //主营品牌
    public String bizCat;   //主营类目
    public String bizCar;   // 主修车型

    public String qualityAssure;
    public String annualFeeLevel;

    //店铺类型文案
    public String store_type;

    //店铺类型list,新版店铺中使用
    public List<String> storeTypeNameList;

    /**
     * HG, 皇冠
     * ZS, 钻石
     * JP, 金牌
     * PT, 普通
     * */
    public String sellerLevel;

    public String storeArea;

    public Integer storeStationNum;


    public String dispAvgQualityScore;
    public String dispAvgLogisticsScore;
    public String dispAvgServiceScore;

    @Deprecated
    public String getStoreName(Objects os){
        if (!TextUtils.isEmpty(storeName)){
            if (storeName.length() > 6){
                storeName = storeName.substring(0,6);
            }
        }
        return storeName;
    }

    @Deprecated
    public String getStoreNickName() {
        if (!TextUtils.isEmpty(storeNickName)){
            if (storeNickName.length() > 6){
                storeNickName = storeNickName.substring(0,6);
            }
        }
        return storeNickName;
    }

    public String getStoreName(){
        return TextUtils.isEmpty(getStoreNickName()) ? getStoreName(null) : getStoreNickName();
    }


    public String getImUsername() {
        return imUsername;
    }

    @Override
    public String toString() {
        return "StoreInfo{" +
                "annualFeeLevel='" + annualFeeLevel + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                ", storeName='" + storeName + '\'' +
                ", storeNickName='" + storeNickName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactMobile='" + contactMobile + '\'' +
                ", wechat='" + wechat + '\'' +
                ", storeProvinceId=" + storeProvinceId +
                ", storeCityId=" + storeCityId +
                ", storeDistrictId=" + storeDistrictId +
                ", storeStreetId=" + storeStreetId +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeType='" + storeType + '\'' +
                ", storePhoto='" + storePhoto + '\'' +
                ", storeBrief='" + storeBrief + '\'' +
                ", businessTimeBegin='" + businessTimeBegin + '\'' +
                ", businessTimeEnd='" + businessTimeEnd + '\'' +
                ", sellerType='" + sellerType + '\'' +
                ", remark='" + remark + '\'' +
                ", shareStoreUrl='" + shareStoreUrl + '\'' +
                ", collect=" + collect +
                ", storeProvinceName='" + storeProvinceName + '\'' +
                ", storeCityName='" + storeCityName + '\'' +
                ", storeDistrictName='" + storeDistrictName + '\'' +
                ", storeStreetName='" + storeStreetName + '\'' +
                ", storeLon='" + storeLon + '\'' +
                ", storeLat='" + storeLat + '\'' +
                ", goodsNum=" + goodsNum +
                ", bannerDesc='" + bannerDesc + '\'' +
                ", bannerImg='" + bannerImg + '\'' +
                ", imUsername='" + imUsername + '\'' +
                ", bizBrandList=" + bizBrandList +
                ", bizCatList=" + bizCatList +
                ", bizCarList=" + bizCarList +
                ", bizBrand='" + bizBrand + '\'' +
                ", bizCat='" + bizCat + '\'' +
                ", bizCar='" + bizCar + '\'' +
                ", qualityAssure='" + qualityAssure + '\'' +
                ", store_type='" + store_type + '\'' +
                ", storeTypeNameList=" + storeTypeNameList +
                ", sellerLevel='" + sellerLevel + '\'' +
                ", storeArea='" + storeArea + '\'' +
                ", storeStationNum=" + storeStationNum +
                ", dispAvgQualityScore='" + dispAvgQualityScore + '\'' +
                ", dispAvgLogisticsScore='" + dispAvgLogisticsScore + '\'' +
                ", dispAvgServiceScore='" + dispAvgServiceScore + '\'' +
                '}';
    }
}
