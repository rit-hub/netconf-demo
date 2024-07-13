package com.rps.netconf.controller;

import com.rps.netconf.service.RestConfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/device-config")
@RequiredArgsConstructor
public class DeviceConfigController {

    private RestConfService restconfService;

    @GetMapping("/device-info")
    public ResponseEntity<String> getDeviceInfo(@RequestParam String path) {
        String deviceInfo = restconfService.getDeviceInfo(path);
        return ResponseEntity.ok(deviceInfo);
    }

    @PatchMapping("/hostname")
    public ResponseEntity<Void> changeHostname(@RequestParam String path, @RequestBody String newHostname) {
        restconfService.changeHostname(path, newHostname);
        return ResponseEntity.ok().build();
    }
}
