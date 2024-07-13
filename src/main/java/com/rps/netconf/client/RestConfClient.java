package com.rps.netconf.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "restConfClient", url = "localhost:8080",
    configuration = FeignConfig.class)
public interface RestConfClient {

    @GetMapping("/restconf/data")
    String getDeviceInfo(@RequestParam("path") String path);

    @PatchMapping("/restconf/data")
    void changeHostname(@RequestParam("path") String path, @RequestBody String hostnameConfig);
}
