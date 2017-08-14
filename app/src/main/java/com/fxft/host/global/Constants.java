package com.fxft.host.global;

/**
 * Created by hzl520 on 2017/8/13.
 * 公共常量
 */
public class Constants {

    /**
     *
     */
//    public static final String BASE_NET_URL = "http://device.fxftcar.com:7431/";//正式
    public static final String BASE_NET_URL = "http://172.16.12.201:8080/Replugin/";//测试


    /**
     * 网络参数
     */
    public static final int DEFAULT_NET_TIMEOUT = 30;//网络超时，单位秒
    public static final int DEFAULT_READER_TIMEOUT = 60;//读取超时，单位秒
    public static final int DEFAULT_WRITER_TIMEOUT = 60;//写入超时，单位秒
    public static final String CA_HEADER_TO_SIGN_PREFIX_SYSTEM = "X-Ca-";

}
