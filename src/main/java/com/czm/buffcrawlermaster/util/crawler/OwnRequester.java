//package com.czm.buffcrawlermaster.util.crawler;
//
//import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
//import cn.edu.hfut.dmic.webcollector.net.Proxies;
//import cn.edu.hfut.dmic.webcollector.plugin.net.OkHttpRequester;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//
//import java.io.IOException;
//import java.net.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//
//
//public class OwnRequester {
//    public static class MRequester extends OkHttpRequester {
//
//        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.82 Safari/537.36";
//        //String cookie = "_ntes_nnid=63a5019e16bbcdb572360bab72a55a03,1630806225596; _ntes_nuid=63a5019e16bbcdb572360bab72a55a03; UM_distinctid=17bb3a03b48191-084ec3df9c81c1-5734174f-1fa400-17bb3a03b495ea; vinfo_n_f_l_n3=5a2e5b4ffc4013a4.1.0.1630806225600.0.1630807157217; Device-Id=c9yhrm6ID1KLHAWWnJjy; _ga=GA1.2.1830504517.1631002039; NTES_P_UTID=LCy61LUjxqrYzGUk8ECeCNq12A2JYNQk|1643433772; nts_mail_user=czm598493603@163.com:-1:1; timing_user_id=time_dRwCaUHoSY; _gid=GA1.2.497052288.1644649565; Locale-Supported=zh-Hans; game=csgo; NTES_YD_SESS=qEPeqZaW0xnpbi_HqlZneQHq29UDA05f_GljvqzcEhbZDJLIDjktuVgnHFS.P_aAw9clx5.hoWY0jPkf.1ecYchy6v0NEgz2YsXYNksPZjJyam4PEmvumWFkYQy75p_KUMLIbR4H6eVIL5pngat42dnLQHymlQ8UXM_ln8ycgeDrHLJ_dMhB8na5h2.35cEzE7besN7FmYi6XcCOEcvJg6UdNaYaciKXBaHp1PUbKXcNo; S_INFO=1644763098|0|0&60##|17371989114; P_INFO=17371989114|1644763098|1|netease_buff|00&99|null&null&null#hub&420100#10#0|&0|null|17371989114; remember_me=U1095763846|akBksSx4JzHmzWxKqLcunsUNGTNiYXPf; session=1-I5Kcl7-4H2M8Aq7yQkkxMOt7rZgG6CLl7StD7kcEir332040436958; _gat_gtag_UA_109989484_1=1; csrf_token=IjBkOTA3M2YyODUxZjYwYjViODFkYmRlYWU3MDA5ZGIxZTMxMjgzODIi.FOqpwA.yaYx1TvZcdhG4e1MPPolgYVKwgE";
//        String cookie = "Device-Id=dlRvdFYTOSna36VbtL6V; _ga=GA1.2.263644632.1624606469; _gid=GA1.2.591238343.1644649629; Locale-Supported=zh-Hans; game=csgo; NTES_YD_SESS=M2l5917fbTpRyqFlZzg212JIRBGS8XVOoDkECMKAbNwFWh3VWELSHa1D37vdo117JLKO1ee2OAU3wcmlNYbq4jRL3rxebFnx_LW_mWfWUxjejNtjWFQMp2MLz72dyqt_fn3VwiIGOZaV3yqvT9SIjlv37G2xk71fsR9AVgzjnK8tSLphVQqmUVXVrp.HgbcdCskVgXXqPhAqTK94XwdUVhPcjNkuDkobF.nYU6W4HUl8X; S_INFO=1644845813|0|0&60##|18062083786; P_INFO=18062083786|1644845813|1|netease_buff|00&99|null&null&null#hub&420100#10#0|&0|null|18062083786; remember_me=U1098371549|g712dRQwg3k05BcXrAofzReksWpSlEsa; session=1-0S8KUbb30SQffcC7s7HYKJgwJb9UZWNGkxjaH3fGNfS" +
//                "T2042187397; _gat_gtag_UA_109989484_1=1; csrf_token=ImQwYWVlNmRiY2JmZmZjZGEyYWM3NGFmM2U1NDZlM2YyMTRiNDI3OTIi.FOvurA.CSJvUFfoM9-zFsxmBsbiAQN2X04";
//
//        // 每次发送请求前都会执行这个方法来构建请求
//        @Override
//        public Request.Builder createRequestBuilder(CrawlDatum crawlDatum) {
//
//            // 这里使用的是OkHttp中的Request.Builder
//            // 可以参考OkHttp的文档来修改请求头
//            System.out.println("request with cookie: " + cookie);
//            return super.createRequestBuilder(crawlDatum)
//                    .header("User-Agent", userAgent)
//                    .header("Cookie", cookie);
//        }
//
//
//    }
//}
package com.czm.buffcrawlermaster.util.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.plugin.net.OkHttpRequester;
import okhttp3.Request;

public class OwnRequester {
    public static class MRequester extends OkHttpRequester {

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
        String cookie = "Device-Id=dlRvdFYTOSna36VbtL6V; _ga=GA1.2.263644632.1624606469; _gid=GA1.2.591238343.1644649629; P_INFO=18062083786|1644845813|1|netease_buff|00&99|null&null&null#hub&420100#10#0|&0|null|18062083786; remember_me=U1098371549|g712dRQwg3k05BcXrAofzReksWpSlEsa; session=1-S7zGmiG78z_wj-SJaVXUUGh9y-mLuHeISzbRVJ55jqGZ2042187397; Locale-Supported=zh-Hans; game=csgo; _gat_gtag_UA_109989484_1=1; csrf_token=IjExYzI0MGVmYTJlY2I0YTExNzgxYjYxNzM3Mzk3Yjc5YzUxYjAzMmUi.FOv1eQ.CWrIQ5EogsBalr7HMp8339MZ1ig";

        // 每次发送请求前都会执行这个方法来构建请求
        @Override
        public Request.Builder createRequestBuilder(CrawlDatum crawlDatum) {
            // 这里使用的是OkHttp中的Request.Builder
            // 可以参考OkHttp的文档来修改请求头
            System.out.println("request with cookie: " + cookie);
            return super.createRequestBuilder(crawlDatum)
                    .header("User-Agent", userAgent)
                    .header("Cookie", cookie);
        }

    }
}

