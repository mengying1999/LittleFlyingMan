package com.lfm.common.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private static String neturl = "http://47.119.126.86/api/order";
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117636920";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCdUq47DN4JKSVm9wf8t9uL/kKDJKjQpMMkx7UWtADnKj5WPZojpIRJ6Nn4yqonST19tQZys+N9KiEqTvKea9Aa+1nqVPY5ZxTnA+fAOelU8qkkaqu5M7Fc85hn9QO4e2MB6IEsKefxOOwPJvCNcBWqhhtHA4I5CDcnRQcvTGXaaFikSvl4HsnMYuN7ric/2V3JYglmVM9JGRxm0g8q7Oduf3HeXAbyimgBnqT0Zd0KDjT1VogFl+2LwGSd2rjAbsHsT4I++YOi7wD27rkbpJelWQZ82ZRNHAOlJVGsj7r3auM6iowtpfmPyUUFUfhEJ12CqF+klNJS0e6zLH7C5UXAgMBAAECggEAL0z7xMTPfJY8nooea+8Rl9AJCd25JTy0OHD3UqOCnGymz5Gz9gELcPDgTICPLQedKRlPmfJxAtVcbI03wpgQNNltAJLiddf6sE37U/luBAG3jafLLRKE7g6pG7hpmOPNz2HNGso6XLF0pKe1CduXW1Tc+mKbrBma2KKTckAexPjfaRPZdSXX4YQxgpl10YtC6saQnOyZP5simctkVHuCEOG0HA3zXooczllTFtVjuGPfnCAgSrxE6NYYXI+CQjflXyWj7ZemUV/Kwj5LuwXrPNBRFwkwsA1fd9JpJZMHtamOs8ERRRwoEub2jWXHYmoxqfA7TezhE8Pzl27nKHZxQQKBgQDW43c3UI6T6SpkifZnJh6vkbOY2Fut8keOoRJEucxLChaJrjB5Ya1nbNGcPP0/Fjtw+dYZG1iZm1QqdtaaMIWTsQ5rfRFxfniuZMsfhsLIVvvVQasmYHTmFYg3rEtViywa/wvKXi8cbAlVU1EaVvbUAoCF0sjeUPPZcC9PrHPBhwKBgQCbarRP+ZXwClX7Wkxj4FEz1o/Iseq7HgptLBwtrhkE8GwhtKNnHGTRn2oH8drjtrl6LLKFRSkq/2SkW48+3rglG5udOdkL2tdjW0RBXxNMVo2JKdWqbxPhDY/23f448X9VrHJDDiJqA0153NwsPprENscuMyStF9UJBvOsZHez8QKBgH+3S7i1iTgBwa9li+w8bMp+d1alaL/Wmo77zmbIYtJKmaCUxbyuwCgTNfV9Dir7pLJ92rCrXxpUhk6CuQOFSS7BcceS2tYwi7tirpL7PjNh92UFFZrGg1PogkBMh628/KbC5RgOqENlNpre3Pohq6vQHODsqXPwey3Fjmj1HwtrAoGALjUaaRC+uICKMdIWFjfSTMRFOZlUPc/fr7fGpPo3LBXDQH4xeu2hOAXag4Qv3TYtjRqO9Tqr08HdDVS/kSSswTOlH6jcVD77fOncsEbxOOge6qIKicK+uVHL9Mzp0cpTXoiH7FHef4B933Z/65OtdhsHO0AvbltAlo9/kUjJojECgYEAigYPU/WXkANmPm7ObZHONj9delHcWRC7JNF/VtgYl/Gxohd/uNnJsEbXq5xwtFKqKlWsLWi/1PvS7XdlV5RwItAEJoVA6/h/ZXr890Z7AHDAbSsbbeWD2gMOQGeOdwwpJIkWcpYKncjYO5r7TRZPYbC62FUWivIWEQ7UKuRn/7Q=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgnVKuOwzeCSklZvcH/Lfbi/5CgySo0KTDJMe1FrQA5yo+Vj2aI6SESejZ+MqqJ0k9fbUGcrPjfSohKk7ynmvQGvtZ6lT2OWcU5wPnwDnpVPKpJGqruTOxXPOYZ/UDuHtjAeiBLCnn8TjsDybwjXAVqoYbRwOCOQg3J0UHL0xl2mhYpEr5eB7JzGLje64nP9ldyWIJZlTPSRkcZtIPKuznbn9x3lwG8opoAZ6k9GXdCg409VaIBZfti8Bkndq4wG7B7E+CPvmDou8A9u65G6SXpVkGfNmUTRwDpSVRrI+692rjOoqMLaX5j8lFBVH4RCddgqhfpJTSUtHusyx+wuVFwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url  = neturl+"/alipay/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = neturl+"/alipay/return_url";
//      public static String return_url ="http://www.gomai.com/buyOrder" ;

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
