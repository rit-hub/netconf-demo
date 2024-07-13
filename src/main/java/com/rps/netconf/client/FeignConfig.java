package com.rps.netconf.client;

import feign.Client;
import lombok.SneakyThrows;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLSocketFactory;
import java.security.cert.X509Certificate;

@Configuration
public class FeignConfig {
    @Bean("ssl")
    public Client feignClientWithSsl() {
        return new Client.Default(getSslSocketFactory(), new NoopHostnameVerifier());
    }
    @SneakyThrows
    protected SSLSocketFactory getSslSocketFactory() {
        return SSLContextBuilder
            .create()
            .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true).build().getSocketFactory();
    }

}
