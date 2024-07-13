package com.rps.netconf.service;

import com.rps.netconf.client.RestConfClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestConfService {

    private RestConfClient restConfClient;

    public String getDeviceInfo(String path) {
        return restConfClient.getDeviceInfo(path);
    }

    public void changeHostname(String path, String newHostname) {
        String hostnameConfig = "{\"ietf-system:hostname\":\"" + newHostname + "\"}";
        restConfClient.changeHostname(path, hostnameConfig);
    }
}