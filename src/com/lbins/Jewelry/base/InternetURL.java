package com.lbins.Jewelry.base;

/**
 * Created by liuzwei on 2015/1/12.
 */
public class InternetURL {
    public static final String INTERNAL = "http://gongyi.apptech.space/";

    //1 获得秘钥
    public static final String GET_TOKEN_URL = INTERNAL + "api/user/auth";
    //注册--发送验证码
    public static final String REG_SEND_CODE_URL = INTERNAL + "api/user/sendCode";
    //注册-校验验证码
    public static final String REG_VERITY_CODE_URL = INTERNAL + "api/user/verifyCode";
    //注册
    public static final String REG__URL = INTERNAL + "api/user/register";
    //登陆
    public static final String LOGIN__URL = INTERNAL + "api/user/login";
    //找回密码
    public static final String FORGET_PWR__URL = INTERNAL + "api/user/forgetPassword";
    //个人信息 (memberInfo
    public static final String MEMBER__URL = INTERNAL + "api/user/memberInfo";


    //9获取会员信息
    public static final String GET_MEMBER_URL = INTERNAL + "json.php/member.api-getBaseInfonByUid";
    //10更新会员个人信息
    public static final String UPDATE_MEMBER_URL = INTERNAL + "json.php/member.api-updateBaseInfoByUid";
    //11轮播图
    public static final String GET_AD_URL = INTERNAL + "json.php/community.api-indexad";
    //12分类列表
    public static final String GET_TYPE_URL = INTERNAL + "json.php/product.api-types";
    //13商城主页
    public static final String GET_SHOP_INDEX_URL = INTERNAL + "json.php/shop.api-index";
    //14商品列表
    public static final String GET_SHOP_PRODUCT_URL = INTERNAL + "json.php/product.api-productList";
    //15产品详情
    public static final String GET_SHOP_PRODUCT_DETAIL_URL = INTERNAL + "json.php/product.api-detail";
    //16下订单
    public static final String SET_ORDER_URL = INTERNAL + "json.php/order.api-order";
    //17取消订单
    public static final String CANCEL_ORDER_URL = INTERNAL + "json.php/order.api-ordercancel";
    //18订单列表
    public static final String LIST_ORDER_URL = INTERNAL + "json.php/order.api-orderlist";
    //19我的关注
    public static final String MINE_GUANZHU_URL = INTERNAL + "json.php/member.api-myfollow";
    //朋友圈发布
    public static final String ADD_RECORD_URL = INTERNAL + "index/ServiceJson/pypush";
    //朋友圈首页
    public static final String LIST_RECORD_URL = INTERNAL + "index/ServiceJson/pylist";
    //朋友圈喜爱操作
    public static final String ADD_FAVOUR_RECORD_URL = INTERNAL + "index/ServiceJson/toFavour";
    //朋友圈评论
    public static final String ADD_COMMENT_RECORD_URL = INTERNAL + "index/ServiceJson/tocomment";
    //查询好友
    public static final String FIND_MEMBER_URL = INTERNAL + "json.php/friends.api-searchByName";
    //收藏产品
    public static final String FAVOUR_LOVE_URL = INTERNAL + "json.php/product.api-love";
    //.添加或修改收获地址
    public static final String ADDRESS_ADD_UPDATE_URL = INTERNAL + "json.php/member.api-addAddress";
    //收获地址列表
    public static final String ADDRESS_LIST_URL = INTERNAL + "json.php/member.api-addresses";
    //获取会员信息
    public static final String GET_MEMBER_BYID_URL = INTERNAL + "json.php/member.api-getBaseInfonByUid";


}
